package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzacr extends zzee implements zzacq {
    public zzacr() {
        attachInterface(this, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzacq zzy(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        return queryLocalInterface instanceof zzacq ? (zzacq) queryLocalInterface : new zzacs(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzacv zzacx;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zza((zzadb) zzef.zza(parcel, zzadb.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                show();
                parcel2.writeNoException();
                break;
            case 3:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzacx = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                    zzacx = queryLocalInterface instanceof zzacv ? (zzacv) queryLocalInterface : new zzacx(readStrongBinder);
                }
                zza(zzacx);
                parcel2.writeNoException();
                break;
            case 5:
                boolean isLoaded = isLoaded();
                parcel2.writeNoException();
                zzef.zza(parcel2, isLoaded);
                break;
            case 6:
                pause();
                parcel2.writeNoException();
                break;
            case 7:
                resume();
                parcel2.writeNoException();
                break;
            case 8:
                destroy();
                parcel2.writeNoException();
                break;
            case 9:
                zzb(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 10:
                zzc(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 11:
                zzd(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 12:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 13:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                break;
            case 34:
                setImmersiveMode(zzef.zza(parcel));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
