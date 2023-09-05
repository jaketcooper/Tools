package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzadt extends zzee implements zzads {
    public zzadt() {
        attachInterface(this, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzads zzaa(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        return queryLocalInterface instanceof zzads ? (zzads) queryLocalInterface : new zzadu(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzm(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                break;
            case 2:
                zzc(IObjectWrapper.zza.zzap(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                zzn(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                break;
            case 4:
                zzo(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                break;
            case 5:
                zzp(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                break;
            case 6:
                zzq(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                break;
            case 7:
                zza(IObjectWrapper.zza.zzap(parcel.readStrongBinder()), (zzadw) zzef.zza(parcel, zzadw.CREATOR));
                break;
            case 8:
                zzr(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                break;
            case 9:
                zzd(IObjectWrapper.zza.zzap(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                zzs(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
