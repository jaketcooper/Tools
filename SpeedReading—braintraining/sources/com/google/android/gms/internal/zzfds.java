package com.google.android.gms.internal;

final class zzfds extends zzfdw {
    private final int zzpbc;
    private final int zzpbd;

    zzfds(byte[] bArr, int i, int i2) {
        super(bArr);
        zzh(i, i + i2, bArr.length);
        this.zzpbc = i;
        this.zzpbd = i2;
    }

    public final int size() {
        return this.zzpbd;
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzjkv, zzctq() + i, bArr, i2, i3);
    }

    /* access modifiers changed from: protected */
    public final int zzctq() {
        return this.zzpbc;
    }

    public final byte zzke(int i) {
        zzy(i, size());
        return this.zzjkv[this.zzpbc + i];
    }
}
