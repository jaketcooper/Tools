package org.solovyev.android.checkout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class PendingRequests implements Runnable {
    @GuardedBy("mList")
    @Nonnull
    private final List<RequestRunnable> mList = new ArrayList();

    PendingRequests() {
    }

    /* access modifiers changed from: package-private */
    public void add(@Nonnull RequestRunnable runnable) {
        synchronized (this.mList) {
            Billing.debug("Adding pending request: " + runnable);
            this.mList.add(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelAll() {
        synchronized (this.mList) {
            Billing.debug("Cancelling all pending requests");
            Iterator<RequestRunnable> iterator = this.mList.iterator();
            while (iterator.hasNext()) {
                iterator.next().cancel();
                iterator.remove();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelAll(@Nullable Object tag) {
        synchronized (this.mList) {
            Billing.debug("Cancelling all pending requests with tag=" + tag);
            Iterator<RequestRunnable> iterator = this.mList.iterator();
            while (iterator.hasNext()) {
                RequestRunnable request = iterator.next();
                Object requestTag = request.getTag();
                if (requestTag == tag) {
                    request.cancel();
                    iterator.remove();
                } else if ((requestTag == null || tag != null) && requestTag != null) {
                    if (requestTag.equals(tag)) {
                        request.cancel();
                        iterator.remove();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void cancel(int requestId) {
        synchronized (this.mList) {
            Billing.debug("Cancelling pending request with id=" + requestId);
            Iterator<RequestRunnable> iterator = this.mList.iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    break;
                }
                RequestRunnable request = iterator.next();
                if (request.getId() == requestId) {
                    request.cancel();
                    iterator.remove();
                    break;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public RequestRunnable pop() {
        RequestRunnable runnable;
        synchronized (this.mList) {
            runnable = !this.mList.isEmpty() ? this.mList.remove(0) : null;
            if (runnable != null) {
                Billing.debug("Removing pending request: " + runnable);
            }
        }
        return runnable;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public RequestRunnable peek() {
        RequestRunnable requestRunnable;
        synchronized (this.mList) {
            requestRunnable = !this.mList.isEmpty() ? this.mList.get(0) : null;
        }
        return requestRunnable;
    }

    public void run() {
        RequestRunnable runnable = peek();
        while (runnable != null) {
            Billing.debug("Running pending request: " + runnable);
            if (runnable.run()) {
                remove(runnable);
                runnable = peek();
            } else {
                return;
            }
        }
    }

    private void remove(@Nonnull RequestRunnable runnable) {
        synchronized (this.mList) {
            Iterator<RequestRunnable> iterator = this.mList.iterator();
            while (true) {
                if (iterator.hasNext()) {
                    if (iterator.next() == runnable) {
                        Billing.debug("Removing pending request: " + runnable);
                        iterator.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onConnectionFailed() {
        Check.isMainThread();
        RequestRunnable requestRunnable = pop();
        while (requestRunnable != null) {
            Request request = requestRunnable.getRequest();
            if (request != null) {
                request.onError((int) ResponseCodes.SERVICE_NOT_CONNECTED);
                requestRunnable.cancel();
            }
            requestRunnable = pop();
        }
    }
}
