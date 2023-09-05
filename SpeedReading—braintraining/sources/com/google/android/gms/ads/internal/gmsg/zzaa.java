package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzvt;
import com.google.android.gms.internal.zzvw;
import com.google.android.gms.internal.zzvy;
import com.google.android.gms.internal.zzvz;
import com.google.android.gms.internal.zzzb;
import java.util.Map;

@zzzb
public final class zzaa implements zzt<zzama> {
    private static Map<String, Integer> zzbwm = zze.zza("resize", 1, "playVideo", 2, "storePicture", 3, "createCalendarEvent", 4, "setOrientationProperties", 5, "closeResizedAd", 6);
    private final zzw zzbwk;
    private final zzvw zzbwl;

    public zzaa(zzw zzw, zzvw zzvw) {
        this.zzbwk = zzw;
        this.zzbwl = zzvw;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzama zzama = (zzama) obj;
        int intValue = zzbwm.get((String) map.get("a")).intValue();
        if (intValue == 5 || this.zzbwk == null || this.zzbwk.zzcu()) {
            switch (intValue) {
                case 1:
                    this.zzbwl.execute(map);
                    return;
                case 3:
                    new zzvz(zzama, map).execute();
                    return;
                case 4:
                    new zzvt(zzama, map).execute();
                    return;
                case 5:
                    new zzvy(zzama, map).execute();
                    return;
                case 6:
                    this.zzbwl.zzl(true);
                    return;
                default:
                    zzafj.zzcn("Unknown MRAID command called.");
                    return;
            }
        } else {
            this.zzbwk.zzs((String) null);
        }
    }
}
