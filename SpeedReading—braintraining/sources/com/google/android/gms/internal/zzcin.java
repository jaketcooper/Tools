package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

final class zzcin implements Runnable {
    private /* synthetic */ zzcik zzjer;
    private /* synthetic */ AppMeasurement.ConditionalUserProperty zzjes;

    zzcin(zzcik zzcik, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.zzjer = zzcik;
        this.zzjes = conditionalUserProperty;
    }

    public final void run() {
        this.zzjer.zzc(this.zzjes);
    }
}
