package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzue extends zzed implements zzuc {
    zzue(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public final zzuf zzbf(String str) throws RemoteException {
        zzuf zzuh;
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        Parcel zza = zza(1, zzaz);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzuh = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            zzuh = queryLocalInterface instanceof zzuf ? (zzuf) queryLocalInterface : new zzuh(readStrongBinder);
        }
        zza.recycle();
        return zzuh;
    }

    public final boolean zzbg(String str) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        Parcel zza = zza(2, zzaz);
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }
}
