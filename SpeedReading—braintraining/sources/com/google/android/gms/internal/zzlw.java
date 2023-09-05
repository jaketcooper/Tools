package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;

@zzzb
public final class zzlw extends zzbej {
    public static final Parcelable.Creator<zzlw> CREATOR = new zzlx();
    public final String zzbfj;

    public zzlw(SearchAdRequest searchAdRequest) {
        this.zzbfj = searchAdRequest.getQuery();
    }

    zzlw(String str) {
        this.zzbfj = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 15, this.zzbfj, false);
        zzbem.zzai(parcel, zze);
    }
}
