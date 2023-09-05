package com.google.android.gms.internal;

final class zzxd implements Runnable {
    private /* synthetic */ zzaeu zzaoc;
    private /* synthetic */ zzxb zzcib;

    zzxd(zzxb zzxb, zzaeu zzaeu) {
        this.zzcib = zzxb;
        this.zzaoc = zzaeu;
    }

    public final void run() {
        synchronized (this.zzcib.mLock) {
            zzxb zzxb = this.zzcib;
            zzxb.zzchu.zzb(this.zzaoc);
        }
    }
}
