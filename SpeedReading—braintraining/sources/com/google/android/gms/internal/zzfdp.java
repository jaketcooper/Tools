package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public abstract class zzfdp implements Serializable, Iterable<Byte> {
    public static final zzfdp zzpaz = new zzfdw(zzfez.EMPTY_BYTE_ARRAY);
    private static final zzfdt zzpba;
    private int zzlwn = 0;

    static {
        boolean z = true;
        try {
            Class.forName("android.content.Context");
        } catch (ClassNotFoundException e) {
            z = false;
        }
        zzpba = z ? new zzfdx((zzfdq) null) : new zzfdr((zzfdq) null);
    }

    zzfdp() {
    }

    private static zzfdp zza(Iterator<zzfdp> it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return it.next();
        } else {
            int i2 = i >>> 1;
            zzfdp zza = zza(it, i2);
            zzfdp zza2 = zza(it, i - i2);
            if (Integer.MAX_VALUE - zza.size() >= zza2.size()) {
                return zzffx.zza(zza, zza2);
            }
            int size = zza.size();
            throw new IllegalArgumentException(new StringBuilder(53).append("ByteString would be too long: ").append(size).append("+").append(zza2.size()).toString());
        }
    }

    public static zzfdp zzay(byte[] bArr) {
        return zze(bArr, 0, bArr.length);
    }

    static zzfdp zzaz(byte[] bArr) {
        return new zzfdw(bArr);
    }

    public static zzfdp zze(byte[] bArr, int i, int i2) {
        return new zzfdw(zzpba.zzf(bArr, i, i2));
    }

    public static zzfdp zzf(Iterable<zzfdp> iterable) {
        int size = ((Collection) iterable).size();
        return size == 0 ? zzpaz : zza(iterable.iterator(), size);
    }

    static int zzh(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(i).append(" < 0").toString());
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(i).append(", ").append(i2).toString());
        } else {
            throw new IndexOutOfBoundsException(new StringBuilder(37).append("End index: ").append(i2).append(" >= ").append(i3).toString());
        }
    }

    static zzfdu zzkf(int i) {
        return new zzfdu(i, (zzfdq) null);
    }

    public static zzfdp zztc(String str) {
        return new zzfdw(str.getBytes(zzfez.UTF_8));
    }

    static void zzy(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(22).append("Index < 0: ").append(i).toString());
        }
        throw new ArrayIndexOutOfBoundsException(new StringBuilder(40).append("Index > length: ").append(i).append(", ").append(i2).toString());
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzlwn;
        if (i == 0) {
            int size = size();
            i = zzg(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzlwn = i;
        }
        return i;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzfdq(this);
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzfez.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        zzb(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(zzfdo zzfdo) throws IOException;

    public final void zza(byte[] bArr, int i, int i2, int i3) {
        zzh(i, i + i3, size());
        zzh(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zzb(bArr, i, i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzb(byte[] bArr, int i, int i2, int i3);

    public abstract zzfdy zzctm();

    /* access modifiers changed from: protected */
    public abstract int zzctn();

    /* access modifiers changed from: protected */
    public abstract boolean zzcto();

    /* access modifiers changed from: protected */
    public final int zzctp() {
        return this.zzlwn;
    }

    /* access modifiers changed from: protected */
    public abstract int zzg(int i, int i2, int i3);

    public abstract byte zzke(int i);

    public abstract zzfdp zzx(int i, int i2);
}
