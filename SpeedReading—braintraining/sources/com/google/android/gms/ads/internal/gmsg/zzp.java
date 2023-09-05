package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzmq;
import java.util.Map;

final class zzp implements zzt<zzama> {
    zzp() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzama zzama = (zzama) obj;
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzblj)).booleanValue()) {
            zzama.zzae(!Boolean.parseBoolean((String) map.get("disabled")));
        }
    }
}
