package com.google.android.gms.internal;

final class zzyy implements Runnable {
    private /* synthetic */ zzaix zzckv;
    private /* synthetic */ String zzckw;

    zzyy(zzyv zzyv, zzaix zzaix, String str) {
        this.zzckv = zzaix;
        this.zzckw = str;
    }

    public final void run() {
        this.zzckv.zzch(this.zzckw);
    }
}
