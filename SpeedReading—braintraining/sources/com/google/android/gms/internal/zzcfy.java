package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzcfy implements Parcelable.Creator<zzcfx> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int zzd = zzbek.zzd(parcel);
        long j = 0;
        zzcfu zzcfu = null;
        String str2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str2 = zzbek.zzq(parcel, readInt);
                    break;
                case 3:
                    zzcfu = (zzcfu) zzbek.zza(parcel, readInt, zzcfu.CREATOR);
                    break;
                case 4:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 5:
                    j = zzbek.zzi(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzcfx(str2, zzcfu, str, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcfx[i];
    }
}
