package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdqk;
import java.io.IOException;

public final class zzdqi extends zzfem<zzdqi, zza> implements zzffs {
    private static volatile zzffu<zzdqi> zzbas;
    /* access modifiers changed from: private */
    public static final zzdqi zzlrf;
    private int zzlqv;
    private zzdqk zzlrd;

    public static final class zza extends zzfen<zzdqi, zza> implements zzffs {
        private zza() {
            super(zzdqi.zzlrf);
        }

        /* synthetic */ zza(zzdqj zzdqj) {
            this();
        }
    }

    static {
        zzdqi zzdqi = new zzdqi();
        zzlrf = zzdqi;
        zzdqi.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdqi.zzpcg.zzbin();
    }

    private zzdqi() {
    }

    public static zzdqi zzs(zzfdp zzfdp) throws zzffe {
        return (zzdqi) zzfem.zza(zzlrf, zzfdp);
    }

    public final int getKeySize() {
        return this.zzlqv;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzdqk.zza zza2;
        boolean z = true;
        switch (zzdqj.zzbaq[i - 1]) {
            case 1:
                return new zzdqi();
            case 2:
                return zzlrf;
            case 3:
                return null;
            case 4:
                return new zza((zzdqj) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzdqi zzdqi = (zzdqi) obj2;
                this.zzlrd = (zzdqk) zzfev.zza(this.zzlrd, zzdqi.zzlrd);
                boolean z2 = this.zzlqv != 0;
                int i2 = this.zzlqv;
                if (zzdqi.zzlqv == 0) {
                    z = false;
                }
                this.zzlqv = zzfev.zza(z2, i2, z, zzdqi.zzlqv);
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
                    synchronized (zzdqi.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlrf);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlrf;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlrd != null) {
            zzfed.zza(1, (zzffq) this.zzlrd == null ? zzdqk.zzbmn() : this.zzlrd);
        }
        if (this.zzlqv != 0) {
            zzfed.zzab(2, this.zzlqv);
        }
        this.zzpcg.zza(zzfed);
    }

    public final zzdqk zzbml() {
        return this.zzlrd == null ? zzdqk.zzbmn() : this.zzlrd;
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzlrd != null) {
            i2 = zzfed.zzb(1, (zzffq) this.zzlrd == null ? zzdqk.zzbmn() : this.zzlrd) + 0;
        }
        if (this.zzlqv != 0) {
            i2 += zzfed.zzae(2, this.zzlqv);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
