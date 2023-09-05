package com.google.android.gms.internal;

final class zzchr implements Runnable {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzcho zzjed;
    private /* synthetic */ zzcfi zzjee;

    zzchr(zzcho zzcho, zzcfi zzcfi, zzcff zzcff) {
        this.zzjed = zzcho;
        this.zzjee = zzcfi;
        this.zzjec = zzcff;
    }

    public final void run() {
        this.zzjed.zzitu.zzbaa();
        this.zzjed.zzitu.zzb(this.zzjee, this.zzjec);
    }
}
