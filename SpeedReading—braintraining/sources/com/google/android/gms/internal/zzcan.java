package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzcan implements Parcelable.Creator<zzcam> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int zzd = zzbek.zzd(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbek.zzg(parcel, readInt);
                    break;
                case 2:
                    str2 = zzbek.zzq(parcel, readInt);
                    break;
                case 3:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzcam(i, str2, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcam[i];
    }
}
