package com.google.android.gms.internal;

import android.content.SharedPreferences;
import org.json.JSONObject;

final class zzml extends zzmg<String> {
    zzml(int i, String str, String str2) {
        super(i, str, str2, (zzmh) null);
    }

    public final /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(getKey(), (String) zzip());
    }

    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Object obj) {
        editor.putString(getKey(), (String) obj);
    }

    public final /* synthetic */ Object zzc(JSONObject jSONObject) {
        return jSONObject.optString(getKey(), (String) zzip());
    }
}
