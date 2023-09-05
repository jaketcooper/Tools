package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzsg implements Runnable {
    private /* synthetic */ zzsh zzbxo;
    private /* synthetic */ zzsi zzbxp;

    zzsg(zzrj zzrj, zzsh zzsh, zzsi zzsi) {
        this.zzbxo = zzsh;
        this.zzbxp = zzsi;
    }

    public final void run() {
        try {
            this.zzbxo.zzb(this.zzbxp);
        } catch (RemoteException e) {
            zzafj.zzc("Could not propagate interstitial ad event.", e);
        }
    }
}
