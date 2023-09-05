package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

final class zzaia implements zzajb<Throwable, T> {
    private /* synthetic */ zzaie zzdat;

    zzaia(zzahy zzahy, zzaie zzaie) {
        this.zzdat = zzaie;
    }

    public final /* synthetic */ zzajp zzc(Object obj) throws Exception {
        Throwable th = (Throwable) obj;
        zzafj.zzb("Error occurred while dispatching http response in getter.", th);
        zzbs.zzeg().zza(th, "HttpGetter.deliverResponse.1");
        return zzajg.zzi(this.zzdat.zznc());
    }
}
