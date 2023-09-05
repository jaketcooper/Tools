package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;
import java.util.List;

@zzzb
public final class zzis extends zzbej {
    public static final Parcelable.Creator<zzis> CREATOR = new zziu();
    public final Bundle extras;
    public final int versionCode;
    public final long zzbbv;
    public final int zzbbw;
    public final List<String> zzbbx;
    public final boolean zzbby;
    public final int zzbbz;
    public final boolean zzbca;
    public final String zzbcb;
    public final zzlw zzbcc;
    public final Location zzbcd;
    public final String zzbce;
    public final Bundle zzbcf;
    public final Bundle zzbcg;
    public final List<String> zzbch;
    public final String zzbci;
    public final String zzbcj;
    public final boolean zzbck;

    public zzis(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, zzlw zzlw, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        this.versionCode = i;
        this.zzbbv = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzbbw = i2;
        this.zzbbx = list;
        this.zzbby = z;
        this.zzbbz = i3;
        this.zzbca = z2;
        this.zzbcb = str;
        this.zzbcc = zzlw;
        this.zzbcd = location;
        this.zzbce = str2;
        this.zzbcf = bundle2 == null ? new Bundle() : bundle2;
        this.zzbcg = bundle3;
        this.zzbch = list2;
        this.zzbci = str3;
        this.zzbcj = str4;
        this.zzbck = z3;
    }

    public static void zzh(zzis zzis) {
        zzis.zzbcf.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzis.extras);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzis)) {
            return false;
        }
        zzis zzis = (zzis) obj;
        return this.versionCode == zzis.versionCode && this.zzbbv == zzis.zzbbv && zzbg.equal(this.extras, zzis.extras) && this.zzbbw == zzis.zzbbw && zzbg.equal(this.zzbbx, zzis.zzbbx) && this.zzbby == zzis.zzbby && this.zzbbz == zzis.zzbbz && this.zzbca == zzis.zzbca && zzbg.equal(this.zzbcb, zzis.zzbcb) && zzbg.equal(this.zzbcc, zzis.zzbcc) && zzbg.equal(this.zzbcd, zzis.zzbcd) && zzbg.equal(this.zzbce, zzis.zzbce) && zzbg.equal(this.zzbcf, zzis.zzbcf) && zzbg.equal(this.zzbcg, zzis.zzbcg) && zzbg.equal(this.zzbch, zzis.zzbch) && zzbg.equal(this.zzbci, zzis.zzbci) && zzbg.equal(this.zzbcj, zzis.zzbcj) && this.zzbck == zzis.zzbck;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.versionCode), Long.valueOf(this.zzbbv), this.extras, Integer.valueOf(this.zzbbw), this.zzbbx, Boolean.valueOf(this.zzbby), Integer.valueOf(this.zzbbz), Boolean.valueOf(this.zzbca), this.zzbcb, this.zzbcc, this.zzbcd, this.zzbce, this.zzbcf, this.zzbcg, this.zzbch, this.zzbci, this.zzbcj, Boolean.valueOf(this.zzbck)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zzc(parcel, 1, this.versionCode);
        zzbem.zza(parcel, 2, this.zzbbv);
        zzbem.zza(parcel, 3, this.extras, false);
        zzbem.zzc(parcel, 4, this.zzbbw);
        zzbem.zzb(parcel, 5, this.zzbbx, false);
        zzbem.zza(parcel, 6, this.zzbby);
        zzbem.zzc(parcel, 7, this.zzbbz);
        zzbem.zza(parcel, 8, this.zzbca);
        zzbem.zza(parcel, 9, this.zzbcb, false);
        zzbem.zza(parcel, 10, (Parcelable) this.zzbcc, i, false);
        zzbem.zza(parcel, 11, (Parcelable) this.zzbcd, i, false);
        zzbem.zza(parcel, 12, this.zzbce, false);
        zzbem.zza(parcel, 13, this.zzbcf, false);
        zzbem.zza(parcel, 14, this.zzbcg, false);
        zzbem.zzb(parcel, 15, this.zzbch, false);
        zzbem.zza(parcel, 16, this.zzbci, false);
        zzbem.zza(parcel, 17, this.zzbcj, false);
        zzbem.zza(parcel, 18, this.zzbck);
        zzbem.zzai(parcel, zze);
    }
}
