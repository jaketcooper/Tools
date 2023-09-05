package com.google.android.gms.internal;

import java.util.concurrent.Callable;

final class zztx implements Callable<zztt> {
    private /* synthetic */ zztq zzcdq;
    private /* synthetic */ zztw zzcdr;

    zztx(zztw zztw, zztq zztq) {
        this.zzcdr = zztw;
        this.zzcdq = zztq;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzlx */
    public final zztt call() throws Exception {
        synchronized (this.zzcdr.mLock) {
            if (this.zzcdr.zzcdm) {
                return null;
            }
            return this.zzcdq.zza(this.zzcdr.mStartTime, this.zzcdr.zzcdk);
        }
    }
}
