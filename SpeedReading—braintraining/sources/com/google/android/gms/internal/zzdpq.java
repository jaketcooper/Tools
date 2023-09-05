package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdpu;
import com.google.android.gms.internal.zzdre;
import java.io.IOException;

public final class zzdpq extends zzfem<zzdpq, zza> implements zzffs {
    private static volatile zzffu<zzdpq> zzbas;
    /* access modifiers changed from: private */
    public static final zzdpq zzlqo;
    private int zzlql;
    private zzdpu zzlqm;
    private zzdre zzlqn;

    public static final class zza extends zzfen<zzdpq, zza> implements zzffs {
        private zza() {
            super(zzdpq.zzlqo);
        }

        /* synthetic */ zza(zzdpr zzdpr) {
            this();
        }

        public final zza zzb(zzdpu zzdpu) {
            zzcvj();
            ((zzdpq) this.zzpcj).zza(zzdpu);
            return this;
        }

        public final zza zzb(zzdre zzdre) {
            zzcvj();
            ((zzdpq) this.zzpcj).zza(zzdre);
            return this;
        }

        public final zza zzfj(int i) {
            zzcvj();
            ((zzdpq) this.zzpcj).setVersion(i);
            return this;
        }
    }

    static {
        zzdpq zzdpq = new zzdpq();
        zzlqo = zzdpq;
        zzdpq.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdpq.zzpcg.zzbin();
    }

    private zzdpq() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzlql = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdpu zzdpu) {
        if (zzdpu == null) {
            throw new NullPointerException();
        }
        this.zzlqm = zzdpu;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdre zzdre) {
        if (zzdre == null) {
            throw new NullPointerException();
        }
        this.zzlqn = zzdre;
    }

    public static zza zzblo() {
        zzdpq zzdpq = zzlqo;
        zzfen zzfen = (zzfen) zzdpq.zza(zzfeu.zzpcv, (Object) null, (Object) null);
        zzfen.zza(zzdpq);
        return (zza) zzfen;
    }

    public static zzdpq zzh(zzfdp zzfdp) throws zzffe {
        return (zzdpq) zzfem.zza(zzlqo, zzfdp);
    }

    public final int getVersion() {
        return this.zzlql;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdre.zza zza2;
        zzdpu.zza zza3;
        boolean z = true;
        switch (zzdpr.zzbaq[i - 1]) {
            case 1:
                return new zzdpq();
            case 2:
                return zzlqo;
            case 3:
                return null;
            case 4:
                return new zza((zzdpr) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzdpq zzdpq = (zzdpq) obj2;
                boolean z2 = this.zzlql != 0;
                int i2 = this.zzlql;
                if (zzdpq.zzlql == 0) {
                    z = false;
                }
                this.zzlql = zzfev.zza(z2, i2, z, zzdpq.zzlql);
                this.zzlqm = (zzdpu) zzfev.zza(this.zzlqm, zzdpq.zzlqm);
                this.zzlqn = (zzdre) zzfev.zza(this.zzlqn, zzdpq.zzlqn);
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
                                    if (this.zzlqm != null) {
                                        zzdpu zzdpu = this.zzlqm;
                                        zzfen zzfen = (zzfen) zzdpu.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                        zzfen.zza(zzdpu);
                                        zza3 = (zzdpu.zza) zzfen;
                                    } else {
                                        zza3 = null;
                                    }
                                    this.zzlqm = (zzdpu) zzfdy.zza(zzdpu.zzblw(), zzfei);
                                    if (zza3 == null) {
                                        break;
                                    } else {
                                        zza3.zza(this.zzlqm);
                                        this.zzlqm = (zzdpu) zza3.zzcvk();
                                        break;
                                    }
                                case 26:
                                    if (this.zzlqn != null) {
                                        zzdre zzdre = this.zzlqn;
                                        zzfen zzfen2 = (zzfen) zzdre.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                        zzfen2.zza(zzdre);
                                        zza2 = (zzdre.zza) zzfen2;
                                    } else {
                                        zza2 = null;
                                    }
                                    this.zzlqn = (zzdre) zzfdy.zza(zzdre.zzbnl(), zzfei);
                                    if (zza2 == null) {
                                        break;
                                    } else {
                                        zza2.zza(this.zzlqn);
                                        this.zzlqn = (zzdre) zza2.zzcvk();
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
                    synchronized (zzdpq.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlqo);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlqo;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlql != 0) {
            zzfed.zzab(1, this.zzlql);
        }
        if (this.zzlqm != null) {
            zzfed.zza(2, (zzffq) this.zzlqm == null ? zzdpu.zzblw() : this.zzlqm);
        }
        if (this.zzlqn != null) {
            zzfed.zza(3, (zzffq) this.zzlqn == null ? zzdre.zzbnl() : this.zzlqn);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzdpu zzblm() {
        return this.zzlqm == null ? zzdpu.zzblw() : this.zzlqm;
    }

    public final zzdre zzbln() {
        return this.zzlqn == null ? zzdre.zzbnl() : this.zzlqn;
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
        if (this.zzlqm != null) {
            i2 += zzfed.zzb(2, (zzffq) this.zzlqm == null ? zzdpu.zzblw() : this.zzlqm);
        }
        if (this.zzlqn != null) {
            i2 += zzfed.zzb(3, (zzffq) this.zzlqn == null ? zzdre.zzbnl() : this.zzlqn);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
