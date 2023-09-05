package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzlx implements Parcelable.Creator<zzlw> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbek.zzd(parcel);
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 15:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzlw(str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzlw[i];
    }
}
