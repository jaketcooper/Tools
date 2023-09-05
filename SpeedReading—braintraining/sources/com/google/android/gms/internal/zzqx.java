package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzqx implements Parcelable.Creator<zzqw> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String[] strArr = null;
        int zzd = zzbek.zzd(parcel);
        String[] strArr2 = null;
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 2:
                    strArr2 = zzbek.zzaa(parcel, readInt);
                    break;
                case 3:
                    strArr = zzbek.zzaa(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzqw(str, strArr2, strArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzqw[i];
    }
}
