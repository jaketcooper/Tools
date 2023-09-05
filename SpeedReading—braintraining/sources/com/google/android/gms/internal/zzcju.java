package com.google.android.gms.internal;

final class zzcju implements Runnable {
    private /* synthetic */ zzcjr zzjgi;
    private /* synthetic */ zzcgb zzjgj;

    zzcju(zzcjr zzcjr, zzcgb zzcgb) {
        this.zzjgi = zzcjr;
        this.zzjgj = zzcgb;
    }

    public final void run() {
        synchronized (this.zzjgi) {
            boolean unused = this.zzjgi.zzjgf = false;
            if (!this.zzjgi.zzjfy.isConnected()) {
                this.zzjgi.zzjfy.zzawn().zzayx().log("Connected to remote service");
                this.zzjgi.zzjfy.zza(this.zzjgj);
            }
        }
    }
}
