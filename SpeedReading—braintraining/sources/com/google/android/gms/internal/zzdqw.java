package com.google.android.gms.internal;

import java.io.IOException;

public final class zzdqw extends zzfem<zzdqw, zza> implements zzffs {
    private static volatile zzffu<zzdqw> zzbas;
    /* access modifiers changed from: private */
    public static final zzdqw zzlsa;
    private int zzlrx;
    private int zzlry;
    private zzfdp zzlrz = zzfdp.zzpaz;

    public static final class zza extends zzfen<zzdqw, zza> implements zzffs {
        private zza() {
            super(zzdqw.zzlsa);
        }

        /* synthetic */ zza(zzdqx zzdqx) {
            this();
        }
    }

    static {
        zzdqw zzdqw = new zzdqw();
        zzlsa = zzdqw;
        zzdqw.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdqw.zzpcg.zzbin();
    }

    private zzdqw() {
    }

    public static zzdqw zzbng() {
        return zzlsa;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: CFG modification limit reached, blocks count: 179 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(int r7, java.lang.Object r8, java.lang.Object r9) {
        /*
            r6 = this;
            r0 = 0
            r2 = 0
            r1 = 1
            int[] r3 = com.google.android.gms.internal.zzdqx.zzbaq
            int r4 = r7 + -1
            r3 = r3[r4]
            switch(r3) {
                case 1: goto L_0x0012;
                case 2: goto L_0x0018;
                case 3: goto L_0x001b;
                case 4: goto L_0x001d;
                case 5: goto L_0x0023;
                case 6: goto L_0x0073;
                case 7: goto L_0x00c7;
                case 8: goto L_0x00cb;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            r0.<init>()
            throw r0
        L_0x0012:
            com.google.android.gms.internal.zzdqw r6 = new com.google.android.gms.internal.zzdqw
            r6.<init>()
        L_0x0017:
            return r6
        L_0x0018:
            com.google.android.gms.internal.zzdqw r6 = zzlsa
            goto L_0x0017
        L_0x001b:
            r6 = r0
            goto L_0x0017
        L_0x001d:
            com.google.android.gms.internal.zzdqw$zza r6 = new com.google.android.gms.internal.zzdqw$zza
            r6.<init>(r0)
            goto L_0x0017
        L_0x0023:
            com.google.android.gms.internal.zzfev r8 = (com.google.android.gms.internal.zzfev) r8
            com.google.android.gms.internal.zzdqw r9 = (com.google.android.gms.internal.zzdqw) r9
            int r0 = r6.zzlrx
            if (r0 == 0) goto L_0x0067
            r0 = r1
        L_0x002c:
            int r4 = r6.zzlrx
            int r3 = r9.zzlrx
            if (r3 == 0) goto L_0x0069
            r3 = r1
        L_0x0033:
            int r5 = r9.zzlrx
            int r0 = r8.zza((boolean) r0, (int) r4, (boolean) r3, (int) r5)
            r6.zzlrx = r0
            int r0 = r6.zzlry
            if (r0 == 0) goto L_0x006b
            r0 = r1
        L_0x0040:
            int r4 = r6.zzlry
            int r3 = r9.zzlry
            if (r3 == 0) goto L_0x006d
            r3 = r1
        L_0x0047:
            int r5 = r9.zzlry
            int r0 = r8.zza((boolean) r0, (int) r4, (boolean) r3, (int) r5)
            r6.zzlry = r0
            com.google.android.gms.internal.zzfdp r0 = r6.zzlrz
            com.google.android.gms.internal.zzfdp r3 = com.google.android.gms.internal.zzfdp.zzpaz
            if (r0 == r3) goto L_0x006f
            r0 = r1
        L_0x0056:
            com.google.android.gms.internal.zzfdp r3 = r6.zzlrz
            com.google.android.gms.internal.zzfdp r4 = r9.zzlrz
            com.google.android.gms.internal.zzfdp r5 = com.google.android.gms.internal.zzfdp.zzpaz
            if (r4 == r5) goto L_0x0071
        L_0x005e:
            com.google.android.gms.internal.zzfdp r2 = r9.zzlrz
            com.google.android.gms.internal.zzfdp r0 = r8.zza((boolean) r0, (com.google.android.gms.internal.zzfdp) r3, (boolean) r1, (com.google.android.gms.internal.zzfdp) r2)
            r6.zzlrz = r0
            goto L_0x0017
        L_0x0067:
            r0 = r2
            goto L_0x002c
        L_0x0069:
            r3 = r2
            goto L_0x0033
        L_0x006b:
            r0 = r2
            goto L_0x0040
        L_0x006d:
            r3 = r2
            goto L_0x0047
        L_0x006f:
            r0 = r2
            goto L_0x0056
        L_0x0071:
            r1 = r2
            goto L_0x005e
        L_0x0073:
            com.google.android.gms.internal.zzfdy r8 = (com.google.android.gms.internal.zzfdy) r8
            com.google.android.gms.internal.zzfei r9 = (com.google.android.gms.internal.zzfei) r9
            if (r9 != 0) goto L_0x0080
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        L_0x007f:
            r2 = r1
        L_0x0080:
            if (r2 != 0) goto L_0x00c7
            int r0 = r8.zzctt()     // Catch:{ zzffe -> 0x0098, IOException -> 0x00ac }
            switch(r0) {
                case 0: goto L_0x007f;
                case 8: goto L_0x0091;
                case 16: goto L_0x00a5;
                case 90: goto L_0x00c0;
                default: goto L_0x0089;
            }     // Catch:{ zzffe -> 0x0098, IOException -> 0x00ac }
        L_0x0089:
            boolean r0 = r6.zza((int) r0, (com.google.android.gms.internal.zzfdy) r8)     // Catch:{ zzffe -> 0x0098, IOException -> 0x00ac }
            if (r0 != 0) goto L_0x0080
            r2 = r1
            goto L_0x0080
        L_0x0091:
            int r0 = r8.zzcud()     // Catch:{ zzffe -> 0x0098, IOException -> 0x00ac }
            r6.zzlrx = r0     // Catch:{ zzffe -> 0x0098, IOException -> 0x00ac }
            goto L_0x0080
        L_0x0098:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.zzffe r0 = r0.zzh(r6)     // Catch:{ all -> 0x00a3 }
            r1.<init>(r0)     // Catch:{ all -> 0x00a3 }
            throw r1     // Catch:{ all -> 0x00a3 }
        L_0x00a3:
            r0 = move-exception
            throw r0
        L_0x00a5:
            int r0 = r8.zzcud()     // Catch:{ zzffe -> 0x0098, IOException -> 0x00ac }
            r6.zzlry = r0     // Catch:{ zzffe -> 0x0098, IOException -> 0x00ac }
            goto L_0x0080
        L_0x00ac:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.zzffe r2 = new com.google.android.gms.internal.zzffe     // Catch:{ all -> 0x00a3 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00a3 }
            r2.<init>(r0)     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.zzffe r0 = r2.zzh(r6)     // Catch:{ all -> 0x00a3 }
            r1.<init>(r0)     // Catch:{ all -> 0x00a3 }
            throw r1     // Catch:{ all -> 0x00a3 }
        L_0x00c0:
            com.google.android.gms.internal.zzfdp r0 = r8.zzcub()     // Catch:{ zzffe -> 0x0098, IOException -> 0x00ac }
            r6.zzlrz = r0     // Catch:{ zzffe -> 0x0098, IOException -> 0x00ac }
            goto L_0x0080
        L_0x00c7:
            com.google.android.gms.internal.zzdqw r6 = zzlsa
            goto L_0x0017
        L_0x00cb:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdqw> r0 = zzbas
            if (r0 != 0) goto L_0x00e0
            java.lang.Class<com.google.android.gms.internal.zzdqw> r1 = com.google.android.gms.internal.zzdqw.class
            monitor-enter(r1)
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdqw> r0 = zzbas     // Catch:{ all -> 0x00e4 }
            if (r0 != 0) goto L_0x00df
            com.google.android.gms.internal.zzfeo r0 = new com.google.android.gms.internal.zzfeo     // Catch:{ all -> 0x00e4 }
            com.google.android.gms.internal.zzdqw r2 = zzlsa     // Catch:{ all -> 0x00e4 }
            r0.<init>(r2)     // Catch:{ all -> 0x00e4 }
            zzbas = r0     // Catch:{ all -> 0x00e4 }
        L_0x00df:
            monitor-exit(r1)     // Catch:{ all -> 0x00e4 }
        L_0x00e0:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdqw> r6 = zzbas
            goto L_0x0017
        L_0x00e4:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00e4 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdqw.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlrx != zzdqy.UNKNOWN_CURVE.zzhn()) {
            zzfed.zzaa(1, this.zzlrx);
        }
        if (this.zzlry != zzdrc.UNKNOWN_HASH.zzhn()) {
            zzfed.zzaa(2, this.zzlry);
        }
        if (!this.zzlrz.isEmpty()) {
            zzfed.zza(11, this.zzlrz);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzdqy zzbnd() {
        zzdqy zzfp = zzdqy.zzfp(this.zzlrx);
        return zzfp == null ? zzdqy.UNRECOGNIZED : zzfp;
    }

    public final zzdrc zzbne() {
        zzdrc zzfq = zzdrc.zzfq(this.zzlry);
        return zzfq == null ? zzdrc.UNRECOGNIZED : zzfq;
    }

    public final zzfdp zzbnf() {
        return this.zzlrz;
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzlrx != zzdqy.UNKNOWN_CURVE.zzhn()) {
            i2 = zzfed.zzag(1, this.zzlrx) + 0;
        }
        if (this.zzlry != zzdrc.UNKNOWN_HASH.zzhn()) {
            i2 += zzfed.zzag(2, this.zzlry);
        }
        if (!this.zzlrz.isEmpty()) {
            i2 += zzfed.zzb(11, this.zzlrz);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
