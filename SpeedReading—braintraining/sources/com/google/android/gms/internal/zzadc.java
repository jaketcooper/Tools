package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzadc implements Parcelable.Creator<zzadb> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbek.zzd(parcel);
        String str = null;
        zzis zzis = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    zzis = (zzis) zzbek.zza(parcel, readInt, zzis.CREATOR);
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
        return new zzadb(zzis, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzadb[i];
    }
}
