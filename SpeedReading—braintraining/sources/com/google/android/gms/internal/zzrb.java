package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzrb extends zzed implements zzra {
    zzrb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final ParcelFileDescriptor zza(zzqw zzqw) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzqw);
        Parcel zza = zza(1, zzaz);
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzef.zza(zza, ParcelFileDescriptor.CREATOR);
        zza.recycle();
        return parcelFileDescriptor;
    }
}
