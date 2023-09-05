package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;

final class zzcjm implements Runnable {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzcjd zzjfy;
    private /* synthetic */ boolean zzjgb = true;
    private /* synthetic */ boolean zzjgc;
    private /* synthetic */ zzcfi zzjgd;
    private /* synthetic */ zzcfi zzjge;

    zzcjm(zzcjd zzcjd, boolean z, boolean z2, zzcfi zzcfi, zzcff zzcff, zzcfi zzcfi2) {
        this.zzjfy = zzcjd;
        this.zzjgc = z2;
        this.zzjgd = zzcfi;
        this.zzjec = zzcff;
        this.zzjge = zzcfi2;
    }

    public final void run() {
        zzcgb zzd = this.zzjfy.zzjfs;
        if (zzd == null) {
            this.zzjfy.zzawn().zzays().log("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zzjgb) {
            this.zzjfy.zza(zzd, this.zzjgc ? null : this.zzjgd, this.zzjec);
        } else {
            try {
                if (TextUtils.isEmpty(this.zzjge.packageName)) {
                    zzd.zza(this.zzjgd, this.zzjec);
                } else {
                    zzd.zzb(this.zzjgd);
                }
            } catch (RemoteException e) {
                this.zzjfy.zzawn().zzays().zzj("Failed to send conditional user property to the service", e);
            }
        }
        this.zzjfy.zzxg();
    }
}
