package com.google.android.gms.internal;

final class zzfep implements zzfev {
    static final zzfep zzpcl = new zzfep();
    private static zzfeq zzpcm = new zzfeq();

    private zzfep() {
    }

    public final double zza(boolean z, double d, boolean z2, double d2) {
        if (z == z2 && d == d2) {
            return d;
        }
        throw zzpcm;
    }

    public final int zza(boolean z, int i, boolean z2, int i2) {
        if (z == z2 && i == i2) {
            return i;
        }
        throw zzpcm;
    }

    public final long zza(boolean z, long j, boolean z2, long j2) {
        if (z == z2 && j == j2) {
            return j;
        }
        throw zzpcm;
    }

    public final zzfdp zza(boolean z, zzfdp zzfdp, boolean z2, zzfdp zzfdp2) {
        if (z == z2 && zzfdp.equals(zzfdp2)) {
            return zzfdp;
        }
        throw zzpcm;
    }

    public final zzffc zza(zzffc zzffc, zzffc zzffc2) {
        if (zzffc.equals(zzffc2)) {
            return zzffc;
        }
        throw zzpcm;
    }

    public final <T> zzffd<T> zza(zzffd<T> zzffd, zzffd<T> zzffd2) {
        if (zzffd.equals(zzffd2)) {
            return zzffd;
        }
        throw zzpcm;
    }

    public final <K, V> zzffp<K, V> zza(zzffp<K, V> zzffp, zzffp<K, V> zzffp2) {
        if (zzffp.equals(zzffp2)) {
            return zzffp;
        }
        throw zzpcm;
    }

    public final <T extends zzffq> T zza(T t, T t2) {
        if (t == null && t2 == null) {
            return null;
        }
        if (t == null || t2 == null) {
            throw zzpcm;
        }
        T t3 = (zzfem) t;
        if (t3 == t2 || !((zzfem) t3.zza(zzfeu.zzpcw, (Object) null, (Object) null)).getClass().isInstance(t2)) {
            return t;
        }
        zzfem zzfem = (zzfem) t2;
        t3.zza(zzfeu.zzpcr, (Object) this, (Object) zzfem);
        t3.zzpcg = zza(t3.zzpcg, zzfem.zzpcg);
        return t;
    }

    public final zzfgq zza(zzfgq zzfgq, zzfgq zzfgq2) {
        if (zzfgq.equals(zzfgq2)) {
            return zzfgq;
        }
        throw zzpcm;
    }

    public final Object zza(boolean z, Object obj, Object obj2) {
        if (z && obj.equals(obj2)) {
            return obj;
        }
        throw zzpcm;
    }

    public final String zza(boolean z, String str, boolean z2, String str2) {
        if (z == z2 && str.equals(str2)) {
            return str;
        }
        throw zzpcm;
    }

    public final boolean zza(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z == z3 && z2 == z4) {
            return z2;
        }
        throw zzpcm;
    }

    public final Object zzb(boolean z, Object obj, Object obj2) {
        if (z && obj.equals(obj2)) {
            return obj;
        }
        throw zzpcm;
    }

    public final Object zzc(boolean z, Object obj, Object obj2) {
        if (z && obj.equals(obj2)) {
            return obj;
        }
        throw zzpcm;
    }

    public final Object zzd(boolean z, Object obj, Object obj2) {
        if (z && obj.equals(obj2)) {
            return obj;
        }
        throw zzpcm;
    }

    public final void zzdb(boolean z) {
        if (z) {
            throw zzpcm;
        }
    }

    public final Object zze(boolean z, Object obj, Object obj2) {
        if (z && obj.equals(obj2)) {
            return obj;
        }
        throw zzpcm;
    }

    public final Object zzf(boolean z, Object obj, Object obj2) {
        if (z && obj.equals(obj2)) {
            return obj;
        }
        throw zzpcm;
    }

    public final Object zzg(boolean z, Object obj, Object obj2) {
        boolean z2;
        if (z) {
            zzfem zzfem = (zzfem) obj;
            zzffq zzffq = (zzffq) obj2;
            if (zzfem == zzffq) {
                z2 = true;
            } else if (!((zzfem) zzfem.zza(zzfeu.zzpcw, (Object) null, (Object) null)).getClass().isInstance(zzffq)) {
                z2 = false;
            } else {
                zzfem zzfem2 = (zzfem) zzffq;
                zzfem.zza(zzfeu.zzpcr, (Object) this, (Object) zzfem2);
                zzfem.zzpcg = zza(zzfem.zzpcg, zzfem2.zzpcg);
                z2 = true;
            }
            if (z2) {
                return obj;
            }
        }
        throw zzpcm;
    }
}
