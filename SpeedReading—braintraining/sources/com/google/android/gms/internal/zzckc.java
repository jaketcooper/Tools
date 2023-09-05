package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzckc extends zzcii {
    private Handler mHandler;
    private long zzjgr = zzwh().elapsedRealtime();
    private final zzcfp zzjgs = new zzckd(this, this.zzitu);
    private final zzcfp zzjgt = new zzcke(this, this.zzitu);

    zzckc(zzchj zzchj) {
        super(zzchj);
    }

    private final void zzbak() {
        synchronized (this) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzbal() {
        zzut();
        zzbr(false);
        zzavz().zzai(zzwh().elapsedRealtime());
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzbd(long j) {
        zzut();
        zzbak();
        this.zzjgs.cancel();
        this.zzjgt.cancel();
        zzawn().zzayy().zzj("Activity resumed, time", Long.valueOf(j));
        this.zzjgr = j;
        if (zzwh().currentTimeMillis() - zzawo().zzjau.get() > zzawo().zzjaw.get()) {
            zzawo().zzjav.set(true);
            zzawo().zzjax.set(0);
        }
        if (zzawo().zzjav.get()) {
            this.zzjgs.zzr(Math.max(0, zzawo().zzjat.get() - zzawo().zzjax.get()));
        } else {
            this.zzjgt.zzr(Math.max(0, 3600000 - zzawo().zzjax.get()));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzbe(long j) {
        zzut();
        zzbak();
        this.zzjgs.cancel();
        this.zzjgt.cancel();
        zzawn().zzayy().zzj("Activity paused, time", Long.valueOf(j));
        if (this.zzjgr != 0) {
            zzawo().zzjax.set(zzawo().zzjax.get() + (j - this.zzjgr));
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
        return false;
    }

    @WorkerThread
    public final boolean zzbr(boolean z) {
        zzut();
        zzwu();
        long elapsedRealtime = zzwh().elapsedRealtime();
        zzawo().zzjaw.set(zzwh().currentTimeMillis());
        long j = elapsedRealtime - this.zzjgr;
        if (z || j >= 1000) {
            zzawo().zzjax.set(j);
            zzawn().zzayy().zzj("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            zzciz.zza((AppMeasurement.zzb) zzawf().zzbad(), bundle);
            zzawb().zzc("auto", "_e", bundle);
            this.zzjgr = elapsedRealtime;
            this.zzjgt.cancel();
            this.zzjgt.zzr(Math.max(0, 3600000 - zzawo().zzjax.get()));
            return true;
        }
        zzawn().zzayy().zzj("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        return false;
    }

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }
}
