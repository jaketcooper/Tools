package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.Map;

final class zzabq implements zzt<Object> {
    private /* synthetic */ zzabn zzcqh;

    zzabq(zzabn zzabn) {
        this.zzcqh = zzabn;
    }

    public final void zza(Object obj, Map<String, String> map) {
        synchronized (this.zzcqh.mLock) {
            if (!this.zzcqh.zzcqd.isDone()) {
                zzabt zzabt = new zzabt(-2, map);
                if (this.zzcqh.zzcqb.equals(zzabt.getRequestId())) {
                    this.zzcqh.zzcqd.set(zzabt);
                }
            }
        }
    }
}
