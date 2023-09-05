package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;

final class zzcjl implements Runnable {
    private /* synthetic */ String zziju;
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzcfx zzjeh;
    private /* synthetic */ zzcjd zzjfy;
    private /* synthetic */ boolean zzjgb = true;
    private /* synthetic */ boolean zzjgc;

    zzcjl(zzcjd zzcjd, boolean z, boolean z2, zzcfx zzcfx, zzcff zzcff, String str) {
        this.zzjfy = zzcjd;
        this.zzjgc = z2;
        this.zzjeh = zzcfx;
        this.zzjec = zzcff;
        this.zziju = str;
    }

    public final void run() {
        zzcgb zzd = this.zzjfy.zzjfs;
        if (zzd == null) {
            this.zzjfy.zzawn().zzays().log("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zzjgb) {
            this.zzjfy.zza(zzd, this.zzjgc ? null : this.zzjeh, this.zzjec);
        } else {
            try {
                if (TextUtils.isEmpty(this.zziju)) {
                    zzd.zza(this.zzjeh, this.zzjec);
                } else {
                    zzd.zza(this.zzjeh, this.zziju, this.zzjfy.zzawn().zzayz());
                }
            } catch (RemoteException e) {
                this.zzjfy.zzawn().zzays().zzj("Failed to send event to the service", e);
            }
        }
        this.zzjfy.zzxg();
    }
}
