package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzvf implements Runnable {
    private /* synthetic */ zzvc zzcei;

    zzvf(zzvc zzvc) {
        this.zzcei = zzvc;
    }

    public final void run() {
        try {
            this.zzcei.zzcea.onAdLoaded();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLoaded.", e);
        }
    }
}
