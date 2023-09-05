package com.google.android.gms.internal;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzpa extends zzed implements zzoy {
    zzpa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public final double getScale() throws RemoteException {
        Parcel zza = zza(3, zzaz());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    public final Uri getUri() throws RemoteException {
        Parcel zza = zza(2, zzaz());
        Uri uri = (Uri) zzef.zza(zza, Uri.CREATOR);
        zza.recycle();
        return uri;
    }

    public final IObjectWrapper zzjl() throws RemoteException {
        Parcel zza = zza(1, zzaz());
        IObjectWrapper zzap = IObjectWrapper.zza.zzap(zza.readStrongBinder());
        zza.recycle();
        return zzap;
    }
}
