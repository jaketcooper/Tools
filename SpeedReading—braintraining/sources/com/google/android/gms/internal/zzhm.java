package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;

@zzzb
public final class zzhm {
    @Nullable
    private Context mContext;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private final Runnable zzbab = new zzhn(this);
    /* access modifiers changed from: private */
    @Nullable
    public zzht zzbac;
    /* access modifiers changed from: private */
    @Nullable
    public zzhx zzbad;

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void connect() {
        /*
            r6 = this;
            java.lang.Object r1 = r6.mLock
            monitor-enter(r1)
            android.content.Context r0 = r6.mContext     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x000b
            com.google.android.gms.internal.zzht r0 = r6.zzbac     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x000d
        L_0x000b:
            monitor-exit(r1)     // Catch:{ all -> 0x002f }
        L_0x000c:
            return
        L_0x000d:
            com.google.android.gms.internal.zzhp r0 = new com.google.android.gms.internal.zzhp     // Catch:{ all -> 0x002f }
            r0.<init>(r6)     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.zzhq r2 = new com.google.android.gms.internal.zzhq     // Catch:{ all -> 0x002f }
            r2.<init>(r6)     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.zzht r3 = new com.google.android.gms.internal.zzht     // Catch:{ all -> 0x002f }
            android.content.Context r4 = r6.mContext     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.zzaii r5 = com.google.android.gms.ads.internal.zzbs.zzet()     // Catch:{ all -> 0x002f }
            android.os.Looper r5 = r5.zzqm()     // Catch:{ all -> 0x002f }
            r3.<init>(r4, r5, r0, r2)     // Catch:{ all -> 0x002f }
            r6.zzbac = r3     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.zzht r0 = r6.zzbac     // Catch:{ all -> 0x002f }
            r0.zzajy()     // Catch:{ all -> 0x002f }
            monitor-exit(r1)     // Catch:{ all -> 0x002f }
            goto L_0x000c
        L_0x002f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhm.connect():void");
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.mLock) {
            if (this.zzbac != null) {
                if (this.zzbac.isConnected() || this.zzbac.isConnecting()) {
                    this.zzbac.disconnect();
                }
                this.zzbac = null;
                this.zzbad = null;
                Binder.flushPendingCommands();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
        L_0x0002:
            return
        L_0x0003:
            java.lang.Object r1 = r3.mLock
            monitor-enter(r1)
            android.content.Context r0 = r3.mContext     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x000f
            monitor-exit(r1)     // Catch:{ all -> 0x000c }
            goto L_0x0002
        L_0x000c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x000c }
            throw r0
        L_0x000f:
            android.content.Context r0 = r4.getApplicationContext()     // Catch:{ all -> 0x000c }
            r3.mContext = r0     // Catch:{ all -> 0x000c }
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbom     // Catch:{ all -> 0x000c }
            com.google.android.gms.internal.zzmo r2 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x000c }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ all -> 0x000c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x000c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x002c
            r3.connect()     // Catch:{ all -> 0x000c }
        L_0x002a:
            monitor-exit(r1)     // Catch:{ all -> 0x000c }
            goto L_0x0002
        L_0x002c:
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbol     // Catch:{ all -> 0x000c }
            com.google.android.gms.internal.zzmo r2 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x000c }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ all -> 0x000c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x000c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x002a
            com.google.android.gms.internal.zzho r0 = new com.google.android.gms.internal.zzho     // Catch:{ all -> 0x000c }
            r0.<init>(r3)     // Catch:{ all -> 0x000c }
            com.google.android.gms.internal.zzgp r2 = com.google.android.gms.ads.internal.zzbs.zzef()     // Catch:{ all -> 0x000c }
            r2.zza(r0)     // Catch:{ all -> 0x000c }
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhm.initialize(android.content.Context):void");
    }

    public final zzhr zza(zzhu zzhu) {
        zzhr zzhr;
        synchronized (this.mLock) {
            if (this.zzbad == null) {
                zzhr = new zzhr();
            } else {
                try {
                    zzhr = this.zzbad.zza(zzhu);
                } catch (RemoteException e) {
                    zzafj.zzb("Unable to call into cache service.", e);
                    zzhr = new zzhr();
                }
            }
        }
        return zzhr;
    }

    public final void zzhb() {
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbon)).booleanValue()) {
            synchronized (this.mLock) {
                connect();
                zzbs.zzec();
                zzagr.zzczc.removeCallbacks(this.zzbab);
                zzbs.zzec();
                zzagr.zzczc.postDelayed(this.zzbab, ((Long) zzbs.zzep().zzd(zzmq.zzboo)).longValue());
            }
        }
    }
}
