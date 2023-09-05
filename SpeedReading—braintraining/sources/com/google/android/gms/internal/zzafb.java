package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

final class zzafb {
    private final Object mLock;
    private volatile int zzcxt;
    private volatile long zzcxu;

    private zzafb() {
        this.mLock = new Object();
        this.zzcxt = zzafc.zzcxv;
        this.zzcxu = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzd(int r6, int r7) {
        /*
            r5 = this;
            r5.zzpq()
            com.google.android.gms.common.util.zzd r0 = com.google.android.gms.ads.internal.zzbs.zzei()
            long r0 = r0.currentTimeMillis()
            java.lang.Object r2 = r5.mLock
            monitor-enter(r2)
            int r3 = r5.zzcxt     // Catch:{ all -> 0x0020 }
            if (r3 == r6) goto L_0x0014
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
        L_0x0013:
            return
        L_0x0014:
            r5.zzcxt = r7     // Catch:{ all -> 0x0020 }
            int r3 = r5.zzcxt     // Catch:{ all -> 0x0020 }
            int r4 = com.google.android.gms.internal.zzafc.zzcxx     // Catch:{ all -> 0x0020 }
            if (r3 != r4) goto L_0x001e
            r5.zzcxu = r0     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            goto L_0x0013
        L_0x0020:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzafb.zzd(int, int):void");
    }

    private final void zzpq() {
        long currentTimeMillis = zzbs.zzei().currentTimeMillis();
        synchronized (this.mLock) {
            if (this.zzcxt == zzafc.zzcxx) {
                if (this.zzcxu + ((Long) zzbs.zzep().zzd(zzmq.zzbpy)).longValue() <= currentTimeMillis) {
                    this.zzcxt = zzafc.zzcxv;
                }
            }
        }
    }

    public final boolean zzpg() {
        zzpq();
        return this.zzcxt == zzafc.zzcxw;
    }

    public final boolean zzph() {
        zzpq();
        return this.zzcxt == zzafc.zzcxx;
    }

    public final void zzpi() {
        zzd(zzafc.zzcxw, zzafc.zzcxx);
    }

    public final void zzz(boolean z) {
        if (z) {
            zzd(zzafc.zzcxv, zzafc.zzcxw);
        } else {
            zzd(zzafc.zzcxw, zzafc.zzcxv);
        }
    }
}
