package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbej;
import com.google.android.gms.internal.zzbem;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class zzc extends zzbej {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();
    public final Intent intent;
    public final String mimeType;
    public final String packageName;
    public final String url;
    private String zzcge;
    public final String zzcgf;
    public final String zzcgg;
    private String zzcgh;

    public zzc(Intent intent2) {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, intent2);
    }

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, (Intent) null);
    }

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent2) {
        this.zzcge = str;
        this.url = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.zzcgf = str5;
        this.zzcgg = str6;
        this.zzcgh = str7;
        this.intent = intent2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, this.zzcge, false);
        zzbem.zza(parcel, 3, this.url, false);
        zzbem.zza(parcel, 4, this.mimeType, false);
        zzbem.zza(parcel, 5, this.packageName, false);
        zzbem.zza(parcel, 6, this.zzcgf, false);
        zzbem.zza(parcel, 7, this.zzcgg, false);
        zzbem.zza(parcel, 8, this.zzcgh, false);
        zzbem.zza(parcel, 9, (Parcelable) this.intent, i, false);
        zzbem.zzai(parcel, zze);
    }
}
