package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class zzchh<V> extends FutureTask<V> implements Comparable<zzchh> {
    private final String zzjce;
    private /* synthetic */ zzche zzjcf;
    private final long zzjcg = zzche.zzjcd.getAndIncrement();
    final boolean zzjch;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzchh(zzche zzche, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        this.zzjcf = zzche;
        zzbq.checkNotNull(str);
        this.zzjce = str;
        this.zzjch = false;
        if (this.zzjcg == Long.MAX_VALUE) {
            zzche.zzawn().zzays().log("Tasks index overflow");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzchh(zzche zzche, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzjcf = zzche;
        zzbq.checkNotNull(str);
        this.zzjce = str;
        this.zzjch = z;
        if (this.zzjcg == Long.MAX_VALUE) {
            zzche.zzawn().zzays().log("Tasks index overflow");
        }
    }

    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        zzchh zzchh = (zzchh) obj;
        if (this.zzjch != zzchh.zzjch) {
            return this.zzjch ? -1 : 1;
        }
        if (this.zzjcg < zzchh.zzjcg) {
            return -1;
        }
        if (this.zzjcg > zzchh.zzjcg) {
            return 1;
        }
        this.zzjcf.zzawn().zzayt().zzj("Two tasks share the same index. index", Long.valueOf(this.zzjcg));
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.zzjcf.zzawn().zzays().zzj(this.zzjce, th);
        if (th instanceof zzchf) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }
}
