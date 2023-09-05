package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzagv extends BroadcastReceiver {
    private /* synthetic */ zzagr zzczl;

    private zzagv(zzagr zzagr) {
        this.zzczl = zzagr;
    }

    /* synthetic */ zzagv(zzagr zzagr, zzags zzags) {
        this(zzagr);
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            boolean unused = this.zzczl.zzczf = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            boolean unused2 = this.zzczl.zzczf = false;
        }
    }
}
