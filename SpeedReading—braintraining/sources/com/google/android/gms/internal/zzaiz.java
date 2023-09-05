package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzaiz implements Parcelable.Creator<zzaiy> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzd = zzbek.zzd(parcel);
        String str = null;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 3:
                    i2 = zzbek.zzg(parcel, readInt);
                    break;
                case 4:
                    i = zzbek.zzg(parcel, readInt);
                    break;
                case 5:
                    z2 = zzbek.zzc(parcel, readInt);
                    break;
                case 6:
                    z = zzbek.zzc(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzaiy(str, i2, i, z2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaiy[i];
    }
}
