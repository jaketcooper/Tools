package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfew extends zzfem<zzfew, zza> implements zzffs {
    private static volatile zzffu<zzfew> zzbas;
    /* access modifiers changed from: private */
    public static final zzfew zzpdd;
    private int zzpdc;

    public static final class zza extends zzfen<zzfew, zza> implements zzffs {
        private zza() {
            super(zzfew.zzpdd);
        }

        /* synthetic */ zza(zzfex zzfex) {
            this();
        }

        public final zza zzlj(int i) {
            zzcvj();
            ((zzfew) this.zzpcj).setValue(i);
            return this;
        }
    }

    static {
        zzfew zzfew = new zzfew();
        zzpdd = zzfew;
        zzfew.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzfew.zzpcg.zzbin();
    }

    private zzfew() {
    }

    /* access modifiers changed from: private */
    public final void setValue(int i) {
        this.zzpdc = i;
    }

    public static zza zzcvo() {
        zzfew zzfew = zzpdd;
        zzfen zzfen = (zzfen) zzfew.zza(zzfeu.zzpcv, (Object) null, (Object) null);
        zzfen.zza(zzfew);
        return (zza) zzfen;
    }

    public static zzfew zzcvp() {
        return zzpdd;
    }

    public final int getValue() {
        return this.zzpdc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        boolean zzb;
        boolean z = true;
        switch (zzfex.zzbaq[i - 1]) {
            case 1:
                return new zzfew();
            case 2:
                return zzpdd;
            case 3:
                return null;
            case 4:
                return new zza((zzfex) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzfew zzfew = (zzfew) obj2;
                boolean z2 = this.zzpdc != 0;
                int i2 = this.zzpdc;
                if (zzfew.zzpdc == 0) {
                    z = false;
                }
                this.zzpdc = zzfev.zza(z2, i2, z, zzfew.zzpdc);
                return this;
            case 6:
                zzfdy zzfdy = (zzfdy) obj;
                if (((zzfei) obj2) != null) {
                    boolean z3 = false;
                    while (!z3) {
                        try {
                            int zzctt = zzfdy.zzctt();
                            switch (zzctt) {
                                case 0:
                                    z3 = true;
                                    break;
                                case 8:
                                    this.zzpdc = zzfdy.zzctw();
                                    break;
                                default:
                                    if ((zzctt & 7) == 4) {
                                        zzb = false;
                                    } else {
                                        if (this.zzpcg == zzfgq.zzcwv()) {
                                            this.zzpcg = zzfgq.zzcww();
                                        }
                                        zzb = this.zzpcg.zzb(zzctt, zzfdy);
                                    }
                                    if (zzb) {
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
                    synchronized (zzfew.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzpdd);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzpdd;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzpdc != 0) {
            zzfed.zzaa(1, this.zzpdc);
        }
        this.zzpcg.zza(zzfed);
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzpdc != 0) {
            i2 = zzfed.zzad(1, this.zzpdc) + 0;
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
