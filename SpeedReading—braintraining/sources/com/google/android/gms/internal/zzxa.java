package com.google.android.gms.internal;

final class zzxa implements Runnable {
    private /* synthetic */ zzwz zzcia;

    zzxa(zzwz zzwz) {
        this.zzcia = zzwz;
    }

    public final void run() {
        if (this.zzcia.zzchz.get()) {
            zzafj.m12e("Timed out waiting for WebView to finish loading.");
            this.zzcia.cancel();
        }
    }
}
