package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

@zzzb
public final class zzhe extends zzgz {
    private MessageDigest zzazp;

    public final byte[] zzx(String str) {
        byte[] bArr;
        byte[] bArr2;
        String[] split = str.split(" ");
        if (split.length == 1) {
            int zzz = zzhd.zzz(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zzz);
            bArr = allocate.array();
        } else if (split.length < 5) {
            byte[] bArr3 = new byte[(split.length << 1)];
            for (int i = 0; i < split.length; i++) {
                int zzz2 = zzhd.zzz(split[i]);
                int i2 = (zzz2 >> 16) ^ (65535 & zzz2);
                byte[] bArr4 = {(byte) i2, (byte) (i2 >> 8)};
                bArr3[i << 1] = bArr4[0];
                bArr3[(i << 1) + 1] = bArr4[1];
            }
            bArr = bArr3;
        } else {
            bArr = new byte[split.length];
            for (int i3 = 0; i3 < split.length; i3++) {
                int zzz3 = zzhd.zzz(split[i3]);
                bArr[i3] = (byte) ((zzz3 >> 24) ^ (((zzz3 & 255) ^ ((zzz3 >> 8) & 255)) ^ ((zzz3 >> 16) & 255)));
            }
        }
        this.zzazp = zzha();
        synchronized (this.mLock) {
            if (this.zzazp == null) {
                bArr2 = new byte[0];
            } else {
                this.zzazp.reset();
                this.zzazp.update(bArr);
                byte[] digest = this.zzazp.digest();
                bArr2 = new byte[(digest.length > 4 ? 4 : digest.length)];
                System.arraycopy(digest, 0, bArr2, 0, bArr2.length);
            }
        }
        return bArr2;
    }
}
