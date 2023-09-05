package com.google.android.gms.internal;

final class zzcfd implements Runnable {
    private /* synthetic */ long zziuj;
    private /* synthetic */ zzcfa zziuk;

    zzcfd(zzcfa zzcfa, long j) {
        this.zziuk = zzcfa;
        this.zziuj = j;
    }

    public final void run() {
        this.zziuk.zzaj(this.zziuj);
    }
}
