package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;

public final class zzcff extends zzbej {
    public static final Parcelable.Creator<zzcff> CREATOR = new zzcfg();
    public final String packageName;
    public final String zzida;
    public final String zzivh;
    public final String zzivi;
    public final long zzivj;
    public final long zzivk;
    public final String zzivl;
    public final boolean zzivm;
    public final boolean zzivn;
    public final long zzivo;
    public final String zzivp;
    public final long zzivq;
    public final long zzivr;
    public final int zzivs;
    public final boolean zzivt;

    zzcff(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3) {
        zzbq.zzgi(str);
        this.packageName = str;
        this.zzivh = TextUtils.isEmpty(str2) ? null : str2;
        this.zzida = str3;
        this.zzivo = j;
        this.zzivi = str4;
        this.zzivj = j2;
        this.zzivk = j3;
        this.zzivl = str5;
        this.zzivm = z;
        this.zzivn = z2;
        this.zzivp = str6;
        this.zzivq = j4;
        this.zzivr = j5;
        this.zzivs = i;
        this.zzivt = z3;
    }

    zzcff(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i, boolean z3) {
        this.packageName = str;
        this.zzivh = str2;
        this.zzida = str3;
        this.zzivo = j3;
        this.zzivi = str4;
        this.zzivj = j;
        this.zzivk = j2;
        this.zzivl = str5;
        this.zzivm = z;
        this.zzivn = z2;
        this.zzivp = str6;
        this.zzivq = j4;
        this.zzivr = j5;
        this.zzivs = i;
        this.zzivt = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, this.packageName, false);
        zzbem.zza(parcel, 3, this.zzivh, false);
        zzbem.zza(parcel, 4, this.zzida, false);
        zzbem.zza(parcel, 5, this.zzivi, false);
        zzbem.zza(parcel, 6, this.zzivj);
        zzbem.zza(parcel, 7, this.zzivk);
        zzbem.zza(parcel, 8, this.zzivl, false);
        zzbem.zza(parcel, 9, this.zzivm);
        zzbem.zza(parcel, 10, this.zzivn);
        zzbem.zza(parcel, 11, this.zzivo);
        zzbem.zza(parcel, 12, this.zzivp, false);
        zzbem.zza(parcel, 13, this.zzivq);
        zzbem.zza(parcel, 14, this.zzivr);
        zzbem.zzc(parcel, 15, this.zzivs);
        zzbem.zza(parcel, 16, this.zzivt);
        zzbem.zzai(parcel, zze);
    }
}
