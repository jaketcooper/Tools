package com.google.android.gms.internal;

import android.os.Looper;

final class zzcfq implements Runnable {
    private /* synthetic */ zzcfp zziwt;

    zzcfq(zzcfp zzcfp) {
        this.zziwt = zzcfp;
    }

    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.zziwt.zzitu.zzawm().zzg(this);
            return;
        }
        boolean zzdr = this.zziwt.zzdr();
        long unused = this.zziwt.zzdss = 0;
        if (zzdr && this.zziwt.zziws) {
            this.zziwt.run();
        }
    }
}
