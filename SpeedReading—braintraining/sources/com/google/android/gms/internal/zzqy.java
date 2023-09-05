package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

@zzzb
public final class zzqy extends zzbej {
    public static final Parcelable.Creator<zzqy> CREATOR = new zzqz();
    public final byte[] data;
    public final int statusCode;
    public final long zzaa;
    public final String[] zzbwu;
    public final String[] zzbwv;
    public final boolean zzbww;
    public final String zzbwx;
    public final boolean zzz;

    zzqy(boolean z, String str, int i, byte[] bArr, String[] strArr, String[] strArr2, boolean z2, long j) {
        this.zzbww = z;
        this.zzbwx = str;
        this.statusCode = i;
        this.data = bArr;
        this.zzbwu = strArr;
        this.zzbwv = strArr2;
        this.zzz = z2;
        this.zzaa = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 1, this.zzbww);
        zzbem.zza(parcel, 2, this.zzbwx, false);
        zzbem.zzc(parcel, 3, this.statusCode);
        zzbem.zza(parcel, 4, this.data, false);
        zzbem.zza(parcel, 5, this.zzbwu, false);
        zzbem.zza(parcel, 6, this.zzbwv, false);
        zzbem.zza(parcel, 7, this.zzz);
        zzbem.zza(parcel, 8, this.zzaa);
        zzbem.zzai(parcel, zze);
    }
}
