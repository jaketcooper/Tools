package com.google.android.gms.internal;

final class zzcil implements Runnable {
    private /* synthetic */ boolean val$enabled;
    private /* synthetic */ zzcik zzjer;

    zzcil(zzcik zzcik, boolean z) {
        this.zzjer = zzcik;
        this.val$enabled = z;
    }

    public final void run() {
        this.zzjer.zzbo(this.val$enabled);
    }
}
