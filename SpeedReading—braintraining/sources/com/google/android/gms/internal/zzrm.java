package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzrm implements zzsh {
    private /* synthetic */ int zzbxk;

    zzrm(zzrk zzrk, int i) {
        this.zzbxk = i;
    }

    public final void zzb(zzsi zzsi) throws RemoteException {
        if (zzsi.zzaoj != null) {
            zzsi.zzaoj.onAdFailedToLoad(this.zzbxk);
        }
    }
}
