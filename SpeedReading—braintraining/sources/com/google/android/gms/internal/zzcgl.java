package com.google.android.gms.internal;

public final class zzcgl {
    private final int mPriority;
    private /* synthetic */ zzcgj zzizt;
    private final boolean zzizu;
    private final boolean zzizv;

    zzcgl(zzcgj zzcgj, int i, boolean z, boolean z2) {
        this.zzizt = zzcgj;
        this.mPriority = i;
        this.zzizu = z;
        this.zzizv = z2;
    }

    public final void log(String str) {
        this.zzizt.zza(this.mPriority, this.zzizu, this.zzizv, str, (Object) null, (Object) null, (Object) null);
    }

    public final void zzd(String str, Object obj, Object obj2, Object obj3) {
        this.zzizt.zza(this.mPriority, this.zzizu, this.zzizv, str, obj, obj2, obj3);
    }

    public final void zze(String str, Object obj, Object obj2) {
        this.zzizt.zza(this.mPriority, this.zzizu, this.zzizv, str, obj, obj2, (Object) null);
    }

    public final void zzj(String str, Object obj) {
        this.zzizt.zza(this.mPriority, this.zzizu, this.zzizv, str, obj, (Object) null, (Object) null);
    }
}
