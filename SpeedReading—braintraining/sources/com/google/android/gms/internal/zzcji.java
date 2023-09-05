package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.measurement.AppMeasurement;

final class zzcji implements Runnable {
    private /* synthetic */ zzcjd zzjfy;
    private /* synthetic */ AppMeasurement.zzb zzjga;

    zzcji(zzcjd zzcjd, AppMeasurement.zzb zzb) {
        this.zzjfy = zzcjd;
        this.zzjga = zzb;
    }

    public final void run() {
        zzcgb zzd = this.zzjfy.zzjfs;
        if (zzd == null) {
            this.zzjfy.zzawn().zzays().log("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zzjga == null) {
                zzd.zza(0, (String) null, (String) null, this.zzjfy.getContext().getPackageName());
            } else {
                zzd.zza(this.zzjga.zziub, this.zzjga.zzitz, this.zzjga.zziua, this.zzjfy.getContext().getPackageName());
            }
            this.zzjfy.zzxg();
        } catch (RemoteException e) {
            this.zzjfy.zzawn().zzays().zzj("Failed to send current screen to the service", e);
        }
    }
}
