package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzaen implements ThreadFactory {
    private final AtomicInteger zzcvo = new AtomicInteger(1);

    zzaen(zzael zzael) {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, new StringBuilder(42).append("AdWorker(SCION_TASK_EXECUTOR) #").append(this.zzcvo.getAndIncrement()).toString());
    }
}
