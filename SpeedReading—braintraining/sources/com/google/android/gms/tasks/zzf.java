package com.google.android.gms.tasks;

final class zzf implements Runnable {
    private /* synthetic */ Task zzkrr;
    private /* synthetic */ zze zzkrv;

    zzf(zze zze, Task task) {
        this.zzkrv = zze;
        this.zzkrr = task;
    }

    public final void run() {
        synchronized (this.zzkrv.mLock) {
            if (this.zzkrv.zzkru != null) {
                this.zzkrv.zzkru.onComplete(this.zzkrr);
            }
        }
    }
}
