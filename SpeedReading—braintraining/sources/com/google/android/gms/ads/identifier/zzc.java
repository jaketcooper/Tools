package com.google.android.gms.ads.identifier;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.HashMap;

final /* synthetic */ class zzc implements Runnable {
    private final AdvertisingIdClient.Info zzamk;
    private final boolean zzaml;
    private final long zzamm;

    zzc(AdvertisingIdClient.Info info, boolean z, long j) {
        this.zzamk = info;
        this.zzaml = z;
        this.zzamm = j;
    }

    public final void run() {
        AdvertisingIdClient.Info info = this.zzamk;
        boolean z = this.zzaml;
        long j = this.zzamm;
        HashMap hashMap = new HashMap();
        hashMap.put("ad_id_size", Integer.toString(info == null ? -1 : info.getId().length()));
        hashMap.put("has_gmscore", z ? "1" : "0");
        hashMap.put("tag", "AdvertisingIdLightClient");
        hashMap.put("time_spent", Long.toString(j));
        new zze().zzc(hashMap);
    }
}
