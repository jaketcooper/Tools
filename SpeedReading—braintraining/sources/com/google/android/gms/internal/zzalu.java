package com.google.android.gms.internal;

import android.support.p000v4.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

final class zzalu implements Runnable {
    private /* synthetic */ String zzckw;
    private /* synthetic */ String zzdho;
    private /* synthetic */ int zzdhp;
    private /* synthetic */ int zzdhq;
    private /* synthetic */ boolean zzdhr = false;
    private /* synthetic */ zzalt zzdhs;

    zzalu(zzalt zzalt, String str, String str2, int i, int i2, boolean z) {
        this.zzdhs = zzalt;
        this.zzckw = str;
        this.zzdho = str2;
        this.zzdhp = i;
        this.zzdhq = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.zzckw);
        hashMap.put("cachedSrc", this.zzdho);
        hashMap.put("bytesLoaded", Integer.toString(this.zzdhp));
        hashMap.put("totalBytes", Integer.toString(this.zzdhq));
        hashMap.put("cacheReady", this.zzdhr ? "1" : "0");
        this.zzdhs.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
