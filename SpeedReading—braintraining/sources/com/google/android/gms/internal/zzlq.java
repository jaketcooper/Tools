package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzlq implements Runnable {
    private /* synthetic */ zzlp zzbfg;

    zzlq(zzlp zzlp) {
        this.zzbfg = zzlp;
    }

    public final void run() {
        if (this.zzbfg.zzaoj != null) {
            try {
                this.zzbfg.zzaoj.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaiw.zzc("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
