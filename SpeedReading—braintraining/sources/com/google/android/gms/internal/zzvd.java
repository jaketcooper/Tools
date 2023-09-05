package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzvd implements Runnable {
    private /* synthetic */ zzvc zzcei;

    zzvd(zzvc zzvc) {
        this.zzcei = zzvc;
    }

    public final void run() {
        try {
            this.zzcei.zzcea.onAdClicked();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdClicked.", e);
        }
    }
}
