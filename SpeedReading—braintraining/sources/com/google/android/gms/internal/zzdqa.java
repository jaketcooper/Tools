package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdqe;
import java.io.IOException;

public final class zzdqa extends zzfem<zzdqa, zza> implements zzffs {
    private static volatile zzffu<zzdqa> zzbas;
    /* access modifiers changed from: private */
    public static final zzdqa zzlra;
    private int zzlql;
    private zzfdp zzlqt = zzfdp.zzpaz;
    private zzdqe zzlqz;

    public static final class zza extends zzfen<zzdqa, zza> implements zzffs {
        private zza() {
            super(zzdqa.zzlra);
        }

        /* synthetic */ zza(zzdqb zzdqb) {
            this();
        }

        public final zza zzb(zzdqe zzdqe) {
            zzcvj();
            ((zzdqa) this.zzpcj).zza(zzdqe);
            return this;
        }

        public final zza zzfl(int i) {
            zzcvj();
            ((zzdqa) this.zzpcj).setVersion(0);
            return this;
        }

        public final zza zzo(zzfdp zzfdp) {
            zzcvj();
            ((zzdqa) this.zzpcj).zzj(zzfdp);
            return this;
        }
    }

    static {
        zzdqa zzdqa = new zzdqa();
        zzlra = zzdqa;
        zzdqa.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdqa.zzpcg.zzbin();
    }

    private zzdqa() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzlql = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdqe zzdqe) {
        if (zzdqe == null) {
            throw new NullPointerException();
        }
        this.zzlqz = zzdqe;
    }

    public static zza zzbme() {
        zzdqa zzdqa = zzlra;
        zzfen zzfen = (zzfen) zzdqa.zza(zzfeu.zzpcv, (Object) null, (Object) null);
        zzfen.zza(zzdqa);
        return (zza) zzfen;
    }

    /* access modifiers changed from: private */
    public final void zzj(zzfdp zzfdp) {
        if (zzfdp == null) {
            throw new NullPointerException();
        }
        this.zzlqt = zzfdp;
    }

    public static zzdqa zzn(zzfdp zzfdp) throws zzffe {
        return (zzdqa) zzfem.zza(zzlra, zzfdp);
    }

    public final int getVersion() {
        return this.zzlql;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdqe.zza zza2;
        boolean z = true;
        switch (zzdqb.zzbaq[i - 1]) {
            case 1:
                return new zzdqa();
            case 2:
                return zzlra;
            case 3:
                return null;
            case 4:
                return new zza((zzdqb) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzdqa zzdqa = (zzdqa) obj2;
                this.zzlql = zzfev.zza(this.zzlql != 0, this.zzlql, zzdqa.zzlql != 0, zzdqa.zzlql);
                this.zzlqz = (zzdqe) zzfev.zza(this.zzlqz, zzdqa.zzlqz);
                boolean z2 = this.zzlqt != zzfdp.zzpaz;
                zzfdp zzfdp = this.zzlqt;
                if (zzdqa.zzlqt == zzfdp.zzpaz) {
                    z = false;
                }
                this.zzlqt = zzfev.zza(z2, zzfdp, z, zzdqa.zzlqt);
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
                                    if (this.zzlqz != null) {
                                        zzdqe zzdqe = this.zzlqz;
                                        zzfen zzfen = (zzfen) zzdqe.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                        zzfen.zza(zzdqe);
                                        zza2 = (zzdqe.zza) zzfen;
                                    } else {
                                        zza2 = null;
                                    }
                                    this.zzlqz = (zzdqe) zzfdy.zza(zzdqe.zzbmh(), zzfei);
                                    if (zza2 == null) {
                                        break;
                                    } else {
                                        zza2.zza(this.zzlqz);
                                        this.zzlqz = (zzdqe) zza2.zzcvk();
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
                    synchronized (zzdqa.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlra);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlra;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlql != 0) {
            zzfed.zzab(1, this.zzlql);
        }
        if (this.zzlqz != null) {
            zzfed.zza(2, (zzffq) this.zzlqz == null ? zzdqe.zzbmh() : this.zzlqz);
        }
        if (!this.zzlqt.isEmpty()) {
            zzfed.zza(3, this.zzlqt);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzfdp zzblu() {
        return this.zzlqt;
    }

    public final zzdqe zzbmd() {
        return this.zzlqz == null ? zzdqe.zzbmh() : this.zzlqz;
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
        if (this.zzlqz != null) {
            i2 += zzfed.zzb(2, (zzffq) this.zzlqz == null ? zzdqe.zzbmh() : this.zzlqz);
        }
        if (!this.zzlqt.isEmpty()) {
            i2 += zzfed.zzb(3, this.zzlqt);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
