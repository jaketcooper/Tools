package com.google.android.gms.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class zzdth {
    private final ConcurrentHashMap<zzdti, List<Throwable>> zzlwl = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzlwm = new ReferenceQueue<>();

    zzdth() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzlwm.poll();
        while (poll != null) {
            this.zzlwl.remove(poll);
            poll = this.zzlwm.poll();
        }
        return this.zzlwl.get(new zzdti(th, (ReferenceQueue<Throwable>) null));
    }
}
