package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzmq;
import java.util.Map;
import java.util.TreeMap;

final class zzbr {
    private final String zzarn;
    private final Map<String, String> zzaro = new TreeMap();
    private String zzarp;
    private String zzarq;

    public zzbr(String str) {
        this.zzarn = str;
    }

    public final String getQuery() {
        return this.zzarp;
    }

    public final void zza(zzis zzis, zzaiy zzaiy) {
        this.zzarp = zzis.zzbcc.zzbfj;
        Bundle bundle = zzis.zzbcf != null ? zzis.zzbcf.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle != null) {
            String str = (String) zzbs.zzep().zzd(zzmq.zzbny);
            for (String str2 : bundle.keySet()) {
                if (str.equals(str2)) {
                    this.zzarq = bundle.getString(str2);
                } else if (str2.startsWith("csa_")) {
                    this.zzaro.put(str2.substring(4), bundle.getString(str2));
                }
            }
            this.zzaro.put("SDKVersion", zzaiy.zzcp);
        }
    }

    public final String zzdu() {
        return this.zzarq;
    }

    public final String zzdv() {
        return this.zzarn;
    }

    public final Map<String, String> zzdw() {
        return this.zzaro;
    }
}
