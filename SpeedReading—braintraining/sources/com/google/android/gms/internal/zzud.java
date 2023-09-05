package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzud extends zzee implements zzuc {
    public zzud() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzuc zzt(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return queryLocalInterface instanceof zzuc ? (zzuc) queryLocalInterface : new zzue(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzuf zzbf = zzbf(parcel.readString());
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzbf);
                return true;
            case 2:
                boolean zzbg = zzbg(parcel.readString());
                parcel2.writeNoException();
                zzef.zza(parcel2, zzbg);
                return true;
            default:
                return false;
        }
    }
}
