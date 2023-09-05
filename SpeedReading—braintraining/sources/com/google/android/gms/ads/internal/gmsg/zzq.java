package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzama;
import java.util.Map;

final class zzq implements zzt<zzama> {
    zzq() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzama zzama = (zzama) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzama.zzck();
        } else if ("resume".equals(str)) {
            zzama.zzcl();
        }
    }
}
