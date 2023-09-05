package com.google.android.gms.internal;

final class zzakr implements Runnable {
    private /* synthetic */ zzakk zzddy;

    zzakr(zzakk zzakk) {
        this.zzddy = zzakk;
    }

    public final void run() {
        if (this.zzddy.zzddx != null) {
            this.zzddy.zzddx.zzrg();
        }
    }
}
