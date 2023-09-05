package com.google.android.gms.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzzb
final class zzajo<T> implements zzajp<T> {
    private final T value;
    private final zzajq zzdcn = new zzajq();

    zzajo(T t) {
        this.value = t;
        this.zzdcn.zzqw();
    }

    public final boolean cancel(boolean z) {
        return false;
    }

    public final T get() {
        return this.value;
    }

    public final T get(long j, TimeUnit timeUnit) {
        return this.value;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }

    public final void zza(Runnable runnable, Executor executor) {
        this.zzdcn.zza(runnable, executor);
    }
}
