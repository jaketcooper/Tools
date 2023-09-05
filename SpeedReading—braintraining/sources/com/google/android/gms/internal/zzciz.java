package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzciz extends zzcii {
    protected zzcjc zzjfc;
    private volatile AppMeasurement.zzb zzjfd;
    private AppMeasurement.zzb zzjfe;
    private long zzjff;
    private final Map<Activity, zzcjc> zzjfg = new ArrayMap();
    private final CopyOnWriteArrayList<AppMeasurement.zza> zzjfh = new CopyOnWriteArrayList<>();
    private boolean zzjfi;
    private AppMeasurement.zzb zzjfj;
    private String zzjfk;

    public zzciz(zzchj zzchj) {
        super(zzchj);
    }

    @MainThread
    private final void zza(Activity activity, zzcjc zzcjc, boolean z) {
        boolean z2;
        boolean z3 = true;
        AppMeasurement.zzb zzb = this.zzjfd != null ? this.zzjfd : (this.zzjfe == null || Math.abs(zzwh().elapsedRealtime() - this.zzjff) >= 1000) ? null : this.zzjfe;
        AppMeasurement.zzb zzb2 = zzb != null ? new AppMeasurement.zzb(zzb) : null;
        this.zzjfi = true;
        try {
            Iterator<AppMeasurement.zza> it = this.zzjfh.iterator();
            while (it.hasNext()) {
                try {
                    z3 &= it.next().zza(zzb2, zzcjc);
                } catch (Exception e) {
                    zzawn().zzays().zzj("onScreenChangeCallback threw exception", e);
                }
            }
            this.zzjfi = false;
            z2 = z3;
        } catch (Exception e2) {
            Exception exc = e2;
            z2 = z3;
            zzawn().zzays().zzj("onScreenChangeCallback loop threw exception", exc);
            this.zzjfi = false;
        } catch (Throwable th) {
            this.zzjfi = false;
            throw th;
        }
        AppMeasurement.zzb zzb3 = this.zzjfd == null ? this.zzjfe : this.zzjfd;
        if (z2) {
            if (zzcjc.zziua == null) {
                zzcjc.zziua = zzjt(activity.getClass().getCanonicalName());
            }
            zzcjc zzcjc2 = new zzcjc(zzcjc);
            this.zzjfe = this.zzjfd;
            this.zzjff = zzwh().elapsedRealtime();
            this.zzjfd = zzcjc2;
            zzawm().zzg(new zzcja(this, z, zzb3, zzcjc2));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(@NonNull zzcjc zzcjc) {
        zzavz().zzai(zzwh().elapsedRealtime());
        if (zzawl().zzbr(zzcjc.zzjfq)) {
            zzcjc.zzjfq = false;
        }
    }

    public static void zza(AppMeasurement.zzb zzb, Bundle bundle) {
        if (bundle != null && zzb != null && !bundle.containsKey("_sc")) {
            if (zzb.zzitz != null) {
                bundle.putString("_sn", zzb.zzitz);
            }
            bundle.putString("_sc", zzb.zziua);
            bundle.putLong("_si", zzb.zziub);
        }
    }

    private static String zzjt(String str) {
        String[] split = str.split("\\.");
        if (split.length == 0) {
            return str.substring(0, 36);
        }
        String str2 = split[split.length - 1];
        return str2.length() > 36 ? str2.substring(0, 36) : str2;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @MainThread
    public final void onActivityDestroyed(Activity activity) {
        this.zzjfg.remove(activity);
    }

    @MainThread
    public final void onActivityPaused(Activity activity) {
        zzcjc zzq = zzq(activity);
        this.zzjfe = this.zzjfd;
        this.zzjff = zzwh().elapsedRealtime();
        this.zzjfd = null;
        zzawm().zzg(new zzcjb(this, zzq));
    }

    @MainThread
    public final void onActivityResumed(Activity activity) {
        zza(activity, zzq(activity), false);
        zzcfa zzavz = zzavz();
        zzavz.zzawm().zzg(new zzcfd(zzavz, zzavz.zzwh().elapsedRealtime()));
    }

    @MainThread
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzcjc zzcjc;
        if (bundle != null && (zzcjc = this.zzjfg.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong(IdentityRealmObject.FIELD_ID, zzcjc.zziub);
            bundle2.putString("name", zzcjc.zzitz);
            bundle2.putString("referrer_name", zzcjc.zziua);
            bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
        }
    }

    @MainThread
    public final void registerOnScreenChangeCallback(@NonNull AppMeasurement.zza zza) {
        if (zza == null) {
            zzawn().zzayu().log("Attempting to register null OnScreenChangeCallback");
            return;
        }
        this.zzjfh.remove(zza);
        this.zzjfh.add(zza);
    }

    @MainThread
    public final void setCurrentScreen(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        if (activity == null) {
            zzawn().zzayu().log("setCurrentScreen must be called with a non-null activity");
            return;
        }
        zzawm();
        if (!zzche.zzas()) {
            zzawn().zzayu().log("setCurrentScreen must be called from the main thread");
        } else if (this.zzjfi) {
            zzawn().zzayu().log("Cannot call setCurrentScreen from onScreenChangeCallback");
        } else if (this.zzjfd == null) {
            zzawn().zzayu().log("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzjfg.get(activity) == null) {
            zzawn().zzayu().log("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zzjt(activity.getClass().getCanonicalName());
            }
            boolean equals = this.zzjfd.zziua.equals(str2);
            boolean zzas = zzckn.zzas(this.zzjfd.zzitz, str);
            if (equals && zzas) {
                zzawn().zzayv().log("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzawn().zzayu().zzj("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzawn().zzayy().zze("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzcjc zzcjc = new zzcjc(str, str2, zzawj().zzban());
                this.zzjfg.put(activity, zzcjc);
                zza(activity, zzcjc, true);
            } else {
                zzawn().zzayu().zzj("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    @MainThread
    public final void unregisterOnScreenChangeCallback(@NonNull AppMeasurement.zza zza) {
        this.zzjfh.remove(zza);
    }

    @WorkerThread
    public final void zza(String str, AppMeasurement.zzb zzb) {
        zzut();
        synchronized (this) {
            if (this.zzjfk == null || this.zzjfk.equals(str) || zzb != null) {
                this.zzjfk = str;
                this.zzjfj = zzb;
            }
        }
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
    public final zzcjc zzbad() {
        zzwu();
        zzut();
        return this.zzjfc;
    }

    public final AppMeasurement.zzb zzbae() {
        AppMeasurement.zzb zzb = this.zzjfd;
        if (zzb == null) {
            return null;
        }
        return new AppMeasurement.zzb(zzb);
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public final zzcjc zzq(@NonNull Activity activity) {
        zzbq.checkNotNull(activity);
        zzcjc zzcjc = this.zzjfg.get(activity);
        if (zzcjc != null) {
            return zzcjc;
        }
        zzcjc zzcjc2 = new zzcjc((String) null, zzjt(activity.getClass().getCanonicalName()), zzawj().zzban());
        this.zzjfg.put(activity, zzcjc2);
        return zzcjc2;
    }

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }
}
