package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzcie implements Callable<List<zzckm>> {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzcho zzjed;

    zzcie(zzcho zzcho, zzcff zzcff) {
        this.zzjed = zzcho;
        this.zzjec = zzcff;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzjed.zzitu.zzbaa();
        return this.zzjed.zzitu.zzawh().zziv(this.zzjec.packageName);
    }
}
