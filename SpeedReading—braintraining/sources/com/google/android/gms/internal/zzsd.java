package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzsd implements zzsh {
    private /* synthetic */ zzacn zzbxn;

    zzsd(zzry zzry, zzacn zzacn) {
        this.zzbxn = zzacn;
    }

    public final void zzb(zzsi zzsi) throws RemoteException {
        if (zzsi.zzbxt != null) {
            zzsi.zzbxt.zza(this.zzbxn);
        }
    }
}
