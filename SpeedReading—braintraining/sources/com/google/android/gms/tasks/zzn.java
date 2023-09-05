package com.google.android.gms.tasks;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.internal.zzbq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

final class zzn<TResult> extends Task<TResult> {
    private final Object mLock = new Object();
    private final zzl<TResult> zzkse = new zzl<>();
    private boolean zzksf;
    private TResult zzksg;
    private Exception zzksh;

    static class zza extends LifecycleCallback {
        private final List<WeakReference<zzk<?>>> zzewv = new ArrayList();

        private zza(zzci zzci) {
            super(zzci);
            this.zzfrt.zza("TaskOnStopCallback", (LifecycleCallback) this);
        }

        public static zza zzr(Activity activity) {
            zzci zzn = zzn(activity);
            zza zza = (zza) zzn.zza("TaskOnStopCallback", zza.class);
            return zza == null ? new zza(zzn) : zza;
        }

        @MainThread
        public final void onStop() {
            synchronized (this.zzewv) {
                for (WeakReference<zzk<?>> weakReference : this.zzewv) {
                    zzk zzk = (zzk) weakReference.get();
                    if (zzk != null) {
                        zzk.cancel();
                    }
                }
                this.zzewv.clear();
            }
        }

        public final <T> void zzb(zzk<T> zzk) {
            synchronized (this.zzewv) {
                this.zzewv.add(new WeakReference(zzk));
            }
        }
    }

    zzn() {
    }

    private final void zzbiz() {
        zzbq.zza(this.zzksf, (Object) "Task is not yet complete");
    }

    private final void zzbja() {
        zzbq.zza(!this.zzksf, (Object) "Task is already complete");
    }

    private final void zzbjb() {
        synchronized (this.mLock) {
            if (this.zzksf) {
                this.zzkse.zzb(this);
            }
        }
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        zze zze = new zze(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.zzkse.zza(zze);
        zza.zzr(activity).zzb(zze);
        zzbjb();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzkse.zza(new zze(executor, onCompleteListener));
        zzbjb();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzg zzg = new zzg(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.zzkse.zza(zzg);
        zza.zzr(activity).zzb(zzg);
        zzbjb();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzkse.zza(new zzg(executor, onFailureListener));
        zzbjb();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zzi zzi = new zzi(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.zzkse.zza(zzi);
        zza.zzr(activity).zzb(zzi);
        zzbjb();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzkse.zza(new zzi(executor, onSuccessListener));
        zzbjb();
        return this;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        zzn zzn = new zzn();
        this.zzkse.zza(new zza(executor, continuation, zzn));
        zzbjb();
        return zzn;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzn zzn = new zzn();
        this.zzkse.zza(new zzc(executor, continuation, zzn));
        zzbjb();
        return zzn;
    }

    @Nullable
    public final Exception getException() {
        Exception exc;
        synchronized (this.mLock) {
            exc = this.zzksh;
        }
        return exc;
    }

    public final TResult getResult() {
        TResult tresult;
        synchronized (this.mLock) {
            zzbiz();
            if (this.zzksh != null) {
                throw new RuntimeExecutionException(this.zzksh);
            }
            tresult = this.zzksg;
        }
        return tresult;
    }

    public final <X extends Throwable> TResult getResult(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.mLock) {
            zzbiz();
            if (cls.isInstance(this.zzksh)) {
                throw ((Throwable) cls.cast(this.zzksh));
            } else if (this.zzksh != null) {
                throw new RuntimeExecutionException(this.zzksh);
            } else {
                tresult = this.zzksg;
            }
        }
        return tresult;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzksf;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzksf && this.zzksh == null;
        }
        return z;
    }

    public final void setException(@NonNull Exception exc) {
        zzbq.checkNotNull(exc, "Exception must not be null");
        synchronized (this.mLock) {
            zzbja();
            this.zzksf = true;
            this.zzksh = exc;
        }
        this.zzkse.zzb(this);
    }

    public final void setResult(TResult tresult) {
        synchronized (this.mLock) {
            zzbja();
            this.zzksf = true;
            this.zzksg = tresult;
        }
        this.zzkse.zzb(this);
    }

    public final boolean trySetException(@NonNull Exception exc) {
        boolean z = true;
        zzbq.checkNotNull(exc, "Exception must not be null");
        synchronized (this.mLock) {
            if (this.zzksf) {
                z = false;
            } else {
                this.zzksf = true;
                this.zzksh = exc;
                this.zzkse.zzb(this);
            }
        }
        return z;
    }

    public final boolean trySetResult(TResult tresult) {
        boolean z = true;
        synchronized (this.mLock) {
            if (this.zzksf) {
                z = false;
            } else {
                this.zzksf = true;
                this.zzksg = tresult;
                this.zzkse.zzb(this);
            }
        }
        return z;
    }
}
