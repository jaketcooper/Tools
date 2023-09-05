package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdri;
import java.io.IOException;

public final class zzdre extends zzfem<zzdre, zza> implements zzffs {
    private static volatile zzffu<zzdre> zzbas;
    /* access modifiers changed from: private */
    public static final zzdre zzlst;
    private int zzlql;
    private zzfdp zzlqt = zzfdp.zzpaz;
    private zzdri zzlss;

    public static final class zza extends zzfen<zzdre, zza> implements zzffs {
        private zza() {
            super(zzdre.zzlst);
        }

        /* synthetic */ zza(zzdrf zzdrf) {
            this();
        }

        public final zza zzc(zzdri zzdri) {
            zzcvj();
            ((zzdre) this.zzpcj).zzb(zzdri);
            return this;
        }

        public final zza zzfr(int i) {
            zzcvj();
            ((zzdre) this.zzpcj).setVersion(0);
            return this;
        }

        public final zza zzx(zzfdp zzfdp) {
            zzcvj();
            ((zzdre) this.zzpcj).zzj(zzfdp);
            return this;
        }
    }

    static {
        zzdre zzdre = new zzdre();
        zzlst = zzdre;
        zzdre.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdre.zzpcg.zzbin();
    }

    private zzdre() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzlql = i;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzdri zzdri) {
        if (zzdri == null) {
            throw new NullPointerException();
        }
        this.zzlss = zzdri;
    }

    public static zza zzbnk() {
        zzdre zzdre = zzlst;
        zzfen zzfen = (zzfen) zzdre.zza(zzfeu.zzpcv, (Object) null, (Object) null);
        zzfen.zza(zzdre);
        return (zza) zzfen;
    }

    public static zzdre zzbnl() {
        return zzlst;
    }

    /* access modifiers changed from: private */
    public final void zzj(zzfdp zzfdp) {
        if (zzfdp == null) {
            throw new NullPointerException();
        }
        this.zzlqt = zzfdp;
    }

    public static zzdre zzw(zzfdp zzfdp) throws zzffe {
        return (zzdre) zzfem.zza(zzlst, zzfdp);
    }

    public final int getVersion() {
        return this.zzlql;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdri.zza zza2;
        boolean z = true;
        switch (zzdrf.zzbaq[i - 1]) {
            case 1:
                return new zzdre();
            case 2:
                return zzlst;
            case 3:
                return null;
            case 4:
                return new zza((zzdrf) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzdre zzdre = (zzdre) obj2;
                this.zzlql = zzfev.zza(this.zzlql != 0, this.zzlql, zzdre.zzlql != 0, zzdre.zzlql);
                this.zzlss = (zzdri) zzfev.zza(this.zzlss, zzdre.zzlss);
                boolean z2 = this.zzlqt != zzfdp.zzpaz;
                zzfdp zzfdp = this.zzlqt;
                if (zzdre.zzlqt == zzfdp.zzpaz) {
                    z = false;
                }
                this.zzlqt = zzfev.zza(z2, zzfdp, z, zzdre.zzlqt);
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
                    synchronized (zzdre.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlst);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlst;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlql != 0) {
            zzfed.zzab(1, this.zzlql);
        }
        if (this.zzlss != null) {
            zzfed.zza(2, (zzffq) this.zzlss == null ? zzdri.zzbnr() : this.zzlss);
        }
        if (!this.zzlqt.isEmpty()) {
            zzfed.zza(3, this.zzlqt);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzfdp zzblu() {
        return this.zzlqt;
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
        if (this.zzlql != 0) {
            i2 = zzfed.zzae(1, this.zzlql) + 0;
        }
        if (this.zzlss != null) {
            i2 += zzfed.zzb(2, (zzffq) this.zzlss == null ? zzdri.zzbnr() : this.zzlss);
        }
        if (!this.zzlqt.isEmpty()) {
            i2 += zzfed.zzb(3, this.zzlqt);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
