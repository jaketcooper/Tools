package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.p004js.zzak;
import com.google.android.gms.ads.internal.p004js.zzc;

final class zzyr implements zzajd<zzc> {
    private /* synthetic */ String zzckm;
    private /* synthetic */ zzt zzckn;

    zzyr(zzyk zzyk, String str, zzt zzt) {
        this.zzckm = str;
        this.zzckn = zzt;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzc) obj).zzb(this.zzckm, (zzt<? super zzak>) this.zzckn);
    }

    public final void zzb(Throwable th) {
    }
}
