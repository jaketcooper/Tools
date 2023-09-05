package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzi<TResult> implements zzk<TResult> {
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private final Executor zzkcm;
    /* access modifiers changed from: private */
    public OnSuccessListener<? super TResult> zzkry;

    public zzi(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzkcm = executor;
        this.zzkry = onSuccessListener;
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzkry = null;
        }
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.mLock) {
                if (this.zzkry != null) {
                    this.zzkcm.execute(new zzj(this, task));
                }
            }
        }
    }
}
