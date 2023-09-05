package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzmb implements Parcelable.Creator<zzma> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzd = zzbek.zzd(parcel);
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    z3 = zzbek.zzc(parcel, readInt);
                    break;
                case 3:
                    z2 = zzbek.zzc(parcel, readInt);
                    break;
                case 4:
                    z = zzbek.zzc(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzma(z3, z2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzma[i];
    }
}
