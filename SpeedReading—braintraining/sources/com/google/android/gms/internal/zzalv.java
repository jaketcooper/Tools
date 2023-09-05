package com.google.android.gms.internal;

import android.support.p000v4.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

final class zzalv implements Runnable {
    private /* synthetic */ String zzckw;
    private /* synthetic */ String zzdho;
    private /* synthetic */ int zzdhq;
    private /* synthetic */ zzalt zzdhs;

    zzalv(zzalt zzalt, String str, String str2, int i) {
        this.zzdhs = zzalt;
        this.zzckw = str;
        this.zzdho = str2;
        this.zzdhq = i;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        hashMap.put("src", this.zzckw);
        hashMap.put("cachedSrc", this.zzdho);
        hashMap.put("totalBytes", Integer.toString(this.zzdhq));
        this.zzdhs.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
