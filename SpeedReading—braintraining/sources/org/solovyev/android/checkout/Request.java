package org.solovyev.android.checkout;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.vending.billing.IInAppBillingService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

abstract class Request<R> {
    @Nonnull
    private static final AtomicInteger sCounter = new AtomicInteger(0);
    protected final int mApiVersion;
    private final int mId;
    @GuardedBy("this")
    @Nullable
    private RequestListener<R> mListener;
    @GuardedBy("this")
    private boolean mListenerCalled;
    @Nullable
    private Object mTag;
    @Nonnull
    private final RequestType mType;

    /* access modifiers changed from: package-private */
    @Nullable
    public abstract String getCacheKey();

    /* access modifiers changed from: package-private */
    public abstract void start(@Nonnull IInAppBillingService iInAppBillingService, @Nonnull String str) throws RemoteException, RequestException;

    Request(@Nonnull RequestType type) {
        this(type, 3);
    }

    Request(@Nonnull RequestType type, int apiVersion) {
        this.mType = type;
        this.mApiVersion = apiVersion;
        this.mId = sCounter.getAndIncrement();
    }

    Request(@Nonnull RequestType type, @Nonnull Request<R> request) {
        this.mType = type;
        this.mId = request.mId;
        this.mApiVersion = request.mApiVersion;
        synchronized (request) {
            this.mListener = request.mListener;
        }
    }

    /* access modifiers changed from: protected */
    public int getId() {
        return this.mId;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Object getTag() {
        return this.mTag;
    }

    /* access modifiers changed from: package-private */
    public void setTag(@Nullable Object tag) {
        this.mTag = tag;
    }

    /* access modifiers changed from: package-private */
    @Nonnull
    public RequestType getType() {
        return this.mType;
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        synchronized (this) {
            if (this.mListener != null) {
                Billing.cancel((RequestListener<?>) this.mListener);
            }
            this.mListener = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isCancelled() {
        boolean z;
        synchronized (this) {
            z = this.mListener == null;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void onSuccess(@Nonnull R result) {
        RequestListener<R> l = getListener();
        if (l != null && !checkListenerCalled()) {
            l.onSuccess(result);
        }
    }

    private boolean checkListenerCalled() {
        synchronized (this) {
            if (this.mListenerCalled) {
                return true;
            }
            this.mListenerCalled = true;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onError(int response) {
        Billing.error("Error response: " + ResponseCodes.toString(response) + " in " + this + " request");
        onError(response, new BillingException(response));
    }

    public void onError(@Nonnull Exception e) {
        Check.isFalse(e instanceof BillingException, "Use onError(int) instead");
        Billing.error("Exception in " + this + " request: ", e);
        onError(ResponseCodes.EXCEPTION, e);
    }

    private void onError(int response, @Nonnull Exception e) {
        Check.notEquals(0, response);
        RequestListener<R> l = getListener();
        if (l != null && !checkListenerCalled()) {
            l.onError(response, e);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean handleError(@Nullable Bundle bundle) {
        return handleError(bundle != null ? bundle.getInt("RESPONSE_CODE") : 6);
    }

    /* access modifiers changed from: protected */
    public final boolean handleError(int response) {
        if (response == 0) {
            return false;
        }
        onError(response);
        return true;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public RequestListener<R> getListener() {
        RequestListener<R> requestListener;
        synchronized (this) {
            requestListener = this.mListener;
        }
        return requestListener;
    }

    /* access modifiers changed from: package-private */
    public void setListener(@Nullable RequestListener<R> listener) {
        synchronized (this) {
            Check.isNull(this.mListener);
            this.mListener = listener;
        }
    }

    public String toString() {
        String cacheKey = getCacheKey();
        if (!TextUtils.isEmpty(cacheKey)) {
            return getClass().getSimpleName() + "(" + cacheKey + ")";
        }
        return getClass().getSimpleName();
    }
}
