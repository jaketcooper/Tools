package com.google.android.gms.ads.internal.p004js;

import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzakb;

/* renamed from: com.google.android.gms.ads.internal.js.zzy */
final class zzy implements zzakb {
    private /* synthetic */ zzo zzbzq;
    private /* synthetic */ zzaf zzbzx;

    zzy(zzo zzo, zzaf zzaf) {
        this.zzbzq = zzo;
        this.zzbzx = zzaf;
    }

    public final void run() {
        synchronized (this.zzbzq.mLock) {
            int unused = this.zzbzq.zzbzn = 1;
            zzafj.m11v("Failed loading new engine. Marking new engine destroyable.");
            this.zzbzx.zzll();
        }
    }
}
