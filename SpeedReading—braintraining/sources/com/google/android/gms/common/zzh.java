package com.google.android.gms.common;

import java.util.Arrays;

final class zzh extends zzg {
    private final byte[] zzfis;

    zzh(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zzfis = bArr;
    }

    /* access modifiers changed from: package-private */
    public final byte[] getBytes() {
        return this.zzfis;
    }
}
