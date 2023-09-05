package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzt;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class zzof implements zzt<Object> {
    private final WeakReference<zzob> zzaow;
    private final String zzaqr;

    public zzof(zzob zzob, String str) {
        this.zzaow = new WeakReference<>(zzob);
        this.zzaqr = str;
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzob zzob;
        String str = map.get("ads_id");
        String str2 = map.get("eventName");
        if (!TextUtils.isEmpty(str) && this.zzaqr.equals(str)) {
            try {
                Integer.parseInt(map.get("eventType"));
            } catch (Exception e) {
                zzafj.zzb("Parse Scion log event type error", e);
            }
            if ("_ai".equals(str2)) {
                zzob zzob2 = (zzob) this.zzaow.get();
                if (zzob2 != null) {
                    zzob2.zzbt();
                }
            } else if ("_ac".equals(str2) && (zzob = (zzob) this.zzaow.get()) != null) {
                zzob.zzbu();
            }
        }
    }
}
