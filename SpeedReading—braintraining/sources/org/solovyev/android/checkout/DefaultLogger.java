package org.solovyev.android.checkout;

import android.util.Log;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
class DefaultLogger implements Logger {
    private boolean mEnabled = false;

    DefaultLogger() {
    }

    /* renamed from: e */
    public void mo19367e(@Nonnull String tag, @Nonnull String msg) {
        if (this.mEnabled) {
            Log.e(tag, msg);
        }
    }

    /* renamed from: w */
    public void mo19374w(@Nonnull String tag, @Nonnull String msg) {
        if (this.mEnabled) {
            Log.w(tag, msg);
        }
    }

    /* renamed from: i */
    public void mo19369i(@Nonnull String tag, @Nonnull String msg) {
        if (this.mEnabled) {
            Log.i(tag, msg);
        }
    }

    /* renamed from: d */
    public void mo19365d(@Nonnull String tag, @Nonnull String msg) {
        if (this.mEnabled) {
            Log.d(tag, msg);
        }
    }

    /* renamed from: v */
    public void mo19372v(@Nonnull String tag, @Nonnull String msg) {
        if (this.mEnabled) {
            Log.v(tag, msg);
        }
    }

    /* renamed from: e */
    public void mo19368e(@Nonnull String tag, @Nonnull String msg, @Nonnull Throwable e) {
        if (this.mEnabled) {
            Log.e(tag, msg, e);
        }
    }

    /* renamed from: w */
    public void mo19375w(@Nonnull String tag, @Nonnull String msg, @Nonnull Throwable e) {
        if (this.mEnabled) {
            Log.w(tag, msg, e);
        }
    }

    /* renamed from: i */
    public void mo19370i(@Nonnull String tag, @Nonnull String msg, @Nonnull Throwable e) {
        if (this.mEnabled) {
            Log.i(tag, msg, e);
        }
    }

    /* renamed from: d */
    public void mo19366d(@Nonnull String tag, @Nonnull String msg, @Nonnull Throwable e) {
        if (this.mEnabled) {
            Log.d(tag, msg, e);
        }
    }

    /* renamed from: v */
    public void mo19373v(@Nonnull String tag, @Nonnull String msg, @Nonnull Throwable e) {
        if (this.mEnabled) {
            Log.v(tag, msg, e);
        }
    }

    public void setEnabled(boolean enabled) {
        this.mEnabled = enabled;
    }
}
