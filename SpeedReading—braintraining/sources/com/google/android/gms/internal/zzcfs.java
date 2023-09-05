package com.google.android.gms.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import java.util.Iterator;

public final class zzcfs {
    final String mAppId;
    final String mName;
    private String mOrigin;
    final long zzfgb;
    final long zziwx;
    final zzcfu zziwy;

    zzcfs(zzchj zzchj, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzbq.zzgi(str2);
        zzbq.zzgi(str3);
        this.mAppId = str2;
        this.mName = str3;
        this.mOrigin = TextUtils.isEmpty(str) ? null : str;
        this.zzfgb = j;
        this.zziwx = j2;
        if (this.zziwx != 0 && this.zziwx > this.zzfgb) {
            zzchj.zzawn().zzayu().zzj("Event created with reverse previous/current timestamps. appId", zzcgj.zzjf(str2));
        }
        this.zziwy = zza(zzchj, bundle);
    }

    private zzcfs(zzchj zzchj, String str, String str2, String str3, long j, long j2, zzcfu zzcfu) {
        zzbq.zzgi(str2);
        zzbq.zzgi(str3);
        zzbq.checkNotNull(zzcfu);
        this.mAppId = str2;
        this.mName = str3;
        this.mOrigin = TextUtils.isEmpty(str) ? null : str;
        this.zzfgb = j;
        this.zziwx = j2;
        if (this.zziwx != 0 && this.zziwx > this.zzfgb) {
            zzchj.zzawn().zzayu().zzj("Event created with reverse previous/current timestamps. appId", zzcgj.zzjf(str2));
        }
        this.zziwy = zzcfu;
    }

    private static zzcfu zza(zzchj zzchj, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new zzcfu(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                zzchj.zzawn().zzays().log("Param name can't be null");
                it.remove();
            } else {
                Object zzk = zzchj.zzawj().zzk(str, bundle2.get(str));
                if (zzk == null) {
                    zzchj.zzawn().zzayu().zzj("Param value can't be null", zzchj.zzawi().zzjd(str));
                    it.remove();
                } else {
                    zzchj.zzawj().zza(bundle2, str, zzk);
                }
            }
        }
        return new zzcfu(bundle2);
    }

    public final String toString() {
        String str = this.mAppId;
        String str2 = this.mName;
        String valueOf = String.valueOf(this.zziwy);
        return new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length()).append("Event{appId='").append(str).append("', name='").append(str2).append("', params=").append(valueOf).append("}").toString();
    }

    /* access modifiers changed from: package-private */
    public final zzcfs zza(zzchj zzchj, long j) {
        return new zzcfs(zzchj, this.mOrigin, this.mAppId, this.mName, this.zzfgb, j, this.zziwy);
    }
}
