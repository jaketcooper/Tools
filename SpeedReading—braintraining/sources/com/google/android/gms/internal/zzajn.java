package com.google.android.gms.internal;

import java.util.concurrent.Future;

final /* synthetic */ class zzajn implements Runnable {
    private final Future zzbxi;
    private final zzajp zzdcm;

    zzajn(zzajp zzajp, Future future) {
        this.zzdcm = zzajp;
        this.zzbxi = future;
    }

    public final void run() {
        zzajp zzajp = this.zzdcm;
        Future future = this.zzbxi;
        if (zzajp.isCancelled()) {
            future.cancel(true);
        }
    }
}
