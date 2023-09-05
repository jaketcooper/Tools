package com.google.android.gms.internal;

public final class zzfet implements zzfev {
    public static final zzfet zzpcp = new zzfet();

    private zzfet() {
    }

    public final double zza(boolean z, double d, boolean z2, double d2) {
        return z2 ? d2 : d;
    }

    public final int zza(boolean z, int i, boolean z2, int i2) {
        return z2 ? i2 : i;
    }

    public final long zza(boolean z, long j, boolean z2, long j2) {
        return z2 ? j2 : j;
    }

    public final zzfdp zza(boolean z, zzfdp zzfdp, boolean z2, zzfdp zzfdp2) {
        return z2 ? zzfdp2 : zzfdp;
    }

    public final zzffc zza(zzffc zzffc, zzffc zzffc2) {
        int size = zzffc.size();
        int size2 = zzffc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzffc.zzcti()) {
                zzffc = zzffc.zzlk(size2 + size);
            }
            zzffc.addAll(zzffc2);
        }
        return size > 0 ? zzffc : zzffc2;
    }

    public final <T> zzffd<T> zza(zzffd<T> zzffd, zzffd<T> zzffd2) {
        int size = zzffd.size();
        int size2 = zzffd2.size();
        if (size > 0 && size2 > 0) {
            if (!zzffd.zzcti()) {
                zzffd = zzffd.zzlo(size2 + size);
            }
            zzffd.addAll(zzffd2);
        }
        return size > 0 ? zzffd : zzffd2;
    }

    public final <K, V> zzffp<K, V> zza(zzffp<K, V> zzffp, zzffp<K, V> zzffp2) {
        if (!zzffp2.isEmpty()) {
            if (!zzffp.isMutable()) {
                zzffp = zzffp.zzcwe();
            }
            zzffp.zza(zzffp2);
        }
        return zzffp;
    }

    public final <T extends zzffq> T zza(T t, T t2) {
        return (t == null || t2 == null) ? t == null ? t2 : t : t.zzcvh().zzc(t2).zzcvn();
    }

    public final zzfgq zza(zzfgq zzfgq, zzfgq zzfgq2) {
        return zzfgq2 == zzfgq.zzcwv() ? zzfgq : zzfgq.zzb(zzfgq, zzfgq2);
    }

    public final Object zza(boolean z, Object obj, Object obj2) {
        return obj2;
    }

    public final String zza(boolean z, String str, boolean z2, String str2) {
        return z2 ? str2 : str;
    }

    public final boolean zza(boolean z, boolean z2, boolean z3, boolean z4) {
        return z3 ? z4 : z2;
    }

    public final Object zzb(boolean z, Object obj, Object obj2) {
        return obj2;
    }

    public final Object zzc(boolean z, Object obj, Object obj2) {
        return obj2;
    }

    public final Object zzd(boolean z, Object obj, Object obj2) {
        return obj2;
    }

    public final void zzdb(boolean z) {
    }

    public final Object zze(boolean z, Object obj, Object obj2) {
        return obj2;
    }

    public final Object zzf(boolean z, Object obj, Object obj2) {
        return obj2;
    }

    public final Object zzg(boolean z, Object obj, Object obj2) {
        return z ? zza((zzffq) obj, (zzffq) obj2) : obj2;
    }
}
