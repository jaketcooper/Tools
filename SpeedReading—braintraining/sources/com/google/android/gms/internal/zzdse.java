package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class zzdse {
    private zzdsa zzlus;
    private int[] zzlut;
    private int[] zzluu;
    private int[] zzluv = new int[16];
    private int zzluw = 0;
    private boolean zzlux;

    zzdse(zzdsa zzdsa, byte[] bArr, int i) {
        this.zzlus = zzdsa;
        this.zzlut = zzdsa.zzd(bArr, i);
        this.zzluu = zzdsa.zzf(this.zzlut);
        this.zzlux = false;
    }

    /* access modifiers changed from: package-private */
    public final int[] zzbot() {
        this.zzlux = true;
        System.arraycopy(this.zzluu, this.zzluw, this.zzluv, 0, 16 - this.zzluw);
        this.zzlus.zzh(this.zzlut);
        this.zzluu = this.zzlus.zzf(this.zzlut);
        System.arraycopy(this.zzluu, 0, this.zzluv, 16 - this.zzluw, this.zzluw);
        return this.zzluv;
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzfz(int i) {
        if (this.zzlux) {
            throw new IllegalStateException("first can only be called once and before next().");
        }
        this.zzlux = true;
        this.zzluw = 8;
        ByteBuffer order = ByteBuffer.allocate(32).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(this.zzluu, 0, 8);
        return order.array();
    }
}
