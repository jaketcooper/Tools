package com.google.android.gms.internal;

final class zzzm implements Runnable {
    private /* synthetic */ zzze zzclf;

    zzzm(zzze zzze) {
        this.zzclf = zzze;
    }

    public final void run() {
        synchronized (this.zzclf.zzchy) {
            if (this.zzclf.zzclb != null) {
                this.zzclf.onStop();
                this.zzclf.zzc(2, "Timed out waiting for ad response.");
            }
        }
    }
}
