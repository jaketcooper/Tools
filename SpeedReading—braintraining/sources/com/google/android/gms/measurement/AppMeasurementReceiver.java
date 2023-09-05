package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.p000v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.zzcha;
import com.google.android.gms.internal.zzchc;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzchc {
    private zzcha zziue;

    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    @MainThread
    public final void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    @MainThread
    public final void onReceive(Context context, Intent intent) {
        if (this.zziue == null) {
            this.zziue = new zzcha(this);
        }
        this.zziue.onReceive(context, intent);
    }
}
