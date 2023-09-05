package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzak;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzbgc;
import com.safonov.speedreading.training.fragment.schultetable.training.view.SchulteTableFragment;

public class zze {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzo.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final zze zzfin = new zze();

    zze() {
    }

    @Nullable
    public static Intent zza(Context context, int i, @Nullable String str) {
        switch (i) {
            case 1:
            case 2:
                return (context == null || !zzi.zzcq(context)) ? zzak.zzt("com.google.android.gms", zzu(context, str)) : zzak.zzalc();
            case 3:
                return zzak.zzgg("com.google.android.gms");
            default:
                return null;
        }
    }

    public static zze zzafn() {
        return zzfin;
    }

    public static void zzcb(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzo.zzbn(context);
    }

    public static void zzcc(Context context) {
        zzo.zzcc(context);
    }

    public static int zzcd(Context context) {
        return zzo.zzcd(context);
    }

    public static boolean zze(Context context, int i) {
        return zzo.zze(context, i);
    }

    private static String zzu(@Nullable Context context, @Nullable String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        sb.append(SchulteTableFragment.NON_INITIALIZATION_VALUE);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(SchulteTableFragment.NON_INITIALIZATION_VALUE);
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append(SchulteTableFragment.NON_INITIALIZATION_VALUE);
        if (context != null) {
            try {
                sb.append(zzbgc.zzcy(context).getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return sb.toString();
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2) {
        return zza(context, i, i2, (String) null);
    }

    public String getErrorString(int i) {
        return zzo.getErrorString(i);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        int isGooglePlayServicesAvailable = zzo.isGooglePlayServicesAvailable(context);
        if (zzo.zze(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }

    public boolean isUserResolvableError(int i) {
        return zzo.isUserRecoverableError(i);
    }

    @Nullable
    public final PendingIntent zza(Context context, int i, int i2, @Nullable String str) {
        Intent zza = zza(context, i, str);
        if (zza == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, zza, 268435456);
    }

    @Nullable
    @Deprecated
    public final Intent zzbq(int i) {
        return zza((Context) null, i, (String) null);
    }
}
