package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdpy;
import java.io.IOException;

public final class zzdpu extends zzfem<zzdpu, zza> implements zzffs {
    private static volatile zzffu<zzdpu> zzbas;
    /* access modifiers changed from: private */
    public static final zzdpu zzlqu;
    private int zzlql;
    private zzdpy zzlqs;
    private zzfdp zzlqt = zzfdp.zzpaz;

    public static final class zza extends zzfen<zzdpu, zza> implements zzffs {
        private zza() {
            super(zzdpu.zzlqu);
        }

        /* synthetic */ zza(zzdpv zzdpv) {
            this();
        }

        public final zza zzc(zzdpy zzdpy) {
            zzcvj();
            ((zzdpu) this.zzpcj).zzb(zzdpy);
            return this;
        }

        public final zza zzfk(int i) {
            zzcvj();
            ((zzdpu) this.zzpcj).setVersion(0);
            return this;
        }

        public final zza zzl(zzfdp zzfdp) {
            zzcvj();
            ((zzdpu) this.zzpcj).zzj(zzfdp);
            return this;
        }
    }

    static {
        zzdpu zzdpu = new zzdpu();
        zzlqu = zzdpu;
        zzdpu.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdpu.zzpcg.zzbin();
    }

    private zzdpu() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzlql = i;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzdpy zzdpy) {
        if (zzdpy == null) {
            throw new NullPointerException();
        }
        this.zzlqs = zzdpy;
    }

    public static zza zzblv() {
        zzdpu zzdpu = zzlqu;
        zzfen zzfen = (zzfen) zzdpu.zza(zzfeu.zzpcv, (Object) null, (Object) null);
        zzfen.zza(zzdpu);
        return (zza) zzfen;
    }

    public static zzdpu zzblw() {
        return zzlqu;
    }

    /* access modifiers changed from: private */
    public final void zzj(zzfdp zzfdp) {
        if (zzfdp == null) {
            throw new NullPointerException();
        }
        this.zzlqt = zzfdp;
    }

    public static zzdpu zzk(zzfdp zzfdp) throws zzffe {
        return (zzdpu) zzfem.zza(zzlqu, zzfdp);
    }

    public final int getVersion() {
        return this.zzlql;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdpy.zza zza2;
        boolean z = true;
        switch (zzdpv.zzbaq[i - 1]) {
            case 1:
                return new zzdpu();
            case 2:
                return zzlqu;
            case 3:
                return null;
            case 4:
                return new zza((zzdpv) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzdpu zzdpu = (zzdpu) obj2;
                this.zzlql = zzfev.zza(this.zzlql != 0, this.zzlql, zzdpu.zzlql != 0, zzdpu.zzlql);
                this.zzlqs = (zzdpy) zzfev.zza(this.zzlqs, zzdpu.zzlqs);
                boolean z2 = this.zzlqt != zzfdp.zzpaz;
                zzfdp zzfdp = this.zzlqt;
                if (zzdpu.zzlqt == zzfdp.zzpaz) {
                    z = false;
                }
                this.zzlqt = zzfev.zza(z2, zzfdp, z, zzdpu.zzlqt);
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
                                    if (this.zzlqs != null) {
                                        zzdpy zzdpy = this.zzlqs;
                                        zzfen zzfen = (zzfen) zzdpy.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                        zzfen.zza(zzdpy);
                                        zza2 = (zzdpy.zza) zzfen;
                                    } else {
                                        zza2 = null;
                                    }
                                    this.zzlqs = (zzdpy) zzfdy.zza(zzdpy.zzbmb(), zzfei);
                                    if (zza2 == null) {
                                        break;
                                    } else {
                                        zza2.zza(this.zzlqs);
                                        this.zzlqs = (zzdpy) zza2.zzcvk();
                                        break;
                                    }
                                case 26:
                                    this.zzlqt = zzfdy.zzcub();
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
                    synchronized (zzdpu.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlqu);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlqu;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlql != 0) {
            zzfed.zzab(1, this.zzlql);
        }
        if (this.zzlqs != null) {
            zzfed.zza(2, (zzffq) this.zzlqs == null ? zzdpy.zzbmb() : this.zzlqs);
        }
        if (!this.zzlqt.isEmpty()) {
            zzfed.zza(3, this.zzlqt);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzdpy zzblt() {
        return this.zzlqs == null ? zzdpy.zzbmb() : this.zzlqs;
    }

    public final zzfdp zzblu() {
        return this.zzlqt;
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
        if (this.zzlqs != null) {
            i2 += zzfed.zzb(2, (zzffq) this.zzlqs == null ? zzdpy.zzbmb() : this.zzlqs);
        }
        if (!this.zzlqt.isEmpty()) {
            i2 += zzfed.zzb(3, this.zzlqt);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
