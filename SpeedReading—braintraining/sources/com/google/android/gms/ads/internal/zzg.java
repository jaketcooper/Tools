package com.google.android.gms.ads.internal;

final class zzg implements Runnable {
    private /* synthetic */ zzd zzand;

    zzg(zzd zzd) {
        this.zzand = zzd;
    }

    public final void run() {
        this.zzand.zzams.pause();
    }
}
