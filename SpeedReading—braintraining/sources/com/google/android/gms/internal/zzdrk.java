package com.google.android.gms.internal;

import java.io.IOException;

public final class zzdrk extends zzfem<zzdrk, zza> implements zzffs {
    private static volatile zzffu<zzdrk> zzbas;
    /* access modifiers changed from: private */
    public static final zzdrk zzltb;
    private String zzlsy = "";
    private zzfdp zzlsz = zzfdp.zzpaz;
    private int zzlta;

    public static final class zza extends zzfen<zzdrk, zza> implements zzffs {
        private zza() {
            super(zzdrk.zzltb);
        }

        /* synthetic */ zza(zzdrl zzdrl) {
            this();
        }

        public final zza zzaa(zzfdp zzfdp) {
            zzcvj();
            ((zzdrk) this.zzpcj).zzz(zzfdp);
            return this;
        }

        public final zza zzb(zzb zzb) {
            zzcvj();
            ((zzdrk) this.zzpcj).zza(zzb);
            return this;
        }

        public final zza zzob(String str) {
            zzcvj();
            ((zzdrk) this.zzpcj).zzoa(str);
            return this;
        }
    }

    public enum zzb implements zzffa {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzffb<zzb> zzbbb = null;
        private final int value;

        static {
            zzbbb = new zzdrm();
        }

        private zzb(int i) {
            this.value = i;
        }

        public static zzb zzfs(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_KEYMATERIAL;
                case 1:
                    return SYMMETRIC;
                case 2:
                    return ASYMMETRIC_PRIVATE;
                case 3:
                    return ASYMMETRIC_PUBLIC;
                case 4:
                    return REMOTE;
                default:
                    return null;
            }
        }

        public final int zzhn() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        zzdrk zzdrk = new zzdrk();
        zzltb = zzdrk;
        zzdrk.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdrk.zzpcg.zzbin();
    }

    private zzdrk() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        if (zzb2 == null) {
            throw new NullPointerException();
        }
        this.zzlta = zzb2.zzhn();
    }

    public static zza zzbnw() {
        zzdrk zzdrk = zzltb;
        zzfen zzfen = (zzfen) zzdrk.zza(zzfeu.zzpcv, (Object) null, (Object) null);
        zzfen.zza(zzdrk);
        return (zza) zzfen;
    }

    public static zzdrk zzbnx() {
        return zzltb;
    }

    /* access modifiers changed from: private */
    public final void zzoa(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.zzlsy = str;
    }

    /* access modifiers changed from: private */
    public final void zzz(zzfdp zzfdp) {
        if (zzfdp == null) {
            throw new NullPointerException();
        }
        this.zzlsz = zzfdp;
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
            int[] r3 = com.google.android.gms.internal.zzdrl.zzbaq
            int r4 = r7 + -1
            r3 = r3[r4]
            switch(r3) {
                case 1: goto L_0x0012;
                case 2: goto L_0x0018;
                case 3: goto L_0x001b;
                case 4: goto L_0x001d;
                case 5: goto L_0x0023;
                case 6: goto L_0x007b;
                case 7: goto L_0x00cf;
                case 8: goto L_0x00d3;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            r0.<init>()
            throw r0
        L_0x0012:
            com.google.android.gms.internal.zzdrk r6 = new com.google.android.gms.internal.zzdrk
            r6.<init>()
        L_0x0017:
            return r6
        L_0x0018:
            com.google.android.gms.internal.zzdrk r6 = zzltb
            goto L_0x0017
        L_0x001b:
            r6 = r0
            goto L_0x0017
        L_0x001d:
            com.google.android.gms.internal.zzdrk$zza r6 = new com.google.android.gms.internal.zzdrk$zza
            r6.<init>(r0)
            goto L_0x0017
        L_0x0023:
            com.google.android.gms.internal.zzfev r8 = (com.google.android.gms.internal.zzfev) r8
            com.google.android.gms.internal.zzdrk r9 = (com.google.android.gms.internal.zzdrk) r9
            java.lang.String r0 = r6.zzlsy
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x006f
            r0 = r1
        L_0x0030:
            java.lang.String r4 = r6.zzlsy
            java.lang.String r3 = r9.zzlsy
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0071
            r3 = r1
        L_0x003b:
            java.lang.String r5 = r9.zzlsy
            java.lang.String r0 = r8.zza((boolean) r0, (java.lang.String) r4, (boolean) r3, (java.lang.String) r5)
            r6.zzlsy = r0
            com.google.android.gms.internal.zzfdp r0 = r6.zzlsz
            com.google.android.gms.internal.zzfdp r3 = com.google.android.gms.internal.zzfdp.zzpaz
            if (r0 == r3) goto L_0x0073
            r0 = r1
        L_0x004a:
            com.google.android.gms.internal.zzfdp r4 = r6.zzlsz
            com.google.android.gms.internal.zzfdp r3 = r9.zzlsz
            com.google.android.gms.internal.zzfdp r5 = com.google.android.gms.internal.zzfdp.zzpaz
            if (r3 == r5) goto L_0x0075
            r3 = r1
        L_0x0053:
            com.google.android.gms.internal.zzfdp r5 = r9.zzlsz
            com.google.android.gms.internal.zzfdp r0 = r8.zza((boolean) r0, (com.google.android.gms.internal.zzfdp) r4, (boolean) r3, (com.google.android.gms.internal.zzfdp) r5)
            r6.zzlsz = r0
            int r0 = r6.zzlta
            if (r0 == 0) goto L_0x0077
            r0 = r1
        L_0x0060:
            int r3 = r6.zzlta
            int r4 = r9.zzlta
            if (r4 == 0) goto L_0x0079
        L_0x0066:
            int r2 = r9.zzlta
            int r0 = r8.zza((boolean) r0, (int) r3, (boolean) r1, (int) r2)
            r6.zzlta = r0
            goto L_0x0017
        L_0x006f:
            r0 = r2
            goto L_0x0030
        L_0x0071:
            r3 = r2
            goto L_0x003b
        L_0x0073:
            r0 = r2
            goto L_0x004a
        L_0x0075:
            r3 = r2
            goto L_0x0053
        L_0x0077:
            r0 = r2
            goto L_0x0060
        L_0x0079:
            r1 = r2
            goto L_0x0066
        L_0x007b:
            com.google.android.gms.internal.zzfdy r8 = (com.google.android.gms.internal.zzfdy) r8
            com.google.android.gms.internal.zzfei r9 = (com.google.android.gms.internal.zzfei) r9
            if (r9 != 0) goto L_0x0088
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        L_0x0087:
            r2 = r1
        L_0x0088:
            if (r2 != 0) goto L_0x00cf
            int r0 = r8.zzctt()     // Catch:{ zzffe -> 0x00a0, IOException -> 0x00b4 }
            switch(r0) {
                case 0: goto L_0x0087;
                case 10: goto L_0x0099;
                case 18: goto L_0x00ad;
                case 24: goto L_0x00c8;
                default: goto L_0x0091;
            }     // Catch:{ zzffe -> 0x00a0, IOException -> 0x00b4 }
        L_0x0091:
            boolean r0 = r6.zza((int) r0, (com.google.android.gms.internal.zzfdy) r8)     // Catch:{ zzffe -> 0x00a0, IOException -> 0x00b4 }
            if (r0 != 0) goto L_0x0088
            r2 = r1
            goto L_0x0088
        L_0x0099:
            java.lang.String r0 = r8.zzcua()     // Catch:{ zzffe -> 0x00a0, IOException -> 0x00b4 }
            r6.zzlsy = r0     // Catch:{ zzffe -> 0x00a0, IOException -> 0x00b4 }
            goto L_0x0088
        L_0x00a0:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x00ab }
            com.google.android.gms.internal.zzffe r0 = r0.zzh(r6)     // Catch:{ all -> 0x00ab }
            r1.<init>(r0)     // Catch:{ all -> 0x00ab }
            throw r1     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r0 = move-exception
            throw r0
        L_0x00ad:
            com.google.android.gms.internal.zzfdp r0 = r8.zzcub()     // Catch:{ zzffe -> 0x00a0, IOException -> 0x00b4 }
            r6.zzlsz = r0     // Catch:{ zzffe -> 0x00a0, IOException -> 0x00b4 }
            goto L_0x0088
        L_0x00b4:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x00ab }
            com.google.android.gms.internal.zzffe r2 = new com.google.android.gms.internal.zzffe     // Catch:{ all -> 0x00ab }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00ab }
            r2.<init>(r0)     // Catch:{ all -> 0x00ab }
            com.google.android.gms.internal.zzffe r0 = r2.zzh(r6)     // Catch:{ all -> 0x00ab }
            r1.<init>(r0)     // Catch:{ all -> 0x00ab }
            throw r1     // Catch:{ all -> 0x00ab }
        L_0x00c8:
            int r0 = r8.zzcud()     // Catch:{ zzffe -> 0x00a0, IOException -> 0x00b4 }
            r6.zzlta = r0     // Catch:{ zzffe -> 0x00a0, IOException -> 0x00b4 }
            goto L_0x0088
        L_0x00cf:
            com.google.android.gms.internal.zzdrk r6 = zzltb
            goto L_0x0017
        L_0x00d3:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrk> r0 = zzbas
            if (r0 != 0) goto L_0x00e8
            java.lang.Class<com.google.android.gms.internal.zzdrk> r1 = com.google.android.gms.internal.zzdrk.class
            monitor-enter(r1)
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrk> r0 = zzbas     // Catch:{ all -> 0x00ec }
            if (r0 != 0) goto L_0x00e7
            com.google.android.gms.internal.zzfeo r0 = new com.google.android.gms.internal.zzfeo     // Catch:{ all -> 0x00ec }
            com.google.android.gms.internal.zzdrk r2 = zzltb     // Catch:{ all -> 0x00ec }
            r0.<init>(r2)     // Catch:{ all -> 0x00ec }
            zzbas = r0     // Catch:{ all -> 0x00ec }
        L_0x00e7:
            monitor-exit(r1)     // Catch:{ all -> 0x00ec }
        L_0x00e8:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrk> r6 = zzbas
            goto L_0x0017
        L_0x00ec:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00ec }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdrk.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (!this.zzlsy.isEmpty()) {
            zzfed.zzn(1, this.zzlsy);
        }
        if (!this.zzlsz.isEmpty()) {
            zzfed.zza(2, this.zzlsz);
        }
        if (this.zzlta != zzb.UNKNOWN_KEYMATERIAL.zzhn()) {
            zzfed.zzaa(3, this.zzlta);
        }
        this.zzpcg.zza(zzfed);
    }

    public final String zzbnt() {
        return this.zzlsy;
    }

    public final zzfdp zzbnu() {
        return this.zzlsz;
    }

    public final zzb zzbnv() {
        zzb zzfs = zzb.zzfs(this.zzlta);
        return zzfs == null ? zzb.UNRECOGNIZED : zzfs;
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
        if (this.zzlta != zzb.UNKNOWN_KEYMATERIAL.zzhn()) {
            i2 += zzfed.zzag(3, this.zzlta);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
