package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzvg implements Runnable {
    private /* synthetic */ zzvc zzcei;

    zzvg(zzvc zzvc) {
        this.zzcei = zzvc;
    }

    public final void run() {
        try {
            this.zzcei.zzcea.onAdClosed();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdClosed.", e);
        }
    }
}
