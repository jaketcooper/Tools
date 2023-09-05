package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrk;
import java.security.GeneralSecurityException;

public final class zzdpg implements zzdos<zzdoo> {
    zzdpg() {
    }

    private static zzdqm zzblk() throws GeneralSecurityException {
        return (zzdqm) zzdqm.zzbmp().zzfn(0).zzu(zzfdp.zzay(zzdtd.zzgc(32))).zzcvl();
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzdoo zza(zzfdp zzfdp) throws GeneralSecurityException {
        try {
            zzdqm zzt = zzdqm.zzt(zzfdp);
            if (!(zzt instanceof zzdqm)) {
                throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
            }
            zzdqm zzdqm = zzt;
            zzdte.zzt(zzdqm.getVersion(), 0);
            if (zzdqm.zzblu().size() == 32) {
                return zzdsf.zzaj(zzdqm.zzblu().toByteArray());
            }
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        } catch (zzffe e) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305 key", e);
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final /* synthetic */ Object zza(zzffq zzffq) throws GeneralSecurityException {
        if (!(zzffq instanceof zzdqm)) {
            throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
        }
        zzdqm zzdqm = (zzdqm) zzffq;
        zzdte.zzt(zzdqm.getVersion(), 0);
        if (zzdqm.zzblu().size() == 32) {
            return zzdsf.zzaj(zzdqm.zzblu().toByteArray());
        }
        throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
    }

    public final zzffq zzb(zzfdp zzfdp) throws GeneralSecurityException {
        return zzblk();
    }

    public final zzffq zzb(zzffq zzffq) throws GeneralSecurityException {
        return zzblk();
    }

    public final zzdrk zzc(zzfdp zzfdp) throws GeneralSecurityException {
        return (zzdrk) zzdrk.zzbnw().zzob("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key").zzaa(zzblk().toByteString()).zzb(zzdrk.zzb.SYMMETRIC).zzcvl();
    }
}
