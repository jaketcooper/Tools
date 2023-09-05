package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

public class TaskCompletionSource<TResult> {
    private final zzn<TResult> zzksc = new zzn<>();

    @NonNull
    public Task<TResult> getTask() {
        return this.zzksc;
    }

    public void setException(@NonNull Exception exc) {
        this.zzksc.setException(exc);
    }

    public void setResult(TResult tresult) {
        this.zzksc.setResult(tresult);
    }

    public boolean trySetException(@NonNull Exception exc) {
        return this.zzksc.trySetException(exc);
    }

    public boolean trySetResult(TResult tresult) {
        return this.zzksc.trySetResult(tresult);
    }
}
