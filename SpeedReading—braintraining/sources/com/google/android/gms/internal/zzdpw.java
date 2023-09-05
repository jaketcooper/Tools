package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdpy;
import java.io.IOException;

public final class zzdpw extends zzfem<zzdpw, zza> implements zzffs {
    private static volatile zzffu<zzdpw> zzbas;
    /* access modifiers changed from: private */
    public static final zzdpw zzlqw;
    private zzdpy zzlqs;
    private int zzlqv;

    public static final class zza extends zzfen<zzdpw, zza> implements zzffs {
        private zza() {
            super(zzdpw.zzlqw);
        }

        /* synthetic */ zza(zzdpx zzdpx) {
            this();
        }
    }

    static {
        zzdpw zzdpw = new zzdpw();
        zzlqw = zzdpw;
        zzdpw.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdpw.zzpcg.zzbin();
    }

    private zzdpw() {
    }

    public static zzdpw zzbly() {
        return zzlqw;
    }

    public static zzdpw zzm(zzfdp zzfdp) throws zzffe {
        return (zzdpw) zzfem.zza(zzlqw, zzfdp);
    }

    public final int getKeySize() {
        return this.zzlqv;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdpy.zza zza2;
        boolean z = true;
        switch (zzdpx.zzbaq[i - 1]) {
            case 1:
                return new zzdpw();
            case 2:
                return zzlqw;
            case 3:
                return null;
            case 4:
                return new zza((zzdpx) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzdpw zzdpw = (zzdpw) obj2;
                this.zzlqs = (zzdpy) zzfev.zza(this.zzlqs, zzdpw.zzlqs);
                boolean z2 = this.zzlqv != 0;
                int i2 = this.zzlqv;
                if (zzdpw.zzlqv == 0) {
                    z = false;
                }
                this.zzlqv = zzfev.zza(z2, i2, z, zzdpw.zzlqv);
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
                    synchronized (zzdpw.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlqw);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlqw;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlqs != null) {
            zzfed.zza(1, (zzffq) this.zzlqs == null ? zzdpy.zzbmb() : this.zzlqs);
        }
        if (this.zzlqv != 0) {
            zzfed.zzab(2, this.zzlqv);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzdpy zzblt() {
        return this.zzlqs == null ? zzdpy.zzbmb() : this.zzlqs;
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzlqs != null) {
            i2 = zzfed.zzb(1, (zzffq) this.zzlqs == null ? zzdpy.zzbmb() : this.zzlqs) + 0;
        }
        if (this.zzlqv != 0) {
            i2 += zzfed.zzae(2, this.zzlqv);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
