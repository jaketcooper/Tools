package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzajy;
import com.google.android.gms.internal.zzzb;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzy implements zzt<Object> {
    private HashMap<String, zzajy<JSONObject>> zzbwj = new HashMap<>();

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("request_id");
        String str2 = map.get("fetched_ad");
        zzafj.zzbw("Received ad from the cache.");
        zzajy zzajy = this.zzbwj.get(str);
        if (zzajy == null) {
            zzafj.m12e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            zzajy.set(new JSONObject(str2));
        } catch (JSONException e) {
            zzafj.zzb("Failed constructing JSON object from value passed from javascript", e);
            zzajy.set(null);
        } finally {
            this.zzbwj.remove(str);
        }
    }

    public final Future<JSONObject> zzar(String str) {
        zzajy zzajy = new zzajy();
        this.zzbwj.put(str, zzajy);
        return zzajy;
    }

    public final void zzas(String str) {
        zzajy zzajy = this.zzbwj.get(str);
        if (zzajy == null) {
            zzafj.m12e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzajy.isDone()) {
            zzajy.cancel(true);
        }
        this.zzbwj.remove(str);
    }
}
