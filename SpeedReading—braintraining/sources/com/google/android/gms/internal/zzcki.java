package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.p000v4.app.NotificationCompat;
import com.google.android.gms.common.util.zzd;

public final class zzcki extends zzcii {
    private final AlarmManager zzdsw = ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM));
    private Integer zzdsx;
    private final zzcfp zzjgv;

    protected zzcki(zzchj zzchj) {
        super(zzchj);
        this.zzjgv = new zzckj(this, zzchj);
    }

    private final int getJobId() {
        if (this.zzdsx == null) {
            String valueOf = String.valueOf(getContext().getPackageName());
            this.zzdsx = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.zzdsx.intValue();
    }

    @TargetApi(24)
    private final void zzbam() {
        zzawn().zzayy().zzj("Cancelling job. JobID", Integer.valueOf(getJobId()));
        ((JobScheduler) getContext().getSystemService("jobscheduler")).cancel(getJobId());
    }

    private final PendingIntent zzyu() {
        Intent className = new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(getContext(), 0, className, 0);
    }

    public final void cancel() {
        zzwu();
        this.zzdsw.cancel(zzyu());
        this.zzjgv.cancel();
        if (Build.VERSION.SDK_INT >= 24) {
            zzbam();
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ void zzavx() {
        super.zzavx();
    }

    public final /* bridge */ /* synthetic */ void zzavy() {
        super.zzavy();
    }

    public final /* bridge */ /* synthetic */ zzcfa zzavz() {
        return super.zzavz();
    }

    public final /* bridge */ /* synthetic */ zzcfh zzawa() {
        return super.zzawa();
    }

    public final /* bridge */ /* synthetic */ zzcik zzawb() {
        return super.zzawb();
    }

    public final /* bridge */ /* synthetic */ zzcge zzawc() {
        return super.zzawc();
    }

    public final /* bridge */ /* synthetic */ zzcfr zzawd() {
        return super.zzawd();
    }

    public final /* bridge */ /* synthetic */ zzcjd zzawe() {
        return super.zzawe();
    }

    public final /* bridge */ /* synthetic */ zzciz zzawf() {
        return super.zzawf();
    }

    public final /* bridge */ /* synthetic */ zzcgf zzawg() {
        return super.zzawg();
    }

    public final /* bridge */ /* synthetic */ zzcfl zzawh() {
        return super.zzawh();
    }

    public final /* bridge */ /* synthetic */ zzcgh zzawi() {
        return super.zzawi();
    }

    public final /* bridge */ /* synthetic */ zzckn zzawj() {
        return super.zzawj();
    }

    public final /* bridge */ /* synthetic */ zzchd zzawk() {
        return super.zzawk();
    }

    public final /* bridge */ /* synthetic */ zzckc zzawl() {
        return super.zzawl();
    }

    public final /* bridge */ /* synthetic */ zzche zzawm() {
        return super.zzawm();
    }

    public final /* bridge */ /* synthetic */ zzcgj zzawn() {
        return super.zzawn();
    }

    public final /* bridge */ /* synthetic */ zzcgu zzawo() {
        return super.zzawo();
    }

    public final /* bridge */ /* synthetic */ zzcfk zzawp() {
        return super.zzawp();
    }

    /* access modifiers changed from: protected */
    public final boolean zzaxo() {
        this.zzdsw.cancel(zzyu());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        zzbam();
        return false;
    }

    public final void zzr(long j) {
        zzwu();
        if (!zzcha.zzbi(getContext())) {
            zzawn().zzayx().log("Receiver not registered/enabled");
        }
        if (!zzcjx.zzk(getContext(), false)) {
            zzawn().zzayx().log("Service not registered/enabled");
        }
        cancel();
        long elapsedRealtime = zzwh().elapsedRealtime() + j;
        if (j < Math.max(0, zzcfz.zziyp.get().longValue()) && !this.zzjgv.zzdr()) {
            zzawn().zzayy().log("Scheduling upload with DelayedRunnable");
            this.zzjgv.zzr(j);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            zzawn().zzayy().log("Scheduling upload with JobScheduler");
            JobInfo.Builder builder = new JobInfo.Builder(getJobId(), new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementJobService"));
            builder.setMinimumLatency(j);
            builder.setOverrideDeadline(j << 1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            builder.setExtras(persistableBundle);
            JobInfo build = builder.build();
            zzawn().zzayy().zzj("Scheduling job. JobID", Integer.valueOf(getJobId()));
            ((JobScheduler) getContext().getSystemService("jobscheduler")).schedule(build);
            return;
        }
        zzawn().zzayy().log("Scheduling upload with AlarmManager");
        this.zzdsw.setInexactRepeating(2, elapsedRealtime, Math.max(zzcfz.zziyk.get().longValue(), j), zzyu());
    }

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }
}
