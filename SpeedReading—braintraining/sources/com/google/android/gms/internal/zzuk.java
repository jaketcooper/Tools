package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzuk extends zzed implements zzui {
    zzuk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public final void onAdClicked() throws RemoteException {
        zzb(1, zzaz());
    }

    public final void onAdClosed() throws RemoteException {
        zzb(2, zzaz());
    }

    public final void onAdFailedToLoad(int i) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeInt(i);
        zzb(3, zzaz);
    }

    public final void onAdImpression() throws RemoteException {
        zzb(8, zzaz());
    }

    public final void onAdLeftApplication() throws RemoteException {
        zzb(4, zzaz());
    }

    public final void onAdLoaded() throws RemoteException {
        zzb(6, zzaz());
    }

    public final void onAdOpened() throws RemoteException {
        zzb(5, zzaz());
    }

    public final void onAppEvent(String str, String str2) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        zzaz.writeString(str2);
        zzb(9, zzaz);
    }

    public final void onVideoEnd() throws RemoteException {
        zzb(11, zzaz());
    }

    public final void zza(zzul zzul) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzul);
        zzb(7, zzaz);
    }

    public final void zzb(zzpu zzpu, String str) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzpu);
        zzaz.writeString(str);
        zzb(10, zzaz);
    }
}
