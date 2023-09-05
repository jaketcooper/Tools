package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzadx implements Parcelable.Creator<zzadw> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbek.zzd(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 3:
                    i = zzbek.zzg(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzadw(str, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzadw[i];
    }
}
