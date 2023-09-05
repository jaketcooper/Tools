package com.google.android.gms.internal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

public final class zzdph implements zzdos<zzdor> {
    zzdph() {
    }

    /* access modifiers changed from: private */
    /* renamed from: zzf */
    public final zzdor zza(zzfdp zzfdp) throws GeneralSecurityException {
        try {
            zzdqu zzv = zzdqu.zzv(zzfdp);
            if (!(zzv instanceof zzdqu)) {
                throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
            }
            zzdqu zzdqu = zzv;
            zzdte.zzt(zzdqu.getVersion(), 0);
            zzdqs zzbmz = zzdqu.zzbmz();
            zzdsi.zza(zzdoy.zza(zzbmz.zzbmu().zzbnd()));
            zzdoy.zza(zzbmz.zzbmu().zzbne());
            if (zzbmz.zzbmw() == zzdqo.UNKNOWN_FORMAT) {
                throw new GeneralSecurityException("unknown EC point format");
            }
            zzdpa.zzlqa.zza(zzbmz.zzbmv().zzbmr());
            zzdqs zzbmz2 = zzdqu.zzbmz();
            zzdqw zzbmu = zzbmz2.zzbmu();
            zzdsk zza = zzdoy.zza(zzbmu.zzbnd());
            byte[] byteArray = zzdqu.zzbna().toByteArray();
            byte[] byteArray2 = zzdqu.zzbnb().toByteArray();
            ECParameterSpec zza2 = zzdsi.zza(zza);
            ECPoint eCPoint = new ECPoint(new BigInteger(1, byteArray), new BigInteger(1, byteArray2));
            zzdsi.zza(eCPoint, zza2.getCurve());
            ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(eCPoint, zza2);
            return new zzdsn((ECPublicKey) KeyFactory.getInstance("EC").generatePublic(eCPublicKeySpec), zzbmu.zzbnf().toByteArray(), zzdoy.zza(zzbmu.zzbne()), zzdoy.zza(zzbmz2.zzbmw()), new zzdpl(zzbmz2.zzbmv().zzbmr()));
        } catch (zzffe e) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPublicKey proto", e);
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public final /* synthetic */ Object zza(zzffq zzffq) throws GeneralSecurityException {
        if (!(zzffq instanceof zzdqu)) {
            throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
        }
        zzdqu zzdqu = (zzdqu) zzffq;
        zzdte.zzt(zzdqu.getVersion(), 0);
        zzdqs zzbmz = zzdqu.zzbmz();
        zzdsi.zza(zzdoy.zza(zzbmz.zzbmu().zzbnd()));
        zzdoy.zza(zzbmz.zzbmu().zzbne());
        if (zzbmz.zzbmw() == zzdqo.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzdpa.zzlqa.zza(zzbmz.zzbmv().zzbmr());
        zzdqs zzbmz2 = zzdqu.zzbmz();
        zzdqw zzbmu = zzbmz2.zzbmu();
        zzdsk zza = zzdoy.zza(zzbmu.zzbnd());
        byte[] byteArray = zzdqu.zzbna().toByteArray();
        byte[] byteArray2 = zzdqu.zzbnb().toByteArray();
        ECParameterSpec zza2 = zzdsi.zza(zza);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, byteArray), new BigInteger(1, byteArray2));
        zzdsi.zza(eCPoint, zza2.getCurve());
        ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(eCPoint, zza2);
        return new zzdsn((ECPublicKey) KeyFactory.getInstance("EC").generatePublic(eCPublicKeySpec), zzbmu.zzbnf().toByteArray(), zzdoy.zza(zzbmu.zzbne()), zzdoy.zza(zzbmz2.zzbmw()), new zzdpl(zzbmz2.zzbmv().zzbmr()));
    }

    public final zzffq zzb(zzfdp zzfdp) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    public final zzffq zzb(zzffq zzffq) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    public final zzdrk zzc(zzfdp zzfdp) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }
}
