package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

final class zzxw implements Runnable {
    private /* synthetic */ AtomicInteger zzcjm;
    private /* synthetic */ int zzcjn;
    private /* synthetic */ zzajy zzcjo;
    private /* synthetic */ List zzcjp;

    zzxw(AtomicInteger atomicInteger, int i, zzajy zzajy, List list) {
        this.zzcjm = atomicInteger;
        this.zzcjn = i;
        this.zzcjo = zzajy;
        this.zzcjp = list;
    }

    public final void run() {
        if (this.zzcjm.incrementAndGet() >= this.zzcjn) {
            try {
                this.zzcjo.set(zzxr.zzl(this.zzcjp));
            } catch (InterruptedException | ExecutionException e) {
                zzafj.zzc("Unable to convert list of futures to a future of list", e);
            }
        }
    }
}
