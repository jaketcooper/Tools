package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzama;
import java.util.Map;

final class zzr implements zzt<zzama> {
    zzr() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzama zzama = (zzama) obj;
        if (map.keySet().contains("start")) {
            zzama.zzsq().zztl();
        } else if (map.keySet().contains("stop")) {
            zzama.zzsq().zztm();
        } else if (map.keySet().contains("cancel")) {
            zzama.zzsq().zztn();
        }
    }
}
