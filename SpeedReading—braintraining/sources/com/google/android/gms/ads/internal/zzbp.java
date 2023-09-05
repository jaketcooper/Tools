package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcs;
import java.util.concurrent.Callable;

final class zzbp implements Callable<zzcs> {
    private /* synthetic */ zzbm zzarm;

    zzbp(zzbm zzbm) {
        this.zzarm = zzbm;
    }

    public final /* synthetic */ Object call() throws Exception {
        return new zzcs(zzcr.zza(this.zzarm.zzaov.zzcp, this.zzarm.mContext, false));
    }
}
