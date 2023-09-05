package com.google.android.gms.internal;

import java.util.concurrent.Future;

final class zzabk implements Runnable {
    private /* synthetic */ Future zzcpz;

    zzabk(zzabh zzabh, Future future) {
        this.zzcpz = future;
    }

    public final void run() {
        if (!this.zzcpz.isDone()) {
            this.zzcpz.cancel(true);
        }
    }
}
