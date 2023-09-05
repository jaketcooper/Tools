package com.google.android.gms.internal;

final class zzcjs implements Runnable {
    private /* synthetic */ zzcgb zzjgh;
    private /* synthetic */ zzcjr zzjgi;

    zzcjs(zzcjr zzcjr, zzcgb zzcgb) {
        this.zzjgi = zzcjr;
        this.zzjgh = zzcgb;
    }

    public final void run() {
        synchronized (this.zzjgi) {
            boolean unused = this.zzjgi.zzjgf = false;
            if (!this.zzjgi.zzjfy.isConnected()) {
                this.zzjgi.zzjfy.zzawn().zzayy().log("Connected to service");
                this.zzjgi.zzjfy.zza(this.zzjgh);
            }
        }
    }
}
