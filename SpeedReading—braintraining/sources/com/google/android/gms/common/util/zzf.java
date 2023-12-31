package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;

public final class zzf {
    private static final String[] zzgbq = {"android.", "com.android.", "dalvik.", "java.", "javax."};
    private static DropBoxManager zzgbr = null;
    private static boolean zzgbs = false;
    private static int zzgbt = -1;
    private static int zzgbu = 0;

    public static boolean zza(Context context, Throwable th) {
        return zza(context, th, 0);
    }

    private static boolean zza(Context context, Throwable th, int i) {
        try {
            zzbq.checkNotNull(context);
            zzbq.checkNotNull(th);
        } catch (Exception e) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e);
        }
        return false;
    }
}
