package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.lang.Thread;

final class zzchg implements Thread.UncaughtExceptionHandler {
    private final String zzjce;
    private /* synthetic */ zzche zzjcf;

    public zzchg(zzche zzche, String str) {
        this.zzjcf = zzche;
        zzbq.checkNotNull(str);
        this.zzjce = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zzjcf.zzawn().zzays().zzj(this.zzjce, th);
    }
}
