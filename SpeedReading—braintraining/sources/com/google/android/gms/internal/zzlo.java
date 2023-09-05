package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzlo implements Runnable {
    private /* synthetic */ zzln zzbff;

    zzlo(zzln zzln) {
        this.zzbff = zzln;
    }

    public final void run() {
        if (this.zzbff.zzbfe.zzaoj != null) {
            try {
                this.zzbff.zzbfe.zzaoj.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaiw.zzc("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
