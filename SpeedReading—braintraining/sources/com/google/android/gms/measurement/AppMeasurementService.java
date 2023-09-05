package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.internal.zzcjx;
import com.google.android.gms.internal.zzckb;

public final class AppMeasurementService extends Service implements zzckb {
    private zzcjx<AppMeasurementService> zziuf;

    private final zzcjx<AppMeasurementService> zzavw() {
        if (this.zziuf == null) {
            this.zziuf = new zzcjx<>(this);
        }
        return this.zziuf;
    }

    public final boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    @MainThread
    public final IBinder onBind(Intent intent) {
        return zzavw().onBind(intent);
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

    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        return zzavw().onStartCommand(intent, i, i2);
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        return zzavw().onUnbind(intent);
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zzm(Intent intent) {
        AppMeasurementReceiver.completeWakefulIntent(intent);
    }
}
