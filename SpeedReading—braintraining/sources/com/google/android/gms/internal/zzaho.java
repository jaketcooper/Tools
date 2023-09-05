package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

final class zzaho implements Runnable {
    private /* synthetic */ zzahj zzczv;

    zzaho(zzahj zzahj) {
        this.zzczv = zzahj;
    }

    public final void run() {
        zzbs.zzel().zzh(this.zzczv.mContext, this.zzczv.zzaou, this.zzczv.zzaus);
    }
}
