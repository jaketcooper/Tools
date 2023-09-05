package com.google.android.gms.internal;

final class zzcfb implements Runnable {
    private /* synthetic */ String zzbdq;
    private /* synthetic */ long zziuj;
    private /* synthetic */ zzcfa zziuk;

    zzcfb(zzcfa zzcfa, String str, long j) {
        this.zziuk = zzcfa;
        this.zzbdq = str;
        this.zziuj = j;
    }

    public final void run() {
        this.zziuk.zze(this.zzbdq, this.zziuj);
    }
}
