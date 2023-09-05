package com.google.android.gms.internal;

import java.util.concurrent.Executor;

final class zzajw implements Executor {
    zzajw() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
