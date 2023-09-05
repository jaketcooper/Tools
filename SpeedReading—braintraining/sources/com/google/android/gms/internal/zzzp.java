package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;

@zzzb
public final class zzzp {
    /* access modifiers changed from: private */
    public static boolean zzd(Context context, boolean z) {
        if (!z) {
            return true;
        }
        zzbs.zzec();
        int zzau = zzagr.zzau(context);
        if (zzau == 0) {
            return false;
        }
        zzbs.zzec();
        return zzau <= zzagr.zzav(context);
    }
}
