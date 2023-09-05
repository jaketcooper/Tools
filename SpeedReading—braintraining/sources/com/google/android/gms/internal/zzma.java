package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;

@zzzb
public final class zzma extends zzbej {
    public static final Parcelable.Creator<zzma> CREATOR = new zzmb();
    public final boolean zzbfk;
    public final boolean zzbfl;
    public final boolean zzbfm;

    public zzma(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    public zzma(boolean z, boolean z2, boolean z3) {
        this.zzbfk = z;
        this.zzbfl = z2;
        this.zzbfm = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, this.zzbfk);
        zzbem.zza(parcel, 3, this.zzbfl);
        zzbem.zza(parcel, 4, this.zzbfm);
        zzbem.zzai(parcel, zze);
    }
}
