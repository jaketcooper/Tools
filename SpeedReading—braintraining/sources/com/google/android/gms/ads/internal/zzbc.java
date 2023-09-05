package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.android.gms.internal.zzaaa;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzajg;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zzoc;
import com.google.android.gms.internal.zzzz;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

final class zzbc implements Callable<zzoc> {
    private /* synthetic */ zzaev zzana;
    private /* synthetic */ zzba zzaqs;
    private /* synthetic */ int zzaqt;
    private /* synthetic */ JSONArray zzaqu;
    private /* synthetic */ int zzaqv;

    zzbc(zzba zzba, int i, JSONArray jSONArray, int i2, zzaev zzaev) {
        this.zzaqs = zzba;
        this.zzaqt = i;
        this.zzaqu = jSONArray;
        this.zzaqv = i2;
        this.zzana = zzaev;
    }

    public final /* synthetic */ Object call() throws Exception {
        if (this.zzaqt >= this.zzaqu.length()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.zzaqu.get(this.zzaqt));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ads", jSONArray);
        zzba zzba = new zzba(this.zzaqs.zzamt.zzaif, this.zzaqs.zzamw, this.zzaqs.zzamt.zzath, this.zzaqs.zzamt.zzatb, this.zzaqs.zzanb, this.zzaqs.zzamt.zzatd, true);
        zzba.zza(this.zzaqs.zzamt, zzba.zzamt);
        zzba.zzdj();
        zzba.zza(this.zzaqs.zzamp);
        zznd zznd = zzba.zzamo;
        int i = this.zzaqt;
        zznd.zzf("num_ads_requested", String.valueOf(this.zzaqv));
        zznd.zzf("ad_index", String.valueOf(i));
        zzzz zzzz = this.zzana.zzcpe;
        String jSONObject2 = jSONObject.toString();
        Bundle bundle = zzzz.zzclo.extras != null ? new Bundle(zzzz.zzclo.extras) : new Bundle();
        bundle.putString("_ad", jSONObject2);
        zzba.zza(new zzaaa(zzzz.zzcln, new zzis(zzzz.zzclo.versionCode, zzzz.zzclo.zzbbv, bundle, zzzz.zzclo.zzbbw, zzzz.zzclo.zzbbx, zzzz.zzclo.zzbby, zzzz.zzclo.zzbbz, zzzz.zzclo.zzbca, zzzz.zzclo.zzbcb, zzzz.zzclo.zzbcc, zzzz.zzclo.zzbcd, zzzz.zzclo.zzbce, zzzz.zzclo.zzbcf, zzzz.zzclo.zzbcg, zzzz.zzclo.zzbch, zzzz.zzclo.zzbci, zzzz.zzclo.zzbcj, zzzz.zzclo.zzbck), zzzz.zzath, zzzz.zzatb, zzzz.applicationInfo, zzzz.zzclp, zzzz.zzclr, zzzz.zzcls, zzzz.zzatd, zzzz.zzclt, zzzz.zzaub, zzzz.zzcmd, zzzz.zzclv, zzzz.zzclw, zzzz.zzclx, zzzz.zzcly, zzzz.zzaxd, zzzz.zzclz, zzzz.zzcma, zzzz.zzcmb, zzzz.zzcmc, zzzz.zzata, zzzz.zzatt, zzzz.zzcmf, zzzz.zzcmg, zzzz.zzcmm, zzzz.zzcmh, zzzz.zzcmi, zzzz.zzcmj, zzzz.zzcmk, zzajg.zzi(zzzz.zzcml), zzzz.zzcmn, zzzz.zzcbz, zzzz.zzcmo, zzzz.zzcmp, zzzz.zzcmq, zzzz.zzatv, zzzz.zzcmr, zzzz.zzcms, zzzz.zzcmw, zzajg.zzi(zzzz.zzclq), zzzz.zzatx, zzzz.zzcmx, zzzz.zzcmy, 1, zzzz.zzcna, zzzz.zzcnb), zzba.zzamo);
        return zzba.zzdl().get();
    }
}
