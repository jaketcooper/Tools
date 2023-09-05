package com.google.android.gms.internal;

final class zzako implements Runnable {
    private /* synthetic */ zzakk zzddy;

    zzako(zzakk zzakk) {
        this.zzddy = zzakk;
    }

    public final void run() {
        if (this.zzddy.zzddx != null) {
            this.zzddy.zzddx.zzre();
        }
    }
}
