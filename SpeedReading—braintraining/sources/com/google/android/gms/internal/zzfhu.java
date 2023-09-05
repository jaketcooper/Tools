package com.google.android.gms.internal;

import java.util.Arrays;

final class zzfhu {
    final int tag;
    final byte[] zzjkv;

    zzfhu(int i, byte[] bArr) {
        this.tag = i;
        this.zzjkv = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfhu)) {
            return false;
        }
        zzfhu zzfhu = (zzfhu) obj;
        return this.tag == zzfhu.tag && Arrays.equals(this.zzjkv, zzfhu.zzjkv);
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzjkv);
    }
}
