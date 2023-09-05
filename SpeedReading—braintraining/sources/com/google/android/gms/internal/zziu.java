package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class zziu implements Parcelable.Creator<zzis> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbek.zzd(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        ArrayList<String> arrayList = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        zzlw zzlw = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbek.zzg(parcel, readInt);
                    break;
                case 2:
                    j = zzbek.zzi(parcel, readInt);
                    break;
                case 3:
                    bundle = zzbek.zzs(parcel, readInt);
                    break;
                case 4:
                    i2 = zzbek.zzg(parcel, readInt);
                    break;
                case 5:
                    arrayList = zzbek.zzac(parcel, readInt);
                    break;
                case 6:
                    z = zzbek.zzc(parcel, readInt);
                    break;
                case 7:
                    i3 = zzbek.zzg(parcel, readInt);
                    break;
                case 8:
                    z2 = zzbek.zzc(parcel, readInt);
                    break;
                case 9:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 10:
                    zzlw = (zzlw) zzbek.zza(parcel, readInt, zzlw.CREATOR);
                    break;
                case 11:
                    location = (Location) zzbek.zza(parcel, readInt, Location.CREATOR);
                    break;
                case 12:
                    str2 = zzbek.zzq(parcel, readInt);
                    break;
                case 13:
                    bundle2 = zzbek.zzs(parcel, readInt);
                    break;
                case 14:
                    bundle3 = zzbek.zzs(parcel, readInt);
                    break;
                case 15:
                    arrayList2 = zzbek.zzac(parcel, readInt);
                    break;
                case 16:
                    str3 = zzbek.zzq(parcel, readInt);
                    break;
                case 17:
                    str4 = zzbek.zzq(parcel, readInt);
                    break;
                case 18:
                    z3 = zzbek.zzc(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzis(i, j, bundle, i2, arrayList, z, i3, z2, str, zzlw, location, str2, bundle2, bundle3, arrayList2, str3, str4, z3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzis[i];
    }
}
