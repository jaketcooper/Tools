package com.google.android.gms.internal;

import java.nio.ByteBuffer;

final class zzdsc extends zzdsd {
    private zzdsc(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    public final zzdse zzai(byte[] bArr) {
        return new zzdse(this, bArr, 1);
    }

    /* access modifiers changed from: package-private */
    public final int zzbos() {
        return 12;
    }

    /* access modifiers changed from: package-private */
    public final int[] zzd(byte[] bArr, int i) {
        int[] iArr = new int[16];
        zzdsd.zzi(iArr);
        zzdsd.zza(iArr, this.zzlur.getBytes());
        iArr[12] = i;
        System.arraycopy(zza(ByteBuffer.wrap(bArr)), 0, iArr, 13, 3);
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public final void zzh(int[] iArr) {
        iArr[12] = iArr[12] + 1;
    }
}
