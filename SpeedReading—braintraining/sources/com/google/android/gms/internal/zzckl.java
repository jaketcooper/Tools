package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzckl implements Parcelable.Creator<zzckk> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Double d = null;
        int zzd = zzbek.zzd(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbek.zzg(parcel, readInt);
                    break;
                case 2:
                    str3 = zzbek.zzq(parcel, readInt);
                    break;
                case 3:
                    j = zzbek.zzi(parcel, readInt);
                    break;
                case 4:
                    l = zzbek.zzj(parcel, readInt);
                    break;
                case 5:
                    f = zzbek.zzm(parcel, readInt);
                    break;
                case 6:
                    str2 = zzbek.zzq(parcel, readInt);
                    break;
                case 7:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 8:
                    d = zzbek.zzo(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzckk(i, str3, j, l, f, str2, str, d);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzckk[i];
    }
}
