package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzlb implements Parcelable.Creator<zzla> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbek.zzd(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    i = zzbek.zzg(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzla(i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzla[i];
    }
}
