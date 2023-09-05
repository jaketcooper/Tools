package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzwc {
    private final boolean zzcfp;
    private final boolean zzcfq;
    private final boolean zzcfr;
    private final boolean zzcfs;
    private final boolean zzcft;

    private zzwc(zzwe zzwe) {
        this.zzcfp = zzwe.zzcfp;
        this.zzcfq = zzwe.zzcfq;
        this.zzcfr = zzwe.zzcfr;
        this.zzcfs = zzwe.zzcfs;
        this.zzcft = zzwe.zzcft;
    }

    public final JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzcfp).put("tel", this.zzcfq).put("calendar", this.zzcfr).put("storePicture", this.zzcfs).put("inlineVideo", this.zzcft);
        } catch (JSONException e) {
            zzafj.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
