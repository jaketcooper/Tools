package com.google.android.gms.internal;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

@zzzb
public abstract class zzaja extends AbstractExecutorService implements ExecutorService {
    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new zzajs(runnable, t);
    }

    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new zzajs(callable);
    }

    public /* synthetic */ Future submit(Runnable runnable) {
        return (zzajp) super.submit(runnable);
    }

    public /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (zzajp) super.submit(runnable, obj);
    }

    public /* synthetic */ Future submit(Callable callable) {
        return (zzajp) super.submit(callable);
    }
}
