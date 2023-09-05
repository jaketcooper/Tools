package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzuq extends zzed implements zzuo {
    zzuq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    public final String getBody() throws RemoteException {
        Parcel zza = zza(4, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final String getCallToAction() throws RemoteException {
        Parcel zza = zza(6, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final Bundle getExtras() throws RemoteException {
        Parcel zza = zza(15, zzaz());
        Bundle bundle = (Bundle) zzef.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final String getHeadline() throws RemoteException {
        Parcel zza = zza(2, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final List getImages() throws RemoteException {
        Parcel zza = zza(3, zzaz());
        ArrayList zzb = zzef.zzb(zza);
        zza.recycle();
        return zzb;
    }

    public final boolean getOverrideClickHandling() throws RemoteException {
        Parcel zza = zza(14, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean getOverrideImpressionRecording() throws RemoteException {
        Parcel zza = zza(13, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final String getPrice() throws RemoteException {
        Parcel zza = zza(9, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final double getStarRating() throws RemoteException {
        Parcel zza = zza(7, zzaz());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    public final String getStore() throws RemoteException {
        Parcel zza = zza(8, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final zzku getVideoController() throws RemoteException {
        Parcel zza = zza(17, zzaz());
        zzku zzh = zzkv.zzh(zza.readStrongBinder());
        zza.recycle();
        return zzh;
    }

    public final void recordImpression() throws RemoteException {
        zzb(10, zzaz());
    }

    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(11, zzaz);
    }

    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(12, zzaz);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(16, zzaz);
    }

    public final zzoy zzjm() throws RemoteException {
        Parcel zza = zza(5, zzaz());
        zzoy zzk = zzoz.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    public final IObjectWrapper zzjr() throws RemoteException {
        Parcel zza = zza(21, zzaz());
        IObjectWrapper zzap = IObjectWrapper.zza.zzap(zza.readStrongBinder());
        zza.recycle();
        return zzap;
    }

    public final zzou zzjs() throws RemoteException {
        Parcel zza = zza(19, zzaz());
        zzou zzj = zzov.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    public final IObjectWrapper zzme() throws RemoteException {
        Parcel zza = zza(18, zzaz());
        IObjectWrapper zzap = IObjectWrapper.zza.zzap(zza.readStrongBinder());
        zza.recycle();
        return zzap;
    }

    public final IObjectWrapper zzmf() throws RemoteException {
        Parcel zza = zza(20, zzaz());
        IObjectWrapper zzap = IObjectWrapper.zza.zzap(zza.readStrongBinder());
        zza.recycle();
        return zzap;
    }
}
