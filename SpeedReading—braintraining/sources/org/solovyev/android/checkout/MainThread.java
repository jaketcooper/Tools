package org.solovyev.android.checkout;

import android.os.Handler;
import android.os.Looper;
import javax.annotation.Nonnull;

final class MainThread implements CancellableExecutor {
    @Nonnull
    private final Handler mHandler;

    MainThread(@Nonnull Handler handler) {
        Check.isTrue(handler.getLooper() == Looper.getMainLooper(), "Should be main application thread handler");
        this.mHandler = handler;
    }

    static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public void execute(@Nonnull Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    public void cancel(@Nonnull Runnable runnable) {
        this.mHandler.removeCallbacks(runnable);
    }
}
