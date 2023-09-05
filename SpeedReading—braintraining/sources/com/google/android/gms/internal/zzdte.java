package com.google.android.gms.internal;

import java.security.GeneralSecurityException;

public final class zzdte {
    public static boolean zzaiz() {
        try {
            Class.forName("android.app.Application", false, (ClassLoader) null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static byte[] zzc(byte[]... bArr) throws GeneralSecurityException {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            if (i > Integer.MAX_VALUE - bArr2.length) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            i += bArr2.length;
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
            i2 += bArr4.length;
        }
        return bArr3;
    }

    public static void zzgd(int i) throws GeneralSecurityException {
        if (i != 16 && i != 24 && i != 32) {
            throw new GeneralSecurityException("invalid Aes key size");
        }
    }

    public static void zzt(int i, int i2) throws GeneralSecurityException {
        if (i < 0 || i > 0) {
            throw new GeneralSecurityException(String.format("key has version %d; only keys with version in range [0..%d] are supported", new Object[]{Integer.valueOf(i), 0}));
        }
    }
}
