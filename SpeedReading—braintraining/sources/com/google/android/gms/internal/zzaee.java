package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzaee extends zzbej {
    public static final Parcelable.Creator<zzaee> CREATOR = new zzaef();
    public final String zzcuw;
    public final String zzcux;
    public final boolean zzcuy;
    public final boolean zzcuz;
    public final List<String> zzcva;
    public final boolean zzcvb;
    public final boolean zzcvc;

    public zzaee(String str, String str2, boolean z, boolean z2, List<String> list, boolean z3, boolean z4) {
        this.zzcuw = str;
        this.zzcux = str2;
        this.zzcuy = z;
        this.zzcuz = z2;
        this.zzcva = list;
        this.zzcvb = z3;
        this.zzcvc = z4;
    }

    @Nullable
    public static zzaee zzo(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("click_string", "");
        String optString2 = jSONObject.optString("report_url", "");
        boolean optBoolean = jSONObject.optBoolean("rendered_ad_enabled", false);
        boolean optBoolean2 = jSONObject.optBoolean("non_malicious_reporting_enabled", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("allowed_headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString3 = optJSONArray.optString(i);
            if (!TextUtils.isEmpty(optString3)) {
                arrayList.add(optString3.toLowerCase(Locale.ENGLISH));
            }
        }
        return new zzaee(optString, optString2, optBoolean, optBoolean2, arrayList, jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, this.zzcuw, false);
        zzbem.zza(parcel, 3, this.zzcux, false);
        zzbem.zza(parcel, 4, this.zzcuy);
        zzbem.zza(parcel, 5, this.zzcuz);
        zzbem.zzb(parcel, 6, this.zzcva, false);
        zzbem.zza(parcel, 7, this.zzcvb);
        zzbem.zza(parcel, 8, this.zzcvc);
        zzbem.zzai(parcel, zze);
    }
}
