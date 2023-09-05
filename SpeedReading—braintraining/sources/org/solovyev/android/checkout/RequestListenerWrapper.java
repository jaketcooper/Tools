package org.solovyev.android.checkout;

import javax.annotation.Nonnull;

class RequestListenerWrapper<R> implements CancellableRequestListener<R> {
    @Nonnull
    protected final RequestListener<R> mListener;

    RequestListenerWrapper(@Nonnull RequestListener<R> listener) {
        this.mListener = listener;
    }

    public void onSuccess(@Nonnull R result) {
        this.mListener.onSuccess(result);
    }

    public void onError(int response, @Nonnull Exception e) {
        this.mListener.onError(response, e);
    }

    public final void cancel() {
        onCancel();
        Billing.cancel((RequestListener<?>) this.mListener);
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
    }
}
