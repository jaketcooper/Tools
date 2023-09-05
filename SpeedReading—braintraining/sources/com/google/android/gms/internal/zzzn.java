package com.google.android.gms.internal;

final class zzzn implements Runnable {
    private /* synthetic */ zzze zzclf;
    private /* synthetic */ zzaka zzclg;

    zzzn(zzze zzze, zzaka zzaka) {
        this.zzclf = zzze;
        this.zzclg = zzaka;
    }

    public final void run() {
        synchronized (this.zzclf.zzchy) {
            this.zzclf.zzclb = this.zzclf.zza(this.zzclf.zzcky.zzatd, this.zzclg);
            if (this.zzclf.zzclb == null) {
                this.zzclf.zzc(0, "Could not start the ad request service.");
                zzagr.zzczc.removeCallbacks(this.zzclf.zzchx);
            }
        }
    }
}
