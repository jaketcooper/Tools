package com.google.android.gms.common.api.internal;

final class zzck implements Runnable {
    private /* synthetic */ String zzao;
    private /* synthetic */ LifecycleCallback zzfrx;
    private /* synthetic */ zzcj zzfry;

    zzck(zzcj zzcj, LifecycleCallback lifecycleCallback, String str) {
        this.zzfry = zzcj;
        this.zzfrx = lifecycleCallback;
        this.zzao = str;
    }

    public final void run() {
        if (this.zzfry.zzbzn > 0) {
            this.zzfrx.onCreate(this.zzfry.zzfrw != null ? this.zzfry.zzfrw.getBundle(this.zzao) : null);
        }
        if (this.zzfry.zzbzn >= 2) {
            this.zzfrx.onStart();
        }
        if (this.zzfry.zzbzn >= 3) {
            this.zzfrx.onResume();
        }
        if (this.zzfry.zzbzn >= 4) {
            this.zzfrx.onStop();
        }
        if (this.zzfry.zzbzn >= 5) {
            this.zzfrx.onDestroy();
        }
    }
}
