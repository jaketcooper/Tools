package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

final class zzajv implements Executor {
    private final Handler zzdcx = new Handler(Looper.getMainLooper());

    zzajv() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            this.zzdcx.post(runnable);
        }
    }
}
