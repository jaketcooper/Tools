package com.google.android.gms.internal;

final class zzcic implements Runnable {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzcho zzjed;
    private /* synthetic */ zzckk zzjei;

    zzcic(zzcho zzcho, zzckk zzckk, zzcff zzcff) {
        this.zzjed = zzcho;
        this.zzjei = zzckk;
        this.zzjec = zzcff;
    }

    public final void run() {
        this.zzjed.zzitu.zzbaa();
        this.zzjed.zzitu.zzc(this.zzjei, this.zzjec);
    }
}
