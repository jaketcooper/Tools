package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzkf extends zzed implements zzke {
    zzkf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder zza(IObjectWrapper iObjectWrapper, zziw zziw, String str, zzuc zzuc, int i, int i2) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (Parcelable) zziw);
        zzaz.writeString(str);
        zzef.zza(zzaz, (IInterface) zzuc);
        zzaz.writeInt(11717000);
        zzaz.writeInt(i2);
        Parcel zza = zza(2, zzaz);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }
}
