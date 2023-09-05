package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzpw extends zzed implements zzpu {
    zzpw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public final void destroy() throws RemoteException {
        zzb(8, zzaz());
    }

    public final List<String> getAvailableAssetNames() throws RemoteException {
        Parcel zza = zza(3, zzaz());
        ArrayList<String> createStringArrayList = zza.createStringArrayList();
        zza.recycle();
        return createStringArrayList;
    }

    public final String getCustomTemplateId() throws RemoteException {
        Parcel zza = zza(4, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final zzku getVideoController() throws RemoteException {
        Parcel zza = zza(7, zzaz());
        zzku zzh = zzkv.zzh(zza.readStrongBinder());
        zza.recycle();
        return zzh;
    }

    public final void performClick(String str) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        zzb(5, zzaz);
    }

    public final void recordImpression() throws RemoteException {
        zzb(6, zzaz());
    }

    public final String zzao(String str) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        Parcel zza = zza(1, zzaz);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final zzoy zzap(String str) throws RemoteException {
        zzoy zzpa;
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        Parcel zza = zza(2, zzaz);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzpa = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzpa = queryLocalInterface instanceof zzoy ? (zzoy) queryLocalInterface : new zzpa(readStrongBinder);
        }
        zza.recycle();
        return zzpa;
    }

    public final boolean zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        Parcel zza = zza(10, zzaz);
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final IObjectWrapper zzjn() throws RemoteException {
        Parcel zza = zza(11, zzaz());
        IObjectWrapper zzap = IObjectWrapper.zza.zzap(zza.readStrongBinder());
        zza.recycle();
        return zzap;
    }

    public final IObjectWrapper zzju() throws RemoteException {
        Parcel zza = zza(9, zzaz());
        IObjectWrapper zzap = IObjectWrapper.zza.zzap(zza.readStrongBinder());
        zza.recycle();
        return zzap;
    }
}
