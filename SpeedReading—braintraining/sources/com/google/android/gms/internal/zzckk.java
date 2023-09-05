package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;

public final class zzckk extends zzbej {
    public static final Parcelable.Creator<zzckk> CREATOR = new zzckl();
    public final String name;
    private int versionCode;
    private String zzfzs;
    public final String zzivu;
    public final long zzjgx;
    private Long zzjgy;
    private Float zzjgz;
    private Double zzjha;

    zzckk(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        Double d2 = null;
        this.versionCode = i;
        this.name = str;
        this.zzjgx = j;
        this.zzjgy = l;
        this.zzjgz = null;
        if (i == 1) {
            this.zzjha = f != null ? Double.valueOf(f.doubleValue()) : d2;
        } else {
            this.zzjha = d;
        }
        this.zzfzs = str2;
        this.zzivu = str3;
    }

    zzckk(zzckm zzckm) {
        this(zzckm.mName, zzckm.zzjhb, zzckm.mValue, zzckm.mOrigin);
    }

    zzckk(String str, long j, Object obj, String str2) {
        zzbq.zzgi(str);
        this.versionCode = 2;
        this.name = str;
        this.zzjgx = j;
        this.zzivu = str2;
        if (obj == null) {
            this.zzjgy = null;
            this.zzjgz = null;
            this.zzjha = null;
            this.zzfzs = null;
        } else if (obj instanceof Long) {
            this.zzjgy = (Long) obj;
            this.zzjgz = null;
            this.zzjha = null;
            this.zzfzs = null;
        } else if (obj instanceof String) {
            this.zzjgy = null;
            this.zzjgz = null;
            this.zzjha = null;
            this.zzfzs = (String) obj;
        } else if (obj instanceof Double) {
            this.zzjgy = null;
            this.zzjgz = null;
            this.zzjha = (Double) obj;
            this.zzfzs = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public final Object getValue() {
        if (this.zzjgy != null) {
            return this.zzjgy;
        }
        if (this.zzjha != null) {
            return this.zzjha;
        }
        if (this.zzfzs != null) {
            return this.zzfzs;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zzc(parcel, 1, this.versionCode);
        zzbem.zza(parcel, 2, this.name, false);
        zzbem.zza(parcel, 3, this.zzjgx);
        zzbem.zza(parcel, 4, this.zzjgy, false);
        zzbem.zza(parcel, 5, (Float) null, false);
        zzbem.zza(parcel, 6, this.zzfzs, false);
        zzbem.zza(parcel, 7, this.zzivu, false);
        zzbem.zza(parcel, 8, this.zzjha, false);
        zzbem.zzai(parcel, zze);
    }
}
