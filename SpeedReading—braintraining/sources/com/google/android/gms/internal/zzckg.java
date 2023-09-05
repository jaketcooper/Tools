package com.google.android.gms.internal;

final class zzckg implements Runnable {
    private /* synthetic */ long zziuj;
    private /* synthetic */ zzckc zzjgu;

    zzckg(zzckc zzckc, long j) {
        this.zzjgu = zzckc;
        this.zziuj = j;
    }

    public final void run() {
        this.zzjgu.zzbe(this.zziuj);
    }
}
