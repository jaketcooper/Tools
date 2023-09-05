package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

public final class zzjy extends zzed implements zzjw {
    zzjy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) publisherAdViewOptions);
        zzb(9, zzaz);
    }

    public final void zza(zzom zzom) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzom);
        zzb(6, zzaz);
    }

    public final void zza(zzpy zzpy) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzpy);
        zzb(3, zzaz);
    }

    public final void zza(zzqb zzqb) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzqb);
        zzb(4, zzaz);
    }

    public final void zza(zzqk zzqk, zziw zziw) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzqk);
        zzef.zza(zzaz, (Parcelable) zziw);
        zzb(8, zzaz);
    }

    public final void zza(String str, zzqh zzqh, zzqe zzqe) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        zzef.zza(zzaz, (IInterface) zzqh);
        zzef.zza(zzaz, (IInterface) zzqe);
        zzb(5, zzaz);
    }

    public final void zzb(zzjq zzjq) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzjq);
        zzb(2, zzaz);
    }

    public final void zzb(zzkm zzkm) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzkm);
        zzb(7, zzaz);
    }

    public final zzjt zzdc() throws RemoteException {
        zzjt zzjv;
        Parcel zza = zza(1, zzaz());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzjv = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            zzjv = queryLocalInterface instanceof zzjt ? (zzjt) queryLocalInterface : new zzjv(readStrongBinder);
        }
        zza.recycle();
        return zzjv;
    }
}
