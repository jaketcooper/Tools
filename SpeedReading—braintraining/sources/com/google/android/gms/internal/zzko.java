package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzko extends zzed implements zzkm {
    zzko(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
    }

    public final long getValue() throws RemoteException {
        Parcel zza = zza(1, zzaz());
        long readLong = zza.readLong();
        zza.recycle();
        return readLong;
    }
}
