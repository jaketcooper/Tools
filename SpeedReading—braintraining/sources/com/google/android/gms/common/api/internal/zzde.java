package com.google.android.gms.common.api.internal;

final class zzde implements Runnable {
    private /* synthetic */ String zzao;
    private /* synthetic */ LifecycleCallback zzfrx;
    private /* synthetic */ zzdd zzfsm;

    zzde(zzdd zzdd, LifecycleCallback lifecycleCallback, String str) {
        this.zzfsm = zzdd;
        this.zzfrx = lifecycleCallback;
        this.zzao = str;
    }

    public final void run() {
        if (this.zzfsm.zzbzn > 0) {
            this.zzfrx.onCreate(this.zzfsm.zzfrw != null ? this.zzfsm.zzfrw.getBundle(this.zzao) : null);
        }
        if (this.zzfsm.zzbzn >= 2) {
            this.zzfrx.onStart();
        }
        if (this.zzfsm.zzbzn >= 3) {
            this.zzfrx.onResume();
        }
        if (this.zzfsm.zzbzn >= 4) {
            this.zzfrx.onStop();
        }
        if (this.zzfsm.zzbzn >= 5) {
            this.zzfrx.onDestroy();
        }
    }
}
