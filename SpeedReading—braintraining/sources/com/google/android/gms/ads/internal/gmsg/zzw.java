package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzzb;
import java.util.Map;

@zzzb
public final class zzw implements zzt<Object> {
    private final zzx zzbwi;

    public zzw(zzx zzx) {
        this.zzbwi = zzx;
    }

    public final void zza(Object obj, Map<String, String> map) {
        float f;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat(map.get("blurRadius"));
                this.zzbwi.zzd(equals);
                this.zzbwi.zza(equals2, f);
            }
        } catch (NumberFormatException e) {
            zzafj.zzb("Fail to parse float", e);
        }
        f = 0.0f;
        this.zzbwi.zzd(equals);
        this.zzbwi.zza(equals2, f);
    }
}
