package com.google.android.gms.internal;

final class zzxc implements Runnable {
    private /* synthetic */ zzxb zzcib;

    zzxc(zzxb zzxb) {
        this.zzcib = zzxb;
    }

    public final void run() {
        this.zzcib.onStop();
    }
}
