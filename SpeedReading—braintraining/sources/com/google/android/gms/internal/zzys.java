package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.p004js.zzc;
import org.json.JSONObject;

final class zzys implements zzajd<zzc> {
    private /* synthetic */ String val$message;
    private /* synthetic */ JSONObject zzcko;

    zzys(zzyk zzyk, String str, JSONObject jSONObject) {
        this.val$message = str;
        this.zzcko = jSONObject;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzc) obj).zza(this.val$message, this.zzcko);
    }

    public final void zzb(Throwable th) {
    }
}
