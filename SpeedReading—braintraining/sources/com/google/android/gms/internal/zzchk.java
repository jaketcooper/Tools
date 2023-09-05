package com.google.android.gms.internal;

final class zzchk implements Runnable {
    private /* synthetic */ zzchj zzjdw;

    zzchk(zzchj zzchj) {
        this.zzjdw = zzchj;
    }

    public final void run() {
        this.zzjdw.zzazl();
        this.zzjdw.start();
    }
}
