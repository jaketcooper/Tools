package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public class zzwg {
    private final zzama zzbwq;
    private final String zzcgd;

    public zzwg(zzama zzama) {
        this(zzama, "");
    }

    public zzwg(zzama zzama, String str) {
        this.zzbwq = zzama;
        this.zzcgd = str;
    }

    public final void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzbwq.zza("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (JSONException e) {
            zzafj.zzb("Error occured while obtaining screen information.", e);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzbwq.zza("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzafj.zzb("Error occured while dispatching size change.", e);
        }
    }

    public final void zzbl(String str) {
        try {
            this.zzbwq.zza("onError", new JSONObject().put("message", str).put("action", this.zzcgd));
        } catch (JSONException e) {
            zzafj.zzb("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzbm(String str) {
        try {
            this.zzbwq.zza("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzafj.zzb("Error occured while dispatching ready Event.", e);
        }
    }

    public final void zzbn(String str) {
        try {
            this.zzbwq.zza("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzafj.zzb("Error occured while dispatching state change.", e);
        }
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzbwq.zza("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzafj.zzb("Error occured while dispatching default position.", e);
        }
    }
}
