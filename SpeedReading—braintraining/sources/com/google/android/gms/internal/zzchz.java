package com.google.android.gms.internal;

final class zzchz implements Runnable {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzcho zzjed;
    private /* synthetic */ zzcfx zzjeh;

    zzchz(zzcho zzcho, zzcfx zzcfx, zzcff zzcff) {
        this.zzjed = zzcho;
        this.zzjeh = zzcfx;
        this.zzjec = zzcff;
    }

    public final void run() {
        this.zzjed.zzitu.zzbaa();
        this.zzjed.zzitu.zzb(this.zzjeh, this.zzjec);
    }
}
