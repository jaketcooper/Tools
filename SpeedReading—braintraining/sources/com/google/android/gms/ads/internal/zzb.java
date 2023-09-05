package com.google.android.gms.ads.internal;

import android.os.Debug;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzmq;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

final class zzb extends TimerTask {
    private /* synthetic */ CountDownLatch zzamx;
    private /* synthetic */ Timer zzamy;
    private /* synthetic */ zza zzamz;

    zzb(zza zza, CountDownLatch countDownLatch, Timer timer) {
        this.zzamz = zza;
        this.zzamx = countDownLatch;
        this.zzamy = timer;
    }

    public final void run() {
        if (((long) ((Integer) zzbs.zzep().zzd(zzmq.zzbni)).intValue()) != this.zzamx.getCount()) {
            zzafj.zzbw("Stopping method tracing");
            Debug.stopMethodTracing();
            if (this.zzamx.getCount() == 0) {
                this.zzamy.cancel();
                return;
            }
        }
        String concat = String.valueOf(this.zzamz.zzamt.zzaif.getPackageName()).concat("_adsTrace_");
        try {
            zzafj.zzbw("Starting method tracing");
            this.zzamx.countDown();
            Debug.startMethodTracing(new StringBuilder(String.valueOf(concat).length() + 20).append(concat).append(zzbs.zzei().currentTimeMillis()).toString(), ((Integer) zzbs.zzep().zzd(zzmq.zzbnj)).intValue());
        } catch (Exception e) {
            zzafj.zzc("Exception occurred while starting method tracing.", e);
        }
    }
}
