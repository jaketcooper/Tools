package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class zzaab implements Parcelable.Creator<zzzz> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbek.zzd(parcel);
        int i = 0;
        Bundle bundle = null;
        zzis zzis = null;
        zziw zziw = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzaiy zzaiy = null;
        Bundle bundle2 = null;
        int i2 = 0;
        ArrayList<String> arrayList = null;
        Bundle bundle3 = null;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        long j = 0;
        String str6 = null;
        ArrayList<String> arrayList2 = null;
        String str7 = null;
        zzom zzom = null;
        ArrayList<String> arrayList3 = null;
        long j2 = 0;
        String str8 = null;
        float f2 = 0.0f;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        int i7 = 0;
        Bundle bundle4 = null;
        String str11 = null;
        zzla zzla = null;
        boolean z6 = false;
        Bundle bundle5 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        boolean z7 = false;
        ArrayList<Integer> arrayList4 = null;
        String str15 = null;
        ArrayList<String> arrayList5 = null;
        int i8 = 0;
        boolean z8 = false;
        boolean z9 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbek.zzg(parcel, readInt);
                    break;
                case 2:
                    bundle = zzbek.zzs(parcel, readInt);
                    break;
                case 3:
                    zzis = (zzis) zzbek.zza(parcel, readInt, zzis.CREATOR);
                    break;
                case 4:
                    zziw = (zziw) zzbek.zza(parcel, readInt, zziw.CREATOR);
                    break;
                case 5:
                    str = zzbek.zzq(parcel, readInt);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) zzbek.zza(parcel, readInt, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) zzbek.zza(parcel, readInt, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = zzbek.zzq(parcel, readInt);
                    break;
                case 9:
                    str3 = zzbek.zzq(parcel, readInt);
                    break;
                case 10:
                    str4 = zzbek.zzq(parcel, readInt);
                    break;
                case 11:
                    zzaiy = (zzaiy) zzbek.zza(parcel, readInt, zzaiy.CREATOR);
                    break;
                case 12:
                    bundle2 = zzbek.zzs(parcel, readInt);
                    break;
                case 13:
                    i2 = zzbek.zzg(parcel, readInt);
                    break;
                case 14:
                    arrayList = zzbek.zzac(parcel, readInt);
                    break;
                case 15:
                    bundle3 = zzbek.zzs(parcel, readInt);
                    break;
                case 16:
                    z = zzbek.zzc(parcel, readInt);
                    break;
                case 18:
                    i3 = zzbek.zzg(parcel, readInt);
                    break;
                case 19:
                    i4 = zzbek.zzg(parcel, readInt);
                    break;
                case 20:
                    f = zzbek.zzl(parcel, readInt);
                    break;
                case 21:
                    str5 = zzbek.zzq(parcel, readInt);
                    break;
                case 25:
                    j = zzbek.zzi(parcel, readInt);
                    break;
                case 26:
                    str6 = zzbek.zzq(parcel, readInt);
                    break;
                case 27:
                    arrayList2 = zzbek.zzac(parcel, readInt);
                    break;
                case 28:
                    str7 = zzbek.zzq(parcel, readInt);
                    break;
                case 29:
                    zzom = (zzom) zzbek.zza(parcel, readInt, zzom.CREATOR);
                    break;
                case 30:
                    arrayList3 = zzbek.zzac(parcel, readInt);
                    break;
                case 31:
                    j2 = zzbek.zzi(parcel, readInt);
                    break;
                case 33:
                    str8 = zzbek.zzq(parcel, readInt);
                    break;
                case 34:
                    f2 = zzbek.zzl(parcel, readInt);
                    break;
                case 35:
                    i5 = zzbek.zzg(parcel, readInt);
                    break;
                case 36:
                    i6 = zzbek.zzg(parcel, readInt);
                    break;
                case 37:
                    z3 = zzbek.zzc(parcel, readInt);
                    break;
                case 38:
                    z4 = zzbek.zzc(parcel, readInt);
                    break;
                case 39:
                    str9 = zzbek.zzq(parcel, readInt);
                    break;
                case 40:
                    z2 = zzbek.zzc(parcel, readInt);
                    break;
                case 41:
                    str10 = zzbek.zzq(parcel, readInt);
                    break;
                case 42:
                    z5 = zzbek.zzc(parcel, readInt);
                    break;
                case 43:
                    i7 = zzbek.zzg(parcel, readInt);
                    break;
                case 44:
                    bundle4 = zzbek.zzs(parcel, readInt);
                    break;
                case 45:
                    str11 = zzbek.zzq(parcel, readInt);
                    break;
                case 46:
                    zzla = (zzla) zzbek.zza(parcel, readInt, zzla.CREATOR);
                    break;
                case 47:
                    z6 = zzbek.zzc(parcel, readInt);
                    break;
                case 48:
                    bundle5 = zzbek.zzs(parcel, readInt);
                    break;
                case 49:
                    str12 = zzbek.zzq(parcel, readInt);
                    break;
                case 50:
                    str13 = zzbek.zzq(parcel, readInt);
                    break;
                case 51:
                    str14 = zzbek.zzq(parcel, readInt);
                    break;
                case 52:
                    z7 = zzbek.zzc(parcel, readInt);
                    break;
                case 53:
                    arrayList4 = zzbek.zzab(parcel, readInt);
                    break;
                case 54:
                    str15 = zzbek.zzq(parcel, readInt);
                    break;
                case 55:
                    arrayList5 = zzbek.zzac(parcel, readInt);
                    break;
                case 56:
                    i8 = zzbek.zzg(parcel, readInt);
                    break;
                case 57:
                    z8 = zzbek.zzc(parcel, readInt);
                    break;
                case 58:
                    z9 = zzbek.zzc(parcel, readInt);
                    break;
                default:
                    zzbek.zzb(parcel, readInt);
                    break;
            }
        }
        zzbek.zzaf(parcel, zzd);
        return new zzzz(i, bundle, zzis, zziw, str, applicationInfo, packageInfo, str2, str3, str4, zzaiy, bundle2, i2, arrayList, bundle3, z, i3, i4, f, str5, j, str6, arrayList2, str7, zzom, arrayList3, j2, str8, f2, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4, str11, zzla, z6, bundle5, str12, str13, str14, z7, arrayList4, str15, arrayList5, i8, z8, z9);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzzz[i];
    }
}
