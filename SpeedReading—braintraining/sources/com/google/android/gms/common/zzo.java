package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.C0555R;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzx;
import com.google.android.gms.internal.zzbgc;
import java.util.concurrent.atomic.AtomicBoolean;

public class zzo {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 11717000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    private static boolean zzfiz = false;
    private static boolean zzfja = false;
    private static boolean zzfjb = false;
    private static boolean zzfjc = false;
    static final AtomicBoolean zzfjd = new AtomicBoolean();
    private static final AtomicBoolean zzfje = new AtomicBoolean();

    zzo() {
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zze.zzafn().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.getStatusString(i);
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C0555R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !zzfje.get()) {
            int zzcn = zzbf.zzcn(context);
            if (zzcn == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (zzcn != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                throw new IllegalStateException(new StringBuilder(String.valueOf("com.google.android.gms.version").length() + 290).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but found ").append(zzcn).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append("com.google.android.gms.version").append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        }
        boolean z = !zzi.zzcq(context) && !zzi.zzcs(context);
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 8256);
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            zzp.zzcg(context);
            if (z) {
                zzg zza = zzp.zza(packageInfo, zzj.zzfiv);
                if (zza == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                    return 9;
                }
                if (zzp.zza(packageInfo2, zza) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else if (zzp.zza(packageInfo2, zzj.zzfiv) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (packageInfo2.versionCode / 1000 < GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000) {
                Log.w("GooglePlayServicesUtil", new StringBuilder(77).append("Google Play services out of date.  Requires ").append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but found ").append(packageInfo2.versionCode).toString());
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @TargetApi(19)
    @Deprecated
    public static boolean zzb(Context context, int i, String str) {
        return zzx.zzb(context, i, str);
    }

    @Deprecated
    public static void zzbn(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = zze.zzafn().isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            zze.zzafn();
            Intent zza = zze.zza(context, isGooglePlayServicesAvailable, "e");
            Log.e("GooglePlayServicesUtil", new StringBuilder(57).append("GooglePlayServices not available due to error ").append(isGooglePlayServicesAvailable).toString());
            if (zza == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", zza);
        }
    }

    @Deprecated
    public static void zzcc(Context context) {
        if (!zzfjd.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException e) {
            }
        }
    }

    @Deprecated
    public static int zzcd(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    public static boolean zzcf(Context context) {
        if (!zzfjc) {
            try {
                PackageInfo packageInfo = zzbgc.zzcy(context).getPackageInfo("com.google.android.gms", 64);
                if (packageInfo != null) {
                    zzp.zzcg(context);
                    if (zzp.zza(packageInfo, zzj.zzfiv[1]) != null) {
                        zzfjb = true;
                    }
                }
                zzfjb = false;
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
            } finally {
                zzfjc = true;
            }
        }
        return zzfjb || !"user".equals(Build.TYPE);
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zzv(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean zzf(Context context, int i) {
        return zzx.zzf(context, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        r0 = ((android.os.UserManager) r5.getSystemService("user")).getApplicationRestrictions(r5.getPackageName());
     */
    @android.annotation.TargetApi(21)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean zzv(android.content.Context r5, java.lang.String r6) {
        /*
            r1 = 1
            r2 = 0
            java.lang.String r0 = "com.google.android.gms"
            boolean r3 = r6.equals(r0)
            boolean r0 = com.google.android.gms.common.util.zzq.zzamc()
            if (r0 == 0) goto L_0x0039
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch:{ Exception -> 0x0036 }
            android.content.pm.PackageInstaller r0 = r0.getPackageInstaller()     // Catch:{ Exception -> 0x0036 }
            java.util.List r0 = r0.getAllSessions()     // Catch:{ Exception -> 0x0036 }
            java.util.Iterator r4 = r0.iterator()
        L_0x001e:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0039
            java.lang.Object r0 = r4.next()
            android.content.pm.PackageInstaller$SessionInfo r0 = (android.content.pm.PackageInstaller.SessionInfo) r0
            java.lang.String r0 = r0.getAppPackageName()
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x001e
            r0 = r1
        L_0x0035:
            return r0
        L_0x0036:
            r0 = move-exception
            r0 = r2
            goto L_0x0035
        L_0x0039:
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            r4 = 8192(0x2000, float:1.14794E-41)
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r6, r4)     // Catch:{ NameNotFoundException -> 0x007b }
            if (r3 == 0) goto L_0x0048
            boolean r0 = r0.enabled     // Catch:{ NameNotFoundException -> 0x007b }
            goto L_0x0035
        L_0x0048:
            boolean r0 = r0.enabled     // Catch:{ NameNotFoundException -> 0x007b }
            if (r0 == 0) goto L_0x0079
            boolean r0 = com.google.android.gms.common.util.zzq.zzalz()     // Catch:{ NameNotFoundException -> 0x007b }
            if (r0 == 0) goto L_0x0077
            java.lang.String r0 = "user"
            java.lang.Object r0 = r5.getSystemService(r0)     // Catch:{ NameNotFoundException -> 0x007b }
            android.os.UserManager r0 = (android.os.UserManager) r0     // Catch:{ NameNotFoundException -> 0x007b }
            java.lang.String r3 = r5.getPackageName()     // Catch:{ NameNotFoundException -> 0x007b }
            android.os.Bundle r0 = r0.getApplicationRestrictions(r3)     // Catch:{ NameNotFoundException -> 0x007b }
            if (r0 == 0) goto L_0x0077
            java.lang.String r3 = "true"
            java.lang.String r4 = "restricted_profile"
            java.lang.String r0 = r0.getString(r4)     // Catch:{ NameNotFoundException -> 0x007b }
            boolean r0 = r3.equals(r0)     // Catch:{ NameNotFoundException -> 0x007b }
            if (r0 == 0) goto L_0x0077
            r0 = r1
        L_0x0073:
            if (r0 != 0) goto L_0x0079
            r0 = r1
            goto L_0x0035
        L_0x0077:
            r0 = r2
            goto L_0x0073
        L_0x0079:
            r0 = r2
            goto L_0x0035
        L_0x007b:
            r0 = move-exception
            r0 = r2
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzo.zzv(android.content.Context, java.lang.String):boolean");
    }
}
