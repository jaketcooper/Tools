package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

public final class zzcfu extends zzbej implements Iterable<String> {
    public static final Parcelable.Creator<zzcfu> CREATOR = new zzcfw();
    /* access modifiers changed from: private */
    public final Bundle zzdyg;

    zzcfu(Bundle bundle) {
        this.zzdyg = bundle;
    }

    /* access modifiers changed from: package-private */
    public final Object get(String str) {
        return this.zzdyg.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Double getDouble(String str) {
        return Double.valueOf(this.zzdyg.getDouble(str));
    }

    /* access modifiers changed from: package-private */
    public final Long getLong(String str) {
        return Long.valueOf(this.zzdyg.getLong(str));
    }

    /* access modifiers changed from: package-private */
    public final String getString(String str) {
        return this.zzdyg.getString(str);
    }

    public final Iterator<String> iterator() {
        return new zzcfv(this);
    }

    public final int size() {
        return this.zzdyg.size();
    }

    public final String toString() {
        return this.zzdyg.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, zzaym(), false);
        zzbem.zzai(parcel, zze);
    }

    public final Bundle zzaym() {
        return new Bundle(this.zzdyg);
    }
}
