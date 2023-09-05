package com.google.android.gms.internal;

import java.util.concurrent.Executor;

final /* synthetic */ class zzajr implements Runnable {
    private final Executor zzdcr;
    private final Runnable zzdcs;

    zzajr(Executor executor, Runnable runnable) {
        this.zzdcr = executor;
        this.zzdcs = runnable;
    }

    public final void run() {
        this.zzdcr.execute(this.zzdcs);
    }
}
