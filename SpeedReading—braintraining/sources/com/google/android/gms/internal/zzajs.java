package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

@zzzb
final class zzajs<V> extends FutureTask<V> implements zzajp<V> {
    private final zzajq zzdcn = new zzajq();

    zzajs(Runnable runnable, V v) {
        super(runnable, v);
    }

    zzajs(Callable<V> callable) {
        super(callable);
    }

    /* access modifiers changed from: protected */
    public final void done() {
        this.zzdcn.zzqw();
    }

    public final void zza(Runnable runnable, Executor executor) {
        this.zzdcn.zza(runnable, executor);
    }
}
