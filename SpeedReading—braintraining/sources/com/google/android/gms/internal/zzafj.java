package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.ads.internal.zzbs;

@zzzb
public final class zzafj extends zzaiw {
    /* renamed from: v */
    public static void m11v(String str) {
        if (zzpt()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean zzpt() {
        if (zzae(2)) {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbkx)).booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
