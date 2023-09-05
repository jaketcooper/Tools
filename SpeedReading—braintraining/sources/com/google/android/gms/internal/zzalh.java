package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzalh {
    public final String zzdgk;
    private boolean zzdgl;
    private int zzdgm;
    private int zzdgn;
    private int zzdgo;
    private int zzdgp;
    private boolean zzdgq;

    public zzalh(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
            }
        } else {
            jSONObject = null;
        }
        jSONObject2 = jSONObject;
        this.zzdgl = zza(jSONObject2, "aggressive_media_codec_release", zzmq.zzbhe);
        this.zzdgk = zzc(jSONObject2, "exo_player_version", zzmq.zzbgl);
        this.zzdgm = zzb(jSONObject2, "exo_cache_buffer_size", zzmq.zzbgs);
        this.zzdgn = zzb(jSONObject2, "exo_connect_timeout_millis", zzmq.zzbgm);
        this.zzdgo = zzb(jSONObject2, "exo_read_timeout_millis", zzmq.zzbgn);
        this.zzdgp = zzb(jSONObject2, "load_check_interval_bytes", zzmq.zzbgo);
        this.zzdgq = zza(jSONObject2, "use_cache_data_source", zzmq.zzbop);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.zzmg<java.lang.Boolean>, com.google.android.gms.internal.zzmg] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zza(org.json.JSONObject r1, java.lang.String r2, com.google.android.gms.internal.zzmg<java.lang.Boolean> r3) {
        /*
            if (r1 == 0) goto L_0x0008
            boolean r0 = r1.getBoolean(r2)     // Catch:{ JSONException -> 0x0007 }
        L_0x0006:
            return r0
        L_0x0007:
            r0 = move-exception
        L_0x0008:
            com.google.android.gms.internal.zzmo r0 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r0 = r0.zzd(r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalh.zza(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.zzmg):boolean");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.zzmg<java.lang.Integer>, com.google.android.gms.internal.zzmg] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(org.json.JSONObject r1, java.lang.String r2, com.google.android.gms.internal.zzmg<java.lang.Integer> r3) {
        /*
            if (r1 == 0) goto L_0x0008
            int r0 = r1.getInt(r2)     // Catch:{ JSONException -> 0x0007 }
        L_0x0006:
            return r0
        L_0x0007:
            r0 = move-exception
        L_0x0008:
            com.google.android.gms.internal.zzmo r0 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r0 = r0.zzd(r3)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalh.zzb(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.zzmg):int");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.zzmg, com.google.android.gms.internal.zzmg<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zzc(org.json.JSONObject r1, java.lang.String r2, com.google.android.gms.internal.zzmg<java.lang.String> r3) {
        /*
            if (r1 == 0) goto L_0x0008
            java.lang.String r0 = r1.getString(r2)     // Catch:{ JSONException -> 0x0007 }
        L_0x0006:
            return r0
        L_0x0007:
            r0 = move-exception
        L_0x0008:
            com.google.android.gms.internal.zzmo r0 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r0 = r0.zzd(r3)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalh.zzc(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.zzmg):java.lang.String");
    }
}
