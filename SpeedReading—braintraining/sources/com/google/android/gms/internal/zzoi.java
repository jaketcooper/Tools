package com.google.android.gms.internal;

import com.safonov.speedreading.application.realm.IdentityRealmObject;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class zzoi implements zzamf {
    private /* synthetic */ Map zzbth;
    private /* synthetic */ zzoh zzbti;

    zzoi(zzoh zzoh, Map map) {
        this.zzbti = zzoh;
        this.zzbth = map;
    }

    public final void zza(zzama zzama, boolean z) {
        String unused = this.zzbti.zzbtg.zzbte = (String) this.zzbth.get(IdentityRealmObject.FIELD_ID);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("messageType", "htmlLoaded");
            jSONObject.put(IdentityRealmObject.FIELD_ID, this.zzbti.zzbtg.zzbte);
            this.zzbti.zzbtf.zza("sendMessageToNativeJs", jSONObject);
        } catch (JSONException e) {
            zzafj.zzb("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
