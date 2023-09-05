package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;

@zzzb
public final class zzgp {
    private final Object zzaxz = new Object();
    private zzgq zzaya = null;
    private boolean zzayb = false;

    @Nullable
    public final Activity getActivity() {
        Activity activity;
        synchronized (this.zzaxz) {
            activity = this.zzaya != null ? this.zzaya.getActivity() : null;
        }
        return activity;
    }

    @Nullable
    public final Context getContext() {
        Context context;
        synchronized (this.zzaxz) {
            context = this.zzaya != null ? this.zzaya.getContext() : null;
        }
        return context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.Object r2 = r4.zzaxz
            monitor-enter(r2)
            boolean r0 = r4.zzayb     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x0048
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbjq     // Catch:{ all -> 0x0032 }
            com.google.android.gms.internal.zzmo r1 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0032 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0032 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x001b
            monitor-exit(r2)     // Catch:{ all -> 0x0032 }
        L_0x001a:
            return
        L_0x001b:
            r1 = 0
            android.content.Context r0 = r5.getApplicationContext()     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x0023
            r0 = r5
        L_0x0023:
            boolean r3 = r0 instanceof android.app.Application     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x004a
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ all -> 0x0032 }
        L_0x0029:
            if (r0 != 0) goto L_0x0035
            java.lang.String r0 = "Can not cast Context to Application"
            com.google.android.gms.internal.zzafj.zzco(r0)     // Catch:{ all -> 0x0032 }
            monitor-exit(r2)     // Catch:{ all -> 0x0032 }
            goto L_0x001a
        L_0x0032:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0032 }
            throw r0
        L_0x0035:
            com.google.android.gms.internal.zzgq r1 = r4.zzaya     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0040
            com.google.android.gms.internal.zzgq r1 = new com.google.android.gms.internal.zzgq     // Catch:{ all -> 0x0032 }
            r1.<init>()     // Catch:{ all -> 0x0032 }
            r4.zzaya = r1     // Catch:{ all -> 0x0032 }
        L_0x0040:
            com.google.android.gms.internal.zzgq r1 = r4.zzaya     // Catch:{ all -> 0x0032 }
            r1.zza((android.app.Application) r0, (android.content.Context) r5)     // Catch:{ all -> 0x0032 }
            r0 = 1
            r4.zzayb = r0     // Catch:{ all -> 0x0032 }
        L_0x0048:
            monitor-exit(r2)     // Catch:{ all -> 0x0032 }
            goto L_0x001a
        L_0x004a:
            r0 = r1
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgp.initialize(android.content.Context):void");
    }

    public final void zza(zzgs zzgs) {
        synchronized (this.zzaxz) {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbjq)).booleanValue()) {
                if (this.zzaya == null) {
                    this.zzaya = new zzgq();
                }
                this.zzaya.zza(zzgs);
            }
        }
    }
}
