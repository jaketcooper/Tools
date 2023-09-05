package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;

final class zzcke extends zzcfp {
    private /* synthetic */ zzckc zzjgu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcke(zzckc zzckc, zzchj zzchj) {
        super(zzchj);
        this.zzjgu = zzckc;
    }

    @WorkerThread
    public final void run() {
        this.zzjgu.zzbal();
    }
}
