package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@zzzb
public final class zzzz extends zzbej {
    public static final Parcelable.Creator<zzzz> CREATOR = new zzaab();
    public final ApplicationInfo applicationInfo;
    public final int versionCode;
    public final String zzata;
    public final String zzatb;
    public final zzaiy zzatd;
    public final zziw zzath;
    public final zzom zzatt;
    @Nullable
    public final zzla zzatv;
    public final List<Integer> zzatx;
    public final List<String> zzaub;
    public final float zzaxd;
    public final boolean zzcbz;
    @Nullable
    public final Bundle zzcln;
    public final zzis zzclo;
    @Nullable
    public final PackageInfo zzclp;
    public final String zzclq;
    public final String zzclr;
    public final String zzcls;
    public final Bundle zzclt;
    public final int zzclu;
    public final Bundle zzclv;
    public final boolean zzclw;
    public final int zzclx;
    public final int zzcly;
    public final String zzclz;
    public final long zzcma;
    public final String zzcmb;
    @Nullable
    public final List<String> zzcmc;
    public final List<String> zzcmd;
    public final long zzcme;
    public final String zzcmf;
    public final float zzcmg;
    public final int zzcmh;
    public final int zzcmi;
    public final boolean zzcmj;
    public final boolean zzcmk;
    public final String zzcml;
    public final boolean zzcmm;
    public final String zzcmn;
    public final int zzcmo;
    public final Bundle zzcmp;
    public final String zzcmq;
    public final boolean zzcmr;
    public final Bundle zzcms;
    @Nullable
    public final String zzcmt;
    @Nullable
    public final String zzcmu;
    @Nullable
    public final String zzcmv;
    public final boolean zzcmw;
    public final String zzcmx;
    public final List<String> zzcmy;
    public final int zzcmz;
    public final boolean zzcna;
    public final boolean zzcnb;

    zzzz(int i, Bundle bundle, zzis zzis, zziw zziw, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, String str4, zzaiy zzaiy, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, zzom zzom, List<String> list3, long j2, String str8, float f2, boolean z2, int i5, int i6, boolean z3, boolean z4, String str9, String str10, boolean z5, int i7, Bundle bundle4, String str11, zzla zzla, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i8, boolean z8, boolean z9) {
        this.versionCode = i;
        this.zzcln = bundle;
        this.zzclo = zzis;
        this.zzath = zziw;
        this.zzatb = str;
        this.applicationInfo = applicationInfo2;
        this.zzclp = packageInfo;
        this.zzclq = str2;
        this.zzclr = str3;
        this.zzcls = str4;
        this.zzatd = zzaiy;
        this.zzclt = bundle2;
        this.zzclu = i2;
        this.zzaub = list;
        this.zzcmd = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzclv = bundle3;
        this.zzclw = z;
        this.zzclx = i3;
        this.zzcly = i4;
        this.zzaxd = f;
        this.zzclz = str5;
        this.zzcma = j;
        this.zzcmb = str6;
        this.zzcmc = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzata = str7;
        this.zzatt = zzom;
        this.zzcme = j2;
        this.zzcmf = str8;
        this.zzcmg = f2;
        this.zzcmm = z2;
        this.zzcmh = i5;
        this.zzcmi = i6;
        this.zzcmj = z3;
        this.zzcmk = z4;
        this.zzcml = str9;
        this.zzcmn = str10;
        this.zzcbz = z5;
        this.zzcmo = i7;
        this.zzcmp = bundle4;
        this.zzcmq = str11;
        this.zzatv = zzla;
        this.zzcmr = z6;
        this.zzcms = bundle5;
        this.zzcmt = str12;
        this.zzcmu = str13;
        this.zzcmv = str14;
        this.zzcmw = z7;
        this.zzatx = list4;
        this.zzcmx = str15;
        this.zzcmy = list5;
        this.zzcmz = i8;
        this.zzcna = z8;
        this.zzcnb = z9;
    }

    private zzzz(@Nullable Bundle bundle, zzis zzis, zziw zziw, String str, ApplicationInfo applicationInfo2, @Nullable PackageInfo packageInfo, String str2, String str3, String str4, zzaiy zzaiy, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i2, int i3, float f, String str5, long j, String str6, @Nullable List<String> list3, String str7, zzom zzom, long j2, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4, String str11, @Nullable zzla zzla, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i7, boolean z8, boolean z9) {
        this(24, bundle, zzis, zziw, str, applicationInfo2, packageInfo, str2, str3, str4, zzaiy, bundle2, i, list, bundle3, z, i2, i3, f, str5, j, str6, list3, str7, zzom, list2, j2, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4, str11, zzla, z6, bundle5, str12, str13, str14, z7, list4, str15, list5, i7, z8, z9);
    }

    public zzzz(zzaaa zzaaa, long j, String str, String str2, String str3) {
        this(zzaaa.zzcln, zzaaa.zzclo, zzaaa.zzath, zzaaa.zzatb, zzaaa.applicationInfo, zzaaa.zzclp, (String) zzajg.zza(zzaaa.zzcnd, ""), zzaaa.zzclr, zzaaa.zzcls, zzaaa.zzatd, zzaaa.zzclt, zzaaa.zzclu, zzaaa.zzaub, zzaaa.zzcmd, zzaaa.zzclv, zzaaa.zzclw, zzaaa.zzclx, zzaaa.zzcly, zzaaa.zzaxd, zzaaa.zzclz, zzaaa.zzcma, zzaaa.zzcmb, zzaaa.zzcmc, zzaaa.zzata, zzaaa.zzatt, j, zzaaa.zzcmf, zzaaa.zzcmg, zzaaa.zzcmm, zzaaa.zzcmh, zzaaa.zzcmi, zzaaa.zzcmj, zzaaa.zzcmk, (String) zzajg.zza(zzaaa.zzcnc, "", 1, TimeUnit.SECONDS), zzaaa.zzcmn, zzaaa.zzcbz, zzaaa.zzcmo, zzaaa.zzcmp, zzaaa.zzcmq, zzaaa.zzatv, zzaaa.zzcmr, zzaaa.zzcms, str, str2, str3, zzaaa.zzcmw, zzaaa.zzatx, zzaaa.zzcmx, zzaaa.zzcmy, zzaaa.zzcmz, zzaaa.zzcna, zzaaa.zzcnb);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zzc(parcel, 1, this.versionCode);
        zzbem.zza(parcel, 2, this.zzcln, false);
        zzbem.zza(parcel, 3, (Parcelable) this.zzclo, i, false);
        zzbem.zza(parcel, 4, (Parcelable) this.zzath, i, false);
        zzbem.zza(parcel, 5, this.zzatb, false);
        zzbem.zza(parcel, 6, (Parcelable) this.applicationInfo, i, false);
        zzbem.zza(parcel, 7, (Parcelable) this.zzclp, i, false);
        zzbem.zza(parcel, 8, this.zzclq, false);
        zzbem.zza(parcel, 9, this.zzclr, false);
        zzbem.zza(parcel, 10, this.zzcls, false);
        zzbem.zza(parcel, 11, (Parcelable) this.zzatd, i, false);
        zzbem.zza(parcel, 12, this.zzclt, false);
        zzbem.zzc(parcel, 13, this.zzclu);
        zzbem.zzb(parcel, 14, this.zzaub, false);
        zzbem.zza(parcel, 15, this.zzclv, false);
        zzbem.zza(parcel, 16, this.zzclw);
        zzbem.zzc(parcel, 18, this.zzclx);
        zzbem.zzc(parcel, 19, this.zzcly);
        zzbem.zza(parcel, 20, this.zzaxd);
        zzbem.zza(parcel, 21, this.zzclz, false);
        zzbem.zza(parcel, 25, this.zzcma);
        zzbem.zza(parcel, 26, this.zzcmb, false);
        zzbem.zzb(parcel, 27, this.zzcmc, false);
        zzbem.zza(parcel, 28, this.zzata, false);
        zzbem.zza(parcel, 29, (Parcelable) this.zzatt, i, false);
        zzbem.zzb(parcel, 30, this.zzcmd, false);
        zzbem.zza(parcel, 31, this.zzcme);
        zzbem.zza(parcel, 33, this.zzcmf, false);
        zzbem.zza(parcel, 34, this.zzcmg);
        zzbem.zzc(parcel, 35, this.zzcmh);
        zzbem.zzc(parcel, 36, this.zzcmi);
        zzbem.zza(parcel, 37, this.zzcmj);
        zzbem.zza(parcel, 38, this.zzcmk);
        zzbem.zza(parcel, 39, this.zzcml, false);
        zzbem.zza(parcel, 40, this.zzcmm);
        zzbem.zza(parcel, 41, this.zzcmn, false);
        zzbem.zza(parcel, 42, this.zzcbz);
        zzbem.zzc(parcel, 43, this.zzcmo);
        zzbem.zza(parcel, 44, this.zzcmp, false);
        zzbem.zza(parcel, 45, this.zzcmq, false);
        zzbem.zza(parcel, 46, (Parcelable) this.zzatv, i, false);
        zzbem.zza(parcel, 47, this.zzcmr);
        zzbem.zza(parcel, 48, this.zzcms, false);
        zzbem.zza(parcel, 49, this.zzcmt, false);
        zzbem.zza(parcel, 50, this.zzcmu, false);
        zzbem.zza(parcel, 51, this.zzcmv, false);
        zzbem.zza(parcel, 52, this.zzcmw);
        zzbem.zza(parcel, 53, this.zzatx, false);
        zzbem.zza(parcel, 54, this.zzcmx, false);
        zzbem.zzb(parcel, 55, this.zzcmy, false);
        zzbem.zzc(parcel, 56, this.zzcmz);
        zzbem.zza(parcel, 57, this.zzcna);
        zzbem.zza(parcel, 58, this.zzcnb);
        zzbem.zzai(parcel, zze);
    }
}
