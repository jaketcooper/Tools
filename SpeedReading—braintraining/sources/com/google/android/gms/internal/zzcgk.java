package com.google.android.gms.internal;

final class zzcgk implements Runnable {
    private /* synthetic */ String zzizs;
    private /* synthetic */ zzcgj zzizt;

    zzcgk(zzcgj zzcgj, String str) {
        this.zzizt = zzcgj;
        this.zzizs = str;
    }

    public final void run() {
        zzcgu zzawo = this.zzizt.zzitu.zzawo();
        if (!zzawo.isInitialized()) {
            this.zzizt.zzk(6, "Persisted config not initialized. Not logging error/warn");
        } else {
            zzawo.zzjaf.zzg(this.zzizs, 1);
        }
    }
}
