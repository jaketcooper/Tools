package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;

public final class zzcfi extends zzbej {
    public static final Parcelable.Creator<zzcfi> CREATOR = new zzcfj();
    public String packageName;
    private int versionCode;
    public String zzivu;
    public zzckk zzivv;
    public long zzivw;
    public boolean zzivx;
    public String zzivy;
    public zzcfx zzivz;
    public long zziwa;
    public zzcfx zziwb;
    public long zziwc;
    public zzcfx zziwd;

    zzcfi(int i, String str, String str2, zzckk zzckk, long j, boolean z, String str3, zzcfx zzcfx, long j2, zzcfx zzcfx2, long j3, zzcfx zzcfx3) {
        this.versionCode = i;
        this.packageName = str;
        this.zzivu = str2;
        this.zzivv = zzckk;
        this.zzivw = j;
        this.zzivx = z;
        this.zzivy = str3;
        this.zzivz = zzcfx;
        this.zziwa = j2;
        this.zziwb = zzcfx2;
        this.zziwc = j3;
        this.zziwd = zzcfx3;
    }

    zzcfi(zzcfi zzcfi) {
        this.versionCode = 1;
        zzbq.checkNotNull(zzcfi);
        this.packageName = zzcfi.packageName;
        this.zzivu = zzcfi.zzivu;
        this.zzivv = zzcfi.zzivv;
        this.zzivw = zzcfi.zzivw;
        this.zzivx = zzcfi.zzivx;
        this.zzivy = zzcfi.zzivy;
        this.zzivz = zzcfi.zzivz;
        this.zziwa = zzcfi.zziwa;
        this.zziwb = zzcfi.zziwb;
        this.zziwc = zzcfi.zziwc;
        this.zziwd = zzcfi.zziwd;
    }

    zzcfi(String str, String str2, zzckk zzckk, long j, boolean z, String str3, zzcfx zzcfx, long j2, zzcfx zzcfx2, long j3, zzcfx zzcfx3) {
        this.versionCode = 1;
        this.packageName = str;
        this.zzivu = str2;
        this.zzivv = zzckk;
        this.zzivw = j;
        this.zzivx = z;
        this.zzivy = str3;
        this.zzivz = zzcfx;
        this.zziwa = j2;
        this.zziwb = zzcfx2;
        this.zziwc = j3;
        this.zziwd = zzcfx3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zzc(parcel, 1, this.versionCode);
        zzbem.zza(parcel, 2, this.packageName, false);
        zzbem.zza(parcel, 3, this.zzivu, false);
        zzbem.zza(parcel, 4, (Parcelable) this.zzivv, i, false);
        zzbem.zza(parcel, 5, this.zzivw);
        zzbem.zza(parcel, 6, this.zzivx);
        zzbem.zza(parcel, 7, this.zzivy, false);
        zzbem.zza(parcel, 8, (Parcelable) this.zzivz, i, false);
        zzbem.zza(parcel, 9, this.zziwa);
        zzbem.zza(parcel, 10, (Parcelable) this.zziwb, i, false);
        zzbem.zza(parcel, 11, this.zziwc);
        zzbem.zza(parcel, 12, (Parcelable) this.zziwd, i, false);
        zzbem.zzai(parcel, zze);
    }
}
