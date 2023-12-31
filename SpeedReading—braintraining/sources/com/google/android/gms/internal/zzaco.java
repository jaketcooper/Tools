package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaco extends zzee implements zzacn {
    public zzaco() {
        attachInterface(this, "com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                String type = getType();
                parcel2.writeNoException();
                parcel2.writeString(type);
                return true;
            case 2:
                int amount = getAmount();
                parcel2.writeNoException();
                parcel2.writeInt(amount);
                return true;
            default:
                return false;
        }
    }
}
