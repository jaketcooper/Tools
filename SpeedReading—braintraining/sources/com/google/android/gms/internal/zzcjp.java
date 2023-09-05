package com.google.android.gms.internal;

final class zzcjp implements Runnable {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzckk zzjei;
    private /* synthetic */ zzcjd zzjfy;
    private /* synthetic */ boolean zzjgc;

    zzcjp(zzcjd zzcjd, boolean z, zzckk zzckk, zzcff zzcff) {
        this.zzjfy = zzcjd;
        this.zzjgc = z;
        this.zzjei = zzckk;
        this.zzjec = zzcff;
    }

    public final void run() {
        zzcgb zzd = this.zzjfy.zzjfs;
        if (zzd == null) {
            this.zzjfy.zzawn().zzays().log("Discarding data. Failed to set user attribute");
            return;
        }
        this.zzjfy.zza(zzd, this.zzjgc ? null : this.zzjei, this.zzjec);
        this.zzjfy.zzxg();
    }
}
