package com.google.android.gms.internal;

final class zzos implements Runnable {
    private /* synthetic */ zzoe zzbty;
    private /* synthetic */ zzor zzbuf;

    zzos(zzor zzor, zzoe zzoe) {
        this.zzbuf = zzor;
        this.zzbty = zzoe;
    }

    public final void run() {
        this.zzbuf.zza(this.zzbty);
    }
}
