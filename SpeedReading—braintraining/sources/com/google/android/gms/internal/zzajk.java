package com.google.android.gms.internal;

import java.util.concurrent.TimeoutException;

final /* synthetic */ class zzajk implements Runnable {
    private final zzajy zzbxh;

    zzajk(zzajy zzajy) {
        this.zzbxh = zzajy;
    }

    public final void run() {
        this.zzbxh.setException(new TimeoutException());
    }
}
