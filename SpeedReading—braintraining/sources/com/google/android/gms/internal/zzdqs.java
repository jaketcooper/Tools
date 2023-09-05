package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdqq;
import com.google.android.gms.internal.zzdqw;
import java.io.IOException;

public final class zzdqs extends zzfem<zzdqs, zza> implements zzffs {
    private static volatile zzffu<zzdqs> zzbas;
    /* access modifiers changed from: private */
    public static final zzdqs zzlrs;
    private zzdqw zzlrp;
    private zzdqq zzlrq;
    private int zzlrr;

    public static final class zza extends zzfen<zzdqs, zza> implements zzffs {
        private zza() {
            super(zzdqs.zzlrs);
        }

        /* synthetic */ zza(zzdqt zzdqt) {
            this();
        }
    }

    static {
        zzdqs zzdqs = new zzdqs();
        zzlrs = zzdqs;
        zzdqs.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdqs.zzpcg.zzbin();
    }

    private zzdqs() {
    }

    public static zzdqs zzbmx() {
        return zzlrs;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdqq.zza zza2;
        zzdqw.zza zza3;
        boolean z = true;
        switch (zzdqt.zzbaq[i - 1]) {
            case 1:
                return new zzdqs();
            case 2:
                return zzlrs;
            case 3:
                return null;
            case 4:
                return new zza((zzdqt) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzdqs zzdqs = (zzdqs) obj2;
                this.zzlrp = (zzdqw) zzfev.zza(this.zzlrp, zzdqs.zzlrp);
                this.zzlrq = (zzdqq) zzfev.zza(this.zzlrq, zzdqs.zzlrq);
                boolean z2 = this.zzlrr != 0;
                int i2 = this.zzlrr;
                if (zzdqs.zzlrr == 0) {
                    z = false;
                }
                this.zzlrr = zzfev.zza(z2, i2, z, zzdqs.zzlrr);
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
                                    if (this.zzlrp != null) {
                                        zzdqw zzdqw = this.zzlrp;
                                        zzfen zzfen = (zzfen) zzdqw.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                        zzfen.zza(zzdqw);
                                        zza3 = (zzdqw.zza) zzfen;
                                    } else {
                                        zza3 = null;
                                    }
                                    this.zzlrp = (zzdqw) zzfdy.zza(zzdqw.zzbng(), zzfei);
                                    if (zza3 == null) {
                                        break;
                                    } else {
                                        zza3.zza(this.zzlrp);
                                        this.zzlrp = (zzdqw) zza3.zzcvk();
                                        break;
                                    }
                                case 18:
                                    if (this.zzlrq != null) {
                                        zzdqq zzdqq = this.zzlrq;
                                        zzfen zzfen2 = (zzfen) zzdqq.zza(zzfeu.zzpcv, (Object) null, (Object) null);
                                        zzfen2.zza(zzdqq);
                                        zza2 = (zzdqq.zza) zzfen2;
                                    } else {
                                        zza2 = null;
                                    }
                                    this.zzlrq = (zzdqq) zzfdy.zza(zzdqq.zzbms(), zzfei);
                                    if (zza2 == null) {
                                        break;
                                    } else {
                                        zza2.zza(this.zzlrq);
                                        this.zzlrq = (zzdqq) zza2.zzcvk();
                                        break;
                                    }
                                case 24:
                                    this.zzlrr = zzfdy.zzcud();
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
                    synchronized (zzdqs.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlrs);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlrs;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlrp != null) {
            zzfed.zza(1, (zzffq) this.zzlrp == null ? zzdqw.zzbng() : this.zzlrp);
        }
        if (this.zzlrq != null) {
            zzfed.zza(2, (zzffq) this.zzlrq == null ? zzdqq.zzbms() : this.zzlrq);
        }
        if (this.zzlrr != zzdqo.UNKNOWN_FORMAT.zzhn()) {
            zzfed.zzaa(3, this.zzlrr);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzdqw zzbmu() {
        return this.zzlrp == null ? zzdqw.zzbng() : this.zzlrp;
    }

    public final zzdqq zzbmv() {
        return this.zzlrq == null ? zzdqq.zzbms() : this.zzlrq;
    }

    public final zzdqo zzbmw() {
        zzdqo zzfo = zzdqo.zzfo(this.zzlrr);
        return zzfo == null ? zzdqo.UNRECOGNIZED : zzfo;
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzlrp != null) {
            i2 = zzfed.zzb(1, (zzffq) this.zzlrp == null ? zzdqw.zzbng() : this.zzlrp) + 0;
        }
        if (this.zzlrq != null) {
            i2 += zzfed.zzb(2, (zzffq) this.zzlrq == null ? zzdqq.zzbms() : this.zzlrq);
        }
        if (this.zzlrr != zzdqo.UNKNOWN_FORMAT.zzhn()) {
            i2 += zzfed.zzag(3, this.zzlrr);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
