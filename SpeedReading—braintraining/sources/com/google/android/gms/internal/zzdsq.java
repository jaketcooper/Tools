package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class zzdsq implements zzdoo {
    private final zzdtb zzlvq;
    private final zzdou zzlvr;
    private final int zzlvs;

    public zzdsq(zzdtb zzdtb, zzdou zzdou, int i) {
        this.zzlvq = zzdtb;
        this.zzlvr = zzdou;
        this.zzlvs = i;
    }

    public final byte[] zzd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzaf = this.zzlvq.zzaf(bArr);
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(8 * ((long) bArr2.length)).array(), 8);
        return zzdte.zzc(zzaf, this.zzlvr.zzab(zzdte.zzc(bArr2, zzaf, copyOf)));
    }
}
