package com.google.android.gms.internal;

import android.content.ComponentName;

final class zzcjv implements Runnable {
    private /* synthetic */ zzcjr zzjgi;

    zzcjv(zzcjr zzcjr) {
        this.zzjgi = zzcjr;
    }

    public final void run() {
        this.zzjgi.zzjfy.onServiceDisconnected(new ComponentName(this.zzjgi.zzjfy.getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
