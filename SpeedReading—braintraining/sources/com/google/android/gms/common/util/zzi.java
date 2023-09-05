package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;

public final class zzi {
    private static Boolean zzgbw;
    private static Boolean zzgbx;
    private static Boolean zzgby;
    private static Boolean zzgbz;
    private static Boolean zzgca;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (zzgbx.booleanValue() != false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(android.content.res.Resources r5) {
        /*
            r4 = 3
            r1 = 1
            r2 = 0
            if (r5 != 0) goto L_0x0006
        L_0x0005:
            return r2
        L_0x0006:
            java.lang.Boolean r0 = zzgbw
            if (r0 != 0) goto L_0x0041
            android.content.res.Configuration r0 = r5.getConfiguration()
            int r0 = r0.screenLayout
            r0 = r0 & 15
            if (r0 <= r4) goto L_0x0048
            r0 = r1
        L_0x0015:
            if (r0 != 0) goto L_0x003a
            java.lang.Boolean r0 = zzgbx
            if (r0 != 0) goto L_0x0032
            android.content.res.Configuration r0 = r5.getConfiguration()
            int r3 = r0.screenLayout
            r3 = r3 & 15
            if (r3 > r4) goto L_0x004a
            int r0 = r0.smallestScreenWidthDp
            r3 = 600(0x258, float:8.41E-43)
            if (r0 < r3) goto L_0x004a
            r0 = r1
        L_0x002c:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            zzgbx = r0
        L_0x0032:
            java.lang.Boolean r0 = zzgbx
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x003b
        L_0x003a:
            r2 = r1
        L_0x003b:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            zzgbw = r0
        L_0x0041:
            java.lang.Boolean r0 = zzgbw
            boolean r2 = r0.booleanValue()
            goto L_0x0005
        L_0x0048:
            r0 = r2
            goto L_0x0015
        L_0x004a:
            r0 = r2
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzi.zza(android.content.res.Resources):boolean");
    }

    @TargetApi(20)
    public static boolean zzcp(Context context) {
        if (zzgby == null) {
            zzgby = Boolean.valueOf(zzq.zzamb() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return zzgby.booleanValue();
    }

    @TargetApi(24)
    public static boolean zzcq(Context context) {
        return (!zzq.isAtLeastN() || zzcr(context)) && zzcp(context);
    }

    @TargetApi(21)
    public static boolean zzcr(Context context) {
        if (zzgbz == null) {
            zzgbz = Boolean.valueOf(zzq.zzamc() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzgbz.booleanValue();
    }

    public static boolean zzcs(Context context) {
        if (zzgca == null) {
            zzgca = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return zzgca.booleanValue();
    }
}
