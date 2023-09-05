package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

final class zzcjb implements Runnable {
    private /* synthetic */ zzciz zzjfo;
    private /* synthetic */ zzcjc zzjfp;

    zzcjb(zzciz zzciz, zzcjc zzcjc) {
        this.zzjfo = zzciz;
        this.zzjfp = zzcjc;
    }

    public final void run() {
        this.zzjfo.zza(this.zzjfp);
        this.zzjfo.zzjfc = null;
        this.zzjfo.zzawe().zza((AppMeasurement.zzb) null);
    }
}
