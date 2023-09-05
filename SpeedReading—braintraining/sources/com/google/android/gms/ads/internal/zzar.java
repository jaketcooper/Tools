package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzamf;
import com.google.android.gms.internal.zzns;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzar implements zzamf {
    private /* synthetic */ zzns zzapz;
    private /* synthetic */ String zzaqa;
    private /* synthetic */ zzama zzaqb;

    zzar(zzns zzns, String str, zzama zzama) {
        this.zzapz = zzns;
        this.zzaqa = str;
        this.zzaqb = zzama;
    }

    public final void zza(zzama zzama, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", this.zzapz.getHeadline());
            jSONObject.put("body", this.zzapz.getBody());
            jSONObject.put("call_to_action", this.zzapz.getCallToAction());
            jSONObject.put(FirebaseAnalytics.Param.PRICE, this.zzapz.getPrice());
            jSONObject.put("star_rating", String.valueOf(this.zzapz.getStarRating()));
            jSONObject.put("store", this.zzapz.getStore());
            jSONObject.put("icon", zzaq.zza(this.zzapz.zzjm()));
            JSONArray jSONArray = new JSONArray();
            List<Object> images = this.zzapz.getImages();
            if (images != null) {
                for (Object zze : images) {
                    jSONArray.put(zzaq.zza(zzaq.zzd(zze)));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put("extras", zzaq.zza(this.zzapz.getExtras(), this.zzaqa));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "2");
            this.zzaqb.zzb("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e) {
            zzafj.zzc("Exception occurred when loading assets", e);
        }
    }
}
