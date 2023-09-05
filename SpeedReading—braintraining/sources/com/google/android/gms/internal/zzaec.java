package com.google.android.gms.internal;

import android.content.Context;

@zzzb
public final class zzaec implements zzaei {
    private zzaej zzcuv;

    public zzaec(zzaej zzaej) {
        this.zzcuv = zzaej;
    }

    public final zzaeh zza(Context context, zzaiy zzaiy, zzaad zzaad) {
        if (zzaad.zzcob == null) {
            return null;
        }
        return new zzady(context, zzaiy, zzaad.zzcob, zzaad.zzchl, this.zzcuv);
    }
}
