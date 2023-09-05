package com.google.android.gms.internal;

final class zzaks implements Runnable {
    private /* synthetic */ zzakk zzddy;

    zzaks(zzakk zzakk) {
        this.zzddy = zzakk;
    }

    public final void run() {
        if (this.zzddy.zzddx != null) {
            this.zzddy.zzddx.onPaused();
        }
    }
}
