package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzcam extends zzbej {
    public static final Parcelable.Creator<zzcam> CREATOR = new zzcan();
    private String packageName;
    private int versionCode;
    private String zzhzf;

    zzcam(int i, String str, String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.zzhzf = str2;
    }

    public zzcam(String str, String str2) {
        this(1, str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zzc(parcel, 1, this.versionCode);
        zzbem.zza(parcel, 2, this.packageName, false);
        zzbem.zza(parcel, 3, this.zzhzf, false);
        zzbem.zzai(parcel, zze);
    }
}
