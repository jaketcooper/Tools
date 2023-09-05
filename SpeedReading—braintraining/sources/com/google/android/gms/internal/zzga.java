package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzga extends BroadcastReceiver {
    private /* synthetic */ zzfy zzaws;

    zzga(zzfy zzfy) {
        this.zzaws = zzfy;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzaws.zzm(3);
    }
}
