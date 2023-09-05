package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzamf;
import com.google.android.gms.internal.zznu;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzas implements zzamf {
    private /* synthetic */ String zzaqa;
    private /* synthetic */ zzama zzaqb;
    private /* synthetic */ zznu zzaqc;

    zzas(zznu zznu, String str, zzama zzama) {
        this.zzaqc = zznu;
        this.zzaqa = str;
        this.zzaqb = zzama;
    }

    public final void zza(zzama zzama, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", this.zzaqc.getHeadline());
            jSONObject.put("body", this.zzaqc.getBody());
            jSONObject.put("call_to_action", this.zzaqc.getCallToAction());
            jSONObject.put("advertiser", this.zzaqc.getAdvertiser());
            jSONObject.put("logo", zzaq.zza(this.zzaqc.zzjt()));
            JSONArray jSONArray = new JSONArray();
            List<Object> images = this.zzaqc.getImages();
            if (images != null) {
                for (Object zze : images) {
                    jSONArray.put(zzaq.zza(zzaq.zzd(zze)));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put("extras", zzaq.zza(this.zzaqc.getExtras(), this.zzaqa));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "1");
            this.zzaqb.zzb("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e) {
            zzafj.zzc("Exception occurred when loading assets", e);
        }
    }
}
