package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Future;

@zzzb
public final class zzaaa {
    public final ApplicationInfo applicationInfo;
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
    public final String zzcmf;
    public final float zzcmg;
    public final int zzcmh;
    public final int zzcmi;
    public final boolean zzcmj;
    public final boolean zzcmk;
    public final boolean zzcmm;
    public final String zzcmn;
    public final int zzcmo;
    public final Bundle zzcmp;
    public final String zzcmq;
    public final boolean zzcmr;
    @Nullable
    public final Bundle zzcms;
    public final boolean zzcmw;
    public final String zzcmx;
    public final List<String> zzcmy;
    public final int zzcmz;
    public final boolean zzcna;
    public final boolean zzcnb;
    public final Future<String> zzcnc;
    public final Future<String> zzcnd;

    public zzaaa(@Nullable Bundle bundle, zzis zzis, zziw zziw, String str, ApplicationInfo applicationInfo2, @Nullable PackageInfo packageInfo, String str2, String str3, zzaiy zzaiy, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i, int i2, float f, String str4, long j, String str5, @Nullable List<String> list3, String str6, zzom zzom, String str7, float f2, boolean z2, int i3, int i4, boolean z3, boolean z4, Future<String> future, String str8, boolean z5, int i5, Bundle bundle4, String str9, @Nullable zzla zzla, boolean z6, Bundle bundle5, boolean z7, Future<String> future2, List<Integer> list4, String str10, List<String> list5, int i6, boolean z8, boolean z9) {
        this.zzcln = bundle;
        this.zzclo = zzis;
        this.zzath = zziw;
        this.zzatb = str;
        this.applicationInfo = applicationInfo2;
        this.zzclp = packageInfo;
        this.zzclr = str2;
        this.zzcls = str3;
        this.zzatd = zzaiy;
        this.zzclt = bundle2;
        this.zzclw = z;
        this.zzclx = i;
        this.zzcly = i2;
        this.zzaxd = f;
        if (list == null || list.size() <= 0) {
            this.zzclu = 0;
            this.zzaub = null;
            this.zzcmd = null;
        } else {
            this.zzclu = 3;
            this.zzaub = list;
            this.zzcmd = list2;
        }
        this.zzclv = bundle3;
        this.zzclz = str4;
        this.zzcma = j;
        this.zzcmb = str5;
        this.zzcmc = list3;
        this.zzata = str6;
        this.zzatt = zzom;
        this.zzcmf = str7;
        this.zzcmg = f2;
        this.zzcmm = z2;
        this.zzcmh = i3;
        this.zzcmi = i4;
        this.zzcmj = z3;
        this.zzcmk = z4;
        this.zzcnc = future;
        this.zzcmn = str8;
        this.zzcbz = z5;
        this.zzcmo = i5;
        this.zzcmp = bundle4;
        this.zzcmq = str9;
        this.zzatv = zzla;
        this.zzcmr = z6;
        this.zzcms = bundle5;
        this.zzcmw = z7;
        this.zzcnd = future2;
        this.zzatx = list4;
        this.zzcmx = str10;
        this.zzcmy = list5;
        this.zzcmz = i6;
        this.zzcna = z8;
        this.zzcnb = z9;
    }
}
