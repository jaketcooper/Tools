package com.google.android.gms.internal;

import java.util.concurrent.Executor;

final /* synthetic */ class zzajl implements Runnable {
    private final zzajy zzbxh;
    private final zzajp zzdcf;
    private final Class zzdcj;
    private final zzajb zzdck;
    private final Executor zzdcl;

    zzajl(zzajy zzajy, zzajp zzajp, Class cls, zzajb zzajb, Executor executor) {
        this.zzbxh = zzajy;
        this.zzdcf = zzajp;
        this.zzdcj = cls;
        this.zzdck = zzajb;
        this.zzdcl = executor;
    }

    public final void run() {
        zzajg.zza(this.zzbxh, this.zzdcf, this.zzdcj, this.zzdck, this.zzdcl);
    }
}
