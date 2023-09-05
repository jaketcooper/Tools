package com.google.android.gms.internal;

final class zzchs implements Runnable {
    private /* synthetic */ zzcho zzjed;
    private /* synthetic */ zzcfi zzjee;

    zzchs(zzcho zzcho, zzcfi zzcfi) {
        this.zzjed = zzcho;
        this.zzjee = zzcfi;
    }

    public final void run() {
        this.zzjed.zzitu.zzbaa();
        this.zzjed.zzitu.zze(this.zzjee);
    }
}
