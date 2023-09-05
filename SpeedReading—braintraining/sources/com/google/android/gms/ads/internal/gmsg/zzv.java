package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzafj;
import org.json.JSONObject;

final class zzv implements Runnable {
    private /* synthetic */ JSONObject zzbvx;
    private /* synthetic */ zzu zzbvy;

    zzv(zzu zzu, JSONObject jSONObject) {
        this.zzbvy = zzu;
        this.zzbvx = jSONObject;
    }

    public final void run() {
        this.zzbvy.zzbvv.zza("fetchHttpRequestCompleted", this.zzbvx);
        zzafj.zzbw("Dispatched http response.");
    }
}
