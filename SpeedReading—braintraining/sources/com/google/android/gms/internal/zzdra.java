package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrt;
import java.io.IOException;

public final class zzdra extends zzfem<zzdra, zza> implements zzffs {
    private static volatile zzffu<zzdra> zzbas;
    /* access modifiers changed from: private */
    public static final zzdra zzlsk;
    private zzfdp zzlsi = zzfdp.zzpaz;
    private zzdrt zzlsj;

    public static final class zza extends zzfen<zzdra, zza> implements zzffs {
        private zza() {
            super(zzdra.zzlsk);
        }

        /* synthetic */ zza(zzdrb zzdrb) {
            this();
        }
    }

    static {
        zzdra zzdra = new zzdra();
        zzlsk = zzdra;
        zzdra.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdra.zzpcg.zzbin();
    }

    private zzdra() {
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdrt.zza zza2;
        boolean z = true;
        switch (zzdrb.zzbaq[i - 1]) {
            case 1:
                return new zzdra();
            case 2:
                return zzlsk;
            case 3:
                return null;
            case 4:
                return new zza((zzdrb) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzdra zzdra = (zzdra) obj2;
                boolean z2 = this.zzlsi != zzfdp.zzpaz;
                zzfdp zzfdp = this.zzlsi;
                if (zzdra.zzlsi == zzfdp.zzpaz) {
                    z = false;
                }
                this.zzlsi = zzfev.zza(z2, zzfdp, z, zzdra.zzlsi);
                this.zzlsj = (zzdrt) zzfev.zza(this.zzlsj, zzdra.zzlsj);
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
                                case 18:
                                    this.zzlsi = zzfdy.zzcub();
                                    break;
                                case 26:
                                    if (this.zzlsj != null) {
                                        zzdrt zzdrt = this.zzlsj;
                                        zzfen zzfen = (zzfen) zzdrt.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                        zzfen.zza(zzdrt);
                                        zza2 = (zzdrt.zza) zzfen;
                                    } else {
                                        zza2 = null;
                                    }
                                    this.zzlsj = (zzdrt) zzfdy.zza(zzdrt.zzbon(), zzfei);
                                    if (zza2 == null) {
                                        break;
                                    } else {
                                        zza2.zza(this.zzlsj);
                                        this.zzlsj = (zzdrt) zza2.zzcvk();
                                        break;
                                    }
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
                    synchronized (zzdra.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlsk);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlsk;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (!this.zzlsi.isEmpty()) {
            zzfed.zza(2, this.zzlsi);
        }
        if (this.zzlsj != null) {
            zzfed.zza(3, (zzffq) this.zzlsj == null ? zzdrt.zzbon() : this.zzlsj);
        }
        this.zzpcg.zza(zzfed);
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.zzlsi.isEmpty()) {
            i2 = zzfed.zzb(2, this.zzlsi) + 0;
        }
        if (this.zzlsj != null) {
            i2 += zzfed.zzb(3, (zzffq) this.zzlsj == null ? zzdrt.zzbon() : this.zzlsj);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
