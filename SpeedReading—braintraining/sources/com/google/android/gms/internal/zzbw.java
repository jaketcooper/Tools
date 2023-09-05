package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.security.GeneralSecurityException;

final class zzbw {
    static zzdor zzyu;

    static boolean zzz() {
        if (zzyu != null) {
            return true;
        }
        String str = (String) zzbs.zzep().zzd(zzmq.zzbmb);
        if (str.length() == 0) {
            return false;
        }
        try {
            try {
                zzdot zzac = zzdov.zzac(zzbr.zza(str, true));
                zzdpi.zzblj();
                zzyu = zzdpj.zza(zzac);
                return zzyu != null;
            } catch (GeneralSecurityException e) {
                return false;
            }
        } catch (IllegalArgumentException e2) {
            return false;
        }
    }
}
