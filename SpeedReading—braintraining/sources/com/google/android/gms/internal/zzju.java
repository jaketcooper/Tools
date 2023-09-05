package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzju extends zzee implements zzjt {
    public zzju() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzd((zzis) zzef.zza(parcel, zzis.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 3:
                boolean isLoading = isLoading();
                parcel2.writeNoException();
                zzef.zza(parcel2, isLoading);
                break;
            case 4:
                String zzcj = zzcj();
                parcel2.writeNoException();
                parcel2.writeString(zzcj);
                break;
            case 5:
                zza((zzis) zzef.zza(parcel, zzis.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
