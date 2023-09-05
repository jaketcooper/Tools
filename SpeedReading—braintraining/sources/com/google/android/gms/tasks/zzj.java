package com.google.android.gms.tasks;

final class zzj implements Runnable {
    private /* synthetic */ Task zzkrr;
    private /* synthetic */ zzi zzkrz;

    zzj(zzi zzi, Task task) {
        this.zzkrz = zzi;
        this.zzkrr = task;
    }

    public final void run() {
        synchronized (this.zzkrz.mLock) {
            if (this.zzkrz.zzkry != null) {
                this.zzkrz.zzkry.onSuccess(this.zzkrr.getResult());
            }
        }
    }
}
