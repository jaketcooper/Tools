package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzvk implements Runnable {
    private /* synthetic */ zzvc zzcei;

    zzvk(zzvc zzvc) {
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
