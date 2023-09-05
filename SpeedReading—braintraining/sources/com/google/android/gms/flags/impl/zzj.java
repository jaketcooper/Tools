package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzbzz;

public final class zzj {
    private static SharedPreferences zzhgt = null;

    public static SharedPreferences zzdf(Context context) throws Exception {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (zzhgt == null) {
                zzhgt = (SharedPreferences) zzbzz.zzb(new zzk(context));
            }
            sharedPreferences = zzhgt;
        }
        return sharedPreferences;
    }
}
