package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.Map;

final class zzabo implements zzt<Object> {
    private /* synthetic */ zzabn zzcqh;

    zzabo(zzabn zzabn) {
        this.zzcqh = zzabn;
    }

    public final void zza(Object obj, Map<String, String> map) {
        synchronized (this.zzcqh.mLock) {
            if (!this.zzcqh.zzcqd.isDone()) {
                if (this.zzcqh.zzcqb.equals(map.get("request_id"))) {
                    zzabt zzabt = new zzabt(1, map);
                    String type = zzabt.getType();
                    String valueOf = String.valueOf(zzabt.zznm());
                    zzafj.zzco(new StringBuilder(String.valueOf(type).length() + 24 + String.valueOf(valueOf).length()).append("Invalid ").append(type).append(" request error: ").append(valueOf).toString());
                    this.zzcqh.zzcqd.set(zzabt);
                }
            }
        }
    }
}
