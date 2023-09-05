package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;
import java.util.List;

@zzzb
public final class zzhu extends zzbej {
    public static final Parcelable.Creator<zzhu> CREATOR = new zzhv();
    @Nullable
    public final String url;
    private long zzbag;
    private String zzbah;
    private String zzbai;
    private String zzbaj;
    private Bundle zzbak;
    private boolean zzbal;
    private long zzbam;

    zzhu(@Nullable String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z, long j2) {
        this.url = str;
        this.zzbag = j;
        this.zzbah = str2 == null ? "" : str2;
        this.zzbai = str3 == null ? "" : str3;
        this.zzbaj = str4 == null ? "" : str4;
        this.zzbak = bundle == null ? new Bundle() : bundle;
        this.zzbal = z;
        this.zzbam = j2;
    }

    @Nullable
    public static zzhu zzaa(String str) {
        return zzd(Uri.parse(str));
    }

    @Nullable
    public static zzhu zzd(Uri uri) {
        long j = 0;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                zzafj.zzco(new StringBuilder(62).append("Expected 2 path parts for namespace and id, found :").append(pathSegments.size()).toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            if (queryParameter2 != null) {
                j = Long.parseLong(queryParameter2);
            }
            Bundle bundle = new Bundle();
            for (String next : zzbs.zzee().zzg(uri)) {
                if (next.startsWith("tag.")) {
                    bundle.putString(next.substring(4), uri.getQueryParameter(next));
                }
            }
            return new zzhu(queryParameter, j, host, str, str2, bundle, equals, 0);
        } catch (NullPointerException | NumberFormatException e) {
            zzafj.zzc("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, this.url, false);
        zzbem.zza(parcel, 3, this.zzbag);
        zzbem.zza(parcel, 4, this.zzbah, false);
        zzbem.zza(parcel, 5, this.zzbai, false);
        zzbem.zza(parcel, 6, this.zzbaj, false);
        zzbem.zza(parcel, 7, this.zzbak, false);
        zzbem.zza(parcel, 8, this.zzbal);
        zzbem.zza(parcel, 9, this.zzbam);
        zzbem.zzai(parcel, zze);
    }
}
