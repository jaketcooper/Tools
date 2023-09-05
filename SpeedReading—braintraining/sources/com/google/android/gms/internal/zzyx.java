package com.google.android.gms.internal;

import java.lang.Thread;

final class zzyx implements Thread.UncaughtExceptionHandler {
    private /* synthetic */ zzyv zzckt;
    private /* synthetic */ Thread.UncaughtExceptionHandler zzcku;

    zzyx(zzyv zzyv, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzckt = zzyv;
        this.zzcku = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzckt.zza(thread, th);
            if (this.zzcku != null) {
                this.zzcku.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            if (this.zzcku != null) {
                this.zzcku.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
