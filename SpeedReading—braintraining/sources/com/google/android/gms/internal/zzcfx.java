package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;

public final class zzcfx extends zzbej {
    public static final Parcelable.Creator<zzcfx> CREATOR = new zzcfy();
    public final String name;
    public final String zzivu;
    public final zzcfu zzixi;
    public final long zzixj;

    zzcfx(zzcfx zzcfx, long j) {
        zzbq.checkNotNull(zzcfx);
        this.name = zzcfx.name;
        this.zzixi = zzcfx.zzixi;
        this.zzivu = zzcfx.zzivu;
        this.zzixj = j;
    }

    public zzcfx(String str, zzcfu zzcfu, String str2, long j) {
        this.name = str;
        this.zzixi = zzcfu;
        this.zzivu = str2;
        this.zzixj = j;
    }

    public final String toString() {
        String str = this.zzivu;
        String str2 = this.name;
        String valueOf = String.valueOf(this.zzixi);
        return new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length()).append("origin=").append(str).append(",name=").append(str2).append(",params=").append(valueOf).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, this.name, false);
        zzbem.zza(parcel, 3, (Parcelable) this.zzixi, i, false);
        zzbem.zza(parcel, 4, this.zzivu, false);
        zzbem.zza(parcel, 5, this.zzixj);
        zzbem.zzai(parcel, zze);
    }
}
