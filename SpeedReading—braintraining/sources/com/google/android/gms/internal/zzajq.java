package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@zzzb
final class zzajq {
    private final Object zzdco = new Object();
    private final List<Runnable> zzdcp = new ArrayList();
    private boolean zzdcq = false;

    public final void zza(Runnable runnable, Executor executor) {
        synchronized (this.zzdco) {
            if (this.zzdcq) {
                executor.execute(runnable);
            } else {
                this.zzdcp.add(new zzajr(executor, runnable));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = r0.get(r2);
        r2 = r2 + 1;
        ((java.lang.Runnable) r1).run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r0 = r0;
        r3 = r0.size();
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r2 >= r3) goto L_0x000d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzqw() {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Object r1 = r4.zzdco
            monitor-enter(r1)
            boolean r2 = r4.zzdcq     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x000e
            monitor-exit(r1)     // Catch:{ all -> 0x0032 }
        L_0x000d:
            return
        L_0x000e:
            java.util.List<java.lang.Runnable> r2 = r4.zzdcp     // Catch:{ all -> 0x0032 }
            r0.addAll(r2)     // Catch:{ all -> 0x0032 }
            java.util.List<java.lang.Runnable> r2 = r4.zzdcp     // Catch:{ all -> 0x0032 }
            r2.clear()     // Catch:{ all -> 0x0032 }
            r2 = 1
            r4.zzdcq = r2     // Catch:{ all -> 0x0032 }
            monitor-exit(r1)     // Catch:{ all -> 0x0032 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r3 = r0.size()
            r1 = 0
            r2 = r1
        L_0x0024:
            if (r2 >= r3) goto L_0x000d
            java.lang.Object r1 = r0.get(r2)
            int r2 = r2 + 1
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r1.run()
            goto L_0x0024
        L_0x0032:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0032 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzajq.zzqw():void");
    }
}
