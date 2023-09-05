package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zzq;

public final class zzbga {
    private static Context zzgcu;
    private static Boolean zzgcv;

    public static synchronized boolean zzcw(Context context) {
        boolean booleanValue;
        synchronized (zzbga.class) {
            Context applicationContext = context.getApplicationContext();
            if (zzgcu == null || zzgcv == null || zzgcu != applicationContext) {
                zzgcv = null;
                if (zzq.isAtLeastO()) {
                    zzgcv = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzgcv = true;
                    } catch (ClassNotFoundException e) {
                        zzgcv = false;
                    }
                }
                zzgcu = applicationContext;
                booleanValue = zzgcv.booleanValue();
            } else {
                booleanValue = zzgcv.booleanValue();
            }
        }
        return booleanValue;
    }
}
