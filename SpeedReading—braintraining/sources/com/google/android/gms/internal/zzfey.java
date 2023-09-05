package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfey extends zzfdl<Integer> implements zzffc, zzffv, RandomAccess {
    private static final zzfey zzpde;
    private int size;
    private int[] zzpdf;

    static {
        zzfey zzfey = new zzfey();
        zzpde = zzfey;
        zzfey.zzbin();
    }

    zzfey() {
        this(new int[10], 0);
    }

    private zzfey(int[] iArr, int i) {
        this.zzpdf = iArr;
        this.size = i;
    }

    private final void zzai(int i, int i2) {
        zzctj();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzln(i));
        }
        if (this.size < this.zzpdf.length) {
            System.arraycopy(this.zzpdf, i, this.zzpdf, i + 1, this.size - i);
        } else {
            int[] iArr = new int[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzpdf, 0, iArr, 0, i);
            System.arraycopy(this.zzpdf, i, iArr, i + 1, this.size - i);
            this.zzpdf = iArr;
        }
        this.zzpdf[i] = i2;
        this.size++;
        this.modCount++;
    }

    public static zzfey zzcvr() {
        return zzpde;
    }

    private final void zzlm(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzln(i));
        }
    }

    private final String zzln(int i) {
        return new StringBuilder(35).append("Index:").append(i).append(", Size:").append(this.size).toString();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzai(i, ((Integer) obj).intValue());
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzctj();
        zzfez.checkNotNull(collection);
        if (!(collection instanceof zzfey)) {
            return super.addAll(collection);
        }
        zzfey zzfey = (zzfey) collection;
        if (zzfey.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzfey.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzfey.size;
        if (i > this.zzpdf.length) {
            this.zzpdf = Arrays.copyOf(this.zzpdf, i);
        }
        System.arraycopy(zzfey.zzpdf, 0, this.zzpdf, this.size, zzfey.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfey)) {
            return super.equals(obj);
        }
        zzfey zzfey = (zzfey) obj;
        if (this.size != zzfey.size) {
            return false;
        }
        int[] iArr = zzfey.zzpdf;
        for (int i = 0; i < this.size; i++) {
            if (this.zzpdf[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        zzlm(i);
        return this.zzpdf[i];
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzpdf[i2];
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzctj();
        zzlm(i);
        int i2 = this.zzpdf[i];
        System.arraycopy(this.zzpdf, i + 1, this.zzpdf, i, this.size - i);
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final boolean remove(Object obj) {
        zzctj();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzpdf[i]))) {
                System.arraycopy(this.zzpdf, i + 1, this.zzpdf, i, this.size - i);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzctj();
        zzlm(i);
        int i2 = this.zzpdf[i];
        this.zzpdf[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.size;
    }

    /* renamed from: zzlk */
    public final zzffc zzlo(int i) {
        if (i >= this.size) {
            return new zzfey(Arrays.copyOf(this.zzpdf, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzll(int i) {
        zzai(this.size, i);
    }
}
