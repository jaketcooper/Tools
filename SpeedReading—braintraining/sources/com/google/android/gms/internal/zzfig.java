package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfig extends zzfem<zzfig, zza> implements zzffs {
    private static volatile zzffu<zzfig> zzbas;
    /* access modifiers changed from: private */
    public static final zzfig zzpjx;
    private int zzltq;
    private int zzpju;
    private String zzpjv = "";
    private zzffd<zzfdm> zzpjw = zzcvg();

    public static final class zza extends zzfen<zzfig, zza> implements zzffs {
        private zza() {
            super(zzfig.zzpjx);
        }

        /* synthetic */ zza(zzfih zzfih) {
            this();
        }
    }

    static {
        zzfig zzfig = new zzfig();
        zzpjx = zzfig;
        zzfig.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzfig.zzpcg.zzbin();
    }

    private zzfig() {
    }

    public static zzfig zzcxp() {
        return zzpjx;
    }

    public final int getCode() {
        return this.zzpju;
    }

    public final String getMessage() {
        return this.zzpjv;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: CFG modification limit reached, blocks count: 180 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(int r7, java.lang.Object r8, java.lang.Object r9) {
        /*
            r6 = this;
            r0 = 0
            r2 = 0
            r1 = 1
            int[] r3 = com.google.android.gms.internal.zzfih.zzbaq
            int r4 = r7 + -1
            r3 = r3[r4]
            switch(r3) {
                case 1: goto L_0x0012;
                case 2: goto L_0x0018;
                case 3: goto L_0x001b;
                case 4: goto L_0x0022;
                case 5: goto L_0x0028;
                case 6: goto L_0x0079;
                case 7: goto L_0x00f1;
                case 8: goto L_0x00f5;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            r0.<init>()
            throw r0
        L_0x0012:
            com.google.android.gms.internal.zzfig r6 = new com.google.android.gms.internal.zzfig
            r6.<init>()
        L_0x0017:
            return r6
        L_0x0018:
            com.google.android.gms.internal.zzfig r6 = zzpjx
            goto L_0x0017
        L_0x001b:
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzfdm> r1 = r6.zzpjw
            r1.zzbin()
            r6 = r0
            goto L_0x0017
        L_0x0022:
            com.google.android.gms.internal.zzfig$zza r6 = new com.google.android.gms.internal.zzfig$zza
            r6.<init>(r0)
            goto L_0x0017
        L_0x0028:
            com.google.android.gms.internal.zzfev r8 = (com.google.android.gms.internal.zzfev) r8
            com.google.android.gms.internal.zzfig r9 = (com.google.android.gms.internal.zzfig) r9
            int r0 = r6.zzpju
            if (r0 == 0) goto L_0x0071
            r0 = r1
        L_0x0031:
            int r4 = r6.zzpju
            int r3 = r9.zzpju
            if (r3 == 0) goto L_0x0073
            r3 = r1
        L_0x0038:
            int r5 = r9.zzpju
            int r0 = r8.zza((boolean) r0, (int) r4, (boolean) r3, (int) r5)
            r6.zzpju = r0
            java.lang.String r0 = r6.zzpjv
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0075
            r0 = r1
        L_0x0049:
            java.lang.String r3 = r6.zzpjv
            java.lang.String r4 = r9.zzpjv
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0077
        L_0x0053:
            java.lang.String r2 = r9.zzpjv
            java.lang.String r0 = r8.zza((boolean) r0, (java.lang.String) r3, (boolean) r1, (java.lang.String) r2)
            r6.zzpjv = r0
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzfdm> r0 = r6.zzpjw
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzfdm> r1 = r9.zzpjw
            com.google.android.gms.internal.zzffd r0 = r8.zza(r0, r1)
            r6.zzpjw = r0
            com.google.android.gms.internal.zzfet r0 = com.google.android.gms.internal.zzfet.zzpcp
            if (r8 != r0) goto L_0x0017
            int r0 = r6.zzltq
            int r1 = r9.zzltq
            r0 = r0 | r1
            r6.zzltq = r0
            goto L_0x0017
        L_0x0071:
            r0 = r2
            goto L_0x0031
        L_0x0073:
            r3 = r2
            goto L_0x0038
        L_0x0075:
            r0 = r2
            goto L_0x0049
        L_0x0077:
            r1 = r2
            goto L_0x0053
        L_0x0079:
            com.google.android.gms.internal.zzfdy r8 = (com.google.android.gms.internal.zzfdy) r8
            com.google.android.gms.internal.zzfei r9 = (com.google.android.gms.internal.zzfei) r9
            if (r9 != 0) goto L_0x0086
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        L_0x0085:
            r2 = r1
        L_0x0086:
            if (r2 != 0) goto L_0x00f1
            int r0 = r8.zzctt()     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            switch(r0) {
                case 0: goto L_0x0085;
                case 8: goto L_0x0097;
                case 18: goto L_0x00ab;
                case 26: goto L_0x00c6;
                default: goto L_0x008f;
            }     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
        L_0x008f:
            boolean r0 = r6.zza((int) r0, (com.google.android.gms.internal.zzfdy) r8)     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            if (r0 != 0) goto L_0x0086
            r2 = r1
            goto L_0x0086
        L_0x0097:
            int r0 = r8.zzctw()     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            r6.zzpju = r0     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            goto L_0x0086
        L_0x009e:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.zzffe r0 = r0.zzh(r6)     // Catch:{ all -> 0x00a9 }
            r1.<init>(r0)     // Catch:{ all -> 0x00a9 }
            throw r1     // Catch:{ all -> 0x00a9 }
        L_0x00a9:
            r0 = move-exception
            throw r0
        L_0x00ab:
            java.lang.String r0 = r8.zzcua()     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            r6.zzpjv = r0     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            goto L_0x0086
        L_0x00b2:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.zzffe r2 = new com.google.android.gms.internal.zzffe     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00a9 }
            r2.<init>(r0)     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.zzffe r0 = r2.zzh(r6)     // Catch:{ all -> 0x00a9 }
            r1.<init>(r0)     // Catch:{ all -> 0x00a9 }
            throw r1     // Catch:{ all -> 0x00a9 }
        L_0x00c6:
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzfdm> r0 = r6.zzpjw     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            boolean r0 = r0.zzcti()     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            if (r0 != 0) goto L_0x00de
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzfdm> r3 = r6.zzpjw     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            int r0 = r3.size()     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            if (r0 != 0) goto L_0x00ee
            r0 = 10
        L_0x00d8:
            com.google.android.gms.internal.zzffd r0 = r3.zzlo(r0)     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            r6.zzpjw = r0     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
        L_0x00de:
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzfdm> r3 = r6.zzpjw     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            com.google.android.gms.internal.zzfdm r0 = com.google.android.gms.internal.zzfdm.zzctk()     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            com.google.android.gms.internal.zzfem r0 = r8.zza(r0, (com.google.android.gms.internal.zzfei) r9)     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            com.google.android.gms.internal.zzfdm r0 = (com.google.android.gms.internal.zzfdm) r0     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            r3.add(r0)     // Catch:{ zzffe -> 0x009e, IOException -> 0x00b2 }
            goto L_0x0086
        L_0x00ee:
            int r0 = r0 << 1
            goto L_0x00d8
        L_0x00f1:
            com.google.android.gms.internal.zzfig r6 = zzpjx
            goto L_0x0017
        L_0x00f5:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzfig> r0 = zzbas
            if (r0 != 0) goto L_0x010a
            java.lang.Class<com.google.android.gms.internal.zzfig> r1 = com.google.android.gms.internal.zzfig.class
            monitor-enter(r1)
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzfig> r0 = zzbas     // Catch:{ all -> 0x010e }
            if (r0 != 0) goto L_0x0109
            com.google.android.gms.internal.zzfeo r0 = new com.google.android.gms.internal.zzfeo     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.zzfig r2 = zzpjx     // Catch:{ all -> 0x010e }
            r0.<init>(r2)     // Catch:{ all -> 0x010e }
            zzbas = r0     // Catch:{ all -> 0x010e }
        L_0x0109:
            monitor-exit(r1)     // Catch:{ all -> 0x010e }
        L_0x010a:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzfig> r6 = zzbas
            goto L_0x0017
        L_0x010e:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x010e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfig.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzpju != 0) {
            zzfed.zzaa(1, this.zzpju);
        }
        if (!this.zzpjv.isEmpty()) {
            zzfed.zzn(2, this.zzpjv);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.zzpjw.size()) {
                zzfed.zza(3, (zzffq) this.zzpjw.get(i2));
                i = i2 + 1;
            } else {
                this.zzpcg.zza(zzfed);
                return;
            }
        }
    }

    public final int zzhl() {
        int i = 0;
        int i2 = this.zzpch;
        if (i2 != -1) {
            return i2;
        }
        int zzad = this.zzpju != 0 ? zzfed.zzad(1, this.zzpju) + 0 : 0;
        if (!this.zzpjv.isEmpty()) {
            zzad += zzfed.zzo(2, this.zzpjv);
        }
        while (true) {
            int i3 = zzad;
            if (i < this.zzpjw.size()) {
                zzad = zzfed.zzb(3, (zzffq) this.zzpjw.get(i)) + i3;
                i++;
            } else {
                int zzhl = this.zzpcg.zzhl() + i3;
                this.zzpch = zzhl;
                return zzhl;
            }
        }
    }
}
