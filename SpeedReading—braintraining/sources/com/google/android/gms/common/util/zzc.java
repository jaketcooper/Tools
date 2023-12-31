package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzbgc;

public final class zzc {
    public static int zzx(Context context, String str) {
        Bundle bundle;
        PackageInfo zzy = zzy(context, str);
        if (zzy == null || zzy.applicationInfo == null || (bundle = zzy.applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    @Nullable
    private static PackageInfo zzy(Context context, String str) {
        try {
            return zzbgc.zzcy(context).getPackageInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static boolean zzz(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            return (zzbgc.zzcy(context).getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
