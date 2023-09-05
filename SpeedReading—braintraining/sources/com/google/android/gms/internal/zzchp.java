package com.google.android.gms.internal;

final class zzchp implements Runnable {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzcho zzjed;

    zzchp(zzcho zzcho, zzcff zzcff) {
        this.zzjed = zzcho;
        this.zzjec = zzcff;
    }

    public final void run() {
        this.zzjed.zzitu.zzbaa();
        this.zzjed.zzitu.zze(this.zzjec);
    }
}
