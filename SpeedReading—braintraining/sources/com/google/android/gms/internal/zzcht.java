package com.google.android.gms.internal;

final class zzcht implements Runnable {
    private /* synthetic */ zzcho zzjed;
    private /* synthetic */ zzcfi zzjee;

    zzcht(zzcho zzcho, zzcfi zzcfi) {
        this.zzjed = zzcho;
        this.zzjee = zzcfi;
    }

    public final void run() {
        this.zzjed.zzitu.zzbaa();
        this.zzjed.zzitu.zzd(this.zzjee);
    }
}
