package com.google.android.gms.internal;

import android.content.Context;

@zzzb
public final class zzaek implements zzgc {
    private final Context mContext;
    private final Object mLock = new Object();
    private String zzaou;
    private boolean zzcvd = false;

    public zzaek(Context context, String str) {
        this.mContext = context;
        this.zzaou = str;
    }

    public final void setAdUnitId(String str) {
        this.zzaou = str;
    }

    public final void zza(zzgb zzgb) {
        zzu(zzgb.zzaxe);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzu(boolean r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.zzael r0 = com.google.android.gms.ads.internal.zzbs.zzfa()
            android.content.Context r1 = r4.mContext
            boolean r0 = r0.zzr(r1)
            if (r0 != 0) goto L_0x000d
        L_0x000c:
            return
        L_0x000d:
            java.lang.Object r1 = r4.mLock
            monitor-enter(r1)
            boolean r0 = r4.zzcvd     // Catch:{ all -> 0x0016 }
            if (r0 != r5) goto L_0x0019
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            goto L_0x000c
        L_0x0016:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            throw r0
        L_0x0019:
            r4.zzcvd = r5     // Catch:{ all -> 0x0016 }
            java.lang.String r0 = r4.zzaou     // Catch:{ all -> 0x0016 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0016 }
            if (r0 == 0) goto L_0x0025
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            goto L_0x000c
        L_0x0025:
            boolean r0 = r4.zzcvd     // Catch:{ all -> 0x0016 }
            if (r0 == 0) goto L_0x0036
            com.google.android.gms.internal.zzael r0 = com.google.android.gms.ads.internal.zzbs.zzfa()     // Catch:{ all -> 0x0016 }
            android.content.Context r2 = r4.mContext     // Catch:{ all -> 0x0016 }
            java.lang.String r3 = r4.zzaou     // Catch:{ all -> 0x0016 }
            r0.zzb(r2, r3)     // Catch:{ all -> 0x0016 }
        L_0x0034:
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            goto L_0x000c
        L_0x0036:
            com.google.android.gms.internal.zzael r0 = com.google.android.gms.ads.internal.zzbs.zzfa()     // Catch:{ all -> 0x0016 }
            android.content.Context r2 = r4.mContext     // Catch:{ all -> 0x0016 }
            java.lang.String r3 = r4.zzaou     // Catch:{ all -> 0x0016 }
            r0.zzc(r2, r3)     // Catch:{ all -> 0x0016 }
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaek.zzu(boolean):void");
    }
}
