package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zztv {
    private static String zza(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public static List<String> zza(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static void zza(Context context, String str, zzaeu zzaeu, String str2, boolean z, List<String> list) {
        if (list != null && !list.isEmpty()) {
            String str3 = z ? "1" : "0";
            for (String zza : list) {
                String zza2 = zza(zza(zza(zza(zza(zza(zza(zza, "@gw_adlocid@", str2), "@gw_adnetrefresh@", str3), "@gw_qdata@", zzaeu.zzcvs.zzcca), "@gw_sdkver@", str), "@gw_sessid@", zzjk.zzhz()), "@gw_seqnum@", zzaeu.zzclr), "@gw_adnetstatus@", zzaeu.zzcvt);
                if (zzaeu.zzcdd != null) {
                    zza2 = zza(zza(zza2, "@gw_adnetid@", zzaeu.zzcdd.zzcbc), "@gw_allocid@", zzaeu.zzcdd.zzcbe);
                }
                String zzb = zzaeo.zzb(zza2, context);
                zzbs.zzec();
                zzagr.zze(context, str, zzb);
            }
        }
    }

    public static void zza(Context context, String str, List<String> list, String str2, @Nullable zzadw zzadw) {
        if (list != null && !list.isEmpty()) {
            long currentTimeMillis = zzbs.zzei().currentTimeMillis();
            for (String zza : list) {
                String zza2 = zza(zza(zza, "@gw_rwd_userid@", str2), "@gw_tmstmp@", Long.toString(currentTimeMillis));
                if (zzadw != null) {
                    zza2 = zza(zza(zza2, "@gw_rwd_itm@", zzadw.type), "@gw_rwd_amt@", Integer.toString(zzadw.zzcuk));
                }
                zzbs.zzec();
                zzagr.zze(context, str, zza2);
            }
        }
    }

    public static boolean zza(String str, int[] iArr) {
        if (TextUtils.isEmpty(str) || iArr.length != 2) {
            return false;
        }
        String[] split = str.split("x");
        if (split.length != 2) {
            return false;
        }
        try {
            iArr[0] = Integer.parseInt(split[0]);
            iArr[1] = Integer.parseInt(split[1]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
