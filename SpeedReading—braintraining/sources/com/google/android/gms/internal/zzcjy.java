package com.google.android.gms.internal;

import android.content.Intent;

final /* synthetic */ class zzcjy implements Runnable {
    private final zzcjx zzjgk;
    private final int zzjgl;
    private final zzcgj zzjgm;
    private final Intent zzjgn;

    zzcjy(zzcjx zzcjx, int i, zzcgj zzcgj, Intent intent) {
        this.zzjgk = zzcjx;
        this.zzjgl = i;
        this.zzjgm = zzcgj;
        this.zzjgn = intent;
    }

    public final void run() {
        this.zzjgk.zza(this.zzjgl, this.zzjgm, this.zzjgn);
    }
}
