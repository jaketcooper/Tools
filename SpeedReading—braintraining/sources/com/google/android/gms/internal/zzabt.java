package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzzb
public final class zzabt {
    private int mErrorCode;
    private String zzad;
    private final String zzcqb;
    private final List<String> zzcrm;
    private final String zzcrn;
    private final String zzcro;
    private final String zzcrp;
    private final boolean zzcrq;
    private final String zzcrr;
    private final boolean zzcrs;

    public zzabt(int i, Map<String, String> map) {
        this.zzad = map.get("url");
        this.zzcrn = map.get("base_uri");
        this.zzcro = map.get("post_parameters");
        this.zzcrq = parseBoolean(map.get("drt_include"));
        this.zzcqb = map.get("request_id");
        this.zzcrp = map.get("type");
        this.zzcrm = zzbo(map.get("errors"));
        this.mErrorCode = i;
        this.zzcrr = map.get("fetched_ad");
        this.zzcrs = parseBoolean(map.get("render_test_ad_label"));
    }

    public zzabt(JSONObject jSONObject) {
        int i = 1;
        this.zzad = jSONObject.optString("url");
        this.zzcrn = jSONObject.optString("base_uri");
        this.zzcro = jSONObject.optString("post_parameters");
        this.zzcrq = parseBoolean(jSONObject.optString("drt_include"));
        this.zzcqb = jSONObject.optString("request_id");
        this.zzcrp = jSONObject.optString("type");
        this.zzcrm = zzbo(jSONObject.optString("errors"));
        this.mErrorCode = jSONObject.optInt("valid", 0) == 1 ? -2 : i;
        this.zzcrr = jSONObject.optString("fetched_ad");
        this.zzcrs = jSONObject.optBoolean("render_test_ad_label");
    }

    private static boolean parseBoolean(String str) {
        return str != null && (str.equals("1") || str.equals("true"));
    }

    private static List<String> zzbo(String str) {
        if (str == null) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    public final int getErrorCode() {
        return this.mErrorCode;
    }

    public final String getRequestId() {
        return this.zzcqb;
    }

    public final String getType() {
        return this.zzcrp;
    }

    public final String getUrl() {
        return this.zzad;
    }

    public final void setUrl(String str) {
        this.zzad = str;
    }

    public final List<String> zznm() {
        return this.zzcrm;
    }

    public final String zznn() {
        return this.zzcrn;
    }

    public final String zzno() {
        return this.zzcro;
    }

    public final boolean zznp() {
        return this.zzcrq;
    }

    public final String zznq() {
        return this.zzcrr;
    }

    public final boolean zznr() {
        return this.zzcrs;
    }
}
