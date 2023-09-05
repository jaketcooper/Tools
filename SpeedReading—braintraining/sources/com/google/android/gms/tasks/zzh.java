package com.google.android.gms.tasks;

final class zzh implements Runnable {
    private /* synthetic */ Task zzkrr;
    private /* synthetic */ zzg zzkrx;

    zzh(zzg zzg, Task task) {
        this.zzkrx = zzg;
        this.zzkrr = task;
    }

    public final void run() {
        synchronized (this.zzkrx.mLock) {
            if (this.zzkrx.zzkrw != null) {
                this.zzkrx.zzkrw.onFailure(this.zzkrr.getException());
            }
        }
    }
}
