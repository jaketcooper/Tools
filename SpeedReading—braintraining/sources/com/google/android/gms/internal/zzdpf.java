package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrk;
import java.security.GeneralSecurityException;

public final class zzdpf implements zzdos<zzdoo> {
    zzdpf() {
    }

    private static zzdoo zzd(zzfdp zzfdp) throws GeneralSecurityException {
        try {
            return new zzdrz(zzdqg.zzq(zzfdp).zzblu().toByteArray());
        } catch (zzffe e) {
            throw new GeneralSecurityException("expected AesGcmKey proto");
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final /* synthetic */ Object zza(zzfdp zzfdp) throws GeneralSecurityException {
        return zzd(zzfdp);
    }

    public final /* synthetic */ Object zza(zzffq zzffq) throws GeneralSecurityException {
        if (!(zzffq instanceof zzdqg)) {
            throw new GeneralSecurityException("expected AesGcmKey proto");
        }
        zzdqg zzdqg = (zzdqg) zzffq;
        zzdte.zzt(zzdqg.getVersion(), 0);
        zzdte.zzgd(zzdqg.zzblu().size());
        return new zzdrz(zzdqg.zzblu().toByteArray());
    }

    public final zzffq zzb(zzfdp zzfdp) throws GeneralSecurityException {
        try {
            return zzb((zzffq) zzdqi.zzs(zzfdp));
        } catch (zzffe e) {
            throw new GeneralSecurityException("expected serialized AesGcmKeyFormat proto", e);
        }
    }

    public final zzffq zzb(zzffq zzffq) throws GeneralSecurityException {
        if (!(zzffq instanceof zzdqi)) {
            throw new GeneralSecurityException("expected AesGcmKeyFormat proto");
        }
        zzdqi zzdqi = (zzdqi) zzffq;
        zzdte.zzgd(zzdqi.getKeySize());
        return zzdqg.zzbmj().zzr(zzfdp.zzay(zzdtd.zzgc(zzdqi.getKeySize()))).zzb(zzdqi.zzbml()).zzfm(0).zzcvl();
    }

    public final zzdrk zzc(zzfdp zzfdp) throws GeneralSecurityException {
        return (zzdrk) zzdrk.zzbnw().zzob("type.googleapis.com/google.crypto.tink.AesGcmKey").zzaa(((zzdqg) zzb(zzfdp)).toByteString()).zzb(zzdrk.zzb.SYMMETRIC).zzcvl();
    }
}
