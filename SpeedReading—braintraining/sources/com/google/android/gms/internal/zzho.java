package com.google.android.gms.internal;

final class zzho implements zzgs {
    private /* synthetic */ zzhm zzbae;

    zzho(zzhm zzhm) {
        this.zzbae = zzhm;
    }

    public final void zzg(boolean z) {
        if (z) {
            this.zzbae.connect();
        } else {
            this.zzbae.disconnect();
        }
    }
}
