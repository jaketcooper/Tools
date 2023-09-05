package com.google.android.gms.ads.internal.p004js;

import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzakd;

/* renamed from: com.google.android.gms.ads.internal.js.zzx */
final class zzx implements zzakd<zzc> {
    private /* synthetic */ zzo zzbzq;
    private /* synthetic */ zzaf zzbzx;

    zzx(zzo zzo, zzaf zzaf) {
        this.zzbzq = zzo;
        this.zzbzx = zzaf;
    }

    public final /* synthetic */ void zzf(Object obj) {
        synchronized (this.zzbzq.mLock) {
            int unused = this.zzbzq.zzbzn = 0;
            if (!(this.zzbzq.zzbzm == null || this.zzbzx == this.zzbzq.zzbzm)) {
                zzafj.m11v("New JS engine is loaded, marking previous one as destroyable.");
                this.zzbzq.zzbzm.zzll();
            }
            zzaf unused2 = this.zzbzq.zzbzm = this.zzbzx;
        }
    }
}
