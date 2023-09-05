package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@zzzb
public final class zzajg {
    public static <V> zzajp<V> zza(zzajp<V> zzajp, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzajy zzajy = new zzajy();
        zza(zzajy, zzajp);
        scheduledExecutorService.schedule(new zzajk(zzajy), j, timeUnit);
        zza(zzajp, zzajy);
        return zzajy;
    }

    public static <A, B> zzajp<B> zza(zzajp<A> zzajp, zzajb<? super A, ? extends B> zzajb, Executor executor) {
        zzajy zzajy = new zzajy();
        zzajp.zza(new zzajj(zzajy, zzajb, zzajp), executor);
        zza(zzajy, zzajp);
        return zzajy;
    }

    public static <A, B> zzajp<B> zza(zzajp<A> zzajp, zzajc<A, B> zzajc, Executor executor) {
        zzajy zzajy = new zzajy();
        zzajp.zza(new zzaji(zzajy, zzajc, zzajp), executor);
        zza(zzajy, zzajp);
        return zzajy;
    }

    public static <V, X extends Throwable> zzajp<V> zza(zzajp<? extends V> zzajp, Class<X> cls, zzajb<? super X, ? extends V> zzajb, Executor executor) {
        zzajy zzajy = new zzajy();
        zza(zzajy, zzajp);
        zzajp.zza(new zzajl(zzajy, zzajp, cls, zzajb, executor), zzaju.zzdcu);
        return zzajy;
    }

    public static <T> T zza(Future<T> future, T t) {
        try {
            return future.get(((Long) zzbs.zzep().zzd(zzmq.zzblr)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            future.cancel(true);
            zzafj.zzc("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            zzbs.zzeg().zza((Throwable) e, "Futures.resolveFuture");
            return t;
        } catch (Exception e2) {
            future.cancel(true);
            zzafj.zzb("Error waiting for future.", e2);
            zzbs.zzeg().zza((Throwable) e2, "Futures.resolveFuture");
            return t;
        }
    }

    public static <T> T zza(Future<T> future, T t, long j, TimeUnit timeUnit) {
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e) {
            future.cancel(true);
            zzafj.zzc("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            zzbs.zzeg().zza((Throwable) e, "Futures.resolveFuture");
            return t;
        } catch (Exception e2) {
            future.cancel(true);
            zzafj.zzb("Error waiting for future.", e2);
            zzbs.zzeg().zza((Throwable) e2, "Futures.resolveFuture");
            return t;
        }
    }

    public static <V> void zza(zzajp<V> zzajp, zzajd<V> zzajd, Executor executor) {
        zzajp.zza(new zzajh(zzajd, zzajp), executor);
    }

    private static <V> void zza(zzajp<? extends V> zzajp, zzajy<V> zzajy) {
        zza(zzajy, zzajp);
        zzajp.zza(new zzajm(zzajy, zzajp), zzaju.zzdcu);
    }

    private static <A, B> void zza(zzajp<A> zzajp, Future<B> future) {
        zzajp.zza(new zzajn(zzajp, future), zzaju.zzdcu);
    }

    static final /* synthetic */ void zza(zzajy zzajy, zzajb zzajb, zzajp zzajp) {
        if (!zzajy.isCancelled()) {
            try {
                zza(zzajb.zzc(zzajp.get()), zzajy);
            } catch (CancellationException e) {
                zzajy.cancel(true);
            } catch (ExecutionException e2) {
                zzajy.setException(e2.getCause());
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                zzajy.setException(e3);
            } catch (Exception e4) {
                zzajy.setException(e4);
            }
        }
    }

    static final /* synthetic */ void zza(zzajy zzajy, zzajp zzajp, Class cls, zzajb zzajb, Executor executor) {
        try {
            zzajy.set(zzajp.get());
            return;
        } catch (ExecutionException e) {
            e = e.getCause();
        } catch (InterruptedException e2) {
            e = e2;
            Thread.currentThread().interrupt();
        } catch (Exception e3) {
            e = e3;
        }
        if (cls.isInstance(e)) {
            zza(zza(zzi(e), zzajb, executor), zzajy);
        } else {
            zzajy.setException(e);
        }
    }

    public static <T> zzajo<T> zzi(T t) {
        return new zzajo<>(t);
    }
}
