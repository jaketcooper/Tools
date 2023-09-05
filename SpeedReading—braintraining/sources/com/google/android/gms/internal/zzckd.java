package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.WorkerThread;

final class zzckd extends zzcfp {
    private /* synthetic */ zzckc zzjgu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzckd(zzckc zzckc, zzchj zzchj) {
        super(zzchj);
        this.zzjgu = zzckc;
    }

    @WorkerThread
    public final void run() {
        zzckc zzckc = this.zzjgu;
        zzckc.zzut();
        zzckc.zzawn().zzayy().zzj("Session started, time", Long.valueOf(zzckc.zzwh().elapsedRealtime()));
        zzckc.zzawo().zzjav.set(false);
        zzckc.zzawb().zzc("auto", "_s", new Bundle());
        zzckc.zzawo().zzjaw.set(zzckc.zzwh().currentTimeMillis());
    }
}
