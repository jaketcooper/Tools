package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

@zzzb
public final class zzaas extends zzbej {
    public static final Parcelable.Creator<zzaas> CREATOR = new zzaat();
    private ApplicationInfo applicationInfo;
    private String packageName;
    private PackageInfo zzclp;
    private List<String> zzcmc;
    private String zzcml;
    private Bundle zzcon;
    private zzaiy zzcoo;
    private boolean zzcop;

    public zzaas(Bundle bundle, zzaiy zzaiy, ApplicationInfo applicationInfo2, String str, List<String> list, PackageInfo packageInfo, String str2, boolean z) {
        this.zzcon = bundle;
        this.zzcoo = zzaiy;
        this.packageName = str;
        this.applicationInfo = applicationInfo2;
        this.zzcmc = list;
        this.zzclp = packageInfo;
        this.zzcml = str2;
        this.zzcop = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 1, this.zzcon, false);
        zzbem.zza(parcel, 2, (Parcelable) this.zzcoo, i, false);
        zzbem.zza(parcel, 3, (Parcelable) this.applicationInfo, i, false);
        zzbem.zza(parcel, 4, this.packageName, false);
        zzbem.zzb(parcel, 5, this.zzcmc, false);
        zzbem.zza(parcel, 6, (Parcelable) this.zzclp, i, false);
        zzbem.zza(parcel, 7, this.zzcml, false);
        zzbem.zza(parcel, 8, this.zzcop);
        zzbem.zzai(parcel, zze);
    }
}
