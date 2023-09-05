package com.google.android.gms.internal;

import java.util.concurrent.Callable;

final class zzagn implements Callable<Void> {
    private /* synthetic */ Runnable zzcyz;

    zzagn(Runnable runnable) {
        this.zzcyz = runnable;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzcyz.run();
        return null;
    }
}
