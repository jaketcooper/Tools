package com.google.android.gms.internal;

import android.support.annotation.Nullable;

@zzzb
public final class zzmw {
    public static boolean zza(@Nullable zznd zznd, @Nullable zznb zznb, String... strArr) {
        if (zznd == null || zznb == null) {
            return false;
        }
        return zznd.zza(zznb, strArr);
    }

    @Nullable
    public static zznb zzb(@Nullable zznd zznd) {
        if (zznd == null) {
            return null;
        }
        return zznd.zziz();
    }
}
