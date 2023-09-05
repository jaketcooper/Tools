package com.google.android.gms.tasks;

final class zzb implements Runnable {
    private /* synthetic */ Task zzkrr;
    private /* synthetic */ zza zzkrs;

    zzb(zza zza, Task task) {
        this.zzkrs = zza;
        this.zzkrr = task;
    }

    public final void run() {
        try {
            this.zzkrs.zzkrq.setResult(this.zzkrs.zzkrp.then(this.zzkrr));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.zzkrs.zzkrq.setException((Exception) e.getCause());
            } else {
                this.zzkrs.zzkrq.setException(e);
            }
        } catch (Exception e2) {
            this.zzkrs.zzkrq.setException(e2);
        }
    }
}
