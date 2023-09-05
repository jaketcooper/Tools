package com.google.android.gms.internal;

final class zzhn implements Runnable {
    private /* synthetic */ zzhm zzbae;

    zzhn(zzhm zzhm) {
        this.zzbae = zzhm;
    }

    public final void run() {
        this.zzbae.disconnect();
    }
}
