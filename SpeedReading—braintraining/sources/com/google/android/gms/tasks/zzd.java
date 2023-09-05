package com.google.android.gms.tasks;

final class zzd implements Runnable {
    private /* synthetic */ Task zzkrr;
    private /* synthetic */ zzc zzkrt;

    zzd(zzc zzc, Task task) {
        this.zzkrt = zzc;
        this.zzkrr = task;
    }

    public final void run() {
        try {
            Task task = (Task) this.zzkrt.zzkrp.then(this.zzkrr);
            if (task == null) {
                this.zzkrt.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            task.addOnSuccessListener(TaskExecutors.zzksd, this.zzkrt);
            task.addOnFailureListener(TaskExecutors.zzksd, (OnFailureListener) this.zzkrt);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.zzkrt.zzkrq.setException((Exception) e.getCause());
            } else {
                this.zzkrt.zzkrq.setException(e);
            }
        } catch (Exception e2) {
            this.zzkrt.zzkrq.setException(e2);
        }
    }
}
