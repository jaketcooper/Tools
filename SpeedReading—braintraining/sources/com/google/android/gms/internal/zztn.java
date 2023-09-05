package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zztn {
    public final List<zztm> zzcbt;
    public final long zzcbu;
    public final List<String> zzcbv;
    public final List<String> zzcbw;
    public final List<String> zzcbx;
    public final List<String> zzcby;
    public final boolean zzcbz;
    public final String zzcca;
    public final long zzccb;
    public final String zzccc;
    public final int zzccd;
    public final int zzcce;
    public final long zzccf;
    public final boolean zzccg;
    public final boolean zzcch;
    public final boolean zzcci;
    public int zzccj;
    public int zzcck;
    public boolean zzccl;

    public zztn(String str) throws JSONException {
        this(new JSONObject(str));
    }

    public zztn(List<zztm> list, long j, List<String> list2, List<String> list3, List<String> list4, List<String> list5, boolean z, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3, boolean z2) {
        this.zzcbt = list;
        this.zzcbu = j;
        this.zzcbv = list2;
        this.zzcbw = list3;
        this.zzcbx = list4;
        this.zzcby = list5;
        this.zzcbz = z;
        this.zzcca = str;
        this.zzccb = -1;
        this.zzccj = 0;
        this.zzcck = 1;
        this.zzccc = null;
        this.zzccd = 0;
        this.zzcce = -1;
        this.zzccf = -1;
        this.zzccg = false;
        this.zzcch = false;
        this.zzcci = false;
        this.zzccl = false;
    }

    public zztn(JSONObject jSONObject) throws JSONException {
        if (zzafj.zzae(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzafj.m11v(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            zztm zztm = new zztm(jSONArray.getJSONObject(i2));
            if (zztm.zzlp()) {
                this.zzccl = true;
            }
            arrayList.add(zztm);
            if (i < 0 && zza(zztm)) {
                i = i2;
            }
        }
        this.zzccj = i;
        this.zzcck = jSONArray.length();
        this.zzcbt = Collections.unmodifiableList(arrayList);
        this.zzcca = jSONObject.optString("qdata");
        this.zzcce = jSONObject.optInt("fs_model_type", -1);
        this.zzccf = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzcbu = optJSONObject.optLong("ad_network_timeout_millis", -1);
            zzbs.zzew();
            this.zzcbv = zztv.zza(optJSONObject, "click_urls");
            zzbs.zzew();
            this.zzcbw = zztv.zza(optJSONObject, "imp_urls");
            zzbs.zzew();
            this.zzcbx = zztv.zza(optJSONObject, "nofill_urls");
            zzbs.zzew();
            this.zzcby = zztv.zza(optJSONObject, "remote_ping_urls");
            this.zzcbz = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            this.zzccb = optLong > 0 ? optLong * 1000 : -1;
            zzadw zza = zzadw.zza(optJSONObject.optJSONArray("rewards"));
            if (zza == null) {
                this.zzccc = null;
                this.zzccd = 0;
            } else {
                this.zzccc = zza.type;
                this.zzccd = zza.zzcuk;
            }
            this.zzccg = optJSONObject.optBoolean("use_displayed_impression", false);
            this.zzcch = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.zzcci = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            return;
        }
        this.zzcbu = -1;
        this.zzcbv = null;
        this.zzcbw = null;
        this.zzcbx = null;
        this.zzcby = null;
        this.zzccb = -1;
        this.zzccc = null;
        this.zzccd = 0;
        this.zzccg = false;
        this.zzcbz = false;
        this.zzcch = false;
        this.zzcci = false;
    }

    private static boolean zza(zztm zztm) {
        for (String equals : zztm.zzcbd) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
