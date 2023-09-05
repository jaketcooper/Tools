package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzrq implements zzsh {
    zzrq(zzrk zzrk) {
    }

    public final void zzb(zzsi zzsi) throws RemoteException {
        if (zzsi.zzaoj != null) {
            zzsi.zzaoj.onAdImpression();
        }
    }
}
