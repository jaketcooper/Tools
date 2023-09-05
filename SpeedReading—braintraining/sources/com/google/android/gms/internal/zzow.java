package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public final class zzow extends zzed implements zzou {
    zzow(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public final String getText() throws RemoteException {
        Parcel zza = zza(2, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final List<zzoy> zzjg() throws RemoteException {
        Parcel zza = zza(3, zzaz());
        ArrayList zzb = zzef.zzb(zza);
        zza.recycle();
        return zzb;
    }
}
