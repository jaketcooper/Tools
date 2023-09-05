package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class zzaat implements Parcelable.Creator<zzaas> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int zzd = zzbek.zzd(parcel);
        boolean z = false;
        PackageInfo packageInfo = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        ApplicationInfo applicationInfo = null;
        zzaiy zzaiy = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    bundle = zzbek.zzs(parcel, readInt);
                    break;
                case 2:
                    zzaiy = (zzaiy) zzbek.zza(parcel, readInt, zzaiy.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) zzbek.zza(parcel, readInt, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    str2 = zzbek.zzq(parcel, readInt);
                    break;
                case 5:
                    arrayList = zzbek.zzac(parcel, readInt);
                    break;
                case 6:
                    packageInfo = (PackageInfo) zzbek.zza(parcel, readInt, PackageInfo.CREATOR);
                    break;
                case 7:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 8:
                    z = zzbek.zzc(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzaas(bundle, zzaiy, applicationInfo, str2, arrayList, packageInfo, str, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaas[i];
    }
}
