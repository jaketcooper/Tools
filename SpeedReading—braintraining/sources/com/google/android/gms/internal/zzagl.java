package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@zzzb
public final class zzagl {
    public static final ThreadPoolExecutor zzcyx = new ThreadPoolExecutor(20, 20, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzcb("Default"));
    private static final ThreadPoolExecutor zzcyy = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzcb("Loader"));

    static {
        zzcyx.allowCoreThreadTimeOut(true);
        zzcyy.allowCoreThreadTimeOut(true);
    }

    public static zzajp<Void> zza(int i, Runnable runnable) {
        return i == 1 ? zza((ExecutorService) zzcyy, new zzagm(runnable)) : zza((ExecutorService) zzcyx, new zzagn(runnable));
    }

    public static zzajp<Void> zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static <T> zzajp<T> zza(ExecutorService executorService, Callable<T> callable) {
        zzajy zzajy = new zzajy();
        try {
            zzajy.zza(new zzagp(zzajy, executorService.submit(new zzago(zzajy, callable))), zzaju.zzdct);
        } catch (RejectedExecutionException e) {
            zzafj.zzc("Thread execution is rejected.", e);
            zzajy.setException(e);
        }
        return zzajy;
    }

    private static ThreadFactory zzcb(String str) {
        return new zzagq(str);
    }
}
