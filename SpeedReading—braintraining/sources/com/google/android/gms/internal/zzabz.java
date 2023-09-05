package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzabz extends zzacb {
    private final Context mApplicationContext;
    private final Object mLock = new Object();
    @Nullable
    private SharedPreferences zzcsw;
    private final zzsu<JSONObject, JSONObject> zzcsx;

    public zzabz(Context context, zzsu<JSONObject, JSONObject> zzsu) {
        this.mApplicationContext = context.getApplicationContext();
        this.zzcsx = zzsu;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzn(JSONObject jSONObject) {
        zzmq.zza(this.mApplicationContext, 1, jSONObject);
        this.zzcsw.edit().putLong("js_last_update", zzbs.zzei().currentTimeMillis()).apply();
        return null;
    }

    public final zzajp<Void> zznt() {
        synchronized (this.mLock) {
            if (this.zzcsw == null) {
                this.zzcsw = this.mApplicationContext.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzbs.zzei().currentTimeMillis() - this.zzcsw.getLong("js_last_update", 0) < ((Long) zzbs.zzep().zzd(zzmq.zzbmp)).longValue()) {
            return zzajg.zzi(null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzaiy.zzqv());
            jSONObject.put("mf", zzbs.zzep().zzd(zzmq.zzbmq));
            jSONObject.put("cl", "173624900");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            return zzajg.zza(this.zzcsx.zzg(jSONObject), new zzaca(this), zzaju.zzdcu);
        } catch (JSONException e) {
            zzafj.zzb("Unable to populate SDK Core Constants parameters.", e);
            return zzajg.zzi(null);
        }
    }
}
