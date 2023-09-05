package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

final class zzahn implements Runnable {
    private /* synthetic */ zzahj zzczv;

    zzahn(zzahj zzahj) {
        this.zzczv = zzahj;
    }

    public final void run() {
        zzbs.zzel().zzg(this.zzczv.mContext, this.zzczv.zzaou, this.zzczv.zzaus);
    }
}
