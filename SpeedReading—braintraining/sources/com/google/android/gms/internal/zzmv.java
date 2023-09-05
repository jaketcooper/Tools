package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;

@zzzb
public final class zzmv {
    @Nullable
    public static zzmt zza(@Nullable zzms zzms) {
        if (!zzms.zzis()) {
            zzafj.m11v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (zzms.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzms.zzfo())) {
            return new zzmt(zzms.getContext(), zzms.zzfo(), zzms.zzit(), zzms.zziu());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
