package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzpe extends zzed implements zzpc {
    zzpe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public final void destroy() throws RemoteException {
        zzb(4, zzaz());
    }

    public final void zza(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(3, zzaz);
    }

    public final IObjectWrapper zzak(String str) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        Parcel zza = zza(2, zzaz);
        IObjectWrapper zzap = IObjectWrapper.zza.zzap(zza.readStrongBinder());
        zza.recycle();
        return zzap;
    }

    public final void zzb(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzaz.writeInt(i);
        zzb(5, zzaz);
    }

    public final void zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(1, zzaz);
    }
}
