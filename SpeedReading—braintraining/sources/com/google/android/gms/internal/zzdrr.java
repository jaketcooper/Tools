package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrk;
import java.io.IOException;
import java.util.List;

public final class zzdrr extends zzfem<zzdrr, zza> implements zzffs {
    private static volatile zzffu<zzdrr> zzbas;
    /* access modifiers changed from: private */
    public static final zzdrr zzltt;
    private int zzltq;
    private int zzltr;
    private zzffd<zzb> zzlts = zzcvg();

    public static final class zza extends zzfen<zzdrr, zza> implements zzffs {
        private zza() {
            super(zzdrr.zzltt);
        }

        /* synthetic */ zza(zzdrs zzdrs) {
            this();
        }
    }

    public static final class zzb extends zzfem<zzb, zza> implements zzffs {
        private static volatile zzffu<zzb> zzbas;
        /* access modifiers changed from: private */
        public static final zzb zzlty;
        private zzdrk zzltu;
        private int zzltv;
        private int zzltw;
        private int zzltx;

        public static final class zza extends zzfen<zzb, zza> implements zzffs {
            private zza() {
                super(zzb.zzlty);
            }

            /* synthetic */ zza(zzdrs zzdrs) {
                this();
            }
        }

        static {
            zzb zzb = new zzb();
            zzlty = zzb;
            zzb.zza(zzfeu.zzpct, (Object) null, (Object) null);
            zzb.zzpcg.zzbin();
        }

        private zzb() {
        }

        public static zzb zzbok() {
            return zzlty;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzdrk.zza zza2;
            boolean z = true;
            switch (zzdrs.zzbaq[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return zzlty;
                case 3:
                    return null;
                case 4:
                    return new zza((zzdrs) null);
                case 5:
                    zzfev zzfev = (zzfev) obj;
                    zzb zzb = (zzb) obj2;
                    this.zzltu = (zzdrk) zzfev.zza(this.zzltu, zzb.zzltu);
                    this.zzltv = zzfev.zza(this.zzltv != 0, this.zzltv, zzb.zzltv != 0, zzb.zzltv);
                    this.zzltw = zzfev.zza(this.zzltw != 0, this.zzltw, zzb.zzltw != 0, zzb.zzltw);
                    boolean z2 = this.zzltx != 0;
                    int i2 = this.zzltx;
                    if (zzb.zzltx == 0) {
                        z = false;
                    }
                    this.zzltx = zzfev.zza(z2, i2, z, zzb.zzltx);
                    return this;
                case 6:
                    zzfdy zzfdy = (zzfdy) obj;
                    zzfei zzfei = (zzfei) obj2;
                    if (zzfei != null) {
                        boolean z3 = false;
                        while (!z3) {
                            try {
                                int zzctt = zzfdy.zzctt();
                                switch (zzctt) {
                                    case 0:
                                        z3 = true;
                                        break;
                                    case 10:
                                        if (this.zzltu != null) {
                                            zzdrk zzdrk = this.zzltu;
                                            zzfen zzfen = (zzfen) zzdrk.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                            zzfen.zza(zzdrk);
                                            zza2 = (zzdrk.zza) zzfen;
                                        } else {
                                            zza2 = null;
                                        }
                                        this.zzltu = (zzdrk) zzfdy.zza(zzdrk.zzbnx(), zzfei);
                                        if (zza2 == null) {
                                            break;
                                        } else {
                                            zza2.zza(this.zzltu);
                                            this.zzltu = (zzdrk) zza2.zzcvk();
                                            break;
                                        }
                                    case 16:
                                        this.zzltv = zzfdy.zzcud();
                                        break;
                                    case 24:
                                        this.zzltw = zzfdy.zzcuc();
                                        break;
                                    case 32:
                                        this.zzltx = zzfdy.zzcud();
                                        break;
                                    default:
                                        if (zza(zzctt, zzfdy)) {
                                            break;
                                        } else {
                                            z3 = true;
                                            break;
                                        }
                                }
                            } catch (zzffe e) {
                                throw new RuntimeException(e.zzh(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new zzffe(e2.getMessage()).zzh(this));
                            }
                        }
                        break;
                    } else {
                        throw new NullPointerException();
                    }
                case 7:
                    break;
                case 8:
                    if (zzbas == null) {
                        synchronized (zzb.class) {
                            if (zzbas == null) {
                                zzbas = new zzfeo(zzlty);
                            }
                        }
                    }
                    return zzbas;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzlty;
        }

        public final void zza(zzfed zzfed) throws IOException {
            if (this.zzltu != null) {
                zzfed.zza(1, (zzffq) this.zzltu == null ? zzdrk.zzbnx() : this.zzltu);
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

        public final boolean zzbof() {
            return this.zzltu != null;
        }

        public final zzdrk zzbog() {
            return this.zzltu == null ? zzdrk.zzbnx() : this.zzltu;
        }

        public final zzdrn zzboh() {
            zzdrn zzft = zzdrn.zzft(this.zzltv);
            return zzft == null ? zzdrn.UNRECOGNIZED : zzft;
        }

        public final int zzboi() {
            return this.zzltw;
        }

        public final zzdrv zzboj() {
            zzdrv zzfy = zzdrv.zzfy(this.zzltx);
            return zzfy == null ? zzdrv.UNRECOGNIZED : zzfy;
        }

        public final int zzhl() {
            int i = this.zzpch;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.zzltu != null) {
                i2 = zzfed.zzb(1, (zzffq) this.zzltu == null ? zzdrk.zzbnx() : this.zzltu) + 0;
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
        zzdrr zzdrr = new zzdrr();
        zzltt = zzdrr;
        zzdrr.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdrr.zzpcg.zzbin();
    }

    private zzdrr() {
    }

    public static zzdrr zzae(byte[] bArr) throws zzffe {
        return (zzdrr) zzfem.zza(zzltt, bArr);
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
            int[] r3 = com.google.android.gms.internal.zzdrs.zzbaq
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
            com.google.android.gms.internal.zzdrr r5 = new com.google.android.gms.internal.zzdrr
            r5.<init>()
        L_0x0017:
            return r5
        L_0x0018:
            com.google.android.gms.internal.zzdrr r5 = zzltt
            goto L_0x0017
        L_0x001b:
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzdrr$zzb> r1 = r5.zzlts
            r1.zzbin()
            r5 = r0
            goto L_0x0017
        L_0x0022:
            com.google.android.gms.internal.zzdrr$zza r5 = new com.google.android.gms.internal.zzdrr$zza
            r5.<init>(r0)
            goto L_0x0017
        L_0x0028:
            com.google.android.gms.internal.zzfev r7 = (com.google.android.gms.internal.zzfev) r7
            com.google.android.gms.internal.zzdrr r8 = (com.google.android.gms.internal.zzdrr) r8
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
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzdrr$zzb> r0 = r5.zzlts
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzdrr$zzb> r1 = r8.zzlts
            com.google.android.gms.internal.zzffd r0 = r7.zza(r0, r1)
            r5.zzlts = r0
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
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzdrr$zzb> r0 = r5.zzlts     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            boolean r0 = r0.zzcti()     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            if (r0 != 0) goto L_0x00a3
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzdrr$zzb> r3 = r5.zzlts     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            int r0 = r3.size()     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            if (r0 != 0) goto L_0x00c7
            r0 = 10
        L_0x009d:
            com.google.android.gms.internal.zzffd r0 = r3.zzlo(r0)     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            r5.zzlts = r0     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
        L_0x00a3:
            com.google.android.gms.internal.zzffd<com.google.android.gms.internal.zzdrr$zzb> r3 = r5.zzlts     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            com.google.android.gms.internal.zzdrr$zzb r0 = com.google.android.gms.internal.zzdrr.zzb.zzbok()     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            com.google.android.gms.internal.zzfem r0 = r7.zza(r0, (com.google.android.gms.internal.zzfei) r8)     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
            com.google.android.gms.internal.zzdrr$zzb r0 = (com.google.android.gms.internal.zzdrr.zzb) r0     // Catch:{ zzffe -> 0x007e, IOException -> 0x00b3 }
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
            com.google.android.gms.internal.zzdrr r5 = zzltt
            goto L_0x0017
        L_0x00ce:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrr> r0 = zzbas
            if (r0 != 0) goto L_0x00e3
            java.lang.Class<com.google.android.gms.internal.zzdrr> r1 = com.google.android.gms.internal.zzdrr.class
            monitor-enter(r1)
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrr> r0 = zzbas     // Catch:{ all -> 0x00e7 }
            if (r0 != 0) goto L_0x00e2
            com.google.android.gms.internal.zzfeo r0 = new com.google.android.gms.internal.zzfeo     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.internal.zzdrr r2 = zzltt     // Catch:{ all -> 0x00e7 }
            r0.<init>(r2)     // Catch:{ all -> 0x00e7 }
            zzbas = r0     // Catch:{ all -> 0x00e7 }
        L_0x00e2:
            monitor-exit(r1)     // Catch:{ all -> 0x00e7 }
        L_0x00e3:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdrr> r5 = zzbas
            goto L_0x0017
        L_0x00e7:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00e7 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdrr.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzltr != 0) {
            zzfed.zzab(1, this.zzltr);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.zzlts.size()) {
                zzfed.zza(2, (zzffq) this.zzlts.get(i2));
                i = i2 + 1;
            } else {
                this.zzpcg.zza(zzfed);
                return;
            }
        }
    }

    public final int zzbob() {
        return this.zzltr;
    }

    public final List<zzb> zzboc() {
        return this.zzlts;
    }

    public final int zzbod() {
        return this.zzlts.size();
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
            if (i < this.zzlts.size()) {
                zzae = zzfed.zzb(2, (zzffq) this.zzlts.get(i)) + i3;
                i++;
            } else {
                int zzhl = this.zzpcg.zzhl() + i3;
                this.zzpch = zzhl;
                return zzhl;
            }
        }
    }
}
