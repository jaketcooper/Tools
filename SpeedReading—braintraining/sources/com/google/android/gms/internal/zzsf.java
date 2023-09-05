package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzsf implements zzsh {
    private /* synthetic */ int zzbxk;

    zzsf(zzry zzry, int i) {
        this.zzbxk = i;
    }

    public final void zzb(zzsi zzsi) throws RemoteException {
        if (zzsi.zzbxt != null) {
            zzsi.zzbxt.onRewardedVideoAdFailedToLoad(this.zzbxk);
        }
    }
}
