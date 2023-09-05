package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;

@zzzb
public final class zzaad extends zzbej {
    public static final Parcelable.Creator<zzaad> CREATOR = new zzaae();
    public String body;
    public final int errorCode;
    public final int orientation;
    private int versionCode;
    public final boolean zzapy;
    public final boolean zzbdd;
    public final boolean zzbde;
    public final boolean zzbdf;
    public final List<String> zzcbv;
    public final List<String> zzcbw;
    public final List<String> zzcby;
    public final boolean zzcbz;
    public final long zzccb;
    private zzzz zzcdj;
    public final String zzchl;
    public final boolean zzclw;
    public final boolean zzcmk;
    @Nullable
    public String zzcml;
    public final boolean zzcmw;
    public final long zzcnf;
    public final boolean zzcng;
    public final long zzcnh;
    public final List<String> zzcni;
    public final String zzcnj;
    public final long zzcnk;
    public final String zzcnl;
    public final boolean zzcnm;
    public final String zzcnn;
    public final String zzcno;
    public final boolean zzcnp;
    public final boolean zzcnq;
    public final boolean zzcnr;
    private zzaap zzcns;
    public String zzcnt;
    public final String zzcnu;
    @Nullable
    public final zzadw zzcnv;
    @Nullable
    public final List<String> zzcnw;
    @Nullable
    public final List<String> zzcnx;
    public final boolean zzcny;
    @Nullable
    public final zzaaf zzcnz;
    @Nullable
    public final String zzcoa;
    @Nullable
    public final zzaee zzcob;
    @Nullable
    public final String zzcoc;
    public final boolean zzcod;
    private Bundle zzcoe;
    public final int zzcof;

    public zzaad(int i) {
        this(19, (String) null, (String) null, (List<String>) null, i, (List<String>) null, -1, false, -1, (List<String>) null, -1, -1, (String) null, -1, (String) null, false, (String) null, (String) null, false, false, false, true, false, (zzaap) null, (String) null, (String) null, false, false, (zzadw) null, (List<String>) null, (List<String>) null, false, (zzaaf) null, false, (String) null, (List<String>) null, false, (String) null, (zzaee) null, (String) null, true, false, (Bundle) null, false, 0);
    }

    public zzaad(int i, long j) {
        this(19, (String) null, (String) null, (List<String>) null, i, (List<String>) null, -1, false, -1, (List<String>) null, j, -1, (String) null, -1, (String) null, false, (String) null, (String) null, false, false, false, true, false, (zzaap) null, (String) null, (String) null, false, false, (zzadw) null, (List<String>) null, (List<String>) null, false, (zzaaf) null, false, (String) null, (List<String>) null, false, (String) null, (zzaee) null, (String) null, true, false, (Bundle) null, false, 0);
    }

    zzaad(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, zzaap zzaap, String str7, String str8, boolean z8, boolean z9, zzadw zzadw, List<String> list4, List<String> list5, boolean z10, zzaaf zzaaf, boolean z11, String str9, List<String> list6, boolean z12, String str10, zzaee zzaee, String str11, boolean z13, boolean z14, Bundle bundle, boolean z15, int i4) {
        zzabd zzabd;
        this.versionCode = i;
        this.zzchl = str;
        this.body = str2;
        this.zzcbv = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzcbw = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzcnf = j;
        this.zzcng = z;
        this.zzcnh = j2;
        this.zzcni = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzccb = j3;
        this.orientation = i3;
        this.zzcnj = str3;
        this.zzcnk = j4;
        this.zzcnl = str4;
        this.zzcnm = z2;
        this.zzcnn = str5;
        this.zzcno = str6;
        this.zzcnp = z3;
        this.zzbdd = z4;
        this.zzclw = z5;
        this.zzcnq = z6;
        this.zzcod = z13;
        this.zzcnr = z7;
        this.zzcns = zzaap;
        this.zzcnt = str7;
        this.zzcnu = str8;
        if (this.body == null && this.zzcns != null && (zzabd = (zzabd) this.zzcns.zza(zzabd.CREATOR)) != null && !TextUtils.isEmpty(zzabd.zzbrb)) {
            this.body = zzabd.zzbrb;
        }
        this.zzbde = z8;
        this.zzbdf = z9;
        this.zzcnv = zzadw;
        this.zzcnw = list4;
        this.zzcnx = list5;
        this.zzcny = z10;
        this.zzcnz = zzaaf;
        this.zzcmk = z11;
        this.zzcml = str9;
        this.zzcby = list6;
        this.zzcbz = z12;
        this.zzcoa = str10;
        this.zzcob = zzaee;
        this.zzcoc = str11;
        this.zzcmw = z14;
        this.zzcoe = bundle;
        this.zzapy = z15;
        this.zzcof = i4;
    }

    public zzaad(zzzz zzzz, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, zzadw zzadw, List<String> list4, List<String> list5, boolean z9, zzaaf zzaaf, boolean z10, String str7, List<String> list6, boolean z11, String str8, zzaee zzaee, String str9, boolean z12, boolean z13, boolean z14, int i2) {
        this(19, str, str2, list, -2, list2, j, z, -1, list3, j3, i, str3, j4, str4, false, (String) null, str5, z2, z3, z4, z5, false, (zzaap) null, (String) null, str6, z7, z8, zzadw, list4, list5, z9, zzaaf, z10, str7, list6, z11, str8, zzaee, str9, z12, z13, (Bundle) null, z14, i2);
        this.zzcdj = zzzz;
    }

    public zzaad(zzzz zzzz, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, zzadw zzadw, List<String> list4, List<String> list5, boolean z10, zzaaf zzaaf, boolean z11, String str8, List<String> list6, boolean z12, String str9, zzaee zzaee, String str10, boolean z13, boolean z14, boolean z15, int i2) {
        this(19, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, (zzaap) null, (String) null, str7, z8, z9, zzadw, list4, list5, z10, zzaaf, z11, str8, list6, z12, str9, zzaee, str10, z13, z14, (Bundle) null, z15, 0);
        this.zzcdj = zzzz;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (this.zzcdj != null && this.zzcdj.versionCode >= 9 && !TextUtils.isEmpty(this.body)) {
            this.zzcns = new zzaap((zzben) new zzabd(this.body));
            this.body = null;
        }
        int zze = zzbem.zze(parcel);
        zzbem.zzc(parcel, 1, this.versionCode);
        zzbem.zza(parcel, 2, this.zzchl, false);
        zzbem.zza(parcel, 3, this.body, false);
        zzbem.zzb(parcel, 4, this.zzcbv, false);
        zzbem.zzc(parcel, 5, this.errorCode);
        zzbem.zzb(parcel, 6, this.zzcbw, false);
        zzbem.zza(parcel, 7, this.zzcnf);
        zzbem.zza(parcel, 8, this.zzcng);
        zzbem.zza(parcel, 9, this.zzcnh);
        zzbem.zzb(parcel, 10, this.zzcni, false);
        zzbem.zza(parcel, 11, this.zzccb);
        zzbem.zzc(parcel, 12, this.orientation);
        zzbem.zza(parcel, 13, this.zzcnj, false);
        zzbem.zza(parcel, 14, this.zzcnk);
        zzbem.zza(parcel, 15, this.zzcnl, false);
        zzbem.zza(parcel, 18, this.zzcnm);
        zzbem.zza(parcel, 19, this.zzcnn, false);
        zzbem.zza(parcel, 21, this.zzcno, false);
        zzbem.zza(parcel, 22, this.zzcnp);
        zzbem.zza(parcel, 23, this.zzbdd);
        zzbem.zza(parcel, 24, this.zzclw);
        zzbem.zza(parcel, 25, this.zzcnq);
        zzbem.zza(parcel, 26, this.zzcnr);
        zzbem.zza(parcel, 28, (Parcelable) this.zzcns, i, false);
        zzbem.zza(parcel, 29, this.zzcnt, false);
        zzbem.zza(parcel, 30, this.zzcnu, false);
        zzbem.zza(parcel, 31, this.zzbde);
        zzbem.zza(parcel, 32, this.zzbdf);
        zzbem.zza(parcel, 33, (Parcelable) this.zzcnv, i, false);
        zzbem.zzb(parcel, 34, this.zzcnw, false);
        zzbem.zzb(parcel, 35, this.zzcnx, false);
        zzbem.zza(parcel, 36, this.zzcny);
        zzbem.zza(parcel, 37, (Parcelable) this.zzcnz, i, false);
        zzbem.zza(parcel, 38, this.zzcmk);
        zzbem.zza(parcel, 39, this.zzcml, false);
        zzbem.zzb(parcel, 40, this.zzcby, false);
        zzbem.zza(parcel, 42, this.zzcbz);
        zzbem.zza(parcel, 43, this.zzcoa, false);
        zzbem.zza(parcel, 44, (Parcelable) this.zzcob, i, false);
        zzbem.zza(parcel, 45, this.zzcoc, false);
        zzbem.zza(parcel, 46, this.zzcod);
        zzbem.zza(parcel, 47, this.zzcmw);
        zzbem.zza(parcel, 48, this.zzcoe, false);
        zzbem.zza(parcel, 49, this.zzapy);
        zzbem.zzc(parcel, 50, this.zzcof);
        zzbem.zzai(parcel, zze);
    }
}
