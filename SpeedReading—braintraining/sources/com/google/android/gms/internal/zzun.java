package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzun extends zzed implements zzul {
    zzun(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
    }

    public final int zzlw() throws RemoteException {
        Parcel zza = zza(1, zzaz());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
