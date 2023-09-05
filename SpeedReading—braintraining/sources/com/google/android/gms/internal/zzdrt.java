package com.google.android.gms.internal;

import java.io.IOException;

public final class zzdrt extends zzfem<zzdrt, zza> implements zzffs {
    private static volatile zzffu<zzdrt> zzbas;
    /* access modifiers changed from: private */
    public static final zzdrt zzlua;
    private int zzltq;
    private int zzltr;
    private zzffd<zzb> zzltz = zzcvg();

    public static final class zza extends zzfen<zzdrt, zza> implements zzffs {
        private zza() {
            super(zzdrt.zzlua);
        }

        /* synthetic */ zza(zzdru zzdru) {
            this();
        }

        public final zza zzb(zzb zzb) {
            zzcvj();
            ((zzdrt) this.zzpcj).zza(zzb);
            return this;
        }

        public final zza zzfv(int i) {
            zzcvj();
            ((zzdrt) this.zzpcj).zzfu(i);
            return this;
        }
    }

    public static final class zzb extends zzfem<zzb, zza> implements zzffs {
        private static volatile zzffu<zzb> zzbas;
        /* access modifiers changed from: private */
        public static final zzb zzlub;
        private String zzlsy = "";
        private int zzltv;
        private int zzltw;
        private int zzltx;

        public static final class zza extends zzfen<zzb, zza> implements zzffs {
            private zza() {
                super(zzb.zzlub);
            }

            /* synthetic */ zza(zzdru zzdru) {
                this();
            }

            public final zza zzb(zzdrn zzdrn) {
                zzcvj();
                ((zzb) this.zzpcj).zza(zzdrn);
                return this;
            }

            public final zza zzb(zzdrv zzdrv) {
                zzcvj();
                ((zzb) this.zzpcj).zza(zzdrv);
                return this;
            }

            public final zza zzfx(int i) {
                zzcvj();
                ((zzb) this.zzpcj).zzfw(i);
                return this;
            }

            public final zza zzoc(String str) {
                zzcvj();
                ((zzb) this.zzpcj).zzoa(str);
                return this;
            }
        }

        static {
            zzb zzb = new zzb();
            zzlub = zzb;
            zzb.zza(zzfeu.zzpct, (Object) null, (Object) null);
            zzb.zzpcg.zzbin();
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        public final void zza(zzdrn zzdrn) {
            if (zzdrn == null) {
                throw new NullPointerException();
            }
            this.zzltv = zzdrn.zzhn();
        }

        /* access modifiers changed from: private */
        public final void zza(zzdrv zzdrv) {
            if (zzdrv == null) {
                throw new NullPointerException();
            }
            this.zzltx = zzdrv.zzhn();
        }

        public static zza zzbop() {
            zzb zzb = zzlub;
            zzfen zzfen = (zzfen) zzb.zza(zzfeu.zzpcv, (Object) null, (Object) null);
            zzfen.zza(zzb);
            return (zza) zzfen;
        }

        public static zzb zzboq() {
            return zzlub;
        }

        /* access modifiers changed from: private */
        public final void zzfw(int i) {
            this.zzltw = i;
        }

        /* access modifiers changed from: private */
        public final void zzoa(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzlsy = str;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: CFG modification limit reached, blocks count: 189 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r7, java.lang.Object r8, java.lang.Object r9) {
            /*
                r6 = this;
                r0 = 0
                r2 = 0
                r1 = 1
                int[] r3 = com.google.android.gms.internal.zzdru.zzbaq
                int r4 = r7 + -1
                r3 = r3[r4]
                switch(r3) {
                    case 1: goto L_0x0012;
                    case 2: goto L_0x0018;
                    case 3: goto L_0x001b;
                    case 4: goto L_0x001d;
                    case 5: goto L_0x0023;
                    case 6: goto L_0x008f;
                    case 7: goto L_0x00ea;
                    case 8: goto L_0x00ee;
                    default: goto L_0x000c;
                }
            L_0x000c:
                java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
                r0.<init>()
                throw r0
            L_0x0012:
                com.google.android.gms.internal.zzdrt$zzb r6 = new com.google.android.gms.internal.zzdrt$zzb
                r6.<init>()
            L_0x0017:
                return r6
            L_0x0018:
                com.google.android.gms.internal.zzdrt$zzb r6 = zzlub
                goto L_0x0017
            L_0x001b:
                r6 = r0
                goto L_0x0017
            L_0x001d:
                com.google.android.gms.internal.zzdrt$zzb$zza r6 = new com.google.android.gms.internal.zzdrt$zzb$zza
                r6.<init>(r0)
                goto L_0x0017
            L_0x0023:
                com.google.android.gms.internal.zzfev r8 = (com.google.android.gms.internal.zzfev) r8
                com.google.android.gms.internal.zzdrt$zzb r9 = (com.google.android.gms.internal.zzdrt.zzb) r9
                java.lang.String r0 = r6.zzlsy
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L_0x007f
                r0 = r1
            L_0x0030:
                java.lang.String r4 = r6.zzlsy
                java.lang.String r3 = r9.zzlsy
                boolean r3 = r3.isEmpty()
                if (r3 != 0) goto L_0x0081
                r3 = r1
            L_0x003b:
                java.lang.String r5 = r9.zzlsy
                java.lang.String r0 = r8.zza((boolean) r0, (java.lang.String) r4, (boolean) r3, (java.lang.String) r5)
                r6.zzlsy = r0
                int r0 = r6.zzltv
                if (r0 == 0) goto L_0x0083
                r0 = r1
            L_0x0048:
                int r4 = r6.zzltv
                int r3 = r9.zzltv
                if (r3 == 0) goto L_0x0085
                r3 = r1
            L_0x004f:
                int r5 = r9.zzltv
                int r0 = r8.zza((boolean) r0, (int) r4, (boolean) r3, (int) r5)
                r6.zzltv = r0
                int r0 = r6.zzltw
                if (r0 == 0) goto L_0x0087
                r0 = r1
            L_0x005c:
                int r4 = r6.zzltw
                int r3 = r9.zzltw
                if (r3 == 0) goto L_0x0089
                r3 = r1
            L_0x0063:
                int r5 = r9.zzltw
                int r0 = r8.zza((boolean) r0, (int) r4, (boolean) r3, (int) r5)
                r6.zzltw = r0
                int r0 = r6.zzltx
                if (r0 == 0) goto L_0x008b
                r0 = r1
            L_0x0070:
                int r3 = r6.zzltx
                int r4 = r9.zzltx
                if (r4 == 0) goto L_0x008d
            L_0x0076:
                int r2 = r9.zzltx
                int r0 = r8.zza((boolean) r0, (int) r3, (boolean) r1, (int) r2)
                r6.zzltx = r0
                goto L_0x0017
            L_0x007f:
                r0 = r2
                goto L_0x0030
            L_0x0081:
                r3 = r2
                goto L_0x003b
            L_0x0083:
                r0 = r2
                goto L_0x0048
            L_0x0085:
                r3 = r2
                goto L_0x004f
            L_0x0087:
                r0 = r2
                goto L_0x005c
            L_0x0089:
                r3 = r2
                goto L_0x0063
            L_0x008b:
                r0 = r2
                goto L_0x0070
            L_0x008d:
                r1 = r2
                goto L_0x0076
            L_0x008f:
                com.google.android.gms.internal.zzfdy r8 = (com.google.android.gms.internal.zzfdy) r8
                com.google.android.gms.internal.zzfei r9 = (com.google.android.gms.internal.zzfei) r9
                if (r9 != 0) goto L_0x009c
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>()
                throw r0
            L_0x009b:
                r2 = r1
            L_0x009c:
                if (r2 != 0) goto L_0x00ea
                int r0 = r8.zzctt()     // Catch:{ zzffe -> 0x00b4, IOException -> 0x00c8 }
                switch(r0) {
                    case 0: goto L_0x009b;
                    case 10: goto L_0x00ad;
                    case 16: goto L_0x00c1;
                    case 24: goto L_0x00dc;
                    case 32: goto L_0x00e3;
                    default: goto L_0x00a5;
                }     // Catch:{ zzffe -> 0x00b4, IOException -> 0x00c8 }
            L_0x00a5:
                boolean r0 = r6.zza((int) r0, (com.google.android.gms.internal.zzfdy) r8)     // Catch:{ zzffe -> 0x00b4, IOException -> 0x00c8 }
                if (r0 != 0) goto L_0x009c
                r2 = r1
                goto L_0x009c
            L_0x00ad:
                java.lang.String r0 = r8.zzcua()     // Catch:{ zzffe -> 0x00b4, IOException -> 0x00c8 }
                r6.zzlsy = r0     // Catch:{ zzffe -> 0x00b4, IOException -> 0x00c8 }
                goto L_0x009c
            L_0x00b4:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x00bf }
                com.google.android.gms.internal.zzffe r0 = r0.zzh(r6)     // Catch:{ all -> 0x00bf }
                r1.<init>(r0)     // Catch:{ all -> 0x00bf }
                throw r1     // Catch:{ all -> 0x00bf }
            L_0x00bf:
                r0 = move-exception
                throw r0
            L_0x00c1:
                int r0 = r8.zzcud()     // Catch:{ zzffe -> 0x00b4, IOException -> 0x00c8 }
                r6.zzltv = r0     // Catch:{ zzffe -> 0x00b4, IOException -> 0x00c8 }
                goto L_0x009c
            L_0x00c8:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x00bf }
                com.google.android.gms.internal.zzffe r2 = new com.google.android.gms.internal.zzffe     // Catch:{ all -> 0x00bf }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00bf }
                r2.<init>(r0)     // Catch:{ all -> 0x00bf }
                com.google.android.gms.internal.zzffe r0 = r2.zzh(r6)     // Catch:{ all -> 0x00bf }
                r1.<init>(r0)     // Catch:{ all -> 0x00bf }
                throw r1     // Catch:{ all -> 0x00bf }
            L_0x00dc:
                int r0 = r8.zzcuc()     // Catch:{ zzffe -> 0x00b4, IOException -> 0x00c8 }
                r6.zzltw = r0     // Catch:{ zzffe -> 0x00b4, IOException -> 0x00c8 }
                goto L_0x009c
            L_0x00e3:
                int r0 = r8.zzcud()     // Catch:{ zzffe -> 0x00b4, IOException -> 0x00c8 }
                r6.zzltx = r0     // Catch:{ zzffe -> 0x00b4, IOException -> 0x00c8 }
                goto L_0x009c
            L_0x00ea:
                com.google.android.gms.internal.zzdrt$zzb r6 = zzlub
                goto L_0x0017
            L_0x00ee:
                com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrt$zzb> r0 = zzbas
                if (r0 != 0) goto L_0x0103
                java.lang.Class<com.google.android.gms.internal.zzdrt$zzb> r1 = com.google.android.gms.internal.zzdrt.zzb.class
                monitor-enter(r1)
                com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrt$zzb> r0 = zzbas     // Catch:{ all -> 0x0107 }
                if (r0 != 0) goto L_0x0102
                com.google.android.gms.internal.zzfeo r0 = new com.google.android.gms.internal.zzfeo     // Catch:{ all -> 0x0107 }
                com.google.android.gms.internal.zzdrt$zzb r2 = zzlub     // Catch:{ all -> 0x0107 }
                r0.<init>(r2)     // Catch:{ all -> 0x0107 }
                zzbas = r0     // Catch:{ all -> 0x0107 }
            L_0x0102:
                monitor-exit(r1)     // Catch:{ all -> 0x0107 }
            L_0x0103:
                com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrt$zzb> r6 = zzbas
                goto L_0x0017
            L_0x0107:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0107 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdrt.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        public final void zza(zzfed zzfed) throws IOException {
            if (!this.zzlsy.isEmpty()) {
                zzfed.zzn(1, this.zzlsy);
            }
            if (this.zzltv != zzdrn.UNKNOWN_STATUS.zzhn()) {
                zzfed.zzaa(2, this.zzltv);
            }
            if (this.zzltw != 0) {
                zzfed.zzab(3, this.zzltw);
            }
            if (this.zzltx != zzdrv.UNKNOWN_PREFIX.zzhn()) {
                zzfed.zzaa(4, this.zzltx);
            }
            this.zzpcg.zza(zzfed);
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
            if (this.zzltv != zzdrn.UNKNOWN_STATUS.zzhn()) {
                i2 += zzfed.zzag(2, this.zzltv);
            }
            if (this.zzltw != 0) {
                i2 += zzfed.zzae(3, this.zzltw);
            }
            if (this.zzltx != zzdrv.UNKNOWN_PREFIX.zzhn()) {
                i2 += zzfed.zzag(4, this.zzltx);
            }
            int zzhl = i2 + this.zzpcg.zzhl();
            this.zzpch = zzhl;
            return zzhl;
        }
    }

    static {
        zzdrt zzdrt = new zzdrt();
        zzlua = zzdrt;
        zzdrt.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdrt.zzpcg.zzbin();
    }

    private zzdrt() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        if (zzb2 == null) {
            throw new NullPointerException();
        }
        if (!this.zzltz.zzcti()) {
            zzffd<zzb> zzffd = this.zzltz;
            int size = zzffd.size();
            this.zzltz = zzffd.zzlo(size == 0 ? 10 : size << 1);
        }
        this.zzltz.add(zzb2);
    }

    public static zza zzbom() {
        zzdrt zzdrt = zzlua;
        zzfen zzfen = (zzfen) zzdrt.zza(zzfeu.zzpcv, (Object) null, (Object) null);
        zzfen.zza(zzdrt);
        return (zza) zzfen;
    }

    public static zzdrt zzbon() {
        return zzlua;
    }

    /* access modifiers changed from: private */
    public final void zzfu(int i) {
        this.zzltr = i;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: CFG modification limit reached, blocks count: 170 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(int r6, java.lang.Object r7, java.lang.Object r8) {
        /*
            r5 = this;
            r0 = 0
            r2 = 0
            r1 = 1
            int[] r3 = com.google.android.gms.internal.zzdru.zzbaq
            int r4 = r6 + -1
            r3 = r3[r4]
            switch(r3) {
                case 1: goto L_0x0012;
                case 2: goto L_0x0018;
                case 3: goto L_0x001b;
                case 4: goto L_0x0022;
                case 5: goto L_0x0028;
                case 6: goto L_0x0059;
                case 7: goto L_0x00ca;
                case 8: goto L_0x00ce;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            r0.<init>()
            throw r0
        L_0x0012:
            com.google.android.gms.internal.zzdrt r5 = new com.google.android.gms.internal.zzdrt
            r5.<init>()
        L_0x0017:
            return r5
        L_0x0018:
            com.google.android.gms.internal.zzdrt r5 = zzlua
            goto L_0x0017
        L_0x001b:
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzdrt$zzb> r1 = r5.zzltz
            r1.zzbin()
            r5 = r0
            goto L_0x0017
        L_0x0022:
            com.google.android.gms.internal.zzdrt$zza r5 = new com.google.android.gms.internal.zzdrt$zza
            r5.<init>(r0)
            goto L_0x0017
        L_0x0028:
            com.google.android.gms.internal.zzfev r7 = (com.google.android.gms.internal.zzfev) r7
            com.google.android.gms.internal.zzdrt r8 = (com.google.android.gms.internal.zzdrt) r8
            int r0 = r5.zzltr
            if (r0 == 0) goto L_0x0055
            r0 = r1
        L_0x0031:
            int r3 = r5.zzltr
            int r4 = r8.zzltr
            if (r4 == 0) goto L_0x0057
        L_0x0037:
            int r2 = r8.zzltr
            int r0 = r7.zza((boolean) r0, (int) r3, (boolean) r1, (int) r2)
            r5.zzltr = r0
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzdrt$zzb> r0 = r5.zzltz
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzdrt$zzb> r1 = r8.zzltz
            com.google.android.gms.internal.zzffd r0 = r7.zza(r0, r1)
            r5.zzltz = r0
            com.google.android.gms.internal.zzfet r0 = com.google.android.gms.internal.zzfet.zzpcp
            if (r7 != r0) goto L_0x0017
            int r0 = r5.zzltq
            int r1 = r8.zzltq
            r0 = r0 | r1
            r5.zzltq = r0
            goto L_0x0017
        L_0x0055:
            r0 = r2
            goto L_0x0031
        L_0x0057:
            r1 = r2
            goto L_0x0037
        L_0x0059:
            com.google.android.gms.internal.zzfdy r7 = (com.google.android.gms.internal.zzfdy) r7
            com.google.android.gms.internal.zzfei r8 = (com.google.android.gms.internal.zzfei) r8
            if (r8 != 0) goto L_0x0066
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        L_0x0065:
            r2 = r1
        L_0x0066:
            if (r2 != 0) goto L_0x00ca
            int r0 = r7.zzctt()     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            switch(r0) {
                case 0: goto L_0x0065;
                case 8: goto L_0x0077;
                case 18: goto L_0x008b;
                default: goto L_0x006f;
            }     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
        L_0x006f:
            boolean r0 = r5.zza((int) r0, (com.google.android.gms.internal.zzfdy) r7)     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            if (r0 != 0) goto L_0x0066
            r2 = r1
            goto L_0x0066
        L_0x0077:
            int r0 = r7.zzcuc()     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            r5.zzltr = r0     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            goto L_0x0066
        L_0x007e:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0089 }
            com.google.android.gms.internal.zzffe r0 = r0.zzh(r5)     // Catch:{ all -> 0x0089 }
            r1.<init>(r0)     // Catch:{ all -> 0x0089 }
            throw r1     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r0 = move-exception
            throw r0
        L_0x008b:
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzdrt$zzb> r0 = r5.zzltz     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            boolean r0 = r0.zzcti()     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            if (r0 != 0) goto L_0x00a3
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzdrt$zzb> r3 = r5.zzltz     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            int r0 = r3.size()     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            if (r0 != 0) goto L_0x00c7
            r0 = 10
        L_0x009d:
            com.google.android.gms.internal.zzffd r0 = r3.zzlo(r0)     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            r5.zzltz = r0     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
        L_0x00a3:
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzdrt$zzb> r3 = r5.zzltz     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            com.google.android.gms.internal.zzdrt$zzb r0 = com.google.android.gms.internal.zzdrt.zzb.zzboq()     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            com.google.android.gms.internal.zzfem r0 = r7.zza(r0, (com.google.android.gms.internal.zzfei) r8)     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            com.google.android.gms.internal.zzdrt$zzb r0 = (com.google.android.gms.internal.zzdrt.zzb) r0     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            r3.add(r0)     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            goto L_0x0066
        L_0x00b3:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0089 }
            com.google.android.gms.internal.zzffe r2 = new com.google.android.gms.internal.zzffe     // Catch:{ all -> 0x0089 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0089 }
            r2.<init>(r0)     // Catch:{ all -> 0x0089 }
            com.google.android.gms.internal.zzffe r0 = r2.zzh(r5)     // Catch:{ all -> 0x0089 }
            r1.<init>(r0)     // Catch:{ all -> 0x0089 }
            throw r1     // Catch:{ all -> 0x0089 }
        L_0x00c7:
            int r0 = r0 << 1
            goto L_0x009d
        L_0x00ca:
            com.google.android.gms.internal.zzdrt r5 = zzlua
            goto L_0x0017
        L_0x00ce:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrt> r0 = zzbas
            if (r0 != 0) goto L_0x00e3
            java.lang.Class<com.google.android.gms.internal.zzdrt> r1 = com.google.android.gms.internal.zzdrt.class
            monitor-enter(r1)
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrt> r0 = zzbas     // Catch:{ all -> 0x00e7 }
            if (r0 != 0) goto L_0x00e2
            com.google.android.gms.internal.zzfeo r0 = new com.google.android.gms.internal.zzfeo     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.zzdrt r2 = zzlua     // Catch:{ all -> 0x00e7 }
            r0.<init>(r2)     // Catch:{ all -> 0x00e7 }
            zzbas = r0     // Catch:{ all -> 0x00e7 }
        L_0x00e2:
            monitor-exit(r1)     // Catch:{ all -> 0x00e7 }
        L_0x00e3:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrt> r5 = zzbas
            goto L_0x0017
        L_0x00e7:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00e7 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdrt.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzltr != 0) {
            zzfed.zzab(1, this.zzltr);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.zzltz.size()) {
                zzfed.zza(2, (zzffq) this.zzltz.get(i2));
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
        int zzae = this.zzltr != 0 ? zzfed.zzae(1, this.zzltr) + 0 : 0;
        while (true) {
            int i3 = zzae;
            if (i < this.zzltz.size()) {
                zzae = zzfed.zzb(2, (zzffq) this.zzltz.get(i)) + i3;
                i++;
            } else {
                int zzhl = this.zzpcg.zzhl() + i3;
                this.zzpch = zzhl;
                return zzhl;
            }
        }
    }
}
