package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzzb;
import java.util.Map;

@zzzb
public final class zza implements zzt<Object> {
    private final zzb zzbva;

    public zza(zzb zzb) {
        this.zzbva = zzb;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzafj.zzco("App event with no name parameter.");
        } else {
            this.zzbva.onAppEvent(str, map.get("info"));
        }
    }
}
