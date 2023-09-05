package com.google.android.gms.ads.internal;

final class zzh implements Runnable {
    private /* synthetic */ zzd zzand;

    zzh(zzd zzd) {
        this.zzand = zzd;
    }

    public final void run() {
        this.zzand.zzams.resume();
    }
}
