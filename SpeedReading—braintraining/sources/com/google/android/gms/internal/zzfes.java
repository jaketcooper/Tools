package com.google.android.gms.internal;

final class zzfes implements zzfev {
    int zzpco = 0;

    zzfes() {
    }

    public final double zza(boolean z, double d, boolean z2, double d2) {
        this.zzpco = (this.zzpco * 53) + zzfez.zzdd(Double.doubleToLongBits(d));
        return d;
    }

    public final int zza(boolean z, int i, boolean z2, int i2) {
        this.zzpco = (this.zzpco * 53) + i;
        return i;
    }

    public final long zza(boolean z, long j, boolean z2, long j2) {
        this.zzpco = (this.zzpco * 53) + zzfez.zzdd(j);
        return j;
    }

    public final zzfdp zza(boolean z, zzfdp zzfdp, boolean z2, zzfdp zzfdp2) {
        this.zzpco = (this.zzpco * 53) + zzfdp.hashCode();
        return zzfdp;
    }

    public final zzffc zza(zzffc zzffc, zzffc zzffc2) {
        this.zzpco = (this.zzpco * 53) + zzffc.hashCode();
        return zzffc;
    }

    public final <T> zzffd<T> zza(zzffd<T> zzffd, zzffd<T> zzffd2) {
        this.zzpco = (this.zzpco * 53) + zzffd.hashCode();
        return zzffd;
    }

    public final <K, V> zzffp<K, V> zza(zzffp<K, V> zzffp, zzffp<K, V> zzffp2) {
        this.zzpco = (this.zzpco * 53) + zzffp.hashCode();
        return zzffp;
    }

    public final <T extends zzffq> T zza(T t, T t2) {
        int i;
        if (t == null) {
            i = 37;
        } else if (t instanceof zzfem) {
            zzfem zzfem = (zzfem) t;
            if (zzfem.zzpat == 0) {
                int i2 = this.zzpco;
                this.zzpco = 0;
                zzfem.zza(zzfeu.zzpcr, (Object) this, (Object) zzfem);
                zzfem.zzpcg = zza(zzfem.zzpcg, zzfem.zzpcg);
                zzfem.zzpat = this.zzpco;
                this.zzpco = i2;
            }
            i = zzfem.zzpat;
        } else {
            i = t.hashCode();
        }
        this.zzpco = i + (this.zzpco * 53);
        return t;
    }

    public final zzfgq zza(zzfgq zzfgq, zzfgq zzfgq2) {
        this.zzpco = (this.zzpco * 53) + zzfgq.hashCode();
        return zzfgq;
    }

    public final Object zza(boolean z, Object obj, Object obj2) {
        this.zzpco = zzfez.zzdc(((Boolean) obj).booleanValue()) + (this.zzpco * 53);
        return obj;
    }

    public final String zza(boolean z, String str, boolean z2, String str2) {
        this.zzpco = (this.zzpco * 53) + str.hashCode();
        return str;
    }

    public final boolean zza(boolean z, boolean z2, boolean z3, boolean z4) {
        this.zzpco = (this.zzpco * 53) + zzfez.zzdc(z2);
        return z2;
    }

    public final Object zzb(boolean z, Object obj, Object obj2) {
        this.zzpco = ((Integer) obj).intValue() + (this.zzpco * 53);
        return obj;
    }

    public final Object zzc(boolean z, Object obj, Object obj2) {
        this.zzpco = zzfez.zzdd(Double.doubleToLongBits(((Double) obj).doubleValue())) + (this.zzpco * 53);
        return obj;
    }

    public final Object zzd(boolean z, Object obj, Object obj2) {
        this.zzpco = zzfez.zzdd(((Long) obj).longValue()) + (this.zzpco * 53);
        return obj;
    }

    public final void zzdb(boolean z) {
        if (z) {
            throw new IllegalStateException();
        }
    }

    public final Object zze(boolean z, Object obj, Object obj2) {
        this.zzpco = (this.zzpco * 53) + obj.hashCode();
        return obj;
    }

    public final Object zzf(boolean z, Object obj, Object obj2) {
        this.zzpco = (this.zzpco * 53) + obj.hashCode();
        return obj;
    }

    public final Object zzg(boolean z, Object obj, Object obj2) {
        return zza((zzffq) obj, (zzffq) obj2);
    }
}
