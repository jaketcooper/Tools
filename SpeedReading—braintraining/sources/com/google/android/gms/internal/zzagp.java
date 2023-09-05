package com.google.android.gms.internal;

import java.util.concurrent.Future;

final class zzagp implements Runnable {
    private /* synthetic */ zzajy zzbxb;
    private /* synthetic */ Future zzcza;

    zzagp(zzajy zzajy, Future future) {
        this.zzbxb = zzajy;
        this.zzcza = future;
    }

    public final void run() {
        if (this.zzbxb.isCancelled()) {
            this.zzcza.cancel(true);
        }
    }
}
