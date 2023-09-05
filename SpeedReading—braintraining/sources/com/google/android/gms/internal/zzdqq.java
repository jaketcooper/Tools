package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrp;
import java.io.IOException;

public final class zzdqq extends zzfem<zzdqq, zza> implements zzffs {
    private static volatile zzffu<zzdqq> zzbas;
    /* access modifiers changed from: private */
    public static final zzdqq zzlro;
    private zzdrp zzlrn;

    public static final class zza extends zzfen<zzdqq, zza> implements zzffs {
        private zza() {
            super(zzdqq.zzlro);
        }

        /* synthetic */ zza(zzdqr zzdqr) {
            this();
        }
    }

    static {
        zzdqq zzdqq = new zzdqq();
        zzlro = zzdqq;
        zzdqq.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdqq.zzpcg.zzbin();
    }

    private zzdqq() {
    }

    public static zzdqq zzbms() {
        return zzlro;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdrp.zza zza2;
        switch (zzdqr.zzbaq[i - 1]) {
            case 1:
                return new zzdqq();
            case 2:
                return zzlro;
            case 3:
                return null;
            case 4:
                return new zza((zzdqr) null);
            case 5:
                this.zzlrn = (zzdrp) ((zzfev) obj).zza(this.zzlrn, ((zzdqq) obj2).zzlrn);
                return this;
            case 6:
                zzfdy zzfdy = (zzfdy) obj;
                zzfei zzfei = (zzfei) obj2;
                if (zzfei != null) {
                    boolean z = false;
                    while (!z) {
                        try {
                            int zzctt = zzfdy.zzctt();
                            switch (zzctt) {
                                case 0:
                                    z = true;
                                    break;
                                case 18:
                                    if (this.zzlrn != null) {
                                        zzdrp zzdrp = this.zzlrn;
                                        zzfen zzfen = (zzfen) zzdrp.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                        zzfen.zza(zzdrp);
                                        zza2 = (zzdrp.zza) zzfen;
                                    } else {
                                        zza2 = null;
                                    }
                                    this.zzlrn = (zzdrp) zzfdy.zza(zzdrp.zzbnz(), zzfei);
                                    if (zza2 == null) {
                                        break;
                                    } else {
                                        zza2.zza(this.zzlrn);
                                        this.zzlrn = (zzdrp) zza2.zzcvk();
                                        break;
                                    }
                                default:
                                    if (zza(zzctt, zzfdy)) {
                                        break;
                                    } else {
                                        z = true;
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
                    synchronized (zzdqq.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlro);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlro;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlrn != null) {
            zzfed.zza(2, (zzffq) this.zzlrn == null ? zzdrp.zzbnz() : this.zzlrn);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzdrp zzbmr() {
        return this.zzlrn == null ? zzdrp.zzbnz() : this.zzlrn;
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzlrn != null) {
            i2 = zzfed.zzb(2, (zzffq) this.zzlrn == null ? zzdrp.zzbnz() : this.zzlrn) + 0;
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
