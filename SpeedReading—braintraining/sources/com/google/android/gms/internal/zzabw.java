package com.google.android.gms.internal;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@zzzb
public final class zzabw {
    /* access modifiers changed from: private */
    public WeakHashMap<Context, zzaby> zzcss = new WeakHashMap<>();

    public final Future<zzabu> zzp(Context context) {
        return zzagl.zza((ExecutorService) zzagl.zzcyx, new zzabx(this, context));
    }
}
