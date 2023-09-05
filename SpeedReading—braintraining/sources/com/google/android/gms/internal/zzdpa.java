package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrk;
import com.google.android.gms.internal.zzdrr;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzdpa {
    public static final zzdpa zzlqa = new zzdpa();
    private final ConcurrentMap<String, zzdos> zzlqb = new ConcurrentHashMap();

    protected zzdpa() {
    }

    private final <P> zzdos<P> zznz(String str) throws GeneralSecurityException {
        zzdos<P> zzdos = (zzdos) this.zzlqb.get(str);
        if (zzdos != null) {
            return zzdos;
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported key type: ".concat(valueOf) : new String("unsupported key type: "));
    }

    public final <P> zzdow<P> zza(zzdot zzdot, zzdos<P> zzdos) throws GeneralSecurityException {
        zzdrr zzblf = zzdot.zzblf();
        if (zzblf.zzbod() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        int zzbob = zzblf.zzbob();
        boolean z = true;
        boolean z2 = false;
        for (zzdrr.zzb next : zzblf.zzboc()) {
            if (!next.zzbof()) {
                throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zzboi())}));
            } else if (next.zzboj() == zzdrv.UNKNOWN_PREFIX) {
                throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zzboi())}));
            } else if (next.zzboh() == zzdrn.UNKNOWN_STATUS) {
                throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zzboi())}));
            } else {
                if (next.zzboh() == zzdrn.ENABLED && next.zzboi() == zzbob) {
                    if (z2) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z2 = true;
                }
                z = next.zzbog().zzbnv() != zzdrk.zzb.ASYMMETRIC_PUBLIC ? false : z;
            }
        }
        if (z2 || z) {
            zzdow<P> zzdow = new zzdow<>();
            for (zzdrr.zzb next2 : zzdot.zzblf().zzboc()) {
                if (next2.zzboh() == zzdrn.ENABLED) {
                    zzdox<P> zza = zzdow.zza(zznz(next2.zzbog().zzbnt()).zza(next2.zzbog().zzbnu()), next2);
                    if (next2.zzboi() == zzdot.zzblf().zzbob()) {
                        zzdow.zza(zza);
                    }
                }
            }
            return zzdow;
        }
        throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
    }

    public final <P> zzdrk zza(zzdrp zzdrp) throws GeneralSecurityException {
        return zznz(zzdrp.zzbnt()).zzc(zzdrp.zzbnu());
    }

    public final <P> zzffq zza(String str, zzffq zzffq) throws GeneralSecurityException {
        return zznz(str).zzb(zzffq);
    }

    public final <P> boolean zza(String str, zzdos<P> zzdos) throws GeneralSecurityException {
        if (zzdos != null) {
            return this.zzlqb.putIfAbsent(str, zzdos) == null;
        }
        throw new NullPointerException("key manager must be non-null.");
    }

    public final <P> zzffq zzb(zzdrp zzdrp) throws GeneralSecurityException {
        return zznz(zzdrp.zzbnt()).zzb(zzdrp.zzbnu());
    }

    public final <P> P zzb(String str, zzffq zzffq) throws GeneralSecurityException {
        return zznz(str).zza(zzffq);
    }
}
