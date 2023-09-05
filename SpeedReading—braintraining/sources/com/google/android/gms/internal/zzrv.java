package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzrv implements zzsh {
    private /* synthetic */ zzng zzbxm;

    zzrv(zzru zzru, zzng zzng) {
        this.zzbxm = zzng;
    }

    public final void zzb(zzsi zzsi) throws RemoteException {
        if (zzsi.zzbxr != null) {
            zzsi.zzbxr.zza(this.zzbxm);
        }
    }
}
