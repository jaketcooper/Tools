package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

public final class zzdoy {
    public static zzdsk zza(zzdqy zzdqy) throws GeneralSecurityException {
        switch (zzdoz.zzlpy[zzdqy.ordinal()]) {
            case 1:
                return zzdsk.NIST_P256;
            case 2:
                return zzdsk.NIST_P384;
            case 3:
                return zzdsk.NIST_P521;
            default:
                String valueOf = String.valueOf(zzdqy);
                throw new GeneralSecurityException(new StringBuilder(String.valueOf(valueOf).length() + 20).append("unknown curve type: ").append(valueOf).toString());
        }
    }

    public static zzdsl zza(zzdqo zzdqo) throws GeneralSecurityException {
        switch (zzdoz.zzlpz[zzdqo.ordinal()]) {
            case 1:
                return zzdsl.UNCOMPRESSED;
            case 2:
                return zzdsl.COMPRESSED;
            default:
                String valueOf = String.valueOf(zzdqo);
                throw new GeneralSecurityException(new StringBuilder(String.valueOf(valueOf).length() + 22).append("unknown point format: ").append(valueOf).toString());
        }
    }

    public static String zza(zzdrc zzdrc) throws NoSuchAlgorithmException {
        switch (zzdoz.zzlpx[zzdrc.ordinal()]) {
            case 1:
                return "HmacSha1";
            case 2:
                return "HmacSha256";
            case 3:
                return "HmacSha512";
            default:
                String valueOf = String.valueOf(zzdrc);
                throw new NoSuchAlgorithmException(new StringBuilder(String.valueOf(valueOf).length() + 27).append("hash unsupported for HMAC: ").append(valueOf).toString());
        }
    }
}
