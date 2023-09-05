package com.google.android.gms.internal;

public final class zzfho implements Cloneable {
    private static final zzfhp zzpho = new zzfhp();
    private int mSize;
    private boolean zzphp;
    private int[] zzphq;
    private zzfhp[] zzphr;

    zzfho() {
        this(10);
    }

    private zzfho(int i) {
        this.zzphp = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzphq = new int[idealIntArraySize];
        this.zzphr = new zzfhp[idealIntArraySize];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            } else if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            } else {
                i3++;
            }
        }
        return i2 / 4;
    }

    private final int zzmc(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzphq[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzfho zzfho = new zzfho(i);
        System.arraycopy(this.zzphq, 0, zzfho.zzphq, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzphr[i2] != null) {
                zzfho.zzphr[i2] = (zzfhp) this.zzphr[i2].clone();
            }
        }
        zzfho.mSize = i;
        return zzfho;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfho)) {
            return false;
        }
        zzfho zzfho = (zzfho) obj;
        if (this.mSize != zzfho.mSize) {
            return false;
        }
        int[] iArr = this.zzphq;
        int[] iArr2 = zzfho.zzphq;
        int i = this.mSize;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            zzfhp[] zzfhpArr = this.zzphr;
            zzfhp[] zzfhpArr2 = zzfho.zzphr;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!zzfhpArr[i4].equals(zzfhpArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzphq[i2]) * 31) + this.zzphr[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return this.mSize;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, zzfhp zzfhp) {
        int zzmc = zzmc(i);
        if (zzmc >= 0) {
            this.zzphr[zzmc] = zzfhp;
            return;
        }
        int i2 = zzmc ^ -1;
        if (i2 >= this.mSize || this.zzphr[i2] != zzpho) {
            if (this.mSize >= this.zzphq.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzfhp[] zzfhpArr = new zzfhp[idealIntArraySize];
                System.arraycopy(this.zzphq, 0, iArr, 0, this.zzphq.length);
                System.arraycopy(this.zzphr, 0, zzfhpArr, 0, this.zzphr.length);
                this.zzphq = iArr;
                this.zzphr = zzfhpArr;
            }
            if (this.mSize - i2 != 0) {
                System.arraycopy(this.zzphq, i2, this.zzphq, i2 + 1, this.mSize - i2);
                System.arraycopy(this.zzphr, i2, this.zzphr, i2 + 1, this.mSize - i2);
            }
            this.zzphq[i2] = i;
            this.zzphr[i2] = zzfhp;
            this.mSize++;
            return;
        }
        this.zzphq[i2] = i;
        this.zzphr[i2] = zzfhp;
    }

    /* access modifiers changed from: package-private */
    public final zzfhp zzma(int i) {
        int zzmc = zzmc(i);
        if (zzmc < 0 || this.zzphr[zzmc] == zzpho) {
            return null;
        }
        return this.zzphr[zzmc];
    }

    /* access modifiers changed from: package-private */
    public final zzfhp zzmb(int i) {
        return this.zzphr[i];
    }
}
