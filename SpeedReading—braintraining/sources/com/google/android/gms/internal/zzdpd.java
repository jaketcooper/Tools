package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrk;
import java.security.GeneralSecurityException;

final class zzdpd implements zzdos<zzdtb> {
    zzdpd() {
    }

    private static void zza(zzdpy zzdpy) throws GeneralSecurityException {
        if (zzdpy.zzbma() < 12 || zzdpy.zzbma() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zze */
    public final zzdrx zza(zzfdp zzfdp) throws GeneralSecurityException {
        try {
            zzdpu zzk = zzdpu.zzk(zzfdp);
            if (!(zzk instanceof zzdpu)) {
                throw new GeneralSecurityException("expected AesCtrKey proto");
            }
            zzdpu zzdpu = zzk;
            zzdte.zzt(zzdpu.getVersion(), 0);
            zzdte.zzgd(zzdpu.zzblu().size());
            zza(zzdpu.zzblt());
            return new zzdrx(zzdpu.zzblu().toByteArray(), zzdpu.zzblt().zzbma());
        } catch (zzffe e) {
            throw new GeneralSecurityException("expected serialized AesCtrKey proto", e);
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final /* synthetic */ Object zza(zzffq zzffq) throws GeneralSecurityException {
        if (!(zzffq instanceof zzdpu)) {
            throw new GeneralSecurityException("expected AesCtrKey proto");
        }
        zzdpu zzdpu = (zzdpu) zzffq;
        zzdte.zzt(zzdpu.getVersion(), 0);
        zzdte.zzgd(zzdpu.zzblu().size());
        zza(zzdpu.zzblt());
        return new zzdrx(zzdpu.zzblu().toByteArray(), zzdpu.zzblt().zzbma());
    }

    public final zzffq zzb(zzfdp zzfdp) throws GeneralSecurityException {
        try {
            return zzb((zzffq) zzdpw.zzm(zzfdp));
        } catch (zzffe e) {
            throw new GeneralSecurityException("expected serialized AesCtrKeyFormat proto", e);
        }
    }

    public final zzffq zzb(zzffq zzffq) throws GeneralSecurityException {
        if (!(zzffq instanceof zzdpw)) {
            throw new GeneralSecurityException("expected AesCtrKeyFormat proto");
        }
        zzdpw zzdpw = (zzdpw) zzffq;
        zzdte.zzgd(zzdpw.getKeySize());
        zza(zzdpw.zzblt());
        return zzdpu.zzblv().zzc(zzdpw.zzblt()).zzl(zzfdp.zzay(zzdtd.zzgc(zzdpw.getKeySize()))).zzfk(0).zzcvl();
    }

    public final zzdrk zzc(zzfdp zzfdp) throws GeneralSecurityException {
        return (zzdrk) zzdrk.zzbnw().zzob("type.googleapis.com/google.crypto.tink.AesCtrKey").zzaa(((zzdpu) zzb(zzfdp)).toByteString()).zzb(zzdrk.zzb.SYMMETRIC).zzcvl();
    }
}
