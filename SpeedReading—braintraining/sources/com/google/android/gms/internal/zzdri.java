package com.google.android.gms.internal;

import java.io.IOException;

public final class zzdri extends zzfem<zzdri, zza> implements zzffs {
    private static volatile zzffu<zzdri> zzbas;
    /* access modifiers changed from: private */
    public static final zzdri zzlsx;
    private int zzlsv;
    private int zzlsw;

    public static final class zza extends zzfen<zzdri, zza> implements zzffs {
        private zza() {
            super(zzdri.zzlsx);
        }

        /* synthetic */ zza(zzdrj zzdrj) {
            this();
        }
    }

    static {
        zzdri zzdri = new zzdri();
        zzlsx = zzdri;
        zzdri.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdri.zzpcg.zzbin();
    }

    private zzdri() {
    }

    public static zzdri zzbnr() {
        return zzlsx;
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
            int[] r3 = com.google.android.gms.internal.zzdrj.zzbaq
            int r4 = r7 + -1
            r3 = r3[r4]
            switch(r3) {
                case 1: goto L_0x0012;
                case 2: goto L_0x0018;
                case 3: goto L_0x001b;
                case 4: goto L_0x001d;
                case 5: goto L_0x0023;
                case 6: goto L_0x0057;
                case 7: goto L_0x00a4;
                case 8: goto L_0x00a8;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            r0.<init>()
            throw r0
        L_0x0012:
            com.google.android.gms.internal.zzdri r6 = new com.google.android.gms.internal.zzdri
            r6.<init>()
        L_0x0017:
            return r6
        L_0x0018:
            com.google.android.gms.internal.zzdri r6 = zzlsx
            goto L_0x0017
        L_0x001b:
            r6 = r0
            goto L_0x0017
        L_0x001d:
            com.google.android.gms.internal.zzdri$zza r6 = new com.google.android.gms.internal.zzdri$zza
            r6.<init>(r0)
            goto L_0x0017
        L_0x0023:
            com.google.android.gms.internal.zzfev r8 = (com.google.android.gms.internal.zzfev) r8
            com.google.android.gms.internal.zzdri r9 = (com.google.android.gms.internal.zzdri) r9
            int r0 = r6.zzlsv
            if (r0 == 0) goto L_0x004f
            r0 = r1
        L_0x002c:
            int r4 = r6.zzlsv
            int r3 = r9.zzlsv
            if (r3 == 0) goto L_0x0051
            r3 = r1
        L_0x0033:
            int r5 = r9.zzlsv
            int r0 = r8.zza((boolean) r0, (int) r4, (boolean) r3, (int) r5)
            r6.zzlsv = r0
            int r0 = r6.zzlsw
            if (r0 == 0) goto L_0x0053
            r0 = r1
        L_0x0040:
            int r3 = r6.zzlsw
            int r4 = r9.zzlsw
            if (r4 == 0) goto L_0x0055
        L_0x0046:
            int r2 = r9.zzlsw
            int r0 = r8.zza((boolean) r0, (int) r3, (boolean) r1, (int) r2)
            r6.zzlsw = r0
            goto L_0x0017
        L_0x004f:
            r0 = r2
            goto L_0x002c
        L_0x0051:
            r3 = r2
            goto L_0x0033
        L_0x0053:
            r0 = r2
            goto L_0x0040
        L_0x0055:
            r1 = r2
            goto L_0x0046
        L_0x0057:
            com.google.android.gms.internal.zzfdy r8 = (com.google.android.gms.internal.zzfdy) r8
            com.google.android.gms.internal.zzfei r9 = (com.google.android.gms.internal.zzfei) r9
            if (r9 != 0) goto L_0x0064
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        L_0x0063:
            r2 = r1
        L_0x0064:
            if (r2 != 0) goto L_0x00a4
            int r0 = r8.zzctt()     // Catch:{ zzffe -> 0x007c, IOException -> 0x0090 }
            switch(r0) {
                case 0: goto L_0x0063;
                case 8: goto L_0x0075;
                case 16: goto L_0x0089;
                default: goto L_0x006d;
            }     // Catch:{ zzffe -> 0x007c, IOException -> 0x0090 }
        L_0x006d:
            boolean r0 = r6.zza((int) r0, (com.google.android.gms.internal.zzfdy) r8)     // Catch:{ zzffe -> 0x007c, IOException -> 0x0090 }
            if (r0 != 0) goto L_0x0064
            r2 = r1
            goto L_0x0064
        L_0x0075:
            int r0 = r8.zzcud()     // Catch:{ zzffe -> 0x007c, IOException -> 0x0090 }
            r6.zzlsv = r0     // Catch:{ zzffe -> 0x007c, IOException -> 0x0090 }
            goto L_0x0064
        L_0x007c:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.zzffe r0 = r0.zzh(r6)     // Catch:{ all -> 0x0087 }
            r1.<init>(r0)     // Catch:{ all -> 0x0087 }
            throw r1     // Catch:{ all -> 0x0087 }
        L_0x0087:
            r0 = move-exception
            throw r0
        L_0x0089:
            int r0 = r8.zzcuc()     // Catch:{ zzffe -> 0x007c, IOException -> 0x0090 }
            r6.zzlsw = r0     // Catch:{ zzffe -> 0x007c, IOException -> 0x0090 }
            goto L_0x0064
        L_0x0090:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.zzffe r2 = new com.google.android.gms.internal.zzffe     // Catch:{ all -> 0x0087 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0087 }
            r2.<init>(r0)     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.zzffe r0 = r2.zzh(r6)     // Catch:{ all -> 0x0087 }
            r1.<init>(r0)     // Catch:{ all -> 0x0087 }
            throw r1     // Catch:{ all -> 0x0087 }
        L_0x00a4:
            com.google.android.gms.internal.zzdri r6 = zzlsx
            goto L_0x0017
        L_0x00a8:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdri> r0 = zzbas
            if (r0 != 0) goto L_0x00bd
            java.lang.Class<com.google.android.gms.internal.zzdri> r1 = com.google.android.gms.internal.zzdri.class
            monitor-enter(r1)
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdri> r0 = zzbas     // Catch:{ all -> 0x00c1 }
            if (r0 != 0) goto L_0x00bc
            com.google.android.gms.internal.zzfeo r0 = new com.google.android.gms.internal.zzfeo     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.internal.zzdri r2 = zzlsx     // Catch:{ all -> 0x00c1 }
            r0.<init>(r2)     // Catch:{ all -> 0x00c1 }
            zzbas = r0     // Catch:{ all -> 0x00c1 }
        L_0x00bc:
            monitor-exit(r1)     // Catch:{ all -> 0x00c1 }
        L_0x00bd:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdri> r6 = zzbas
            goto L_0x0017
        L_0x00c1:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00c1 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdri.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlsv != zzdrc.UNKNOWN_HASH.zzhn()) {
            zzfed.zzaa(1, this.zzlsv);
        }
        if (this.zzlsw != 0) {
            zzfed.zzab(2, this.zzlsw);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzdrc zzbnp() {
        zzdrc zzfq = zzdrc.zzfq(this.zzlsv);
        return zzfq == null ? zzdrc.UNRECOGNIZED : zzfq;
    }

    public final int zzbnq() {
        return this.zzlsw;
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzlsv != zzdrc.UNKNOWN_HASH.zzhn()) {
            i2 = zzfed.zzag(1, this.zzlsv) + 0;
        }
        if (this.zzlsw != 0) {
            i2 += zzfed.zzae(2, this.zzlsw);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
