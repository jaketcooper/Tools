package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzvj implements Runnable {
    private /* synthetic */ zzvc zzcei;

    zzvj(zzvc zzvc) {
        this.zzcei = zzvc;
    }

    public final void run() {
        try {
            this.zzcei.zzcea.onAdOpened();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdOpened.", e);
        }
    }
}
