package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzao;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzbek;

public final class zzm implements Parcelable.Creator<AdOverlayInfoParcel> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbek.zzd(parcel);
        zzc zzc = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i = 0;
        int i2 = 0;
        String str3 = null;
        zzaiy zzaiy = null;
        String str4 = null;
        zzao zzao = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    zzc = (zzc) zzbek.zza(parcel, readInt, zzc.CREATOR);
                    break;
                case 3:
                    iBinder = zzbek.zzr(parcel, readInt);
                    break;
                case 4:
                    iBinder2 = zzbek.zzr(parcel, readInt);
                    break;
                case 5:
                    iBinder3 = zzbek.zzr(parcel, readInt);
                    break;
                case 6:
                    iBinder4 = zzbek.zzr(parcel, readInt);
                    break;
                case 7:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 8:
                    z = zzbek.zzc(parcel, readInt);
                    break;
                case 9:
                    str2 = zzbek.zzq(parcel, readInt);
                    break;
                case 10:
                    iBinder5 = zzbek.zzr(parcel, readInt);
                    break;
                case 11:
                    i = zzbek.zzg(parcel, readInt);
                    break;
                case 12:
                    i2 = zzbek.zzg(parcel, readInt);
                    break;
                case 13:
                    str3 = zzbek.zzq(parcel, readInt);
                    break;
                case 14:
                    zzaiy = (zzaiy) zzbek.zza(parcel, readInt, zzaiy.CREATOR);
                    break;
                case 16:
                    str4 = zzbek.zzq(parcel, readInt);
                    break;
                case 17:
                    zzao = (zzao) zzbek.zza(parcel, readInt, zzao.CREATOR);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new AdOverlayInfoParcel(zzc, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i, i2, str3, zzaiy, str4, zzao);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
