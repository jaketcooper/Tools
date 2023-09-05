package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzut extends zzed implements zzur {
    zzut(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    public final String getAdvertiser() throws RemoteException {
        Parcel zza = zza(7, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
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
        Parcel zza = zza(13, zzaz());
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
        Parcel zza = zza(12, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean getOverrideImpressionRecording() throws RemoteException {
        Parcel zza = zza(11, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final zzku getVideoController() throws RemoteException {
        Parcel zza = zza(16, zzaz());
        zzku zzh = zzkv.zzh(zza.readStrongBinder());
        zza.recycle();
        return zzh;
    }

    public final void recordImpression() throws RemoteException {
        zzb(8, zzaz());
    }

    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(9, zzaz);
    }

    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(10, zzaz);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(14, zzaz);
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

    public final zzoy zzjt() throws RemoteException {
        Parcel zza = zza(5, zzaz());
        zzoy zzk = zzoz.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    public final IObjectWrapper zzme() throws RemoteException {
        Parcel zza = zza(15, zzaz());
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
