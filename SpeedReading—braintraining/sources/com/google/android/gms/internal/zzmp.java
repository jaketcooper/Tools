package com.google.android.gms.internal;

import java.util.concurrent.Callable;

final class zzmp implements Callable<T> {
    private /* synthetic */ zzmg zzbfv;
    private /* synthetic */ zzmo zzbfw;

    zzmp(zzmo zzmo, zzmg zzmg) {
        this.zzbfw = zzmo;
        this.zzbfv = zzmg;
    }

    public final T call() {
        return this.zzbfv.zza(this.zzbfw.zzbfu);
    }
}
