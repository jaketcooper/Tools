package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdqk;
import java.io.IOException;

public final class zzdqg extends zzfem<zzdqg, zza> implements zzffs {
    private static volatile zzffu<zzdqg> zzbas;
    /* access modifiers changed from: private */
    public static final zzdqg zzlre;
    private int zzlql;
    private zzfdp zzlqt = zzfdp.zzpaz;
    private zzdqk zzlrd;

    public static final class zza extends zzfen<zzdqg, zza> implements zzffs {
        private zza() {
            super(zzdqg.zzlre);
        }

        /* synthetic */ zza(zzdqh zzdqh) {
            this();
        }

        public final zza zzb(zzdqk zzdqk) {
            zzcvj();
            ((zzdqg) this.zzpcj).zza(zzdqk);
            return this;
        }

        public final zza zzfm(int i) {
            zzcvj();
            ((zzdqg) this.zzpcj).setVersion(0);
            return this;
        }

        public final zza zzr(zzfdp zzfdp) {
            zzcvj();
            ((zzdqg) this.zzpcj).zzj(zzfdp);
            return this;
        }
    }

    static {
        zzdqg zzdqg = new zzdqg();
        zzlre = zzdqg;
        zzdqg.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdqg.zzpcg.zzbin();
    }

    private zzdqg() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzlql = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdqk zzdqk) {
        if (zzdqk == null) {
            throw new NullPointerException();
        }
        this.zzlrd = zzdqk;
    }

    public static zza zzbmj() {
        zzdqg zzdqg = zzlre;
        zzfen zzfen = (zzfen) zzdqg.zza(zzfeu.zzpcv, (Object) null, (Object) null);
        zzfen.zza(zzdqg);
        return (zza) zzfen;
    }

    /* access modifiers changed from: private */
    public final void zzj(zzfdp zzfdp) {
        if (zzfdp == null) {
            throw new NullPointerException();
        }
        this.zzlqt = zzfdp;
    }

    public static zzdqg zzq(zzfdp zzfdp) throws zzffe {
        return (zzdqg) zzfem.zza(zzlre, zzfdp);
    }

    public final int getVersion() {
        return this.zzlql;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdqk.zza zza2;
        boolean z = true;
        switch (zzdqh.zzbaq[i - 1]) {
            case 1:
                return new zzdqg();
            case 2:
                return zzlre;
            case 3:
                return null;
            case 4:
                return new zza((zzdqh) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzdqg zzdqg = (zzdqg) obj2;
                this.zzlql = zzfev.zza(this.zzlql != 0, this.zzlql, zzdqg.zzlql != 0, zzdqg.zzlql);
                this.zzlrd = (zzdqk) zzfev.zza(this.zzlrd, zzdqg.zzlrd);
                boolean z2 = this.zzlqt != zzfdp.zzpaz;
                zzfdp zzfdp = this.zzlqt;
                if (zzdqg.zzlqt == zzfdp.zzpaz) {
                    z = false;
                }
                this.zzlqt = zzfev.zza(z2, zzfdp, z, zzdqg.zzlqt);
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
                                    if (this.zzlrd != null) {
                                        zzdqk zzdqk = this.zzlrd;
                                        zzfen zzfen = (zzfen) zzdqk.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                        zzfen.zza(zzdqk);
                                        zza2 = (zzdqk.zza) zzfen;
                                    } else {
                                        zza2 = null;
                                    }
                                    this.zzlrd = (zzdqk) zzfdy.zza(zzdqk.zzbmn(), zzfei);
                                    if (zza2 == null) {
                                        break;
                                    } else {
                                        zza2.zza(this.zzlrd);
                                        this.zzlrd = (zzdqk) zza2.zzcvk();
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
                    synchronized (zzdqg.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlre);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlre;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlql != 0) {
            zzfed.zzab(1, this.zzlql);
        }
        if (this.zzlrd != null) {
            zzfed.zza(2, (zzffq) this.zzlrd == null ? zzdqk.zzbmn() : this.zzlrd);
        }
        if (!this.zzlqt.isEmpty()) {
            zzfed.zza(3, this.zzlqt);
        }
        this.zzpcg.zza(zzfed);
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
        if (this.zzlrd != null) {
            i2 += zzfed.zzb(2, (zzffq) this.zzlrd == null ? zzdqk.zzbmn() : this.zzlrd);
        }
        if (!this.zzlqt.isEmpty()) {
            i2 += zzfed.zzb(3, this.zzlqt);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
