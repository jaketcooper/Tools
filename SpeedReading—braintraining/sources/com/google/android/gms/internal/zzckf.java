package com.google.android.gms.internal;

final class zzckf implements Runnable {
    private /* synthetic */ long zziuj;
    private /* synthetic */ zzckc zzjgu;

    zzckf(zzckc zzckc, long j) {
        this.zzjgu = zzckc;
        this.zziuj = j;
    }

    public final void run() {
        this.zzjgu.zzbd(this.zziuj);
    }
}
