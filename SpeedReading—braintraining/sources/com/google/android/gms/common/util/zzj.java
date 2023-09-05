package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import com.google.firebase.analytics.FirebaseAnalytics;

public final class zzj {
    private static IntentFilter zzgcb = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzgcc;
    private static float zzgcd = Float.NaN;

    @TargetApi(20)
    public static int zzct(Context context) {
        int i = 1;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, zzgcb);
        boolean z = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        int i2 = (zzq.zzamb() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 1 : 0) << 1;
        if (!z) {
            i = 0;
        }
        return i2 | i;
    }

    public static synchronized float zzcu(Context context) {
        float f;
        synchronized (zzj.class) {
            if (SystemClock.elapsedRealtime() - zzgcc >= 60000 || Float.isNaN(zzgcd)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, zzgcb);
                if (registerReceiver != null) {
                    zzgcd = ((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzgcc = SystemClock.elapsedRealtime();
                f = zzgcd;
            } else {
                f = zzgcd;
            }
        }
        return f;
    }
}
