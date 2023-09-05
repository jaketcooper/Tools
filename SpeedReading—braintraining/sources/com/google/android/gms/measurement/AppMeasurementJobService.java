package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.support.annotation.MainThread;
import com.google.android.gms.internal.zzcjx;
import com.google.android.gms.internal.zzckb;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzckb {
    private zzcjx<AppMeasurementJobService> zziuf;

    private final zzcjx<AppMeasurementJobService> zzavw() {
        if (this.zziuf == null) {
            this.zziuf = new zzcjx<>(this);
        }
        return this.zziuf;
    }

    public final boolean callServiceStopSelfResult(int i) {
        throw new UnsupportedOperationException();
    }

    @MainThread
    public final void onCreate() {
        super.onCreate();
        zzavw().onCreate();
    }

    @MainThread
    public final void onDestroy() {
        zzavw().onDestroy();
        super.onDestroy();
    }

    @MainThread
    public final void onRebind(Intent intent) {
        zzavw().onRebind(intent);
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        return zzavw().onStartJob(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        return zzavw().onUnbind(intent);
    }

    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final void zzm(Intent intent) {
    }
}
