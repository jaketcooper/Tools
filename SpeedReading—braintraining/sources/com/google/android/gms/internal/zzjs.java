package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzjs extends zzed implements zzjq {
    zzjs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final void onAdClicked() throws RemoteException {
        zzb(6, zzaz());
    }

    public final void onAdClosed() throws RemoteException {
        zzb(1, zzaz());
    }

    public final void onAdFailedToLoad(int i) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeInt(i);
        zzb(2, zzaz);
    }

    public final void onAdImpression() throws RemoteException {
        zzb(7, zzaz());
    }

    public final void onAdLeftApplication() throws RemoteException {
        zzb(3, zzaz());
    }

    public final void onAdLoaded() throws RemoteException {
        zzb(4, zzaz());
    }

    public final void onAdOpened() throws RemoteException {
        zzb(5, zzaz());
    }
}
