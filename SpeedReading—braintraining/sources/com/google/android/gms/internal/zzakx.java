package com.google.android.gms.internal;

final class zzakx implements Runnable {
    private /* synthetic */ zzakw zzdev;

    zzakx(zzakw zzakw) {
        this.zzdev = zzakw;
    }

    public final void run() {
        this.zzdev.zza("surfaceCreated", new String[0]);
    }
}
