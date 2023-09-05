package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzacx extends zzed implements zzacv {
    zzacx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public final void onRewardedVideoAdClosed() throws RemoteException {
        zzb(4, zzaz());
    }

    public final void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeInt(i);
        zzb(7, zzaz);
    }

    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        zzb(6, zzaz());
    }

    public final void onRewardedVideoAdLoaded() throws RemoteException {
        zzb(1, zzaz());
    }

    public final void onRewardedVideoAdOpened() throws RemoteException {
        zzb(2, zzaz());
    }

    public final void onRewardedVideoStarted() throws RemoteException {
        zzb(3, zzaz());
    }

    public final void zza(zzacn zzacn) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzacn);
        zzb(5, zzaz);
    }
}
