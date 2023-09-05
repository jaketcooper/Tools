package com.google.android.gms.internal;

import java.util.concurrent.Callable;

final class zzagm implements Callable<Void> {
    private /* synthetic */ Runnable zzcyz;

    zzagm(Runnable runnable) {
        this.zzcyz = runnable;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzcyz.run();
        return null;
    }
}
