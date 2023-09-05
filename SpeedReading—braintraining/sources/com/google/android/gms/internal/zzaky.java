package com.google.android.gms.internal;

final class zzaky implements Runnable {
    private /* synthetic */ zzakw zzdev;

    zzaky(zzakw zzakw) {
        this.zzdev = zzakw;
    }

    public final void run() {
        this.zzdev.zza("surfaceDestroyed", new String[0]);
    }
}
