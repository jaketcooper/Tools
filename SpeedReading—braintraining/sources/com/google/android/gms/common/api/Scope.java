package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbej;
import com.google.android.gms.internal.zzbem;

public final class Scope extends zzbej implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzf();
    private int zzdzm;
    private final String zzfkx;

    Scope(int i, String str) {
        zzbq.zzh(str, "scopeUri must not be null or empty");
        this.zzdzm = i;
        this.zzfkx = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.zzfkx.equals(((Scope) obj).zzfkx);
    }

    public final int hashCode() {
        return this.zzfkx.hashCode();
    }

    public final String toString() {
        return this.zzfkx;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zzc(parcel, 1, this.zzdzm);
        zzbem.zza(parcel, 2, this.zzfkx, false);
        zzbem.zzai(parcel, zze);
    }

    public final String zzagk() {
        return this.zzfkx;
    }
}
