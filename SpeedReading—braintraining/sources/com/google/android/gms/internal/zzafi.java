package com.google.android.gms.internal;

final class zzafi implements Runnable {
    private /* synthetic */ zzafh zzcyk;

    zzafi(zzafh zzafh) {
        this.zzcyk = zzafh;
    }

    public final void run() {
        Thread unused = this.zzcyk.zzcyi = Thread.currentThread();
        this.zzcyk.zzdg();
    }
}
