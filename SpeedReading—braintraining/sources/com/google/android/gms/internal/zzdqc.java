package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdqe;
import java.io.IOException;

public final class zzdqc extends zzfem<zzdqc, zza> implements zzffs {
    private static volatile zzffu<zzdqc> zzbas;
    /* access modifiers changed from: private */
    public static final zzdqc zzlrb;
    private int zzlqv;
    private zzdqe zzlqz;

    public static final class zza extends zzfen<zzdqc, zza> implements zzffs {
        private zza() {
            super(zzdqc.zzlrb);
        }

        /* synthetic */ zza(zzdqd zzdqd) {
            this();
        }
    }

    static {
        zzdqc zzdqc = new zzdqc();
        zzlrb = zzdqc;
        zzdqc.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdqc.zzpcg.zzbin();
    }

    private zzdqc() {
    }

    public static zzdqc zzp(zzfdp zzfdp) throws zzffe {
        return (zzdqc) zzfem.zza(zzlrb, zzfdp);
    }

    public final int getKeySize() {
        return this.zzlqv;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdqe.zza zza2;
        boolean z = true;
        switch (zzdqd.zzbaq[i - 1]) {
            case 1:
                return new zzdqc();
            case 2:
                return zzlrb;
            case 3:
                return null;
            case 4:
                return new zza((zzdqd) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzdqc zzdqc = (zzdqc) obj2;
                this.zzlqz = (zzdqe) zzfev.zza(this.zzlqz, zzdqc.zzlqz);
                boolean z2 = this.zzlqv != 0;
                int i2 = this.zzlqv;
                if (zzdqc.zzlqv == 0) {
                    z = false;
                }
                this.zzlqv = zzfev.zza(z2, i2, z, zzdqc.zzlqv);
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
                    synchronized (zzdqc.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlrb);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlrb;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlqz != null) {
            zzfed.zza(1, (zzffq) this.zzlqz == null ? zzdqe.zzbmh() : this.zzlqz);
        }
        if (this.zzlqv != 0) {
            zzfed.zzab(2, this.zzlqv);
        }
        this.zzpcg.zza(zzfed);
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
        if (this.zzlqz != null) {
            i2 = zzfed.zzb(1, (zzffq) this.zzlqz == null ? zzdqe.zzbmh() : this.zzlqz) + 0;
        }
        if (this.zzlqv != 0) {
            i2 += zzfed.zzae(2, this.zzlqv);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
