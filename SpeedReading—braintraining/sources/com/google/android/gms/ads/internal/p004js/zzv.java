package com.google.android.gms.ads.internal.p004js;

/* renamed from: com.google.android.gms.ads.internal.js.zzv */
final class zzv implements Runnable {
    final /* synthetic */ zzc zzbzr;
    private /* synthetic */ zzp zzbzs;

    zzv(zzp zzp, zzc zzc) {
        this.zzbzs = zzp;
        this.zzbzr = zzc;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r3 = this;
            com.google.android.gms.ads.internal.js.zzp r0 = r3.zzbzs
            com.google.android.gms.ads.internal.js.zzo r0 = r0.zzbzq
            java.lang.Object r1 = r0.mLock
            monitor-enter(r1)
            com.google.android.gms.ads.internal.js.zzp r0 = r3.zzbzs     // Catch:{ all -> 0x003a }
            com.google.android.gms.ads.internal.js.zzaf r0 = r0.zzbzp     // Catch:{ all -> 0x003a }
            int r0 = r0.getStatus()     // Catch:{ all -> 0x003a }
            r2 = -1
            if (r0 == r2) goto L_0x001f
            com.google.android.gms.ads.internal.js.zzp r0 = r3.zzbzs     // Catch:{ all -> 0x003a }
            com.google.android.gms.ads.internal.js.zzaf r0 = r0.zzbzp     // Catch:{ all -> 0x003a }
            int r0 = r0.getStatus()     // Catch:{ all -> 0x003a }
            r2 = 1
            if (r0 != r2) goto L_0x0021
        L_0x001f:
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
        L_0x0020:
            return
        L_0x0021:
            com.google.android.gms.ads.internal.js.zzp r0 = r3.zzbzs     // Catch:{ all -> 0x003a }
            com.google.android.gms.ads.internal.js.zzaf r0 = r0.zzbzp     // Catch:{ all -> 0x003a }
            r0.reject()     // Catch:{ all -> 0x003a }
            com.google.android.gms.ads.internal.zzbs.zzec()     // Catch:{ all -> 0x003a }
            com.google.android.gms.ads.internal.js.zzw r0 = new com.google.android.gms.ads.internal.js.zzw     // Catch:{ all -> 0x003a }
            r0.<init>(r3)     // Catch:{ all -> 0x003a }
            com.google.android.gms.internal.zzagr.runOnUiThread(r0)     // Catch:{ all -> 0x003a }
            java.lang.String r0 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.internal.zzafj.m11v(r0)     // Catch:{ all -> 0x003a }
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            goto L_0x0020
        L_0x003a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.p004js.zzv.run():void");
    }
}
