package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class zzcja implements Runnable {
    private /* synthetic */ boolean zzjfl;
    private /* synthetic */ AppMeasurement.zzb zzjfm;
    private /* synthetic */ zzcjc zzjfn;
    private /* synthetic */ zzciz zzjfo;

    zzcja(zzciz zzciz, boolean z, AppMeasurement.zzb zzb, zzcjc zzcjc) {
        this.zzjfo = zzciz;
        this.zzjfl = z;
        this.zzjfm = zzb;
        this.zzjfn = zzcjc;
    }

    public final void run() {
        if (this.zzjfl && this.zzjfo.zzjfc != null) {
            this.zzjfo.zza(this.zzjfo.zzjfc);
        }
        if (this.zzjfm == null || this.zzjfm.zziub != this.zzjfn.zziub || !zzckn.zzas(this.zzjfm.zziua, this.zzjfn.zziua) || !zzckn.zzas(this.zzjfm.zzitz, this.zzjfn.zzitz)) {
            Bundle bundle = new Bundle();
            zzciz.zza((AppMeasurement.zzb) this.zzjfn, bundle);
            if (this.zzjfm != null) {
                if (this.zzjfm.zzitz != null) {
                    bundle.putString("_pn", this.zzjfm.zzitz);
                }
                bundle.putString("_pc", this.zzjfm.zziua);
                bundle.putLong("_pi", this.zzjfm.zziub);
            }
            this.zzjfo.zzawb().zzc("auto", "_vs", bundle);
        }
        this.zzjfo.zzjfc = this.zzjfn;
        this.zzjfo.zzawe().zza((AppMeasurement.zzb) this.zzjfn);
    }
}
