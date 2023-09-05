package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zze<TResult> implements zzk<TResult> {
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private final Executor zzkcm;
    /* access modifiers changed from: private */
    public OnCompleteListener<TResult> zzkru;

    public zze(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzkcm = executor;
        this.zzkru = onCompleteListener;
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzkru = null;
        }
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        synchronized (this.mLock) {
            if (this.zzkru != null) {
                this.zzkcm.execute(new zzf(this, task));
            }
        }
    }
}
