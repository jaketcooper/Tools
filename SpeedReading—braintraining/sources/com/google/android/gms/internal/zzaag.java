package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class zzaag implements Parcelable.Creator<zzaaf> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbek.zzd(parcel);
        boolean z = false;
        ArrayList<String> arrayList = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    z = zzbek.zzc(parcel, readInt);
                    break;
                case 3:
                    arrayList = zzbek.zzac(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzaaf(z, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaaf[i];
    }
}
