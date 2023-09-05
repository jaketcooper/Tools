package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzcjh implements Runnable {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzcjd zzjfy;

    zzcjh(zzcjd zzcjd, zzcff zzcff) {
        this.zzjfy = zzcjd;
        this.zzjec = zzcff;
    }

    public final void run() {
        zzcgb zzd = this.zzjfy.zzjfs;
        if (zzd == null) {
            this.zzjfy.zzawn().zzays().log("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzd.zza(this.zzjec);
            this.zzjfy.zza(zzd, (zzbej) null, this.zzjec);
            this.zzjfy.zzxg();
        } catch (RemoteException e) {
            this.zzjfy.zzawn().zzays().zzj("Failed to send app launch to the service", e);
        }
    }
}
