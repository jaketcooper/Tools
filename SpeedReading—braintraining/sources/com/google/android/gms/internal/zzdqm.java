package com.google.android.gms.internal;

import java.io.IOException;

public final class zzdqm extends zzfem<zzdqm, zza> implements zzffs {
    private static volatile zzffu<zzdqm> zzbas;
    /* access modifiers changed from: private */
    public static final zzdqm zzlrh;
    private int zzlql;
    private zzfdp zzlqt = zzfdp.zzpaz;

    public static final class zza extends zzfen<zzdqm, zza> implements zzffs {
        private zza() {
            super(zzdqm.zzlrh);
        }

        /* synthetic */ zza(zzdqn zzdqn) {
            this();
        }

        public final zza zzfn(int i) {
            zzcvj();
            ((zzdqm) this.zzpcj).setVersion(0);
            return this;
        }

        public final zza zzu(zzfdp zzfdp) {
            zzcvj();
            ((zzdqm) this.zzpcj).zzj(zzfdp);
            return this;
        }
    }

    static {
        zzdqm zzdqm = new zzdqm();
        zzlrh = zzdqm;
        zzdqm.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdqm.zzpcg.zzbin();
    }

    private zzdqm() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzlql = i;
    }

    public static zza zzbmp() {
        zzdqm zzdqm = zzlrh;
        zzfen zzfen = (zzfen) zzdqm.zza(zzfeu.zzpcv, (Object) null, (Object) null);
        zzfen.zza(zzdqm);
        return (zza) zzfen;
    }

    /* access modifiers changed from: private */
    public final void zzj(zzfdp zzfdp) {
        if (zzfdp == null) {
            throw new NullPointerException();
        }
        this.zzlqt = zzfdp;
    }

    public static zzdqm zzt(zzfdp zzfdp) throws zzffe {
        return (zzdqm) zzfem.zza(zzlrh, zzfdp);
    }

    public final int getVersion() {
        return this.zzlql;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: CFG modification limit reached, blocks count: 169 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(int r7, java.lang.Object r8, java.lang.Object r9) {
        /*
            r6 = this;
            r0 = 0
            r2 = 0
            r1 = 1
            int[] r3 = com.google.android.gms.internal.zzdqn.zzbaq
            int r4 = r7 + -1
            r3 = r3[r4]
            switch(r3) {
                case 1: goto L_0x0012;
                case 2: goto L_0x0018;
                case 3: goto L_0x001b;
                case 4: goto L_0x001d;
                case 5: goto L_0x0023;
                case 6: goto L_0x005b;
                case 7: goto L_0x00a8;
                case 8: goto L_0x00ac;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            r0.<init>()
            throw r0
        L_0x0012:
            com.google.android.gms.internal.zzdqm r6 = new com.google.android.gms.internal.zzdqm
            r6.<init>()
        L_0x0017:
            return r6
        L_0x0018:
            com.google.android.gms.internal.zzdqm r6 = zzlrh
            goto L_0x0017
        L_0x001b:
            r6 = r0
            goto L_0x0017
        L_0x001d:
            com.google.android.gms.internal.zzdqm$zza r6 = new com.google.android.gms.internal.zzdqm$zza
            r6.<init>(r0)
            goto L_0x0017
        L_0x0023:
            com.google.android.gms.internal.zzfev r8 = (com.google.android.gms.internal.zzfev) r8
            com.google.android.gms.internal.zzdqm r9 = (com.google.android.gms.internal.zzdqm) r9
            int r0 = r6.zzlql
            if (r0 == 0) goto L_0x0053
            r0 = r1
        L_0x002c:
            int r4 = r6.zzlql
            int r3 = r9.zzlql
            if (r3 == 0) goto L_0x0055
            r3 = r1
        L_0x0033:
            int r5 = r9.zzlql
            int r0 = r8.zza((boolean) r0, (int) r4, (boolean) r3, (int) r5)
            r6.zzlql = r0
            com.google.android.gms.internal.zzfdp r0 = r6.zzlqt
            com.google.android.gms.internal.zzfdp r3 = com.google.android.gms.internal.zzfdp.zzpaz
            if (r0 == r3) goto L_0x0057
            r0 = r1
        L_0x0042:
            com.google.android.gms.internal.zzfdp r3 = r6.zzlqt
            com.google.android.gms.internal.zzfdp r4 = r9.zzlqt
            com.google.android.gms.internal.zzfdp r5 = com.google.android.gms.internal.zzfdp.zzpaz
            if (r4 == r5) goto L_0x0059
        L_0x004a:
            com.google.android.gms.internal.zzfdp r2 = r9.zzlqt
            com.google.android.gms.internal.zzfdp r0 = r8.zza((boolean) r0, (com.google.android.gms.internal.zzfdp) r3, (boolean) r1, (com.google.android.gms.internal.zzfdp) r2)
            r6.zzlqt = r0
            goto L_0x0017
        L_0x0053:
            r0 = r2
            goto L_0x002c
        L_0x0055:
            r3 = r2
            goto L_0x0033
        L_0x0057:
            r0 = r2
            goto L_0x0042
        L_0x0059:
            r1 = r2
            goto L_0x004a
        L_0x005b:
            com.google.android.gms.internal.zzfdy r8 = (com.google.android.gms.internal.zzfdy) r8
            com.google.android.gms.internal.zzfei r9 = (com.google.android.gms.internal.zzfei) r9
            if (r9 != 0) goto L_0x0068
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        L_0x0067:
            r2 = r1
        L_0x0068:
            if (r2 != 0) goto L_0x00a8
            int r0 = r8.zzctt()     // Catch:{ zzffe -> 0x0080, IOException -> 0x0094 }
            switch(r0) {
                case 0: goto L_0x0067;
                case 8: goto L_0x0079;
                case 18: goto L_0x008d;
                default: goto L_0x0071;
            }     // Catch:{ zzffe -> 0x0080, IOException -> 0x0094 }
        L_0x0071:
            boolean r0 = r6.zza((int) r0, (com.google.android.gms.internal.zzfdy) r8)     // Catch:{ zzffe -> 0x0080, IOException -> 0x0094 }
            if (r0 != 0) goto L_0x0068
            r2 = r1
            goto L_0x0068
        L_0x0079:
            int r0 = r8.zzcuc()     // Catch:{ zzffe -> 0x0080, IOException -> 0x0094 }
            r6.zzlql = r0     // Catch:{ zzffe -> 0x0080, IOException -> 0x0094 }
            goto L_0x0068
        L_0x0080:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.zzffe r0 = r0.zzh(r6)     // Catch:{ all -> 0x008b }
            r1.<init>(r0)     // Catch:{ all -> 0x008b }
            throw r1     // Catch:{ all -> 0x008b }
        L_0x008b:
            r0 = move-exception
            throw r0
        L_0x008d:
            com.google.android.gms.internal.zzfdp r0 = r8.zzcub()     // Catch:{ zzffe -> 0x0080, IOException -> 0x0094 }
            r6.zzlqt = r0     // Catch:{ zzffe -> 0x0080, IOException -> 0x0094 }
            goto L_0x0068
        L_0x0094:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.zzffe r2 = new com.google.android.gms.internal.zzffe     // Catch:{ all -> 0x008b }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x008b }
            r2.<init>(r0)     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.zzffe r0 = r2.zzh(r6)     // Catch:{ all -> 0x008b }
            r1.<init>(r0)     // Catch:{ all -> 0x008b }
            throw r1     // Catch:{ all -> 0x008b }
        L_0x00a8:
            com.google.android.gms.internal.zzdqm r6 = zzlrh
            goto L_0x0017
        L_0x00ac:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdqm> r0 = zzbas
            if (r0 != 0) goto L_0x00c1
            java.lang.Class<com.google.android.gms.internal.zzdqm> r1 = com.google.android.gms.internal.zzdqm.class
            monitor-enter(r1)
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdqm> r0 = zzbas     // Catch:{ all -> 0x00c5 }
            if (r0 != 0) goto L_0x00c0
            com.google.android.gms.internal.zzfeo r0 = new com.google.android.gms.internal.zzfeo     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.internal.zzdqm r2 = zzlrh     // Catch:{ all -> 0x00c5 }
            r0.<init>(r2)     // Catch:{ all -> 0x00c5 }
            zzbas = r0     // Catch:{ all -> 0x00c5 }
        L_0x00c0:
            monitor-exit(r1)     // Catch:{ all -> 0x00c5 }
        L_0x00c1:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdqm> r6 = zzbas
            goto L_0x0017
        L_0x00c5:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00c5 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdqm.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlql != 0) {
            zzfed.zzab(1, this.zzlql);
        }
        if (!this.zzlqt.isEmpty()) {
            zzfed.zza(2, this.zzlqt);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzfdp zzblu() {
        return this.zzlqt;
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzlql != 0) {
            i2 = zzfed.zzae(1, this.zzlql) + 0;
        }
        if (!this.zzlqt.isEmpty()) {
            i2 += zzfed.zzb(2, this.zzlqt);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
