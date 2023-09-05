package com.google.android.gms.internal;

import android.support.p000v4.app.NotificationCompat;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

final class zzalw implements Runnable {
    private /* synthetic */ String val$message;
    private /* synthetic */ String zzckw;
    private /* synthetic */ String zzdho;
    private /* synthetic */ zzalt zzdhs;
    private /* synthetic */ String zzdht;

    zzalw(zzalt zzalt, String str, String str2, String str3, String str4) {
        this.zzdhs = zzalt;
        this.zzckw = str;
        this.zzdho = str2;
        this.zzdht = str3;
        this.val$message = str4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheCanceled");
        hashMap.put("src", this.zzckw);
        if (!TextUtils.isEmpty(this.zzdho)) {
            hashMap.put("cachedSrc", this.zzdho);
        }
        hashMap.put("type", zzalt.zzcs(this.zzdht));
        hashMap.put("reason", this.zzdht);
        if (!TextUtils.isEmpty(this.val$message)) {
            hashMap.put("message", this.val$message);
        }
        this.zzdhs.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
