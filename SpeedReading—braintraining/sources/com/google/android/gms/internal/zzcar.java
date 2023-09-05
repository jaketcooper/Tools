package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzcar extends zzed implements zzcaq {
    zzcar(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzcao zza(zzcam zzcam) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzcam);
        Parcel zza = zza(1, zzaz);
        zzcao zzcao = (zzcao) zzef.zza(zza, zzcao.CREATOR);
        zza.recycle();
        return zzcao;
    }
}
