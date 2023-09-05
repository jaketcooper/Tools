package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfdm extends zzfem<zzfdm, zza> implements zzffs {
    private static volatile zzffu<zzfdm> zzbas;
    /* access modifiers changed from: private */
    public static final zzfdm zzpay;
    private String zzlsy = "";
    private zzfdp zzlsz = zzfdp.zzpaz;

    public static final class zza extends zzfen<zzfdm, zza> implements zzffs {
        private zza() {
            super(zzfdm.zzpay);
        }

        /* synthetic */ zza(zzfdn zzfdn) {
            this();
        }
    }

    static {
        zzfdm zzfdm = new zzfdm();
        zzpay = zzfdm;
        zzfdm.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzfdm.zzpcg.zzbin();
    }

    private zzfdm() {
    }

    public static zzfdm zzctk() {
        return zzpay;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        boolean zzb;
        boolean z = true;
        switch (zzfdn.zzbaq[i - 1]) {
            case 1:
                return new zzfdm();
            case 2:
                return zzpay;
            case 3:
                return null;
            case 4:
                return new zza((zzfdn) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzfdm zzfdm = (zzfdm) obj2;
                this.zzlsy = zzfev.zza(!this.zzlsy.isEmpty(), this.zzlsy, !zzfdm.zzlsy.isEmpty(), zzfdm.zzlsy);
                boolean z2 = this.zzlsz != zzfdp.zzpaz;
                zzfdp zzfdp = this.zzlsz;
                if (zzfdm.zzlsz == zzfdp.zzpaz) {
                    z = false;
                }
                this.zzlsz = zzfev.zza(z2, zzfdp, z, zzfdm.zzlsz);
                return this;
            case 6:
                zzfdy zzfdy = (zzfdy) obj;
                if (((zzfei) obj2) != null) {
                    boolean z3 = false;
                    while (!z3) {
                        try {
                            int zzctt = zzfdy.zzctt();
                            switch (zzctt) {
                                case 0:
                                    z3 = true;
                                    break;
                                case 10:
                                    this.zzlsy = zzfdy.zzcua();
                                    break;
                                case 18:
                                    this.zzlsz = zzfdy.zzcub();
                                    break;
                                default:
                                    if ((zzctt & 7) == 4) {
                                        zzb = false;
                                    } else {
                                        if (this.zzpcg == zzfgq.zzcwv()) {
                                            this.zzpcg = zzfgq.zzcww();
                                        }
                                        zzb = this.zzpcg.zzb(zzctt, zzfdy);
                                    }
                                    if (zzb) {
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
                    synchronized (zzfdm.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzpay);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzpay;
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
