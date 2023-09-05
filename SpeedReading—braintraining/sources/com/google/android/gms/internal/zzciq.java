package com.google.android.gms.internal;

final class zzciq implements Runnable {
    private /* synthetic */ zzcik zzjer;
    private /* synthetic */ long zzjev;

    zzciq(zzcik zzcik, long j) {
        this.zzjer = zzcik;
        this.zzjev = j;
    }

    public final void run() {
        this.zzjer.zzawo().zzjat.set(this.zzjev);
        this.zzjer.zzawn().zzayx().zzj("Minimum session duration set", Long.valueOf(this.zzjev));
    }
}
