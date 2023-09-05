package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbek;

public final class zzb implements Parcelable.Creator<zzc> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Intent intent = null;
        int zzd = zzbek.zzd(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str7 = zzbek.zzq(parcel, readInt);
                    break;
                case 3:
                    str6 = zzbek.zzq(parcel, readInt);
                    break;
                case 4:
                    str5 = zzbek.zzq(parcel, readInt);
                    break;
                case 5:
                    str4 = zzbek.zzq(parcel, readInt);
                    break;
                case 6:
                    str3 = zzbek.zzq(parcel, readInt);
                    break;
                case 7:
                    str2 = zzbek.zzq(parcel, readInt);
                    break;
                case 8:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 9:
                    intent = (Intent) zzbek.zza(parcel, readInt, Intent.CREATOR);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzc(str7, str6, str5, str4, str3, str2, str, intent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzc[i];
    }
}
