package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdri;
import java.io.IOException;

public final class zzdrg extends zzfem<zzdrg, zza> implements zzffs {
    private static volatile zzffu<zzdrg> zzbas;
    /* access modifiers changed from: private */
    public static final zzdrg zzlsu;
    private int zzlqv;
    private zzdri zzlss;

    public static final class zza extends zzfen<zzdrg, zza> implements zzffs {
        private zza() {
            super(zzdrg.zzlsu);
        }

        /* synthetic */ zza(zzdrh zzdrh) {
            this();
        }
    }

    static {
        zzdrg zzdrg = new zzdrg();
        zzlsu = zzdrg;
        zzdrg.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdrg.zzpcg.zzbin();
    }

    private zzdrg() {
    }

    public static zzdrg zzbnn() {
        return zzlsu;
    }

    public static zzdrg zzy(zzfdp zzfdp) throws zzffe {
        return (zzdrg) zzfem.zza(zzlsu, zzfdp);
    }

    public final int getKeySize() {
        return this.zzlqv;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdri.zza zza2;
        boolean z = true;
        switch (zzdrh.zzbaq[i - 1]) {
            case 1:
                return new zzdrg();
            case 2:
                return zzlsu;
            case 3:
                return null;
            case 4:
                return new zza((zzdrh) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzdrg zzdrg = (zzdrg) obj2;
                this.zzlss = (zzdri) zzfev.zza(this.zzlss, zzdrg.zzlss);
                boolean z2 = this.zzlqv != 0;
                int i2 = this.zzlqv;
                if (zzdrg.zzlqv == 0) {
                    z = false;
                }
                this.zzlqv = zzfev.zza(z2, i2, z, zzdrg.zzlqv);
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
                                    if (this.zzlss != null) {
                                        zzdri zzdri = this.zzlss;
                                        zzfen zzfen = (zzfen) zzdri.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                        zzfen.zza(zzdri);
                                        zza2 = (zzdri.zza) zzfen;
                                    } else {
                                        zza2 = null;
                                    }
                                    this.zzlss = (zzdri) zzfdy.zza(zzdri.zzbnr(), zzfei);
                                    if (zza2 == null) {
                                        break;
                                    } else {
                                        zza2.zza(this.zzlss);
                                        this.zzlss = (zzdri) zza2.zzcvk();
                                        break;
                                    }
                                case 16:
                                    this.zzlqv = zzfdy.zzcuc();
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
                    synchronized (zzdrg.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlsu);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlsu;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlss != null) {
            zzfed.zza(1, (zzffq) this.zzlss == null ? zzdri.zzbnr() : this.zzlss);
        }
        if (this.zzlqv != 0) {
            zzfed.zzab(2, this.zzlqv);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzdri zzbnj() {
        return this.zzlss == null ? zzdri.zzbnr() : this.zzlss;
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzlss != null) {
            i2 = zzfed.zzb(1, (zzffq) this.zzlss == null ? zzdri.zzbnr() : this.zzlss) + 0;
        }
        if (this.zzlqv != 0) {
            i2 += zzfed.zzae(2, this.zzlqv);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
