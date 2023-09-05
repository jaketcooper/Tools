package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzqz implements Parcelable.Creator<zzqy> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        String[] strArr = null;
        int zzd = zzbek.zzd(parcel);
        long j = 0;
        String[] strArr2 = null;
        byte[] bArr = null;
        int i = 0;
        String str = null;
        boolean z2 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    z2 = zzbek.zzc(parcel, readInt);
                    break;
                case 2:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 3:
                    i = zzbek.zzg(parcel, readInt);
                    break;
                case 4:
                    bArr = zzbek.zzt(parcel, readInt);
                    break;
                case 5:
                    strArr2 = zzbek.zzaa(parcel, readInt);
                    break;
                case 6:
                    strArr = zzbek.zzaa(parcel, readInt);
                    break;
                case 7:
                    z = zzbek.zzc(parcel, readInt);
                    break;
                case 8:
                    j = zzbek.zzi(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzqy(z2, str, i, bArr, strArr2, strArr, z, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzqy[i];
    }
}
