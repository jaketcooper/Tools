package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzc<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzk<TResult> {
    private final Executor zzkcm;
    /* access modifiers changed from: private */
    public final Continuation<TResult, Task<TContinuationResult>> zzkrp;
    /* access modifiers changed from: private */
    public final zzn<TContinuationResult> zzkrq;

    public zzc(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation, @NonNull zzn<TContinuationResult> zzn) {
        this.zzkcm = executor;
        this.zzkrp = continuation;
        this.zzkrq = zzn;
    }

    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        this.zzkcm.execute(new zzd(this, task));
    }

    public final void onFailure(@NonNull Exception exc) {
        this.zzkrq.setException(exc);
    }

    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.zzkrq.setResult(tcontinuationresult);
    }
}
