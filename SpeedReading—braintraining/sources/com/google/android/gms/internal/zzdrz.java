package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzdrz implements zzdoo {
    private final SecretKeySpec zzluj;

    public zzdrz(byte[] bArr) {
        this.zzluj = new SecretKeySpec(bArr, "AES");
    }

    public final byte[] zzd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[(bArr.length + 12 + 16)];
        byte[] zzgc = zzdtd.zzgc(12);
        System.arraycopy(zzgc, 0, bArr3, 0, 12);
        Cipher zzod = zzdsr.zzlvu.zzod("AES/GCM/NoPadding");
        zzod.init(1, this.zzluj, new GCMParameterSpec(128, zzgc));
        zzod.updateAAD(bArr2);
        zzod.doFinal(bArr, 0, bArr.length, bArr3, 12);
        return bArr3;
    }
}
