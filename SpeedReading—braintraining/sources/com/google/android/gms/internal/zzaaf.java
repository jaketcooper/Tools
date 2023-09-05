package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzaaf extends zzbej {
    public static final Parcelable.Creator<zzaaf> CREATOR = new zzaag();
    public final boolean zzcog;
    @Nullable
    public final List<String> zzcoh;

    public zzaaf() {
        this(false, Collections.emptyList());
    }

    public zzaaf(boolean z, List<String> list) {
        this.zzcog = z;
        this.zzcoh = list;
    }

    @Nullable
    public static zzaaf zzl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new zzaaf();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("reporting_urls");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                } catch (JSONException e) {
                    zzafj.zzc("Error grabbing url from json.", e);
                }
            }
        }
        return new zzaaf(jSONObject.optBoolean("enable_protection"), arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, this.zzcog);
        zzbem.zzb(parcel, 3, this.zzcoh, false);
        zzbem.zzai(parcel, zze);
    }
}
