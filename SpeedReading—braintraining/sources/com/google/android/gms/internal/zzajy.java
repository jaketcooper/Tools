package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzzb
public class zzajy<T> implements zzajp<T> {
    private final Object mLock = new Object();
    private T mValue;
    private boolean zzcdm;
    private Throwable zzdcz;
    private boolean zzdda;
    private final zzajq zzddb = new zzajq();

    private final boolean zzqx() {
        return this.zzdcz != null || this.zzdda;
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.mLock) {
            if (zzqx()) {
                return false;
            }
            this.zzcdm = true;
            this.zzdda = true;
            this.mLock.notifyAll();
            this.zzddb.zzqw();
            return true;
        }
    }

    public T get() throws CancellationException, ExecutionException, InterruptedException {
        T t;
        synchronized (this.mLock) {
            if (!zzqx()) {
                try {
                    this.mLock.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.zzdcz != null) {
                throw new ExecutionException(this.zzdcz);
            } else if (this.zzcdm) {
                throw new CancellationException("SettableFuture was cancelled.");
            } else {
                t = this.mValue;
            }
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        T t;
        synchronized (this.mLock) {
            if (!zzqx()) {
                try {
                    long millis = timeUnit.toMillis(j);
                    if (millis != 0) {
                        this.mLock.wait(millis);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.zzdcz != null) {
                throw new ExecutionException(this.zzdcz);
            } else if (!this.zzdda) {
                throw new TimeoutException("SettableFuture timed out.");
            } else if (this.zzcdm) {
                throw new CancellationException("SettableFuture was cancelled.");
            } else {
                t = this.mValue;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcdm;
        }
        return z;
    }

    public boolean isDone() {
        boolean zzqx;
        synchronized (this.mLock) {
            zzqx = zzqx();
        }
        return zzqx;
    }

    public final void set(@Nullable T t) {
        synchronized (this.mLock) {
            if (!this.zzcdm) {
                if (zzqx()) {
                    zzbs.zzeg().zza((Throwable) new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
                    return;
                }
                this.zzdda = true;
                this.mValue = t;
                this.mLock.notifyAll();
                this.zzddb.zzqw();
            }
        }
    }

    public final void setException(Throwable th) {
        synchronized (this.mLock) {
            if (!this.zzcdm) {
                if (zzqx()) {
                    zzbs.zzeg().zza((Throwable) new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
                    return;
                }
                this.zzdcz = th;
                this.mLock.notifyAll();
                this.zzddb.zzqw();
            }
        }
    }

    public final void zza(Runnable runnable, Executor executor) {
        this.zzddb.zza(runnable, executor);
    }
}
