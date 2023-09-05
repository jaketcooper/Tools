package com.google.android.gms.internal;

final class zzcia implements Runnable {
    private /* synthetic */ String zziju;
    private /* synthetic */ zzcho zzjed;
    private /* synthetic */ zzcfx zzjeh;

    zzcia(zzcho zzcho, zzcfx zzcfx, String str) {
        this.zzjed = zzcho;
        this.zzjeh = zzcfx;
        this.zziju = str;
    }

    public final void run() {
        this.zzjed.zzitu.zzbaa();
        this.zzjed.zzitu.zzb(this.zzjeh, this.zziju);
    }
}
