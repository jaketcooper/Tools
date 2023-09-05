package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class zzol implements zzt<Object> {
    private /* synthetic */ zzyg zzbtf;
    private /* synthetic */ zzog zzbtg;

    zzol(zzog zzog, zzyg zzyg) {
        this.zzbtg = zzog;
        this.zzbtf = zzyg;
    }

    public final void zza(Object obj, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String next : map.keySet()) {
                jSONObject.put(next, map.get(next));
            }
            jSONObject.put(IdentityRealmObject.FIELD_ID, this.zzbtg.zzbte);
            this.zzbtf.zza("sendMessageToNativeJs", jSONObject);
        } catch (JSONException e) {
            zzafj.zzb("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
