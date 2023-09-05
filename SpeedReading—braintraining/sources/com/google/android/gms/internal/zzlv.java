package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzlv implements Runnable {
    private /* synthetic */ zzlu zzbfi;

    zzlv(zzlu zzlu) {
        this.zzbfi = zzlu;
    }

    public final void run() {
        if (this.zzbfi.zzbfh != null) {
            try {
                this.zzbfi.zzbfh.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaiw.zzc("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
