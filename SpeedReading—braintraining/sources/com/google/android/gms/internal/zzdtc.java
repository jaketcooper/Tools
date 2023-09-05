package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;

public final class zzdtc implements zzdou {
    private Mac zzlwe;
    private final int zzlwf;
    private final String zzlwg;
    private final Key zzlwh;

    public zzdtc(String str, Key key, int i) throws GeneralSecurityException {
        this.zzlwg = str;
        this.zzlwf = i;
        this.zzlwh = key;
        this.zzlwe = zzdsr.zzlvv.zzod(str);
        this.zzlwe.init(key);
    }

    public final byte[] zzab(byte[] bArr) throws GeneralSecurityException {
        Mac zzod;
        try {
            zzod = (Mac) this.zzlwe.clone();
        } catch (CloneNotSupportedException e) {
            zzod = zzdsr.zzlvv.zzod(this.zzlwg);
            zzod.init(this.zzlwh);
        }
        zzod.update(bArr);
        byte[] bArr2 = new byte[this.zzlwf];
        System.arraycopy(zzod.doFinal(), 0, bArr2, 0, this.zzlwf);
        return bArr2;
    }
}
