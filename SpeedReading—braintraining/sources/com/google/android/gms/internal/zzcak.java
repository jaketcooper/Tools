package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.p000v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

final class zzcak implements zzf, zzg {
    private final String packageName;
    private zzcal zzhzb;
    private final String zzhzc;
    private final LinkedBlockingQueue<zzaw> zzhzd;
    private final HandlerThread zzhze = new HandlerThread("GassClient");

    public zzcak(Context context, String str, String str2) {
        this.packageName = str;
        this.zzhzc = str2;
        this.zzhze.start();
        this.zzhzb = new zzcal(context, this.zzhze.getLooper(), this, this);
        this.zzhzd = new LinkedBlockingQueue<>();
        this.zzhzb.zzajy();
    }

    private final zzcaq zzaud() {
        try {
            return this.zzhzb.zzauf();
        } catch (DeadObjectException | IllegalStateException e) {
            return null;
        }
    }

    private static zzaw zzaue() {
        zzaw zzaw = new zzaw();
        zzaw.zzdn = Long.valueOf(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID);
        return zzaw;
    }

    private final void zzne() {
        if (this.zzhzb == null) {
            return;
        }
        if (this.zzhzb.isConnected() || this.zzhzb.isConnecting()) {
            this.zzhzb.disconnect();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        zzne();
        r4.zzhze.quit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0038 A[ExcHandler:  FINALLY, Splitter:B:2:0x0006] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(android.os.Bundle r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.zzcaq r0 = r4.zzaud()
            if (r0 == 0) goto L_0x0024
            com.google.android.gms.internal.zzcam r1 = new com.google.android.gms.internal.zzcam     // Catch:{ Throwable -> 0x0025, all -> 0x0038 }
            java.lang.String r2 = r4.packageName     // Catch:{ Throwable -> 0x0025, all -> 0x0038 }
            java.lang.String r3 = r4.zzhzc     // Catch:{ Throwable -> 0x0025, all -> 0x0038 }
            r1.<init>(r2, r3)     // Catch:{ Throwable -> 0x0025, all -> 0x0038 }
            com.google.android.gms.internal.zzcao r0 = r0.zza(r1)     // Catch:{ Throwable -> 0x0025, all -> 0x0038 }
            com.google.android.gms.internal.zzaw r0 = r0.zzaug()     // Catch:{ Throwable -> 0x0025, all -> 0x0038 }
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.zzaw> r1 = r4.zzhzd     // Catch:{ Throwable -> 0x0025, all -> 0x0038 }
            r1.put(r0)     // Catch:{ Throwable -> 0x0025, all -> 0x0038 }
            r4.zzne()
            android.os.HandlerThread r0 = r4.zzhze
            r0.quit()
        L_0x0024:
            return
        L_0x0025:
            r0 = move-exception
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.zzaw> r0 = r4.zzhzd     // Catch:{ InterruptedException -> 0x0042, all -> 0x0038 }
            com.google.android.gms.internal.zzaw r1 = zzaue()     // Catch:{ InterruptedException -> 0x0042, all -> 0x0038 }
            r0.put(r1)     // Catch:{ InterruptedException -> 0x0042, all -> 0x0038 }
        L_0x002f:
            r4.zzne()
            android.os.HandlerThread r0 = r4.zzhze
            r0.quit()
            goto L_0x0024
        L_0x0038:
            r0 = move-exception
            r4.zzne()
            android.os.HandlerThread r1 = r4.zzhze
            r1.quit()
            throw r0
        L_0x0042:
            r0 = move-exception
            goto L_0x002f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcak.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzhzd.put(zzaue());
        } catch (InterruptedException e) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            this.zzhzd.put(zzaue());
        } catch (InterruptedException e) {
        }
    }

    public final zzaw zzdp(int i) {
        zzaw zzaw;
        try {
            zzaw = this.zzhzd.poll(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzaw = null;
        }
        return zzaw == null ? zzaue() : zzaw;
    }
}
