package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzckb;

public final class zzcjx<T extends Context & zzckb> {
    private final T zzdvw;

    public zzcjx(T t) {
        zzbq.checkNotNull(t);
        this.zzdvw = t;
    }

    private final zzcgj zzawn() {
        return zzchj.zzdu(this.zzdvw).zzawn();
    }

    private final void zzk(Runnable runnable) {
        zzchj zzdu = zzchj.zzdu(this.zzdvw);
        zzdu.zzawn();
        zzdu.zzawm().zzg(new zzcka(this, zzdu, runnable));
    }

    public static boolean zzk(Context context, boolean z) {
        zzbq.checkNotNull(context);
        return Build.VERSION.SDK_INT >= 24 ? zzckn.zzt(context, "com.google.android.gms.measurement.AppMeasurementJobService") : zzckn.zzt(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    @MainThread
    public final IBinder onBind(Intent intent) {
        if (intent == null) {
            zzawn().zzays().log("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzcho(zzchj.zzdu(this.zzdvw));
        }
        zzawn().zzayu().zzj("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public final void onCreate() {
        zzchj.zzdu(this.zzdvw).zzawn().zzayy().log("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void onDestroy() {
        zzchj.zzdu(this.zzdvw).zzawn().zzayy().log("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final void onRebind(Intent intent) {
        if (intent == null) {
            zzawn().zzays().log("onRebind called with null intent");
            return;
        }
        zzawn().zzayy().zzj("onRebind called. action", intent.getAction());
    }

    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        zzcgj zzawn = zzchj.zzdu(this.zzdvw).zzawn();
        if (intent == null) {
            zzawn.zzayu().log("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            zzawn.zzayy().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                zzk(new zzcjy(this, i2, zzawn, intent));
            }
        }
        return 2;
    }

    @TargetApi(24)
    @MainThread
    public final boolean onStartJob(JobParameters jobParameters) {
        zzcgj zzawn = zzchj.zzdu(this.zzdvw).zzawn();
        String string = jobParameters.getExtras().getString("action");
        zzawn.zzayy().zzj("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zzk(new zzcjz(this, zzawn, jobParameters));
        return true;
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        if (intent == null) {
            zzawn().zzays().log("onUnbind called with null intent");
        } else {
            zzawn().zzayy().zzj("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, zzcgj zzcgj, Intent intent) {
        if (((zzckb) this.zzdvw).callServiceStopSelfResult(i)) {
            zzcgj.zzayy().zzj("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzawn().zzayy().log("Completed wakeful intent.");
            ((zzckb) this.zzdvw).zzm(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzcgj zzcgj, JobParameters jobParameters) {
        zzcgj.zzayy().log("AppMeasurementJobService processed last upload request.");
        ((zzckb) this.zzdvw).zza(jobParameters, false);
    }
}
