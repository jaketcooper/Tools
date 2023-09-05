package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzi extends zzg {
    private static final WeakReference<byte[]> zzfiu = new WeakReference<>((Object) null);
    private WeakReference<byte[]> zzfit = zzfiu;

    zzi(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    public final byte[] getBytes() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.zzfit.get();
            if (bArr == null) {
                bArr = zzafr();
                this.zzfit = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] zzafr();
}
