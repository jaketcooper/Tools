package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import java.lang.Thread;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class zzche extends zzcii {
    /* access modifiers changed from: private */
    public static final AtomicLong zzjcd = new AtomicLong(Long.MIN_VALUE);
    private ExecutorService zzicc;
    /* access modifiers changed from: private */
    public zzchi zzjbu;
    /* access modifiers changed from: private */
    public zzchi zzjbv;
    private final PriorityBlockingQueue<zzchh<?>> zzjbw = new PriorityBlockingQueue<>();
    private final BlockingQueue<zzchh<?>> zzjbx = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zzjby = new zzchg(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzjbz = new zzchg(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object zzjca = new Object();
    /* access modifiers changed from: private */
    public final Semaphore zzjcb = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean zzjcc;

    zzche(zzchj zzchj) {
        super(zzchj);
    }

    private final void zza(zzchh<?> zzchh) {
        synchronized (this.zzjca) {
            this.zzjbw.add(zzchh);
            if (this.zzjbu == null) {
                this.zzjbu = new zzchi(this, "Measurement Worker", this.zzjbw);
                this.zzjbu.setUncaughtExceptionHandler(this.zzjby);
                this.zzjbu.start();
            } else {
                this.zzjbu.zzrb();
            }
        }
    }

    public static boolean zzas() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ void zzavx() {
        super.zzavx();
    }

    public final void zzavy() {
        if (Thread.currentThread() != this.zzjbv) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final /* bridge */ /* synthetic */ zzcfa zzavz() {
        return super.zzavz();
    }

    public final /* bridge */ /* synthetic */ zzcfh zzawa() {
        return super.zzawa();
    }

    public final /* bridge */ /* synthetic */ zzcik zzawb() {
        return super.zzawb();
    }

    public final /* bridge */ /* synthetic */ zzcge zzawc() {
        return super.zzawc();
    }

    public final /* bridge */ /* synthetic */ zzcfr zzawd() {
        return super.zzawd();
    }

    public final /* bridge */ /* synthetic */ zzcjd zzawe() {
        return super.zzawe();
    }

    public final /* bridge */ /* synthetic */ zzciz zzawf() {
        return super.zzawf();
    }

    public final /* bridge */ /* synthetic */ zzcgf zzawg() {
        return super.zzawg();
    }

    public final /* bridge */ /* synthetic */ zzcfl zzawh() {
        return super.zzawh();
    }

    public final /* bridge */ /* synthetic */ zzcgh zzawi() {
        return super.zzawi();
    }

    public final /* bridge */ /* synthetic */ zzckn zzawj() {
        return super.zzawj();
    }

    public final /* bridge */ /* synthetic */ zzchd zzawk() {
        return super.zzawk();
    }

    public final /* bridge */ /* synthetic */ zzckc zzawl() {
        return super.zzawl();
    }

    public final /* bridge */ /* synthetic */ zzche zzawm() {
        return super.zzawm();
    }

    public final /* bridge */ /* synthetic */ zzcgj zzawn() {
        return super.zzawn();
    }

    public final /* bridge */ /* synthetic */ zzcgu zzawo() {
        return super.zzawo();
    }

    public final /* bridge */ /* synthetic */ zzcfk zzawp() {
        return super.zzawp();
    }

    /* access modifiers changed from: protected */
    public final boolean zzaxo() {
        return false;
    }

    public final boolean zzazh() {
        return Thread.currentThread() == this.zzjbu;
    }

    /* access modifiers changed from: package-private */
    public final ExecutorService zzazi() {
        ExecutorService executorService;
        synchronized (this.zzjca) {
            if (this.zzicc == null) {
                this.zzicc = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.zzicc;
        }
        return executorService;
    }

    public final <V> Future<V> zzc(Callable<V> callable) throws IllegalStateException {
        zzwu();
        zzbq.checkNotNull(callable);
        zzchh zzchh = new zzchh(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzjbu) {
            if (!this.zzjbw.isEmpty()) {
                zzawn().zzayu().log("Callable skipped the worker queue.");
            }
            zzchh.run();
        } else {
            zza((zzchh<?>) zzchh);
        }
        return zzchh;
    }

    public final <V> Future<V> zzd(Callable<V> callable) throws IllegalStateException {
        zzwu();
        zzbq.checkNotNull(callable);
        zzchh zzchh = new zzchh(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzjbu) {
            zzchh.run();
        } else {
            zza((zzchh<?>) zzchh);
        }
        return zzchh;
    }

    public final void zzg(Runnable runnable) throws IllegalStateException {
        zzwu();
        zzbq.checkNotNull(runnable);
        zza((zzchh<?>) new zzchh(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzh(Runnable runnable) throws IllegalStateException {
        zzwu();
        zzbq.checkNotNull(runnable);
        zzchh zzchh = new zzchh(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzjca) {
            this.zzjbx.add(zzchh);
            if (this.zzjbv == null) {
                this.zzjbv = new zzchi(this, "Measurement Network", this.zzjbx);
                this.zzjbv.setUncaughtExceptionHandler(this.zzjbz);
                this.zzjbv.start();
            } else {
                this.zzjbv.zzrb();
            }
        }
    }

    public final void zzut() {
        if (Thread.currentThread() != this.zzjbu) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }
}
