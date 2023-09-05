package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrk;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

public final class zzdpn implements zzdos<zzdou> {
    zzdpn() {
    }

    private static void zza(zzdri zzdri) throws GeneralSecurityException {
        if (zzdri.zzbnq() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        switch (zzdpo.zzlpx[zzdri.zzbnp().ordinal()]) {
            case 1:
                if (zzdri.zzbnq() > 20) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case 2:
                if (zzdri.zzbnq() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case 3:
                if (zzdri.zzbnq() > 64) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            default:
                throw new GeneralSecurityException("unknown hash type");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzg */
    public final zzdou zza(zzfdp zzfdp) throws GeneralSecurityException {
        zzdtc zzdtc;
        try {
            zzdre zzw = zzdre.zzw(zzfdp);
            if (!(zzw instanceof zzdre)) {
                throw new GeneralSecurityException("expected HmacKey proto");
            }
            zzdre zzdre = zzw;
            zzdte.zzt(zzdre.getVersion(), 0);
            if (zzdre.zzblu().size() < 16) {
                throw new GeneralSecurityException("key too short");
            }
            zza(zzdre.zzbnj());
            zzdrc zzbnp = zzdre.zzbnj().zzbnp();
            SecretKeySpec secretKeySpec = new SecretKeySpec(zzdre.zzblu().toByteArray(), "HMAC");
            int zzbnq = zzdre.zzbnj().zzbnq();
            switch (zzdpo.zzlpx[zzbnp.ordinal()]) {
                case 1:
                    zzdtc = new zzdtc("HMACSHA1", secretKeySpec, zzbnq);
                    break;
                case 2:
                    zzdtc = new zzdtc("HMACSHA256", secretKeySpec, zzbnq);
                    break;
                case 3:
                    zzdtc = new zzdtc("HMACSHA512", secretKeySpec, zzbnq);
                    break;
                default:
                    throw new GeneralSecurityException("unknown hash");
            }
            return zzdtc;
        } catch (zzffe e) {
            throw new GeneralSecurityException("expected serialized HmacKey proto", e);
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final /* synthetic */ Object zza(zzffq zzffq) throws GeneralSecurityException {
        if (!(zzffq instanceof zzdre)) {
            throw new GeneralSecurityException("expected HmacKey proto");
        }
        zzdre zzdre = (zzdre) zzffq;
        zzdte.zzt(zzdre.getVersion(), 0);
        if (zzdre.zzblu().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zza(zzdre.zzbnj());
        zzdrc zzbnp = zzdre.zzbnj().zzbnp();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzdre.zzblu().toByteArray(), "HMAC");
        int zzbnq = zzdre.zzbnj().zzbnq();
        switch (zzdpo.zzlpx[zzbnp.ordinal()]) {
            case 1:
                return new zzdtc("HMACSHA1", secretKeySpec, zzbnq);
            case 2:
                return new zzdtc("HMACSHA256", secretKeySpec, zzbnq);
            case 3:
                return new zzdtc("HMACSHA512", secretKeySpec, zzbnq);
            default:
                throw new GeneralSecurityException("unknown hash");
        }
    }

    public final zzffq zzb(zzfdp zzfdp) throws GeneralSecurityException {
        try {
            return zzb((zzffq) zzdrg.zzy(zzfdp));
        } catch (zzffe e) {
            throw new GeneralSecurityException("expected serialized HmacKeyFormat proto", e);
        }
    }

    public final zzffq zzb(zzffq zzffq) throws GeneralSecurityException {
        if (!(zzffq instanceof zzdrg)) {
            throw new GeneralSecurityException("expected HmacKeyFormat proto");
        }
        zzdrg zzdrg = (zzdrg) zzffq;
        if (zzdrg.getKeySize() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zza(zzdrg.zzbnj());
        return zzdre.zzbnk().zzfr(0).zzc(zzdrg.zzbnj()).zzx(zzfdp.zzay(zzdtd.zzgc(zzdrg.getKeySize()))).zzcvl();
    }

    public final zzdrk zzc(zzfdp zzfdp) throws GeneralSecurityException {
        return (zzdrk) zzdrk.zzbnw().zzob("type.googleapis.com/google.crypto.tink.HmacKey").zzaa(((zzdre) zzb(zzfdp)).toByteString()).zzb(zzdrk.zzb.SYMMETRIC).zzcvl();
    }
}
