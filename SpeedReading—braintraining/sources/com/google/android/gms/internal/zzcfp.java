package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.zzbq;

abstract class zzcfp {
    private static volatile Handler zzdsr;
    /* access modifiers changed from: private */
    public volatile long zzdss;
    /* access modifiers changed from: private */
    public final zzchj zzitu;
    /* access modifiers changed from: private */
    public boolean zziws = true;
    private final Runnable zzv = new zzcfq(this);

    zzcfp(zzchj zzchj) {
        zzbq.checkNotNull(zzchj);
        this.zzitu = zzchj;
    }

    private final Handler getHandler() {
        Handler handler;
        if (zzdsr != null) {
            return zzdsr;
        }
        synchronized (zzcfp.class) {
            if (zzdsr == null) {
                zzdsr = new Handler(this.zzitu.getContext().getMainLooper());
            }
            handler = zzdsr;
        }
        return handler;
    }

    public final void cancel() {
        this.zzdss = 0;
        getHandler().removeCallbacks(this.zzv);
    }

    public abstract void run();

    public final boolean zzdr() {
        return this.zzdss != 0;
    }

    public final void zzr(long j) {
        cancel();
        if (j >= 0) {
            this.zzdss = this.zzitu.zzwh().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzv, j)) {
                this.zzitu.zzawn().zzays().zzj("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }
}
