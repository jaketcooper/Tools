package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzjv extends zzed implements zzjt {
    zzjv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(2, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final boolean isLoading() throws RemoteException {
        Parcel zza = zza(3, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zza(zzis zzis, int i) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzis);
        zzaz.writeInt(i);
        zzb(5, zzaz);
    }

    public final String zzcj() throws RemoteException {
        Parcel zza = zza(4, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zzd(zzis zzis) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzis);
        zzb(1, zzaz);
    }
}
