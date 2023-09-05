package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.WorkerThread;
import android.support.p000v4.p002os.EnvironmentCompat;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzcc;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.zzo;
import com.google.firebase.iid.FirebaseInstanceId;
import java.math.BigInteger;
import java.util.Locale;

public final class zzcge extends zzcii {
    private String mAppId;
    private String zzcvg;
    private String zzdob;
    private String zzdoc;
    private String zziur;
    private long zziuv;
    private int zziyz;
    private long zziza;
    private int zzizb;

    zzcge(zzchj zzchj) {
        super(zzchj);
    }

    @WorkerThread
    private final String zzaws() {
        zzut();
        try {
            return FirebaseInstanceId.getInstance().getId();
        } catch (IllegalStateException e) {
            zzawn().zzayu().log("Failed to retrieve Firebase Instance Id");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String getAppId() {
        zzwu();
        return this.mAppId;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: package-private */
    public final String getGmpAppId() {
        zzwu();
        return this.zzcvg;
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
        return true;
    }

    /* access modifiers changed from: protected */
    public final void zzayn() {
        boolean z;
        int i = 1;
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        String str2 = "Unknown";
        int i2 = Integer.MIN_VALUE;
        String str3 = "Unknown";
        String packageName = getContext().getPackageName();
        PackageManager packageManager = getContext().getPackageManager();
        if (packageManager == null) {
            zzawn().zzays().zzj("PackageManager is null, app identity information might be inaccurate. appId", zzcgj.zzjf(packageName));
        } else {
            try {
                str = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException e) {
                zzawn().zzays().zzj("Error retrieving app installer package name. appId", zzcgj.zzjf(packageName));
            }
            if (str == null) {
                str = "manual_install";
            } else if (zzo.GOOGLE_PLAY_STORE_PACKAGE.equals(str)) {
                str = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        str3 = applicationLabel.toString();
                    }
                    str2 = packageInfo.versionName;
                    i2 = packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                zzawn().zzays().zze("Error retrieving package info. appId, appName", zzcgj.zzjf(packageName), str3);
            }
        }
        this.mAppId = packageName;
        this.zziur = str;
        this.zzdoc = str2;
        this.zziyz = i2;
        this.zzdob = str3;
        this.zziza = 0;
        Status zzci = zzcc.zzci(getContext());
        boolean z2 = zzci != null && zzci.isSuccess();
        if (!z2) {
            if (zzci == null) {
                zzawn().zzays().log("GoogleService failed to initialize (no status)");
            } else {
                zzawn().zzays().zze("GoogleService failed to initialize, status", Integer.valueOf(zzci.getStatusCode()), zzci.getStatusMessage());
            }
        }
        if (z2) {
            Boolean zzit = zzawp().zzit("firebase_analytics_collection_enabled");
            if (zzawp().zzaxp()) {
                zzawn().zzayw().log("Collection disabled with firebase_analytics_collection_deactivated=1");
                z = false;
            } else if (zzit != null && !zzit.booleanValue()) {
                zzawn().zzayw().log("Collection disabled with firebase_analytics_collection_enabled=0");
                z = false;
            } else if (zzit != null || !zzcc.zzaix()) {
                zzawn().zzayy().log("Collection enabled");
                z = true;
            } else {
                zzawn().zzayw().log("Collection disabled with google_app_measurement_enable=0");
                z = false;
            }
        } else {
            z = false;
        }
        this.zzcvg = "";
        this.zziuv = 0;
        try {
            String zzaiw = zzcc.zzaiw();
            if (TextUtils.isEmpty(zzaiw)) {
                zzaiw = "";
            }
            this.zzcvg = zzaiw;
            if (z) {
                zzawn().zzayy().zze("App package, google app id", this.mAppId, this.zzcvg);
            }
        } catch (IllegalStateException e3) {
            zzawn().zzays().zze("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzcgj.zzjf(packageName), e3);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (!zzbga.zzcw(getContext())) {
                i = 0;
            }
            this.zzizb = i;
            return;
        }
        this.zzizb = 0;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzayo() {
        byte[] bArr = new byte[16];
        zzawj().zzbao().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final int zzayp() {
        zzwu();
        return this.zziyz;
    }

    /* access modifiers changed from: package-private */
    public final int zzayq() {
        zzwu();
        return this.zzizb;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzcff zzjb(String str) {
        zzut();
        String appId = getAppId();
        String gmpAppId = getGmpAppId();
        zzwu();
        String str2 = this.zzdoc;
        long zzayp = (long) zzayp();
        zzwu();
        String str3 = this.zziur;
        zzwu();
        zzut();
        if (this.zziza == 0) {
            this.zziza = this.zzitu.zzawj().zzaf(getContext(), getContext().getPackageName());
        }
        long j = this.zziza;
        boolean isEnabled = this.zzitu.isEnabled();
        boolean z = !zzawo().zzjay;
        String zzaws = zzaws();
        zzwu();
        long zzazu = this.zzitu.zzazu();
        int zzayq = zzayq();
        Boolean zzit = zzawp().zzit("google_analytics_adid_collection_enabled");
        return new zzcff(appId, gmpAppId, str2, zzayp, str3, 11717, j, str, isEnabled, z, zzaws, 0, zzazu, zzayq, Boolean.valueOf(zzit == null || zzit.booleanValue()).booleanValue());
    }

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }
}
