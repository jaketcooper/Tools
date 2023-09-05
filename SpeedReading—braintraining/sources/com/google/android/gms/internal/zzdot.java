package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrr;
import com.google.android.gms.internal.zzdrt;
import java.security.GeneralSecurityException;

public final class zzdot {
    private final zzdrr zzlpp;
    private final zzdra zzlpq = null;

    zzdot(zzdrr zzdrr) {
        this.zzlpp = zzdrr;
    }

    public static void zza(zzdrr zzdrr) throws GeneralSecurityException {
        if (zzdrr == null || zzdrr.zzbod() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public final String toString() {
        zzdrr zzdrr = this.zzlpp;
        zzdrt.zza zzfv = zzdrt.zzbom().zzfv(zzdrr.zzbob());
        for (zzdrr.zzb next : zzdrr.zzboc()) {
            zzfv.zzb((zzdrt.zzb) zzdrt.zzb.zzbop().zzoc(next.zzbog().zzbnt()).zzb(next.zzboh()).zzb(next.zzboj()).zzfx(next.zzboi()).zzcvl());
        }
        return ((zzdrt) zzfv.zzcvl()).toString();
    }

    public final zzdrr zzblf() {
        return this.zzlpp;
    }
}
