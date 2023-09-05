package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzcap implements Parcelable.Creator<zzcao> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbek.zzd(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbek.zzg(parcel, readInt);
                    break;
                case 2:
                    bArr = zzbek.zzt(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzcao(i, bArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcao[i];
    }
}
