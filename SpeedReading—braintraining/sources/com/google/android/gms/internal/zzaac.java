package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

@zzzb
public final class zzaac extends zzaal {
    private final WeakReference<zzzr> zzcne;

    public zzaac(zzzr zzzr) {
        this.zzcne = new WeakReference<>(zzzr);
    }

    public final void zza(zzaad zzaad) {
        zzzr zzzr = (zzzr) this.zzcne.get();
        if (zzzr != null) {
            zzzr.zza(zzaad);
        }
    }
}
