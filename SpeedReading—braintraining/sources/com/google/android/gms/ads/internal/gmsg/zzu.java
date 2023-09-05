package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.p004js.zza;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagr;
import java.util.Map;
import org.json.JSONObject;

final class zzu implements Runnable {
    private /* synthetic */ Map zzbth;
    final /* synthetic */ zza zzbvv;
    private /* synthetic */ HttpClient zzbvw;

    zzu(HttpClient httpClient, Map map, zza zza) {
        this.zzbvw = httpClient;
        this.zzbth = map;
        this.zzbvv = zza;
    }

    public final void run() {
        zzafj.zzbw("Received Http request.");
        try {
            JSONObject send = this.zzbvw.send(new JSONObject((String) this.zzbth.get("http_request")));
            if (send == null) {
                zzafj.m12e("Response should not be null.");
            } else {
                zzagr.zzczc.post(new zzv(this, send));
            }
        } catch (Exception e) {
            zzafj.zzb("Error converting request to json.", e);
        }
    }
}
