package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;

@zzzb
public final class zzom extends zzbej {
    public static final Parcelable.Creator<zzom> CREATOR = new zzon();
    public final int versionCode;
    public final boolean zzbtj;
    public final int zzbtk;
    public final boolean zzbtl;
    public final int zzbtm;
    @Nullable
    public final zzma zzbtn;

    public zzom(int i, boolean z, int i2, boolean z2, int i3, zzma zzma) {
        this.versionCode = i;
        this.zzbtj = z;
        this.zzbtk = i2;
        this.zzbtl = z2;
        this.zzbtm = i3;
        this.zzbtn = zzma;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzom(NativeAdOptions nativeAdOptions) {
        this(3, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzma(nativeAdOptions.getVideoOptions()) : null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zzc(parcel, 1, this.versionCode);
        zzbem.zza(parcel, 2, this.zzbtj);
        zzbem.zzc(parcel, 3, this.zzbtk);
        zzbem.zza(parcel, 4, this.zzbtl);
        zzbem.zzc(parcel, 5, this.zzbtm);
        zzbem.zza(parcel, 6, (Parcelable) this.zzbtn, i, false);
        zzbem.zzai(parcel, zze);
    }
}
