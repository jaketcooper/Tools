package com.google.android.gms.internal;

import android.app.job.JobParameters;

final /* synthetic */ class zzcjz implements Runnable {
    private final zzcjx zzjgk;
    private final zzcgj zzjgo;
    private final JobParameters zzjgp;

    zzcjz(zzcjx zzcjx, zzcgj zzcgj, JobParameters jobParameters) {
        this.zzjgk = zzcjx;
        this.zzjgo = zzcgj;
        this.zzjgp = jobParameters;
    }

    public final void run() {
        this.zzjgk.zza(this.zzjgo, this.zzjgp);
    }
}
