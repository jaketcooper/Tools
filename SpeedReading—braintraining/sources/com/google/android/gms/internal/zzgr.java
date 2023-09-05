package com.google.android.gms.internal;

final class zzgr implements Runnable {
    private /* synthetic */ zzgq zzayi;

    zzgr(zzgq zzgq) {
        this.zzayi = zzgq;
    }

    public final void run() {
        synchronized (this.zzayi.mLock) {
            if (!this.zzayi.zzayc || !this.zzayi.zzayd) {
                zzafj.zzbw("App is still foreground");
            } else {
                boolean unused = this.zzayi.zzayc = false;
                zzafj.zzbw("App went background");
                for (zzgs zzg : this.zzayi.zzaye) {
                    try {
                        zzg.zzg(false);
                    } catch (Exception e) {
                        zzafj.zzb("OnForegroundStateChangedListener threw exception.", e);
                    }
                }
            }
        }
    }
}
