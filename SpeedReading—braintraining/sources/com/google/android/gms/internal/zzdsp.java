package com.google.android.gms.internal;

public final class zzdsp {
    private final zzdta zzlvo;
    private final zzdta zzlvp;

    public zzdsp(byte[] bArr, byte[] bArr2) {
        this.zzlvo = zzdta.zzak(bArr);
        this.zzlvp = zzdta.zzak(bArr2);
    }

    public final byte[] zzbou() {
        if (this.zzlvo == null) {
            return null;
        }
        return this.zzlvo.getBytes();
    }

    public final byte[] zzbov() {
        if (this.zzlvp == null) {
            return null;
        }
        return this.zzlvp.getBytes();
    }
}
