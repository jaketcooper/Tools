package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

@zzzb
public final class zzla extends zzbej {
    public static final Parcelable.Creator<zzla> CREATOR = new zzlb();
    public final int zzbee;

    public zzla(int i) {
        this.zzbee = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zzc(parcel, 2, this.zzbee);
        zzbem.zzai(parcel, zze);
    }
}
