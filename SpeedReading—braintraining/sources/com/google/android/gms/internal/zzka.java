package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzka extends zzed implements zzjz {
    zzka(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
    }

    public final IBinder zza(IObjectWrapper iObjectWrapper, String str, zzuc zzuc, int i) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzaz.writeString(str);
        zzef.zza(zzaz, (IInterface) zzuc);
        zzaz.writeInt(11717000);
        Parcel zza = zza(1, zzaz);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }
}
