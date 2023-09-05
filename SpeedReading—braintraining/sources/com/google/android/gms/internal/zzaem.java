package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.Callable;

final /* synthetic */ class zzaem implements Callable {
    private final zzael zzcvm;
    private final Context zzcvn;

    zzaem(zzael zzael, Context context) {
        this.zzcvm = zzael;
        this.zzcvn = context;
    }

    public final Object call() {
        return this.zzcvm.zzab(this.zzcvn);
    }
}
