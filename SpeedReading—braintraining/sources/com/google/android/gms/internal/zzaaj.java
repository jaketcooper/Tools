package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzaaj extends zzed implements zzaah {
    zzaaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final void zza(zzaas zzaas, zzaan zzaan) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzaas);
        zzef.zza(zzaz, (IInterface) zzaan);
        zzb(4, zzaz);
    }

    public final void zza(zzzz zzzz, zzaak zzaak) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzzz);
        zzef.zza(zzaz, (IInterface) zzaak);
        zzb(2, zzaz);
    }

    public final zzaad zzb(zzzz zzzz) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzzz);
        Parcel zza = zza(1, zzaz);
        zzaad zzaad = (zzaad) zzef.zza(zza, zzaad.CREATOR);
        zza.recycle();
        return zzaad;
    }
}
