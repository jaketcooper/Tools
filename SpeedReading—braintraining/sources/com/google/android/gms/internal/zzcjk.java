package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzcjk implements Runnable {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzcjd zzjfy;

    zzcjk(zzcjd zzcjd, zzcff zzcff) {
        this.zzjfy = zzcjd;
        this.zzjec = zzcff;
    }

    public final void run() {
        zzcgb zzd = this.zzjfy.zzjfs;
        if (zzd == null) {
            this.zzjfy.zzawn().zzays().log("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzd.zzb(this.zzjec);
            this.zzjfy.zzxg();
        } catch (RemoteException e) {
            this.zzjfy.zzawn().zzays().zzj("Failed to send measurementEnabled to the service", e);
        }
    }
}
