package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzhy extends zzed implements zzhx {
    zzhy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zzhr zza(zzhu zzhu) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzhu);
        Parcel zza = zza(1, zzaz);
        zzhr zzhr = (zzhr) zzef.zza(zza, zzhr.CREATOR);
        zza.recycle();
        return zzhr;
    }
}
