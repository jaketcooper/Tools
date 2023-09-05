package org.solovyev.android.checkout;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class MainThreadRequestListener<R> extends RequestListenerWrapper<R> {
    @Nullable
    private Runnable mErrorRunnable;
    @Nonnull
    private final CancellableExecutor mMainThread;
    @Nullable
    private Runnable mSuccessRunnable;

    MainThreadRequestListener(@Nonnull CancellableExecutor mainThread, @Nonnull RequestListener<R> listener) {
        super(listener);
        this.mMainThread = mainThread;
    }

    public void onSuccess(@Nonnull final R result) {
        this.mSuccessRunnable = new Runnable() {
            public void run() {
                MainThreadRequestListener.this.mListener.onSuccess(result);
            }
        };
        this.mMainThread.execute(this.mSuccessRunnable);
    }

    public void onError(final int response, @Nonnull final Exception e) {
        this.mErrorRunnable = new Runnable() {
            public void run() {
                MainThreadRequestListener.this.mListener.onError(response, e);
            }
        };
        this.mMainThread.execute(this.mErrorRunnable);
    }

    public void onCancel() {
        if (this.mSuccessRunnable != null) {
            this.mMainThread.cancel(this.mSuccessRunnable);
            this.mSuccessRunnable = null;
        }
        if (this.mErrorRunnable != null) {
            this.mMainThread.cancel(this.mErrorRunnable);
            this.mErrorRunnable = null;
        }
    }
}
