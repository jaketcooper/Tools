package com.google.android.gms.internal;

final class zzfdu {
    private final byte[] buffer;
    private final zzfed zzpbe;

    private zzfdu(int i) {
        this.buffer = new byte[i];
        this.zzpbe = zzfed.zzbb(this.buffer);
    }

    /* synthetic */ zzfdu(int i, zzfdq zzfdq) {
        this(i);
    }

    public final zzfdp zzctr() {
        this.zzpbe.zzcut();
        return new zzfdw(this.buffer);
    }

    public final zzfed zzcts() {
        return this.zzpbe;
    }
}
