package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.security.MessageDigest;

@zzzb
public final class zzhi extends zzgz {
    private MessageDigest zzazp;
    private final int zzazs;
    private final int zzazt;

    public zzhi(int i) {
        int i2 = i / 8;
        this.zzazs = i % 8 > 0 ? i2 + 1 : i2;
        this.zzazt = i;
    }

    public final byte[] zzx(String str) {
        byte[] bArr;
        synchronized (this.mLock) {
            this.zzazp = zzha();
            if (this.zzazp == null) {
                bArr = new byte[0];
            } else {
                this.zzazp.reset();
                this.zzazp.update(str.getBytes(Charset.forName("UTF-8")));
                byte[] digest = this.zzazp.digest();
                bArr = new byte[(digest.length > this.zzazs ? this.zzazs : digest.length)];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
                if (this.zzazt % 8 > 0) {
                    long j = 0;
                    for (int i = 0; i < bArr.length; i++) {
                        if (i > 0) {
                            j <<= 8;
                        }
                        j += (long) (bArr[i] & 255);
                    }
                    long j2 = j >>> (8 - (this.zzazt % 8));
                    for (int i2 = this.zzazs - 1; i2 >= 0; i2--) {
                        bArr[i2] = (byte) ((int) (255 & j2));
                        j2 >>>= 8;
                    }
                }
            }
        }
        return bArr;
    }
}
