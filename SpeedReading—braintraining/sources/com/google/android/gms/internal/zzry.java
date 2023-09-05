package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzry extends zzacw {
    private /* synthetic */ zzrj zzbxj;

    zzry(zzrj zzrj) {
        this.zzbxj = zzrj;
    }

    public final void onRewardedVideoAdClosed() throws RemoteException {
        this.zzbxj.zzaof.add(new zzsc(this));
    }

    public final void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
        this.zzbxj.zzaof.add(new zzsf(this, i));
    }

    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        this.zzbxj.zzaof.add(new zzse(this));
    }

    public final void onRewardedVideoAdLoaded() throws RemoteException {
        this.zzbxj.zzaof.add(new zzrz(this));
    }

    public final void onRewardedVideoAdOpened() throws RemoteException {
        this.zzbxj.zzaof.add(new zzsa(this));
    }

    public final void onRewardedVideoStarted() throws RemoteException {
        this.zzbxj.zzaof.add(new zzsb(this));
    }

    public final void zza(zzacn zzacn) throws RemoteException {
        this.zzbxj.zzaof.add(new zzsd(this, zzacn));
    }
}
