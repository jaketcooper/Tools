package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrk;
import java.security.GeneralSecurityException;

public final class zzdpe implements zzdos<zzdoo> {
    zzdpe() {
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzdoo zza(zzfdp zzfdp) throws GeneralSecurityException {
        try {
            zzdqa zzn = zzdqa.zzn(zzfdp);
            if (!(zzn instanceof zzdqa)) {
                throw new GeneralSecurityException("expected AesEaxKey proto");
            }
            zzdqa zzdqa = zzn;
            zzdte.zzt(zzdqa.getVersion(), 0);
            zzdte.zzgd(zzdqa.zzblu().size());
            if (zzdqa.zzbmd().zzbma() == 12 || zzdqa.zzbmd().zzbma() == 16) {
                return new zzdry(zzdqa.zzblu().toByteArray(), zzdqa.zzbmd().zzbma());
            }
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        } catch (zzffe e) {
            throw new GeneralSecurityException("expected serialized AesEaxKey proto", e);
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final /* synthetic */ Object zza(zzffq zzffq) throws GeneralSecurityException {
        if (!(zzffq instanceof zzdqa)) {
            throw new GeneralSecurityException("expected AesEaxKey proto");
        }
        zzdqa zzdqa = (zzdqa) zzffq;
        zzdte.zzt(zzdqa.getVersion(), 0);
        zzdte.zzgd(zzdqa.zzblu().size());
        if (zzdqa.zzbmd().zzbma() == 12 || zzdqa.zzbmd().zzbma() == 16) {
            return new zzdry(zzdqa.zzblu().toByteArray(), zzdqa.zzbmd().zzbma());
        }
        throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
    }

    public final zzffq zzb(zzfdp zzfdp) throws GeneralSecurityException {
        try {
            return zzb((zzffq) zzdqc.zzp(zzfdp));
        } catch (zzffe e) {
            throw new GeneralSecurityException("expected serialized AesEaxKeyFormat proto", e);
        }
    }

    public final zzffq zzb(zzffq zzffq) throws GeneralSecurityException {
        if (!(zzffq instanceof zzdqc)) {
            throw new GeneralSecurityException("expected AesEaxKeyFormat proto");
        }
        zzdqc zzdqc = (zzdqc) zzffq;
        zzdte.zzgd(zzdqc.getKeySize());
        if (zzdqc.zzbmd().zzbma() == 12 || zzdqc.zzbmd().zzbma() == 16) {
            return zzdqa.zzbme().zzo(zzfdp.zzay(zzdtd.zzgc(zzdqc.getKeySize()))).zzb(zzdqc.zzbmd()).zzfl(0).zzcvl();
        }
        throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
    }

    public final zzdrk zzc(zzfdp zzfdp) throws GeneralSecurityException {
        return (zzdrk) zzdrk.zzbnw().zzob("type.googleapis.com/google.crypto.tink.AesEaxKey").zzaa(((zzdqa) zzb(zzfdp)).toByteString()).zzb(zzdrk.zzb.SYMMETRIC).zzcvl();
    }
}
