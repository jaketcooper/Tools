package com.google.android.gms.internal;

import java.io.IOException;

class zzfdw extends zzfdv {
    protected final byte[] zzjkv;

    zzfdw(byte[] bArr) {
        this.zzjkv = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfdp)) {
            return false;
        }
        if (size() != ((zzfdp) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzfdw)) {
            return obj.equals(this);
        }
        int zzctp = zzctp();
        int zzctp2 = ((zzfdw) obj).zzctp();
        if (zzctp == 0 || zzctp2 == 0 || zzctp == zzctp2) {
            return zza((zzfdw) obj, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzjkv.length;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzfdo zzfdo) throws IOException {
        zzfdo.zzd(this.zzjkv, zzctq(), size());
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzfdp zzfdp, int i, int i2) {
        if (i2 > zzfdp.size()) {
            throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(i2).append(size()).toString());
        } else if (i + i2 > zzfdp.size()) {
            throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: ").append(i).append(", ").append(i2).append(", ").append(zzfdp.size()).toString());
        } else if (!(zzfdp instanceof zzfdw)) {
            return zzfdp.zzx(i, i + i2).equals(zzx(0, i2));
        } else {
            zzfdw zzfdw = (zzfdw) zzfdp;
            byte[] bArr = this.zzjkv;
            byte[] bArr2 = zzfdw.zzjkv;
            int zzctq = zzctq() + i2;
            int zzctq2 = zzctq();
            int zzctq3 = zzfdw.zzctq() + i;
            while (zzctq2 < zzctq) {
                if (bArr[zzctq2] != bArr2[zzctq3]) {
                    return false;
                }
                zzctq2++;
                zzctq3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzjkv, i, bArr, i2, i3);
    }

    public final zzfdy zzctm() {
        return zzfdy.zzb(this.zzjkv, zzctq(), size(), true);
    }

    /* access modifiers changed from: protected */
    public int zzctq() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final int zzg(int i, int i2, int i3) {
        return zzfez.zza(i, this.zzjkv, zzctq() + i2, i3);
    }

    public byte zzke(int i) {
        return this.zzjkv[i];
    }

    public final zzfdp zzx(int i, int i2) {
        int zzh = zzh(i, i2, size());
        return zzh == 0 ? zzfdp.zzpaz : new zzfds(this.zzjkv, zzctq() + i, zzh);
    }
}
