package com.google.android.gms.internal;

import java.lang.Thread;

final class zzyw implements Thread.UncaughtExceptionHandler {
    private /* synthetic */ Thread.UncaughtExceptionHandler zzcks;
    private /* synthetic */ zzyv zzckt;

    zzyw(zzyv zzyv, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzckt = zzyv;
        this.zzcks = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzckt.zza(thread, th);
            if (this.zzcks != null) {
                this.zzcks.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            if (this.zzcks != null) {
                this.zzcks.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
