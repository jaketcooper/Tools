package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbej;
import com.google.android.gms.internal.zzbem;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class zzao extends zzbej {
    public static final Parcelable.Creator<zzao> CREATOR = new zzap();
    public final boolean zzapr;
    public final boolean zzaps;
    private String zzapt;
    public final boolean zzapu;
    public final float zzapv;
    public final int zzapw;
    public final boolean zzapx;
    public final boolean zzapy;

    zzao(boolean z, boolean z2, String str, boolean z3, float f, int i, boolean z4, boolean z5) {
        this.zzapr = z;
        this.zzaps = z2;
        this.zzapt = str;
        this.zzapu = z3;
        this.zzapv = f;
        this.zzapw = i;
        this.zzapx = z4;
        this.zzapy = z5;
    }

    public zzao(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5) {
        this(z, z2, (String) null, z3, f, i, z4, z5);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, this.zzapr);
        zzbem.zza(parcel, 3, this.zzaps);
        zzbem.zza(parcel, 4, this.zzapt, false);
        zzbem.zza(parcel, 5, this.zzapu);
        zzbem.zza(parcel, 6, this.zzapv);
        zzbem.zzc(parcel, 7, this.zzapw);
        zzbem.zza(parcel, 8, this.zzapx);
        zzbem.zza(parcel, 9, this.zzapy);
        zzbem.zzai(parcel, zze);
    }
}
