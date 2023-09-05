package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zza<TResult, TContinuationResult> implements zzk<TResult> {
    private final Executor zzkcm;
    /* access modifiers changed from: private */
    public final Continuation<TResult, TContinuationResult> zzkrp;
    /* access modifiers changed from: private */
    public final zzn<TContinuationResult> zzkrq;

    public zza(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull zzn<TContinuationResult> zzn) {
        this.zzkcm = executor;
        this.zzkrp = continuation;
        this.zzkrq = zzn;
    }

    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        this.zzkcm.execute(new zzb(this, task));
    }
}
