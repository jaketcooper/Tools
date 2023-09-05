package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzg<TResult> implements zzk<TResult> {
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private final Executor zzkcm;
    /* access modifiers changed from: private */
    public OnFailureListener zzkrw;

    public zzg(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzkcm = executor;
        this.zzkrw = onFailureListener;
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzkrw = null;
        }
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        if (!task.isSuccessful()) {
            synchronized (this.mLock) {
                if (this.zzkrw != null) {
                    this.zzkcm.execute(new zzh(this, task));
                }
            }
        }
    }
}
