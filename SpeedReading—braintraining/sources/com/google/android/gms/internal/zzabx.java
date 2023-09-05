package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import java.util.concurrent.Callable;

final class zzabx implements Callable<zzabu> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzabw zzcst;

    zzabx(zzabw zzabw, Context context) {
        this.zzcst = zzabw;
        this.val$context = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzabu zzns;
        zzaby zzaby = (zzaby) this.zzcst.zzcss.get(this.val$context);
        if (zzaby != null) {
            if (!(zzaby.zzcsu + ((Long) zzbs.zzep().zzd(zzmq.zzblc)).longValue() < zzbs.zzei().currentTimeMillis())) {
                if (((Boolean) zzbs.zzep().zzd(zzmq.zzblb)).booleanValue()) {
                    zzns = new zzabv(this.val$context, zzaby.zzcsv).zzns();
                    this.zzcst.zzcss.put(this.val$context, new zzaby(this.zzcst, zzns));
                    return zzns;
                }
            }
        }
        zzns = new zzabv(this.val$context).zzns();
        this.zzcst.zzcss.put(this.val$context, new zzaby(this.zzcst, zzns));
        return zzns;
    }
}
