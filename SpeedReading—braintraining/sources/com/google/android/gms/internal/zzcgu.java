package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

final class zzcgu extends zzcii {
    static final Pair<String, Long> zzjae = new Pair<>("", 0L);
    private SharedPreferences zzdvp;
    public final zzcgy zzjaf = new zzcgy(this, "health_monitor", Math.max(0, zzcfz.zzixu.get().longValue()));
    public final zzcgx zzjag = new zzcgx(this, "last_upload", 0);
    public final zzcgx zzjah = new zzcgx(this, "last_upload_attempt", 0);
    public final zzcgx zzjai = new zzcgx(this, "backoff", 0);
    public final zzcgx zzjaj = new zzcgx(this, "last_delete_stale", 0);
    public final zzcgx zzjak = new zzcgx(this, "midnight_offset", 0);
    public final zzcgx zzjal = new zzcgx(this, "first_open_time", 0);
    public final zzcgz zzjam = new zzcgz(this, "app_instance_id", (String) null);
    private String zzjan;
    private boolean zzjao;
    private long zzjap;
    private String zzjaq;
    private long zzjar;
    private final Object zzjas = new Object();
    public final zzcgx zzjat = new zzcgx(this, "time_before_start", 10000);
    public final zzcgx zzjau = new zzcgx(this, "session_timeout", 1800000);
    public final zzcgw zzjav = new zzcgw(this, "start_new_session", true);
    public final zzcgx zzjaw = new zzcgx(this, "last_pause_time", 0);
    public final zzcgx zzjax = new zzcgx(this, "time_active", 0);
    public boolean zzjay;

    zzcgu(zzchj zzchj) {
        super(zzchj);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final SharedPreferences zzaza() {
        zzut();
        zzwu();
        return this.zzdvp;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void setMeasurementEnabled(boolean z) {
        zzut();
        zzawn().zzayy().zzj("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzaza().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public final boolean zzaxo() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void zzayn() {
        this.zzdvp = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzjay = this.zzdvp.getBoolean("has_been_opened", false);
        if (!this.zzjay) {
            SharedPreferences.Editor edit = this.zzdvp.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzazb() {
        zzut();
        return zzaza().getString("gmp_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    public final String zzazc() {
        String str;
        synchronized (this.zzjas) {
            str = Math.abs(zzwh().elapsedRealtime() - this.zzjar) < 1000 ? this.zzjaq : null;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean zzazd() {
        zzut();
        if (!zzaza().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzaza().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzaze() {
        boolean z = true;
        zzut();
        zzawn().zzayy().log("Clearing collection preferences.");
        boolean contains = zzaza().contains("measurement_enabled");
        if (contains) {
            z = zzbm(true);
        }
        SharedPreferences.Editor edit = zzaza().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            setMeasurementEnabled(z);
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzazf() {
        zzut();
        String string = zzaza().getString("previous_os_version", (String) null);
        zzawd().zzwu();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzaza().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzbl(boolean z) {
        zzut();
        zzawn().zzayy().zzj("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzaza().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzbm(boolean z) {
        zzut();
        return zzaza().getBoolean("measurement_enabled", z);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @NonNull
    public final Pair<String, Boolean> zzjh(String str) {
        zzut();
        long elapsedRealtime = zzwh().elapsedRealtime();
        if (this.zzjan != null && elapsedRealtime < this.zzjap) {
            return new Pair<>(this.zzjan, Boolean.valueOf(this.zzjao));
        }
        this.zzjap = elapsedRealtime + zzawp().zza(str, zzcfz.zzixt);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            if (advertisingIdInfo != null) {
                this.zzjan = advertisingIdInfo.getId();
                this.zzjao = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzjan == null) {
                this.zzjan = "";
            }
        } catch (Throwable th) {
            zzawn().zzayx().zzj("Unable to get advertising id", th);
            this.zzjan = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzjan, Boolean.valueOf(this.zzjao));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzji(String str) {
        zzut();
        String str2 = (String) zzjh(str).first;
        MessageDigest zzed = zzckn.zzed("MD5");
        if (zzed == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzed.digest(str2.getBytes()))});
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzjj(String str) {
        zzut();
        SharedPreferences.Editor edit = zzaza().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zzjk(String str) {
        synchronized (this.zzjas) {
            this.zzjaq = str;
            this.zzjar = zzwh().elapsedRealtime();
        }
    }
}
