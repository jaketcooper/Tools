package com.google.android.gms.internal;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.zzb;
import java.util.Date;
import java.util.HashSet;

@zzzb
public final class zzvo {
    public static int zza(AdRequest.ErrorCode errorCode) {
        switch (zzvp.zzcel[errorCode.ordinal()]) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    public static MediationAdRequest zza(zzis zzis, boolean z) {
        AdRequest.Gender gender;
        HashSet hashSet = zzis.zzbbx != null ? new HashSet(zzis.zzbbx) : null;
        Date date = new Date(zzis.zzbbv);
        switch (zzis.zzbbw) {
            case 1:
                gender = AdRequest.Gender.MALE;
                break;
            case 2:
                gender = AdRequest.Gender.FEMALE;
                break;
            default:
                gender = AdRequest.Gender.UNKNOWN;
                break;
        }
        return new MediationAdRequest(date, gender, hashSet, z, zzis.zzbcd);
    }

    public static AdSize zzb(zziw zziw) {
        AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        for (int i = 0; i < 6; i++) {
            if (adSizeArr[i].getWidth() == zziw.width && adSizeArr[i].getHeight() == zziw.height) {
                return adSizeArr[i];
            }
        }
        return new AdSize(zzb.zza(zziw.width, zziw.height, zziw.zzbda));
    }
}
