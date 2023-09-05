package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

final class zzcig implements Runnable {
    private /* synthetic */ String zziju;
    private /* synthetic */ zzcho zzjed;
    private /* synthetic */ String zzjej;
    private /* synthetic */ String zzjek;
    private /* synthetic */ long zzjel;

    zzcig(zzcho zzcho, String str, String str2, String str3, long j) {
        this.zzjed = zzcho;
        this.zzjej = str;
        this.zziju = str2;
        this.zzjek = str3;
        this.zzjel = j;
    }

    public final void run() {
        if (this.zzjej == null) {
            this.zzjed.zzitu.zzawf().zza(this.zziju, (AppMeasurement.zzb) null);
            return;
        }
        AppMeasurement.zzb zzb = new AppMeasurement.zzb();
        zzb.zzitz = this.zzjek;
        zzb.zziua = this.zzjej;
        zzb.zziub = this.zzjel;
        this.zzjed.zzitu.zzawf().zza(this.zziju, zzb);
    }
}
