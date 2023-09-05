package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzabe implements Parcelable.Creator<zzabd> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbek.zzd(parcel);
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzabd(str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzabd[i];
    }
}
