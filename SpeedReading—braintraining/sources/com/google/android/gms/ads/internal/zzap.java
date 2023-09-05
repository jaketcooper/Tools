package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbek;

public final class zzap implements Parcelable.Creator<zzao> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzd = zzbek.zzd(parcel);
        String str = null;
        float f = 0.0f;
        boolean z2 = false;
        int i = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    z5 = zzbek.zzc(parcel, readInt);
                    break;
                case 3:
                    z4 = zzbek.zzc(parcel, readInt);
                    break;
                case 4:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 5:
                    z3 = zzbek.zzc(parcel, readInt);
                    break;
                case 6:
                    f = zzbek.zzl(parcel, readInt);
                    break;
                case 7:
                    i = zzbek.zzg(parcel, readInt);
                    break;
                case 8:
                    z2 = zzbek.zzc(parcel, readInt);
                    break;
                case 9:
                    z = zzbek.zzc(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzao(z5, z4, str, z3, f, i, z2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzao[i];
    }
}
