package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Map;

public final class zzcfa extends zzcih {
    private final Map<String, Long> zziug = new ArrayMap();
    private final Map<String, Integer> zziuh = new ArrayMap();
    private long zziui;

    public zzcfa(zzchj zzchj) {
        super(zzchj);
    }

    @WorkerThread
    private final void zza(long j, AppMeasurement.zzb zzb) {
        if (zzb == null) {
            zzawn().zzayy().log("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            zzawn().zzayy().zzj("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzciz.zza(zzb, bundle);
            zzawb().zzc("am", "_xa", bundle);
        }
    }

    @WorkerThread
    private final void zza(String str, long j, AppMeasurement.zzb zzb) {
        if (zzb == null) {
            zzawn().zzayy().log("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            zzawn().zzayy().zzj("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzciz.zza(zzb, bundle);
            zzawb().zzc("am", "_xu", bundle);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzaj(long j) {
        for (String put : this.zziug.keySet()) {
            this.zziug.put(put, Long.valueOf(j));
        }
        if (!this.zziug.isEmpty()) {
            this.zziui = j;
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zze(String str, long j) {
        zzut();
        zzbq.zzgi(str);
        if (this.zziuh.isEmpty()) {
            this.zziui = j;
        }
        Integer num = this.zziuh.get(str);
        if (num != null) {
            this.zziuh.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.zziuh.size() >= 100) {
            zzawn().zzayu().log("Too many ads visible");
        } else {
            this.zziuh.put(str, 1);
            this.zziug.put(str, Long.valueOf(j));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzf(String str, long j) {
        zzut();
        zzbq.zzgi(str);
        Integer num = this.zziuh.get(str);
        if (num != null) {
            zzcjc zzbad = zzawf().zzbad();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.zziuh.remove(str);
                Long l = this.zziug.get(str);
                if (l == null) {
                    zzawn().zzays().log("First ad unit exposure time was never set");
                } else {
                    this.zziug.remove(str);
                    zza(str, j - l.longValue(), (AppMeasurement.zzb) zzbad);
                }
                if (!this.zziuh.isEmpty()) {
                    return;
                }
                if (this.zziui == 0) {
                    zzawn().zzays().log("First ad exposure time was never set");
                    return;
                }
                zza(j - this.zziui, (AppMeasurement.zzb) zzbad);
                this.zziui = 0;
                return;
            }
            this.zziuh.put(str, Integer.valueOf(intValue));
            return;
        }
        zzawn().zzays().zzj("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    public final void beginAdUnitExposure(String str) {
        if (str == null || str.length() == 0) {
            zzawn().zzays().log("Ad unit id must be a non-empty string");
            return;
        }
        zzawm().zzg(new zzcfb(this, str, zzwh().elapsedRealtime()));
    }

    public final void endAdUnitExposure(String str) {
        if (str == null || str.length() == 0) {
            zzawn().zzays().log("Ad unit id must be a non-empty string");
            return;
        }
        zzawm().zzg(new zzcfc(this, str, zzwh().elapsedRealtime()));
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final void zzai(long j) {
        zzcjc zzbad = zzawf().zzbad();
        for (String next : this.zziug.keySet()) {
            zza(next, j - this.zziug.get(next).longValue(), (AppMeasurement.zzb) zzbad);
        }
        if (!this.zziug.isEmpty()) {
            zza(j - this.zziui, (AppMeasurement.zzb) zzbad);
        }
        zzaj(j);
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

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }
}
