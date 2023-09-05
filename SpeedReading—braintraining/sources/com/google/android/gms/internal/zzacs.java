package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzacs extends zzed implements zzacq {
    zzacs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public final void destroy() throws RemoteException {
        zzb(8, zzaz());
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(12, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final boolean isLoaded() throws RemoteException {
        Parcel zza = zza(5, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void pause() throws RemoteException {
        zzb(6, zzaz());
    }

    public final void resume() throws RemoteException {
        zzb(7, zzaz());
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, z);
        zzb(34, zzaz);
    }

    public final void setUserId(String str) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        zzb(13, zzaz);
    }

    public final void show() throws RemoteException {
        zzb(2, zzaz());
    }

    public final void zza(zzacv zzacv) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzacv);
        zzb(3, zzaz);
    }

    public final void zza(zzadb zzadb) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzadb);
        zzb(1, zzaz);
    }

    public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(9, zzaz);
    }

    public final void zzc(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(10, zzaz);
    }

    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(11, zzaz);
    }
}
