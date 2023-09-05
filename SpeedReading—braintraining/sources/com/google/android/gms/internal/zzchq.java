package com.google.android.gms.internal;

final class zzchq implements Runnable {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzcho zzjed;
    private /* synthetic */ zzcfi zzjee;

    zzchq(zzcho zzcho, zzcfi zzcfi, zzcff zzcff) {
        this.zzjed = zzcho;
        this.zzjee = zzcfi;
        this.zzjec = zzcff;
    }

    public final void run() {
        this.zzjed.zzitu.zzbaa();
        this.zzjed.zzitu.zzc(this.zzjee, this.zzjec);
    }
}
