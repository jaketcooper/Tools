package com.google.android.gms.internal;

import java.util.concurrent.Future;

final /* synthetic */ class zzrg implements Runnable {
    private final zzajy zzbxh;
    private final Future zzbxi;

    zzrg(zzajy zzajy, Future future) {
        this.zzbxh = zzajy;
        this.zzbxi = future;
    }

    public final void run() {
        zzajy zzajy = this.zzbxh;
        Future future = this.zzbxi;
        if (zzajy.isCancelled()) {
            future.cancel(true);
        }
    }
}
