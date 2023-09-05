package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class zzdso {
    private ECPublicKey zzlvn;

    public zzdso(ECPublicKey eCPublicKey) {
        this.zzlvn = eCPublicKey;
    }

    public final zzdsp zza(String str, byte[] bArr, byte[] bArr2, int i, zzdsl zzdsl) throws GeneralSecurityException {
        int i2 = 1;
        ECParameterSpec params = this.zzlvn.getParams();
        KeyPairGenerator zzod = zzdsr.zzlvz.zzod("EC");
        zzod.initialize(params);
        KeyPair generateKeyPair = zzod.generateKeyPair();
        ECPublicKey eCPublicKey = (ECPublicKey) generateKeyPair.getPublic();
        zzdsi.zza(this.zzlvn.getW(), this.zzlvn.getParams().getCurve());
        KeyAgreement zzod2 = zzdsr.zzlvy.zzod("ECDH");
        zzod2.init((ECPrivateKey) generateKeyPair.getPrivate());
        zzod2.doPhase(this.zzlvn, true);
        byte[] generateSecret = zzod2.generateSecret();
        byte[] zza = zzdsi.zza(eCPublicKey.getParams().getCurve(), zzdsl, eCPublicKey.getW());
        byte[] zzc = zzdte.zzc(zza, generateSecret);
        Mac zzod3 = zzdsr.zzlvv.zzod(str);
        if (i > zzod3.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        if (bArr == null || bArr.length == 0) {
            zzod3.init(new SecretKeySpec(new byte[zzod3.getMacLength()], str));
        } else {
            zzod3.init(new SecretKeySpec(bArr, str));
        }
        byte[] bArr3 = new byte[i];
        zzod3.init(new SecretKeySpec(zzod3.doFinal(zzc), str));
        byte[] bArr4 = new byte[0];
        int i3 = 0;
        while (true) {
            zzod3.update(bArr4);
            zzod3.update(bArr2);
            zzod3.update((byte) i2);
            bArr4 = zzod3.doFinal();
            if (bArr4.length + i3 < i) {
                System.arraycopy(bArr4, 0, bArr3, i3, bArr4.length);
                i3 += bArr4.length;
                i2++;
            } else {
                System.arraycopy(bArr4, 0, bArr3, i3, i - i3);
                return new zzdsp(zza, bArr3);
            }
        }
    }
}
