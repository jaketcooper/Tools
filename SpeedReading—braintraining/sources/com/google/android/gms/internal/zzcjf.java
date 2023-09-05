package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzcjf implements Runnable {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzcjd zzjfy;

    zzcjf(zzcjd zzcjd, zzcff zzcff) {
        this.zzjfy = zzcjd;
        this.zzjec = zzcff;
    }

    public final void run() {
        zzcgb zzd = this.zzjfy.zzjfs;
        if (zzd == null) {
            this.zzjfy.zzawn().zzays().log("Failed to reset data on the service; null service");
            return;
        }
        try {
            zzd.zzd(this.zzjec);
        } catch (RemoteException e) {
            this.zzjfy.zzawn().zzays().zzj("Failed to reset data on the service", e);
        }
        this.zzjfy.zzxg();
    }
}
