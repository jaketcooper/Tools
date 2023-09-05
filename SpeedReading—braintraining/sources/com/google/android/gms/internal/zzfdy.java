package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;

public abstract class zzfdy {
    private static volatile boolean zzpbj = true;
    int zzpbf;
    int zzpbg;
    int zzpbh;
    private boolean zzpbi;

    private zzfdy() {
        this.zzpbg = 100;
        this.zzpbh = Integer.MAX_VALUE;
        this.zzpbi = false;
    }

    static zzfdy zzb(byte[] bArr, int i, int i2, boolean z) {
        zzfea zzfea = new zzfea(bArr, i, i2, z);
        try {
            zzfea.zzkj(i2);
            return zzfea;
        } catch (zzffe e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static zzfdy zzba(byte[] bArr) {
        return zzb(bArr, 0, bArr.length, false);
    }

    public static long zzcr(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static zzfdy zzg(byte[] bArr, int i, int i2) {
        return zzb(bArr, i, i2, false);
    }

    public static zzfdy zzi(InputStream inputStream) {
        if (inputStream != null) {
            return new zzfeb(inputStream);
        }
        byte[] bArr = zzfez.EMPTY_BYTE_ARRAY;
        return zzb(bArr, 0, bArr.length, false);
    }

    public static int zzkm(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract <T extends zzfem<T, ?>> T zza(T t, zzfei zzfei) throws IOException;

    public abstract void zza(zzffr zzffr, zzfei zzfei) throws IOException;

    public abstract int zzctt() throws IOException;

    public abstract long zzctu() throws IOException;

    public abstract long zzctv() throws IOException;

    public abstract int zzctw() throws IOException;

    public abstract long zzctx() throws IOException;

    public abstract int zzcty() throws IOException;

    public abstract boolean zzctz() throws IOException;

    public abstract String zzcua() throws IOException;

    public abstract zzfdp zzcub() throws IOException;

    public abstract int zzcuc() throws IOException;

    public abstract int zzcud() throws IOException;

    public abstract int zzcue() throws IOException;

    public abstract long zzcuf() throws IOException;

    public abstract int zzcug() throws IOException;

    public abstract long zzcuh() throws IOException;

    public abstract int zzcui() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long zzcuj() throws IOException;

    public abstract int zzcuk();

    public abstract boolean zzcul() throws IOException;

    public abstract int zzcum();

    public abstract void zzkg(int i) throws zzffe;

    public abstract boolean zzkh(int i) throws IOException;

    public final int zzki(int i) {
        int i2 = this.zzpbh;
        this.zzpbh = Integer.MAX_VALUE;
        return i2;
    }

    public abstract int zzkj(int i) throws zzffe;

    public abstract void zzkk(int i);

    public abstract void zzkl(int i) throws IOException;
}
