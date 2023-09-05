package org.solovyev.android.checkout;

import android.os.Handler;
import android.os.Looper;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
class MainThreadLogger implements Logger {
    /* access modifiers changed from: private */
    @Nonnull
    public final Logger mLogger;
    private final MainThread mMainThread = new MainThread(new Handler(Looper.getMainLooper()));

    public MainThreadLogger(@Nonnull Logger logger) {
        this.mLogger = logger;
    }

    /* renamed from: v */
    public void mo19372v(@Nonnull final String tag, @Nonnull final String msg) {
        this.mMainThread.execute(new Runnable() {
            public void run() {
                MainThreadLogger.this.mLogger.mo19372v(tag, msg);
            }
        });
    }

    /* renamed from: v */
    public void mo19373v(@Nonnull final String tag, @Nonnull final String msg, @Nonnull final Throwable e) {
        this.mMainThread.execute(new Runnable() {
            public void run() {
                MainThreadLogger.this.mLogger.mo19373v(tag, msg, e);
            }
        });
    }

    /* renamed from: d */
    public void mo19365d(@Nonnull final String tag, @Nonnull final String msg) {
        this.mMainThread.execute(new Runnable() {
            public void run() {
                MainThreadLogger.this.mLogger.mo19365d(tag, msg);
            }
        });
    }

    /* renamed from: d */
    public void mo19366d(@Nonnull final String tag, @Nonnull final String msg, @Nonnull final Throwable e) {
        this.mMainThread.execute(new Runnable() {
            public void run() {
                MainThreadLogger.this.mLogger.mo19366d(tag, msg, e);
            }
        });
    }

    /* renamed from: i */
    public void mo19369i(@Nonnull final String tag, @Nonnull final String msg) {
        this.mMainThread.execute(new Runnable() {
            public void run() {
                MainThreadLogger.this.mLogger.mo19369i(tag, msg);
            }
        });
    }

    /* renamed from: i */
    public void mo19370i(@Nonnull final String tag, @Nonnull final String msg, @Nonnull final Throwable e) {
        this.mMainThread.execute(new Runnable() {
            public void run() {
                MainThreadLogger.this.mLogger.mo19370i(tag, msg, e);
            }
        });
    }

    /* renamed from: w */
    public void mo19374w(@Nonnull final String tag, @Nonnull final String msg) {
        this.mMainThread.execute(new Runnable() {
            public void run() {
                MainThreadLogger.this.mLogger.mo19374w(tag, msg);
            }
        });
    }

    /* renamed from: w */
    public void mo19375w(@Nonnull final String tag, @Nonnull final String msg, @Nonnull final Throwable e) {
        this.mMainThread.execute(new Runnable() {
            public void run() {
                MainThreadLogger.this.mLogger.mo19375w(tag, msg, e);
            }
        });
    }

    /* renamed from: e */
    public void mo19367e(@Nonnull final String tag, @Nonnull final String msg) {
        this.mMainThread.execute(new Runnable() {
            public void run() {
                MainThreadLogger.this.mLogger.mo19367e(tag, msg);
            }
        });
    }

    /* renamed from: e */
    public void mo19368e(@Nonnull final String tag, @Nonnull final String msg, @Nonnull final Throwable e) {
        this.mMainThread.execute(new Runnable() {
            public void run() {
                MainThreadLogger.this.mLogger.mo19368e(tag, msg, e);
            }
        });
    }
}
