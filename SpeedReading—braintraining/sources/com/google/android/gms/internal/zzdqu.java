package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdqs;
import java.io.IOException;

public final class zzdqu extends zzfem<zzdqu, zza> implements zzffs {
    private static volatile zzffu<zzdqu> zzbas;
    /* access modifiers changed from: private */
    public static final zzdqu zzlrw;
    private int zzlql;
    private zzdqs zzlrt;
    private zzfdp zzlru = zzfdp.zzpaz;
    private zzfdp zzlrv = zzfdp.zzpaz;

    public static final class zza extends zzfen<zzdqu, zza> implements zzffs {
        private zza() {
            super(zzdqu.zzlrw);
        }

        /* synthetic */ zza(zzdqv zzdqv) {
            this();
        }
    }

    static {
        zzdqu zzdqu = new zzdqu();
        zzlrw = zzdqu;
        zzdqu.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdqu.zzpcg.zzbin();
    }

    private zzdqu() {
    }

    public static zzdqu zzv(zzfdp zzfdp) throws zzffe {
        return (zzdqu) zzfem.zza(zzlrw, zzfdp);
    }

    public final int getVersion() {
        return this.zzlql;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdqs.zza zza2;
        boolean z = true;
        switch (zzdqv.zzbaq[i - 1]) {
            case 1:
                return new zzdqu();
            case 2:
                return zzlrw;
            case 3:
                return null;
            case 4:
                return new zza((zzdqv) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzdqu zzdqu = (zzdqu) obj2;
                this.zzlql = zzfev.zza(this.zzlql != 0, this.zzlql, zzdqu.zzlql != 0, zzdqu.zzlql);
                this.zzlrt = (zzdqs) zzfev.zza(this.zzlrt, zzdqu.zzlrt);
                this.zzlru = zzfev.zza(this.zzlru != zzfdp.zzpaz, this.zzlru, zzdqu.zzlru != zzfdp.zzpaz, zzdqu.zzlru);
                boolean z2 = this.zzlrv != zzfdp.zzpaz;
                zzfdp zzfdp = this.zzlrv;
                if (zzdqu.zzlrv == zzfdp.zzpaz) {
                    z = false;
                }
                this.zzlrv = zzfev.zza(z2, zzfdp, z, zzdqu.zzlrv);
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
                                case 8:
                                    this.zzlql = zzfdy.zzcuc();
                                    break;
                                case 18:
                                    if (this.zzlrt != null) {
                                        zzdqs zzdqs = this.zzlrt;
                                        zzfen zzfen = (zzfen) zzdqs.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                        zzfen.zza(zzdqs);
                                        zza2 = (zzdqs.zza) zzfen;
                                    } else {
                                        zza2 = null;
                                    }
                                    this.zzlrt = (zzdqs) zzfdy.zza(zzdqs.zzbmx(), zzfei);
                                    if (zza2 == null) {
                                        break;
                                    } else {
                                        zza2.zza(this.zzlrt);
                                        this.zzlrt = (zzdqs) zza2.zzcvk();
                                        break;
                                    }
                                case 26:
                                    this.zzlru = zzfdy.zzcub();
                                    break;
                                case 34:
                                    this.zzlrv = zzfdy.zzcub();
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
                    synchronized (zzdqu.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlrw);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlrw;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlql != 0) {
            zzfed.zzab(1, this.zzlql);
        }
        if (this.zzlrt != null) {
            zzfed.zza(2, (zzffq) this.zzlrt == null ? zzdqs.zzbmx() : this.zzlrt);
        }
        if (!this.zzlru.isEmpty()) {
            zzfed.zza(3, this.zzlru);
        }
        if (!this.zzlrv.isEmpty()) {
            zzfed.zza(4, this.zzlrv);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzdqs zzbmz() {
        return this.zzlrt == null ? zzdqs.zzbmx() : this.zzlrt;
    }

    public final zzfdp zzbna() {
        return this.zzlru;
    }

    public final zzfdp zzbnb() {
        return this.zzlrv;
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzlql != 0) {
            i2 = zzfed.zzae(1, this.zzlql) + 0;
        }
        if (this.zzlrt != null) {
            i2 += zzfed.zzb(2, (zzffq) this.zzlrt == null ? zzdqs.zzbmx() : this.zzlrt);
        }
        if (!this.zzlru.isEmpty()) {
            i2 += zzfed.zzb(3, this.zzlru);
        }
        if (!this.zzlrv.isEmpty()) {
            i2 += zzfed.zzb(4, this.zzlrv);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
