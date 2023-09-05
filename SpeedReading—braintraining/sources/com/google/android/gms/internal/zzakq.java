package com.google.android.gms.internal;

final class zzakq implements Runnable {
    private /* synthetic */ zzakk zzddy;

    zzakq(zzakk zzakk) {
        this.zzddy = zzakk;
    }

    public final void run() {
        if (this.zzddy.zzddx != null) {
            this.zzddy.zzddx.onPaused();
            this.zzddy.zzddx.zzri();
        }
    }
}
