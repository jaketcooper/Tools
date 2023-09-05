package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.zzbq;

@zzzb
public final class zzaii {
    private Handler mHandler = null;
    private final Object mLock = new Object();
    private HandlerThread zzdba = null;
    private int zzdbb = 0;

    public final Handler getHandler() {
        return this.mHandler;
    }

    public final Looper zzqm() {
        Looper looper;
        synchronized (this.mLock) {
            if (this.zzdbb != 0) {
                zzbq.checkNotNull(this.zzdba, "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzdba == null) {
                zzafj.m11v("Starting the looper thread.");
                this.zzdba = new HandlerThread("LooperProvider");
                this.zzdba.start();
                this.mHandler = new Handler(this.zzdba.getLooper());
                zzafj.m11v("Looper thread started.");
            } else {
                zzafj.m11v("Resuming the looper thread");
                this.mLock.notifyAll();
            }
            this.zzdbb++;
            looper = this.zzdba.getLooper();
        }
        return looper;
    }
}
