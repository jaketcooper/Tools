package com.google.android.gms.internal;

import android.content.SharedPreferences;
import org.json.JSONObject;

final class zzmk extends zzmg<Float> {
    zzmk(int i, String str, Float f) {
        super(i, str, f, (zzmh) null);
    }

    public final /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(getKey(), ((Float) zzip()).floatValue()));
    }

    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Object obj) {
        editor.putFloat(getKey(), ((Float) obj).floatValue());
    }

    public final /* synthetic */ Object zzc(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(getKey(), (double) ((Float) zzip()).floatValue()));
    }
}
