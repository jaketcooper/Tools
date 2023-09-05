package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.gmsg.zzx;
import com.google.android.gms.ads.internal.gmsg.zzz;
import com.google.android.gms.ads.internal.p004js.JavascriptEngineFactory;
import com.google.android.gms.ads.internal.p004js.zzak;
import com.google.android.gms.ads.internal.p004js.zzc;
import com.google.android.gms.ads.internal.p004js.zzo;
import com.google.android.gms.ads.internal.zzba;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzw;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@zzzb
public final class zzyk extends zzxp<zzyk> {
    private static final Object sLock = new Object();
    private static final long zzckc = TimeUnit.SECONDS.toMillis(60);
    private static boolean zzckd = false;
    private static zzo zzcke = null;
    private final Context mContext;
    private final Object mLock = new Object();
    private final zzaiy zzaqi;
    private String zzaqr;
    private final zzcs zzbta;
    private final zzba zzcjq;
    private JavascriptEngineFactory zzcka;
    private zzajp<zzc> zzckb;
    private final zzz zzckf;
    private final zzof zzckg;

    public zzyk(Context context, zzba zzba, String str, zzcs zzcs, zzaiy zzaiy) {
        zzafj.zzcn("Webview loading for native ads.");
        this.mContext = context;
        this.zzcjq = zzba;
        this.zzbta = zzcs;
        this.zzaqi = zzaiy;
        this.zzaqr = str;
        this.zzcka = new JavascriptEngineFactory();
        zzajp<zzc> zza = this.zzcka.zza(this.mContext, this.zzaqi, (String) zzbs.zzep().zzd(zzmq.zzbmt), this.zzbta, this.zzcjq.zzbk());
        this.zzckf = new zzz(this.mContext);
        this.zzckg = new zzof(zzba, str);
        this.zzckb = zzajg.zza(zza, new zzyl(this), zzaju.zzdcu);
        zzaje.zza(this.zzckb, "WebViewNativeAdsUtil.constructor");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzajp zza(zzc zzc) throws Exception {
        zzafj.zzcn("Javascript has loaded for native ads.");
        zzc.zza(this.zzcjq, this.zzcjq, this.zzcjq, this.zzcjq, false, (zzx) null, (zzw) null, (zzwh) null);
        zzc.zza("/logScionEvent", this.zzckf);
        zzc.zza("/logScionEvent", this.zzckg);
        return zzajg.zzi(zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzajp zza(JSONObject jSONObject, zzc zzc) throws Exception {
        jSONObject.put("ads_id", this.zzaqr);
        zzc.zzb("google.afma.nativeAds.handleImpressionPing", jSONObject);
        return zzajg.zzi(new JSONObject());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzc zzc, zzxq zzxq, zzajy zzajy, zzak zzak, Map map) {
        JSONObject jSONObject;
        boolean z;
        try {
            String str = (String) map.get("success");
            String str2 = (String) map.get("failure");
            if (!TextUtils.isEmpty(str2)) {
                z = false;
                jSONObject = new JSONObject(str2);
            } else {
                jSONObject = new JSONObject(str);
                z = true;
            }
            if (this.zzaqr.equals(jSONObject.optString("ads_id", ""))) {
                zzc.zzb("/nativeAdPreProcess", (zzt<? super zzak>) zzxq.zzcip);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("success", z);
                jSONObject2.put("json", jSONObject);
                zzajy.set(jSONObject2);
            }
        } catch (Throwable th) {
            zzafj.zzb("Error while preprocessing json.", th);
            zzajy.setException(th);
        }
    }

    public final void zza(String str, zzt zzt) {
        zzajg.zza(this.zzckb, new zzyq(this, str, zzt), zzaju.zzdct);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzajg.zza(this.zzckb, new zzys(this, str, jSONObject), zzaju.zzdct);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzajp zzb(JSONObject jSONObject, zzc zzc) throws Exception {
        jSONObject.put("ads_id", this.zzaqr);
        zzc.zzb("google.afma.nativeAds.handleClickGmsg", jSONObject);
        return zzajg.zzi(new JSONObject());
    }

    public final void zzb(String str, zzt zzt) {
        zzajg.zza(this.zzckb, new zzyr(this, str, zzt), zzaju.zzdct);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzajp zzc(JSONObject jSONObject, zzc zzc) throws Exception {
        jSONObject.put("ads_id", this.zzaqr);
        zzajy zzajy = new zzajy();
        zzxq zzxq = new zzxq();
        zzyp zzyp = new zzyp(this, zzc, zzxq, zzajy);
        zzxq.zzcip = zzyp;
        zzc.zza("/nativeAdPreProcess", zzyp);
        zzc.zzb("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
        return zzajy;
    }

    public final zzajp<JSONObject> zzi(JSONObject jSONObject) {
        return zzajg.zza(this.zzckb, new zzym(this, jSONObject), zzaju.zzdct);
    }

    public final zzajp<JSONObject> zzj(JSONObject jSONObject) {
        return zzajg.zza(this.zzckb, new zzyn(this, jSONObject), zzaju.zzdct);
    }

    public final zzajp<JSONObject> zzk(JSONObject jSONObject) {
        return zzajg.zza(this.zzckb, new zzyo(this, jSONObject), zzaju.zzdct);
    }

    public final void zzlm() {
        zzajg.zza(this.zzckb, new zzyt(this), zzaju.zzdct);
    }
}
