package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class zzac {
    private static final long zznvt = TimeUnit.DAYS.toMillis(7);
    private long timestamp;
    private String zzida;
    final String zzlax;

    private zzac(String str, String str2, long j) {
        this.zzlax = str;
        this.zzida = str2;
        this.timestamp = j;
    }

    static String zzc(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put(AppMeasurement.Param.TIMESTAMP, j);
            return jSONObject.toString();
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to encode token: ").append(valueOf).toString());
            return null;
        }
    }

    static zzac zzqy(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new zzac(str, (String) null, 0);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzac(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong(AppMeasurement.Param.TIMESTAMP));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to parse token: ").append(valueOf).toString());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzqz(String str) {
        return System.currentTimeMillis() > this.timestamp + zznvt || !str.equals(this.zzida);
    }
}
