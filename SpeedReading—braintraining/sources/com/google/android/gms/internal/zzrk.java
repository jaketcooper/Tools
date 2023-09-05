package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzrk extends zzjr {
    private /* synthetic */ zzrj zzbxj;

    zzrk(zzrj zzrj) {
        this.zzbxj = zzrj;
    }

    public final void onAdClicked() throws RemoteException {
        this.zzbxj.zzaof.add(new zzrr(this));
    }

    public final void onAdClosed() throws RemoteException {
        this.zzbxj.zzaof.add(new zzrl(this));
    }

    public final void onAdFailedToLoad(int i) throws RemoteException {
        this.zzbxj.zzaof.add(new zzrm(this, i));
        zzafj.m11v("Pooled interstitial failed to load.");
    }

    public final void onAdImpression() throws RemoteException {
        this.zzbxj.zzaof.add(new zzrq(this));
    }

    public final void onAdLeftApplication() throws RemoteException {
        this.zzbxj.zzaof.add(new zzrn(this));
    }

    public final void onAdLoaded() throws RemoteException {
        this.zzbxj.zzaof.add(new zzro(this));
        zzafj.m11v("Pooled interstitial loaded.");
    }

    public final void onAdOpened() throws RemoteException {
        this.zzbxj.zzaof.add(new zzrp(this));
    }
}
