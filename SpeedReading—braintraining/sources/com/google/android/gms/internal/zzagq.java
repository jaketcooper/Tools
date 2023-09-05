package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzagq implements ThreadFactory {
    private final AtomicInteger zzcvo = new AtomicInteger(1);
    private /* synthetic */ String zzczb;

    zzagq(String str) {
        this.zzczb = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.zzczb;
        return new Thread(runnable, new StringBuilder(String.valueOf(str).length() + 23).append("AdWorker(").append(str).append(") #").append(this.zzcvo.getAndIncrement()).toString());
    }
}
