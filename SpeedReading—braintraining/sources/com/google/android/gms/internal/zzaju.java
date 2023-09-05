package com.google.android.gms.internal;

import java.util.concurrent.Executor;

@zzzb
public final class zzaju {
    public static final Executor zzdct = new zzajv();
    public static final Executor zzdcu = new zzajw();
    private static zzajt zzdcv = zza(zzdct);
    private static zzajt zzdcw = zza(zzdcu);

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.zzajt, com.google.android.gms.internal.zzajx] */
    private static zzajt zza(Executor executor) {
        return new zzajx(executor, (zzajv) null);
    }
}
