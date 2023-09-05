package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfgn extends zzfem<zzfgn, zza> implements zzffs {
    private static volatile zzffu<zzfgn> zzbas;
    /* access modifiers changed from: private */
    public static final zzfgn zzpex;
    private long zzpev;
    private int zzpew;

    public static final class zza extends zzfen<zzfgn, zza> implements zzffs {
        private zza() {
            super(zzfgn.zzpex);
        }

        /* synthetic */ zza(zzfgo zzfgo) {
            this();
        }

        public final zza zzdf(long j) {
            zzcvj();
            ((zzfgn) this.zzpcj).zzde(j);
            return this;
        }

        public final zza zzlt(int i) {
            zzcvj();
            ((zzfgn) this.zzpcj).setNanos(i);
            return this;
        }
    }

    static {
        zzfgn zzfgn = new zzfgn();
        zzpex = zzfgn;
        zzfgn.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzfgn.zzpcg.zzbin();
    }

    private zzfgn() {
    }

    /* access modifiers changed from: private */
    public final void setNanos(int i) {
        this.zzpew = i;
    }

    public static zza zzcwr() {
        zzfgn zzfgn = zzpex;
        zzfen zzfen = (zzfen) zzfgn.zza(zzfeu.zzpcv, (Object) null, (Object) null);
        zzfen.zza(zzfgn);
        return (zza) zzfen;
    }

    public static zzfgn zzcws() {
        return zzpex;
    }

    /* access modifiers changed from: private */
    public final void zzde(long j) {
        this.zzpev = j;
    }

    public final int getNanos() {
        return this.zzpew;
    }

    public final long getSeconds() {
        return this.zzpev;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        boolean zzb;
        boolean z = true;
        switch (zzfgo.zzbaq[i - 1]) {
            case 1:
                return new zzfgn();
            case 2:
                return zzpex;
            case 3:
                return null;
            case 4:
                return new zza((zzfgo) null);
            case 5:
                zzfev zzfev = (zzfev) obj;
                zzfgn zzfgn = (zzfgn) obj2;
                this.zzpev = zzfev.zza(this.zzpev != 0, this.zzpev, zzfgn.zzpev != 0, zzfgn.zzpev);
                boolean z2 = this.zzpew != 0;
                int i2 = this.zzpew;
                if (zzfgn.zzpew == 0) {
                    z = false;
                }
                this.zzpew = zzfev.zza(z2, i2, z, zzfgn.zzpew);
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
                                    this.zzpev = zzfdy.zzctv();
                                    break;
                                case 16:
                                    this.zzpew = zzfdy.zzctw();
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
                    synchronized (zzfgn.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzpex);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzpex;
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzpev != 0) {
            zzfed.zza(1, this.zzpev);
        }
        if (this.zzpew != 0) {
            zzfed.zzaa(2, this.zzpew);
        }
        this.zzpcg.zza(zzfed);
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzpev != 0) {
            i2 = zzfed.zzc(1, this.zzpev) + 0;
        }
        if (this.zzpew != 0) {
            i2 += zzfed.zzad(2, this.zzpew);
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
