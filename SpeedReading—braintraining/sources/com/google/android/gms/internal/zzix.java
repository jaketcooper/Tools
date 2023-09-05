package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzix implements Parcelable.Creator<zziw> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        zziw[] zziwArr = null;
        boolean z = false;
        int zzd = zzbek.zzd(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        boolean z4 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 3:
                    i4 = zzbek.zzg(parcel, readInt);
                    break;
                case 4:
                    i3 = zzbek.zzg(parcel, readInt);
                    break;
                case 5:
                    z4 = zzbek.zzc(parcel, readInt);
                    break;
                case 6:
                    i2 = zzbek.zzg(parcel, readInt);
                    break;
                case 7:
                    i = zzbek.zzg(parcel, readInt);
                    break;
                case 8:
                    zziwArr = (zziw[]) zzbek.zzb(parcel, readInt, zziw.CREATOR);
                    break;
                case 9:
                    z3 = zzbek.zzc(parcel, readInt);
                    break;
                case 10:
                    z2 = zzbek.zzc(parcel, readInt);
                    break;
                case 11:
                    z = zzbek.zzc(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zziw(str, i4, i3, z4, i2, i, zziwArr, z3, z2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zziw[i];
    }
}
