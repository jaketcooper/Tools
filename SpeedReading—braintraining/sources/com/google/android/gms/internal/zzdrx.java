package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zzdrx implements zzdtb {
    private final SecretKeySpec zzluj;
    private final int zzluk;
    private final int zzlul = zzdsr.zzlvu.zzod("AES/CTR/NoPadding").getBlockSize();

    public zzdrx(byte[] bArr, int i) throws GeneralSecurityException {
        this.zzluj = new SecretKeySpec(bArr, "AES");
        if (i < 12 || i > this.zzlul) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzluk = i;
    }

    public final byte[] zzaf(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length > Integer.MAX_VALUE - this.zzluk) {
            throw new GeneralSecurityException(new StringBuilder(43).append("plaintext length can not exceed ").append(Integer.MAX_VALUE - this.zzluk).toString());
        }
        byte[] bArr2 = new byte[(this.zzluk + bArr.length)];
        byte[] zzgc = zzdtd.zzgc(this.zzluk);
        System.arraycopy(zzgc, 0, bArr2, 0, this.zzluk);
        int length = bArr.length;
        int i = this.zzluk;
        Cipher zzod = zzdsr.zzlvu.zzod("AES/CTR/NoPadding");
        byte[] bArr3 = new byte[this.zzlul];
        System.arraycopy(zzgc, 0, bArr3, 0, this.zzluk);
        zzod.init(1, this.zzluj, new IvParameterSpec(bArr3));
        if (zzod.doFinal(bArr, 0, length, bArr2, i) == length) {
            return bArr2;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
