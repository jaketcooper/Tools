package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzbs;

final class zzabj implements Runnable {
    private /* synthetic */ zzzz zzcpw;
    private /* synthetic */ zzaak zzcpx;
    private /* synthetic */ zzabh zzcpy;

    zzabj(zzabh zzabh, zzzz zzzz, zzaak zzaak) {
        this.zzcpy = zzabh;
        this.zzcpw = zzzz;
        this.zzcpx = zzaak;
    }

    public final void run() {
        zzaad zzaad;
        try {
            zzaad = this.zzcpy.zzb(this.zzcpw);
        } catch (Exception e) {
            zzbs.zzeg().zza((Throwable) e, "AdRequestServiceImpl.loadAdAsync");
            zzafj.zzc("Could not fetch ad response due to an Exception.", e);
            zzaad = null;
        }
        if (zzaad == null) {
            zzaad = new zzaad(0);
        }
        try {
            this.zzcpx.zza(zzaad);
        } catch (RemoteException e2) {
            zzafj.zzc("Fail to forward ad response.", e2);
        }
    }
}
