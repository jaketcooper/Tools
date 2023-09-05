package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.internal.zzadw;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzzb;
import java.util.Map;

@zzzb
public final class zzaf implements zzt<Object> {
    private final zzag zzbwt;

    public zzaf(zzag zzag) {
        this.zzbwt = zzag;
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzadw zzadw;
        String str = map.get("action");
        if ("grant".equals(str)) {
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzadw = new zzadw(str2, parseInt);
                    this.zzbwt.zzb(zzadw);
                }
            } catch (NumberFormatException e) {
                zzafj.zzc("Unable to parse reward amount.", e);
            }
            zzadw = null;
            this.zzbwt.zzb(zzadw);
        } else if ("video_start".equals(str)) {
            this.zzbwt.zzdf();
        }
    }
}
