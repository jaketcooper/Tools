package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzbs;

@zzzb
public final class zzade extends zzafh implements zzadk, zzadn {
    /* access modifiers changed from: private */
    public final Context mContext;
    private int mErrorCode = 3;
    private final Object mLock;
    /* access modifiers changed from: private */
    public final String zzcco;
    private final zzaev zzchv;
    private final zzadr zzctm;
    private final zzadn zzctn;
    /* access modifiers changed from: private */
    public final String zzcto;
    private final zztm zzctp;
    private final long zzctq;
    private int zzctr = 0;
    private zzadh zzcts;

    public zzade(Context context, String str, String str2, zztm zztm, zzaev zzaev, zzadr zzadr, zzadn zzadn, long j) {
        this.mContext = context;
        this.zzcco = str;
        this.zzcto = str2;
        this.zzctp = zztm;
        this.zzchv = zzaev;
        this.zzctm = zzadr;
        this.mLock = new Object();
        this.zzctn = zzadn;
        this.zzctq = j;
    }

    /* access modifiers changed from: private */
    public final void zza(zzis zzis, zzuf zzuf) {
        this.zzctm.zzod().zza((zzadn) this);
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzcco)) {
                zzuf.zza(zzis, this.zzcto, this.zzctp.zzcbb);
            } else {
                zzuf.zzc(zzis, this.zzcto);
            }
        } catch (RemoteException e) {
            zzafj.zzc("Fail to load ad from adapter.", e);
            zza(this.zzcco, 0);
        }
    }

    private final boolean zze(long j) {
        long elapsedRealtime = this.zzctq - (zzbs.zzei().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            this.mErrorCode = 4;
            return false;
        }
        try {
            this.mLock.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.mErrorCode = 5;
            return false;
        }
    }

    public final void onStop() {
    }

    public final void zza(String str, int i) {
        synchronized (this.mLock) {
            this.zzctr = 2;
            this.mErrorCode = i;
            this.mLock.notify();
        }
    }

    public final void zzaa(int i) {
        zza(this.zzcco, 0);
    }

    public final void zzbq(String str) {
        synchronized (this.mLock) {
            this.zzctr = 1;
            this.mLock.notify();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        r2 = new com.google.android.gms.internal.zzadj().zzf(com.google.android.gms.ads.internal.zzbs.zzei().elapsedRealtime() - r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        if (1 != r10.zzctr) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
        r0 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        r10.zzcts = r2.zzab(r0).zzbr(r10.zzcco).zzbs(r10.zzctp.zzcbe).zzoa();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0 = r10.mErrorCode;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzdg() {
        /*
            r10 = this;
            r9 = 1
            r8 = 0
            com.google.android.gms.internal.zzadr r0 = r10.zzctm
            if (r0 == 0) goto L_0x0016
            com.google.android.gms.internal.zzadr r0 = r10.zzctm
            com.google.android.gms.internal.zzadm r0 = r0.zzod()
            if (r0 == 0) goto L_0x0016
            com.google.android.gms.internal.zzadr r0 = r10.zzctm
            com.google.android.gms.internal.zzuf r0 = r0.zzoc()
            if (r0 != 0) goto L_0x0017
        L_0x0016:
            return
        L_0x0017:
            com.google.android.gms.internal.zzadr r0 = r10.zzctm
            com.google.android.gms.internal.zzadm r1 = r0.zzod()
            r1.zza((com.google.android.gms.internal.zzadn) r8)
            r1.zza((com.google.android.gms.internal.zzadk) r10)
            com.google.android.gms.internal.zzaev r0 = r10.zzchv
            com.google.android.gms.internal.zzzz r0 = r0.zzcpe
            com.google.android.gms.internal.zzis r0 = r0.zzclo
            com.google.android.gms.internal.zzadr r2 = r10.zzctm
            com.google.android.gms.internal.zzuf r2 = r2.zzoc()
            boolean r3 = r2.isInitialized()     // Catch:{ RemoteException -> 0x009c }
            if (r3 == 0) goto L_0x0091
            android.os.Handler r3 = com.google.android.gms.internal.zzais.zzdbs     // Catch:{ RemoteException -> 0x009c }
            com.google.android.gms.internal.zzadf r4 = new com.google.android.gms.internal.zzadf     // Catch:{ RemoteException -> 0x009c }
            r4.<init>(r10, r0, r2)     // Catch:{ RemoteException -> 0x009c }
            r3.post(r4)     // Catch:{ RemoteException -> 0x009c }
        L_0x003f:
            com.google.android.gms.common.util.zzd r0 = com.google.android.gms.ads.internal.zzbs.zzei()
            long r2 = r0.elapsedRealtime()
        L_0x0047:
            java.lang.Object r4 = r10.mLock
            monitor-enter(r4)
            int r0 = r10.zzctr     // Catch:{ all -> 0x00e1 }
            if (r0 == 0) goto L_0x00ac
            com.google.android.gms.internal.zzadj r0 = new com.google.android.gms.internal.zzadj     // Catch:{ all -> 0x00e1 }
            r0.<init>()     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.common.util.zzd r5 = com.google.android.gms.ads.internal.zzbs.zzei()     // Catch:{ all -> 0x00e1 }
            long r6 = r5.elapsedRealtime()     // Catch:{ all -> 0x00e1 }
            long r2 = r6 - r2
            com.google.android.gms.internal.zzadj r2 = r0.zzf(r2)     // Catch:{ all -> 0x00e1 }
            int r0 = r10.zzctr     // Catch:{ all -> 0x00e1 }
            if (r9 != r0) goto L_0x00a9
            r0 = 6
        L_0x0066:
            com.google.android.gms.internal.zzadj r0 = r2.zzab(r0)     // Catch:{ all -> 0x00e1 }
            java.lang.String r2 = r10.zzcco     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.internal.zzadj r0 = r0.zzbr(r2)     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.internal.zztm r2 = r10.zzctp     // Catch:{ all -> 0x00e1 }
            java.lang.String r2 = r2.zzcbe     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.internal.zzadj r0 = r0.zzbs(r2)     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.internal.zzadh r0 = r0.zzoa()     // Catch:{ all -> 0x00e1 }
            r10.zzcts = r0     // Catch:{ all -> 0x00e1 }
            monitor-exit(r4)     // Catch:{ all -> 0x00e1 }
        L_0x007f:
            r1.zza((com.google.android.gms.internal.zzadn) r8)
            r1.zza((com.google.android.gms.internal.zzadk) r8)
            int r0 = r10.zzctr
            if (r0 != r9) goto L_0x00e7
            com.google.android.gms.internal.zzadn r0 = r10.zzctn
            java.lang.String r1 = r10.zzcco
            r0.zzbq(r1)
            goto L_0x0016
        L_0x0091:
            android.os.Handler r3 = com.google.android.gms.internal.zzais.zzdbs     // Catch:{ RemoteException -> 0x009c }
            com.google.android.gms.internal.zzadg r4 = new com.google.android.gms.internal.zzadg     // Catch:{ RemoteException -> 0x009c }
            r4.<init>(r10, r2, r0, r1)     // Catch:{ RemoteException -> 0x009c }
            r3.post(r4)     // Catch:{ RemoteException -> 0x009c }
            goto L_0x003f
        L_0x009c:
            r0 = move-exception
            java.lang.String r2 = "Fail to check if adapter is initialized."
            com.google.android.gms.internal.zzafj.zzc(r2, r0)
            java.lang.String r0 = r10.zzcco
            r2 = 0
            r10.zza((java.lang.String) r0, (int) r2)
            goto L_0x003f
        L_0x00a9:
            int r0 = r10.mErrorCode     // Catch:{ all -> 0x00e1 }
            goto L_0x0066
        L_0x00ac:
            boolean r0 = r10.zze(r2)     // Catch:{ all -> 0x00e1 }
            if (r0 != 0) goto L_0x00e4
            com.google.android.gms.internal.zzadj r0 = new com.google.android.gms.internal.zzadj     // Catch:{ all -> 0x00e1 }
            r0.<init>()     // Catch:{ all -> 0x00e1 }
            int r5 = r10.mErrorCode     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.internal.zzadj r0 = r0.zzab(r5)     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.common.util.zzd r5 = com.google.android.gms.ads.internal.zzbs.zzei()     // Catch:{ all -> 0x00e1 }
            long r6 = r5.elapsedRealtime()     // Catch:{ all -> 0x00e1 }
            long r2 = r6 - r2
            com.google.android.gms.internal.zzadj r0 = r0.zzf(r2)     // Catch:{ all -> 0x00e1 }
            java.lang.String r2 = r10.zzcco     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.internal.zzadj r0 = r0.zzbr(r2)     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.internal.zztm r2 = r10.zzctp     // Catch:{ all -> 0x00e1 }
            java.lang.String r2 = r2.zzcbe     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.internal.zzadj r0 = r0.zzbs(r2)     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.internal.zzadh r0 = r0.zzoa()     // Catch:{ all -> 0x00e1 }
            r10.zzcts = r0     // Catch:{ all -> 0x00e1 }
            monitor-exit(r4)     // Catch:{ all -> 0x00e1 }
            goto L_0x007f
        L_0x00e1:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00e1 }
            throw r0
        L_0x00e4:
            monitor-exit(r4)     // Catch:{ all -> 0x00e1 }
            goto L_0x0047
        L_0x00e7:
            com.google.android.gms.internal.zzadn r0 = r10.zzctn
            java.lang.String r1 = r10.zzcco
            int r2 = r10.mErrorCode
            r0.zza(r1, r2)
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzade.zzdg():void");
    }

    public final zzadh zznx() {
        zzadh zzadh;
        synchronized (this.mLock) {
            zzadh = this.zzcts;
        }
        return zzadh;
    }

    public final zztm zzny() {
        return this.zzctp;
    }

    public final void zznz() {
        zza(this.zzchv.zzcpe.zzclo, this.zzctm.zzoc());
    }
}
