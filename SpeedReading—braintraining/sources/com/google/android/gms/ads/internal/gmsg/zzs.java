package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzama;
import java.util.Map;

final class zzs implements zzt<zzama> {
    zzs() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzama zzama = (zzama) obj;
        if (map.keySet().contains("start")) {
            zzama.zzaf(true);
        }
        if (map.keySet().contains("stop")) {
            zzama.zzaf(false);
        }
    }
}
