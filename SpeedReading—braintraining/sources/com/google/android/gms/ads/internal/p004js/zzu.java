package com.google.android.gms.ads.internal.p004js;

import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzaim;
import java.util.Map;

/* renamed from: com.google.android.gms.ads.internal.js.zzu */
final class zzu implements zzt<zzak> {
    private /* synthetic */ zzc zzbzr;
    private /* synthetic */ zzp zzbzs;
    private /* synthetic */ zzaim zzbzv;

    zzu(zzp zzp, zzc zzc, zzaim zzaim) {
        this.zzbzs = zzp;
        this.zzbzr = zzc;
        this.zzbzv = zzaim;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        synchronized (this.zzbzs.zzbzq.mLock) {
            zzafj.zzcn("JS Engine is requesting an update");
            if (this.zzbzs.zzbzq.zzbzn == 0) {
                zzafj.zzcn("Starting reload.");
                int unused = this.zzbzs.zzbzq.zzbzn = 2;
                this.zzbzs.zzbzq.zza(this.zzbzs.zzbzo);
            }
            this.zzbzr.zzb("/requestReload", (zzt<? super zzak>) (zzt) this.zzbzv.get());
        }
    }
}
