package com.google.android.gms.internal;

import java.io.IOException;

public final class zzdrp extends zzfem<zzdrp, zza> implements zzffs {
    private static volatile zzffu<zzdrp> zzbas;
    /* access modifiers changed from: private */
    public static final zzdrp zzltp;
    private String zzlsy = "";
    private zzfdp zzlsz = zzfdp.zzpaz;

    public static final class zza extends zzfen<zzdrp, zza> implements zzffs {
        private zza() {
            super(zzdrp.zzltp);
        }

        /* synthetic */ zza(zzdrq zzdrq) {
            this();
        }
    }

    static {
        zzdrp zzdrp = new zzdrp();
        zzltp = zzdrp;
        zzdrp.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdrp.zzpcg.zzbin();
    }

    private zzdrp() {
    }

    public static zzdrp zzbnz() {
        return zzltp;
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
            int[] r3 = com.google.android.gms.internal.zzdrq.zzbaq
            int r4 = r7 + -1
            r3 = r3[r4]
            switch(r3) {
                case 1: goto L_0x0012;
                case 2: goto L_0x0018;
                case 3: goto L_0x001b;
                case 4: goto L_0x001d;
                case 5: goto L_0x0023;
                case 6: goto L_0x0063;
                case 7: goto L_0x00b0;
                case 8: goto L_0x00b4;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            r0.<init>()
            throw r0
        L_0x0012:
            com.google.android.gms.internal.zzdrp r6 = new com.google.android.gms.internal.zzdrp
            r6.<init>()
        L_0x0017:
            return r6
        L_0x0018:
            com.google.android.gms.internal.zzdrp r6 = zzltp
            goto L_0x0017
        L_0x001b:
            r6 = r0
            goto L_0x0017
        L_0x001d:
            com.google.android.gms.internal.zzdrp$zza r6 = new com.google.android.gms.internal.zzdrp$zza
            r6.<init>(r0)
            goto L_0x0017
        L_0x0023:
            com.google.android.gms.internal.zzfev r8 = (com.google.android.gms.internal.zzfev) r8
            com.google.android.gms.internal.zzdrp r9 = (com.google.android.gms.internal.zzdrp) r9
            java.lang.String r0 = r6.zzlsy
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x005b
            r0 = r1
        L_0x0030:
            java.lang.String r4 = r6.zzlsy
            java.lang.String r3 = r9.zzlsy
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x005d
            r3 = r1
        L_0x003b:
            java.lang.String r5 = r9.zzlsy
            java.lang.String r0 = r8.zza((boolean) r0, (java.lang.String) r4, (boolean) r3, (java.lang.String) r5)
            r6.zzlsy = r0
            com.google.android.gms.internal.zzfdp r0 = r6.zzlsz
            com.google.android.gms.internal.zzfdp r3 = com.google.android.gms.internal.zzfdp.zzpaz
            if (r0 == r3) goto L_0x005f
            r0 = r1
        L_0x004a:
            com.google.android.gms.internal.zzfdp r3 = r6.zzlsz
            com.google.android.gms.internal.zzfdp r4 = r9.zzlsz
            com.google.android.gms.internal.zzfdp r5 = com.google.android.gms.internal.zzfdp.zzpaz
            if (r4 == r5) goto L_0x0061
        L_0x0052:
            com.google.android.gms.internal.zzfdp r2 = r9.zzlsz
            com.google.android.gms.internal.zzfdp r0 = r8.zza((boolean) r0, (com.google.android.gms.internal.zzfdp) r3, (boolean) r1, (com.google.android.gms.internal.zzfdp) r2)
            r6.zzlsz = r0
            goto L_0x0017
        L_0x005b:
            r0 = r2
            goto L_0x0030
        L_0x005d:
            r3 = r2
            goto L_0x003b
        L_0x005f:
            r0 = r2
            goto L_0x004a
        L_0x0061:
            r1 = r2
            goto L_0x0052
        L_0x0063:
            com.google.android.gms.internal.zzfdy r8 = (com.google.android.gms.internal.zzfdy) r8
            com.google.android.gms.internal.zzfei r9 = (com.google.android.gms.internal.zzfei) r9
            if (r9 != 0) goto L_0x0070
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        L_0x006f:
            r2 = r1
        L_0x0070:
            if (r2 != 0) goto L_0x00b0
            int r0 = r8.zzctt()     // Catch:{ zzffe -> 0x0088, IOException -> 0x009c }
            switch(r0) {
                case 0: goto L_0x006f;
                case 10: goto L_0x0081;
                case 18: goto L_0x0095;
                default: goto L_0x0079;
            }     // Catch:{ zzffe -> 0x0088, IOException -> 0x009c }
        L_0x0079:
            boolean r0 = r6.zza((int) r0, (com.google.android.gms.internal.zzfdy) r8)     // Catch:{ zzffe -> 0x0088, IOException -> 0x009c }
            if (r0 != 0) goto L_0x0070
            r2 = r1
            goto L_0x0070
        L_0x0081:
            java.lang.String r0 = r8.zzcua()     // Catch:{ zzffe -> 0x0088, IOException -> 0x009c }
            r6.zzlsy = r0     // Catch:{ zzffe -> 0x0088, IOException -> 0x009c }
            goto L_0x0070
        L_0x0088:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0093 }
            com.google.android.gms.internal.zzffe r0 = r0.zzh(r6)     // Catch:{ all -> 0x0093 }
            r1.<init>(r0)     // Catch:{ all -> 0x0093 }
            throw r1     // Catch:{ all -> 0x0093 }
        L_0x0093:
            r0 = move-exception
            throw r0
        L_0x0095:
            com.google.android.gms.internal.zzfdp r0 = r8.zzcub()     // Catch:{ zzffe -> 0x0088, IOException -> 0x009c }
            r6.zzlsz = r0     // Catch:{ zzffe -> 0x0088, IOException -> 0x009c }
            goto L_0x0070
        L_0x009c:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0093 }
            com.google.android.gms.internal.zzffe r2 = new com.google.android.gms.internal.zzffe     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0093 }
            r2.<init>(r0)     // Catch:{ all -> 0x0093 }
            com.google.android.gms.internal.zzffe r0 = r2.zzh(r6)     // Catch:{ all -> 0x0093 }
            r1.<init>(r0)     // Catch:{ all -> 0x0093 }
            throw r1     // Catch:{ all -> 0x0093 }
        L_0x00b0:
            com.google.android.gms.internal.zzdrp r6 = zzltp
            goto L_0x0017
        L_0x00b4:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrp> r0 = zzbas
            if (r0 != 0) goto L_0x00c9
            java.lang.Class<com.google.android.gms.internal.zzdrp> r1 = com.google.android.gms.internal.zzdrp.class
            monitor-enter(r1)
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrp> r0 = zzbas     // Catch:{ all -> 0x00cd }
            if (r0 != 0) goto L_0x00c8
            com.google.android.gms.internal.zzfeo r0 = new com.google.android.gms.internal.zzfeo     // Catch:{ all -> 0x00cd }
            com.google.android.gms.internal.zzdrp r2 = zzltp     // Catch:{ all -> 0x00cd }
            r0.<init>(r2)     // Catch:{ all -> 0x00cd }
            zzbas = r0     // Catch:{ all -> 0x00cd }
        L_0x00c8:
            monitor-exit(r1)     // Catch:{ all -> 0x00cd }
        L_0x00c9:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrp> r6 = zzbas
            goto L_0x0017
        L_0x00cd:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00cd }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdrp.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (!this.zzlsy.isEmpty()) {
            zzfed.zzn(1, this.zzlsy);
        }
        if (!this.zzlsz.isEmpty()) {
            zzfed.zza(2, this.zzlsz);
        }
        this.zzpcg.zza(zzfed);
    }

    public final String zzbnt() {
        return this.zzlsy;
    }

    public final zzfdp zzbnu() {
        return this.zzlsz;
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.zzlsy.isEmpty()) {
            i2 = zzfed.zzo(1, this.zzlsy) + 0;
        }
        if (!this.zzlsz.isEmpty()) {
            i2 += zzfed.zzb(2, this.zzlsz);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
