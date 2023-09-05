package com.google.android.gms.internal;

import android.content.Context;

final class zzagt implements Runnable {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzagr zzczl;

    zzagt(zzagr zzagr, Context context) {
        this.zzczl = zzagr;
        this.val$context = context;
    }

    public final void run() {
        synchronized (this.zzczl.mLock) {
            String unused = this.zzczl.zzcxh = zzagr.zzai(this.val$context);
            this.zzczl.mLock.notifyAll();
        }
    }
}
