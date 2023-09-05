package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzfhs {
    protected volatile int zzpaw = -1;

    public static final <T extends zzfhs> T zza(T t, byte[] bArr) throws zzfhr {
        return zza(t, bArr, 0, bArr.length);
    }

    private static <T extends zzfhs> T zza(T t, byte[] bArr, int i, int i2) throws zzfhr {
        try {
            zzfhj zzn = zzfhj.zzn(bArr, 0, i2);
            t.zza(zzn);
            zzn.zzkg(0);
            return t;
        } catch (zzfhr e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public static final byte[] zzc(zzfhs zzfhs) {
        byte[] bArr = new byte[zzfhs.zzhl()];
        try {
            zzfhk zzo = zzfhk.zzo(bArr, 0, bArr.length);
            zzfhs.zza(zzo);
            zzo.zzcut();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public String toString() {
        return zzfht.zzd(this);
    }

    public abstract zzfhs zza(zzfhj zzfhj) throws IOException;

    public void zza(zzfhk zzfhk) throws IOException {
    }

    /* renamed from: zzcxg */
    public zzfhs clone() throws CloneNotSupportedException {
        return (zzfhs) super.clone();
    }

    public final int zzcxm() {
        if (this.zzpaw < 0) {
            zzhl();
        }
        return this.zzpaw;
    }

    public final int zzhl() {
        int zzo = zzo();
        this.zzpaw = zzo;
        return zzo;
    }

    /* access modifiers changed from: protected */
    public int zzo() {
        return 0;
    }
}
