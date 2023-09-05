package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzhv implements Parcelable.Creator<zzhu> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int zzd = zzbek.zzd(parcel);
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str4 = zzbek.zzq(parcel, readInt);
                    break;
                case 3:
                    j2 = zzbek.zzi(parcel, readInt);
                    break;
                case 4:
                    str3 = zzbek.zzq(parcel, readInt);
                    break;
                case 5:
                    str2 = zzbek.zzq(parcel, readInt);
                    break;
                case 6:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 7:
                    bundle = zzbek.zzs(parcel, readInt);
                    break;
                case 8:
                    z = zzbek.zzc(parcel, readInt);
                    break;
                case 9:
                    j = zzbek.zzi(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzhu(str4, j2, str3, str2, str, bundle, z, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzhu[i];
    }
}
