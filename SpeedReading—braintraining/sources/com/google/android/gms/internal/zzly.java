package com.google.android.gms.internal;

import android.os.Parcel;

@zzzb
public final class zzly extends zziw {
    public zzly(zziw zziw) {
        super(zziw.zzbda, zziw.height, zziw.heightPixels, zziw.zzbdb, zziw.width, zziw.widthPixels, zziw.zzbdc, zziw.zzbdd, zziw.zzbde, zziw.zzbdf);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, this.zzbda, false);
        zzbem.zzc(parcel, 3, this.height);
        zzbem.zzc(parcel, 6, this.width);
        zzbem.zzai(parcel, zze);
    }
}
