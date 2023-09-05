package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.Map;

@zzzb
public final class zzqw extends zzbej {
    public static final Parcelable.Creator<zzqw> CREATOR = new zzqx();
    private String url;
    private String[] zzbwu;
    private String[] zzbwv;

    zzqw(String str, String[] strArr, String[] strArr2) {
        this.url = str;
        this.zzbwu = strArr;
        this.zzbwv = strArr2;
    }

    public static zzqw zze(zzp zzp) throws zza {
        Map<String, String> headers = zzp.getHeaders();
        int size = headers.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        Iterator<Map.Entry<String, String>> it = headers.entrySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return new zzqw(zzp.getUrl(), strArr, strArr2);
            }
            Map.Entry next = it.next();
            strArr[i2] = (String) next.getKey();
            strArr2[i2] = (String) next.getValue();
            i = i2 + 1;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 1, this.url, false);
        zzbem.zza(parcel, 2, this.zzbwu, false);
        zzbem.zza(parcel, 3, this.zzbwv, false);
        zzbem.zzai(parcel, zze);
    }
}
