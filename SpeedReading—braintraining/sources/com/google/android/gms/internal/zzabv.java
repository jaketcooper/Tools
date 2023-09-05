package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.p000v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.common.zzo;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;

public final class zzabv {
    private float zzaxd;
    private int zzclx;
    private int zzcly;
    private int zzcrt;
    private boolean zzcru;
    private boolean zzcrv;
    private String zzcrw;
    private String zzcrx;
    private boolean zzcry;
    private boolean zzcrz;
    private boolean zzcsa;
    private boolean zzcsb;
    private String zzcsc;
    private String zzcsd;
    private String zzcse;
    private int zzcsf;
    private int zzcsg;
    private int zzcsh;
    private int zzcsi;
    private int zzcsj;
    private int zzcsk;
    private double zzcsl;
    private boolean zzcsm;
    private boolean zzcsn;
    private int zzcso;
    private String zzcsp;
    private String zzcsq;
    private boolean zzcsr;

    public zzabv(Context context) {
        DisplayMetrics displayMetrics;
        boolean z = true;
        PackageManager packageManager = context.getPackageManager();
        zzm(context);
        zzn(context);
        zzo(context);
        Locale locale = Locale.getDefault();
        this.zzcru = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzcrv = zza(packageManager, "http://www.google.com") == null ? false : z;
        this.zzcrx = locale.getCountry();
        zzjk.zzhx();
        this.zzcry = zzais.zzqs();
        this.zzcrz = zzi.zzcr(context);
        this.zzcsc = locale.getLanguage();
        this.zzcsd = zzb(context, packageManager);
        this.zzcse = zza(context, packageManager);
        Resources resources = context.getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            this.zzaxd = displayMetrics.density;
            this.zzclx = displayMetrics.widthPixels;
            this.zzcly = displayMetrics.heightPixels;
        }
    }

    public zzabv(Context context, zzabu zzabu) {
        context.getPackageManager();
        zzm(context);
        zzn(context);
        zzo(context);
        this.zzcsp = Build.FINGERPRINT;
        this.zzcsq = Build.DEVICE;
        this.zzcsr = zzq.zzalw() && zznn.zzi(context);
        this.zzcru = zzabu.zzcru;
        this.zzcrv = zzabu.zzcrv;
        this.zzcrx = zzabu.zzcrx;
        this.zzcry = zzabu.zzcry;
        this.zzcrz = zzabu.zzcrz;
        this.zzcsc = zzabu.zzcsc;
        this.zzcsd = zzabu.zzcsd;
        this.zzcse = zzabu.zzcse;
        this.zzaxd = zzabu.zzaxd;
        this.zzclx = zzabu.zzclx;
        this.zzcly = zzabu.zzcly;
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzbs.zzeg().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    private static String zza(Context context, PackageManager packageManager) {
        try {
            PackageInfo packageInfo = zzbgc.zzcy(context).getPackageInfo(zzo.GOOGLE_PLAY_STORE_PACKAGE, 128);
            if (packageInfo == null) {
                return null;
            }
            int i = packageInfo.versionCode;
            String str = packageInfo.packageName;
            return new StringBuilder(String.valueOf(str).length() + 12).append(i).append(".").append(str).toString();
        } catch (Exception e) {
            return null;
        }
    }

    private static String zzb(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = zzbgc.zzcy(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo == null) {
                return null;
            }
            int i = packageInfo.versionCode;
            String str = activityInfo.packageName;
            return new StringBuilder(String.valueOf(str).length() + 12).append(i).append(".").append(str).toString();
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private final void zzm(Context context) {
        zzbs.zzec();
        AudioManager zzao = zzagr.zzao(context);
        if (zzao != null) {
            try {
                this.zzcrt = zzao.getMode();
                this.zzcsa = zzao.isMusicActive();
                this.zzcsb = zzao.isSpeakerphoneOn();
                this.zzcsf = zzao.getStreamVolume(3);
                this.zzcsj = zzao.getRingerMode();
                this.zzcsk = zzao.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzbs.zzeg().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzcrt = -2;
        this.zzcsa = false;
        this.zzcsb = false;
        this.zzcsf = 0;
        this.zzcsj = 0;
        this.zzcsk = 0;
    }

    @TargetApi(16)
    private final void zzn(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzcrw = telephonyManager.getNetworkOperator();
        this.zzcsh = telephonyManager.getNetworkType();
        this.zzcsi = telephonyManager.getPhoneType();
        this.zzcsg = -2;
        this.zzcsn = false;
        this.zzcso = -1;
        zzbs.zzec();
        if (zzagr.zzd(context, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.zzcsg = activeNetworkInfo.getType();
                this.zzcso = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.zzcsg = -1;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.zzcsn = connectivityManager.isActiveNetworkMetered();
            }
        }
    }

    private final void zzo(Context context) {
        boolean z = false;
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            this.zzcsl = (double) (((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.zzcsm = z;
            return;
        }
        this.zzcsl = -1.0d;
        this.zzcsm = false;
    }

    public final zzabu zzns() {
        return new zzabu(this.zzcrt, this.zzcru, this.zzcrv, this.zzcrw, this.zzcrx, this.zzcry, this.zzcrz, this.zzcsa, this.zzcsb, this.zzcsc, this.zzcsd, this.zzcse, this.zzcsf, this.zzcsg, this.zzcsh, this.zzcsi, this.zzcsj, this.zzcsk, this.zzaxd, this.zzclx, this.zzcly, this.zzcsl, this.zzcsm, this.zzcsn, this.zzcso, this.zzcsp, this.zzcsr, this.zzcsq);
    }
}
