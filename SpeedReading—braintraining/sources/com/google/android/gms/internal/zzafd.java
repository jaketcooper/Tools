package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;

@zzzb
public final class zzafd {
    private final Object mLock = new Object();
    private String mSessionId;
    int zzcxo = -1;
    private long zzcxz = -1;
    private long zzcya = -1;
    private int zzcyb = -1;
    private long zzcyc = 0;
    private int zzcyd = 0;
    private int zzcye = 0;

    public zzafd(String str) {
        this.mSessionId = str;
    }

    private static boolean zzae(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            zzafj.zzcn("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzafj.zzcn("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            zzafj.zzco("Fail to fetch AdActivity theme");
            zzafj.zzcn("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.internal.zzis r11, long r12) {
        /*
            r10 = this;
            java.lang.Object r1 = r10.mLock
            monitor-enter(r1)
            com.google.android.gms.internal.zzaez r0 = com.google.android.gms.ads.internal.zzbs.zzeg()     // Catch:{ all -> 0x0059 }
            long r2 = r0.zzpc()     // Catch:{ all -> 0x0059 }
            com.google.android.gms.common.util.zzd r0 = com.google.android.gms.ads.internal.zzbs.zzei()     // Catch:{ all -> 0x0059 }
            long r4 = r0.currentTimeMillis()     // Catch:{ all -> 0x0059 }
            long r6 = r10.zzcya     // Catch:{ all -> 0x0059 }
            r8 = -1
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x005c
            long r2 = r4 - r2
            com.google.android.gms.internal.zzmg<java.lang.Long> r0 = com.google.android.gms.internal.zzmq.zzbjs     // Catch:{ all -> 0x0059 }
            com.google.android.gms.internal.zzmo r6 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x0059 }
            java.lang.Object r0 = r6.zzd(r0)     // Catch:{ all -> 0x0059 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x0059 }
            long r6 = r0.longValue()     // Catch:{ all -> 0x0059 }
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x004e
            r0 = -1
            r10.zzcxo = r0     // Catch:{ all -> 0x0059 }
        L_0x0034:
            r10.zzcya = r12     // Catch:{ all -> 0x0059 }
            long r2 = r10.zzcya     // Catch:{ all -> 0x0059 }
            r10.zzcxz = r2     // Catch:{ all -> 0x0059 }
        L_0x003a:
            if (r11 == 0) goto L_0x005f
            android.os.Bundle r0 = r11.extras     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x005f
            android.os.Bundle r0 = r11.extras     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = "gw"
            r3 = 2
            int r0 = r0.getInt(r2, r3)     // Catch:{ all -> 0x0059 }
            r2 = 1
            if (r0 != r2) goto L_0x005f
            monitor-exit(r1)     // Catch:{ all -> 0x0059 }
        L_0x004d:
            return
        L_0x004e:
            com.google.android.gms.internal.zzaez r0 = com.google.android.gms.ads.internal.zzbs.zzeg()     // Catch:{ all -> 0x0059 }
            int r0 = r0.zzpf()     // Catch:{ all -> 0x0059 }
            r10.zzcxo = r0     // Catch:{ all -> 0x0059 }
            goto L_0x0034
        L_0x0059:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0059 }
            throw r0
        L_0x005c:
            r10.zzcxz = r12     // Catch:{ all -> 0x0059 }
            goto L_0x003a
        L_0x005f:
            int r0 = r10.zzcyb     // Catch:{ all -> 0x0059 }
            int r0 = r0 + 1
            r10.zzcyb = r0     // Catch:{ all -> 0x0059 }
            int r0 = r10.zzcxo     // Catch:{ all -> 0x0059 }
            int r0 = r0 + 1
            r10.zzcxo = r0     // Catch:{ all -> 0x0059 }
            int r0 = r10.zzcxo     // Catch:{ all -> 0x0059 }
            if (r0 != 0) goto L_0x007c
            r2 = 0
            r10.zzcyc = r2     // Catch:{ all -> 0x0059 }
            com.google.android.gms.internal.zzaez r0 = com.google.android.gms.ads.internal.zzbs.zzeg()     // Catch:{ all -> 0x0059 }
            r0.zzj(r4)     // Catch:{ all -> 0x0059 }
        L_0x007a:
            monitor-exit(r1)     // Catch:{ all -> 0x0059 }
            goto L_0x004d
        L_0x007c:
            com.google.android.gms.internal.zzaez r0 = com.google.android.gms.ads.internal.zzbs.zzeg()     // Catch:{ all -> 0x0059 }
            long r2 = r0.zzpd()     // Catch:{ all -> 0x0059 }
            long r2 = r4 - r2
            r10.zzcyc = r2     // Catch:{ all -> 0x0059 }
            goto L_0x007a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzafd.zzb(com.google.android.gms.internal.zzis, long):void");
    }

    public final Bundle zzl(Context context, String str) {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putString("session_id", this.mSessionId);
            bundle.putLong("basets", this.zzcya);
            bundle.putLong("currts", this.zzcxz);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzcyb);
            bundle.putInt("preqs_in_session", this.zzcxo);
            bundle.putLong("time_in_session", this.zzcyc);
            bundle.putInt("pclick", this.zzcyd);
            bundle.putInt("pimp", this.zzcye);
            bundle.putBoolean("support_transparent_background", zzae(context));
        }
        return bundle;
    }

    public final void zzoi() {
        synchronized (this.mLock) {
            this.zzcye++;
        }
    }

    public final void zzoj() {
        synchronized (this.mLock) {
            this.zzcyd++;
        }
    }
}
