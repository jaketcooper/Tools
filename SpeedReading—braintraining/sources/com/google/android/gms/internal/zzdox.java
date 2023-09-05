package com.google.android.gms.internal;

public final class zzdox<P> {
    private final P zzlpt;
    private final zzdta zzlpu;
    private final zzdrn zzlpv;
    private final zzdrv zzlpw;

    public zzdox(P p, byte[] bArr, zzdrn zzdrn, zzdrv zzdrv) {
        this.zzlpt = p;
        this.zzlpu = zzdta.zzak(bArr);
        this.zzlpv = zzdrn;
        this.zzlpw = zzdrv;
    }

    public final P zzblh() {
        return this.zzlpt;
    }

    public final byte[] zzbli() {
        if (this.zzlpu == null) {
            return null;
        }
        return this.zzlpu.getBytes();
    }
}
