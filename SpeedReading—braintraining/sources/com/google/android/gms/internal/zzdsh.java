package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class zzdsh extends zzdsf {
    private zzdsh(zzdsa zzdsa) {
        super(zzdsa);
    }

    /* access modifiers changed from: package-private */
    public final byte[] zza(byte[] bArr, ByteBuffer byteBuffer) {
        int zzgb = zzdsf.zzga(bArr.length);
        int remaining = byteBuffer.remaining();
        int zzgb2 = zzdsf.zzga(remaining);
        ByteBuffer order = ByteBuffer.allocate(zzgb + zzgb2 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr);
        order.position(zzgb);
        order.put(byteBuffer);
        order.position(zzgb + zzgb2);
        order.putLong((long) bArr.length);
        order.putLong((long) remaining);
        return order.array();
    }
}
