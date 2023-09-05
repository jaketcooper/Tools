package com.google.android.gms.internal;

import android.content.Intent;

final class zzckj extends zzcfp {
    private /* synthetic */ zzcki zzjgw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzckj(zzcki zzcki, zzchj zzchj) {
        super(zzchj);
        this.zzjgw = zzcki;
    }

    public final void run() {
        this.zzjgw.cancel();
        this.zzjgw.zzawn().zzayy().log("Sending upload intent from DelayedRunnable");
        Intent className = new Intent().setClassName(this.zzjgw.getContext(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        this.zzjgw.getContext().sendBroadcast(className);
    }
}
