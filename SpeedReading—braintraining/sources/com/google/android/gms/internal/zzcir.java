package com.google.android.gms.internal;

final class zzcir implements Runnable {
    private /* synthetic */ zzcik zzjer;
    private /* synthetic */ long zzjev;

    zzcir(zzcik zzcik, long j) {
        this.zzjer = zzcik;
        this.zzjev = j;
    }

    public final void run() {
        this.zzjer.zzawo().zzjau.set(this.zzjev);
        this.zzjer.zzawn().zzayx().zzj("Session timeout duration set", Long.valueOf(this.zzjev));
    }
}
