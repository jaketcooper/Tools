package com.google.android.gms.internal;

import java.io.IOException;

public final class zzdqk extends zzfem<zzdqk, zza> implements zzffs {
    private static volatile zzffu<zzdqk> zzbas;
    /* access modifiers changed from: private */
    public static final zzdqk zzlrg;

    public static final class zza extends zzfen<zzdqk, zza> implements zzffs {
        private zza() {
            super(zzdqk.zzlrg);
        }

        /* synthetic */ zza(zzdql zzdql) {
            this();
        }
    }

    static {
        zzdqk zzdqk = new zzdqk();
        zzlrg = zzdqk;
        zzdqk.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdqk.zzpcg.zzbin();
    }

    private zzdqk() {
    }

    public static zzdqk zzbmn() {
        return zzlrg;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdql.zzbaq[i - 1]) {
            case 1:
                return new zzdqk();
            case 2:
                return zzlrg;
            case 3:
                return null;
            case 4:
                return new zza((zzdql) null);
            case 5:
                return this;
            case 6:
                zzfdy zzfdy = (zzfdy) obj;
                if (((zzfei) obj2) != null) {
                    boolean z = false;
                    while (!z) {
                        try {
                            int zzctt = zzfdy.zzctt();
                            switch (zzctt) {
                                case 0:
                                    z = true;
                                    break;
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
                    synchronized (zzdqk.class) {
                        if (zzbas == null) {
                            zzbas = new zzfeo(zzlrg);
                        }
                    }
                }
                return zzbas;
            default:
                throw new UnsupportedOperationException();
        }
        return zzlrg;
    }

    public final void zza(zzfed zzfed) throws IOException {
        this.zzpcg.zza(zzfed);
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int zzhl = this.zzpcg.zzhl() + 0;
        this.zzpch = zzhl;
        return zzhl;
    }
}
