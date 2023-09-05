package com.google.android.gms.internal;

final class zzcfc implements Runnable {
    private /* synthetic */ String zzbdq;
    private /* synthetic */ long zziuj;
    private /* synthetic */ zzcfa zziuk;

    zzcfc(zzcfa zzcfa, String str, long j) {
        this.zziuk = zzcfa;
        this.zzbdq = str;
        this.zziuj = j;
    }

    public final void run() {
        this.zziuk.zzf(this.zzbdq, this.zziuj);
    }
}
