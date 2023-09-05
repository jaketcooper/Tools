package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzvn implements Runnable {
    private /* synthetic */ zzvc zzcei;

    zzvn(zzvc zzvc) {
        this.zzcei = zzvc;
    }

    public final void run() {
        try {
            this.zzcei.zzcea.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLeftApplication.", e);
        }
    }
}
