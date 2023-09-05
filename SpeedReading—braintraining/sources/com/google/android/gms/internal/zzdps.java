package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdpw;
import com.google.android.gms.internal.zzdrg;
import java.io.IOException;

public final class zzdps extends zzfem<zzdps, zza> implements zzffs {
    private static volatile zzffu<zzdps> zzbas;
    /* access modifiers changed from: private */
    public static final zzdps zzlqr;
    private zzdpw zzlqp;
    private zzdrg zzlqq;

    public static final class zza extends zzfen<zzdps, zza> implements zzffs {
        private zza() {
            super(zzdps.zzlqr);
        }

        /* synthetic */ zza(zzdpt zzdpt) {
            this();
        }
    }

    static {
        zzdps zzdps = new zzdps();
        zzlqr = zzdps;
        zzdps.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdps.zzpcg.zzbin();
    }

    private zzdps() {
    }

    public static zzdps zzi(zzfdp zzfdp) throws zzffe {
        return (zzdps) zzfem.zza(zzlqr, zzfdp);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdrg.zza zza2;
        zzdpw.zza zza3;
        switch (zzdpt.zzbaq[i - 1]) {
            case 1:
                return new zzdps();
            case 2:
                return zzlqr;
            case 3:
                return null;
            case 4:
                return new zza((zzdpt) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzdps zzdps = (zzdps) obj2;
                this.zzlqp = (zzdpw) zzfev.zza(this.zzlqp, zzdps.zzlqp);
                this.zzlqq = (zzdrg) zzfev.zza(this.zzlqq, zzdps.zzlqq);
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
                                case 10:
                                    if (this.zzlqp != null) {
                                        zzdpw zzdpw = this.zzlqp;
                                        zzfen zzfen = (zzfen) zzdpw.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                        zzfen.zza(zzdpw);
                                        zza3 = (zzdpw.zza) zzfen;
                                    } else {
                                        zza3 = null;
                                    }
                                    this.zzlqp = (zzdpw) zzfdy.zza(zzdpw.zzbly(), zzfei);
                                    if (zza3 == null) {
                                        break;
                                    } else {
                                        zza3.zza(this.zzlqp);
                                        this.zzlqp = (zzdpw) zza3.zzcvk();
                                        break;
                                    }
                                case 18:
                                    if (this.zzlqq != null) {
                                        zzdrg zzdrg = this.zzlqq;
                                        zzfen zzfen2 = (zzfen) zzdrg.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                        zzfen2.zza(zzdrg);
                                        zza2 = (zzdrg.zza) zzfen2;
                                    } else {
                                        zza2 = null;
                                    }
                                    this.zzlqq = (zzdrg) zzfdy.zza(zzdrg.zzbnn(), zzfei);
                                    if (zza2 == null) {
                                        break;
                                    } else {
                                        zza2.zza(this.zzlqq);
                                        this.zzlqq = (zzdrg) zza2.zzcvk();
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
                    synchronized (zzdps.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlqr);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlqr;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlqp != null) {
            zzfed.zza(1, (zzffq) this.zzlqp == null ? zzdpw.zzbly() : this.zzlqp);
        }
        if (this.zzlqq != null) {
            zzfed.zza(2, (zzffq) this.zzlqq == null ? zzdrg.zzbnn() : this.zzlqq);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzdpw zzblq() {
        return this.zzlqp == null ? zzdpw.zzbly() : this.zzlqp;
    }

    public final zzdrg zzblr() {
        return this.zzlqq == null ? zzdrg.zzbnn() : this.zzlqq;
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzlqp != null) {
            i2 = zzfed.zzb(1, (zzffq) this.zzlqp == null ? zzdpw.zzbly() : this.zzlqp) + 0;
        }
        if (this.zzlqq != null) {
            i2 += zzfed.zzb(2, (zzffq) this.zzlqq == null ? zzdrg.zzbnn() : this.zzlqq);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
