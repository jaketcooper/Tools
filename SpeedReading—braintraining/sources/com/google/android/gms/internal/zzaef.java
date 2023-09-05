package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class zzaef implements Parcelable.Creator<zzaee> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        ArrayList<String> arrayList = null;
        boolean z = false;
        int zzd = zzbek.zzd(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str2 = zzbek.zzq(parcel, readInt);
                    break;
                case 3:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 4:
                    z4 = zzbek.zzc(parcel, readInt);
                    break;
                case 5:
                    z3 = zzbek.zzc(parcel, readInt);
                    break;
                case 6:
                    arrayList = zzbek.zzac(parcel, readInt);
                    break;
                case 7:
                    z2 = zzbek.zzc(parcel, readInt);
                    break;
                case 8:
                    z = zzbek.zzc(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzaee(str2, str, z4, z3, arrayList, z2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaee[i];
    }
}
