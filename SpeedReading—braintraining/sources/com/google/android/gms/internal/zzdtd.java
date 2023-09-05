package com.google.android.gms.internal;

import java.security.SecureRandom;

public final class zzdtd {
    private static final SecureRandom zzlwi = new SecureRandom();

    public static byte[] zzgc(int i) {
        byte[] bArr = new byte[i];
        zzlwi.nextBytes(bArr);
        return bArr;
    }
}
