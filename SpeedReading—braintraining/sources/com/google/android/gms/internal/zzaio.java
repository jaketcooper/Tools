package com.google.android.gms.internal;

import android.annotation.TargetApi;

@zzzb
@TargetApi(17)
public final class zzaio {
    private static zzaio zzdbi = null;
    String zzcxh;

    private zzaio() {
    }

    public static zzaio zzqn() {
        if (zzdbi == null) {
            zzdbi = new zzaio();
        }
        return zzdbi;
    }
}
