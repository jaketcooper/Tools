package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbl;
import com.google.android.gms.ads.internal.zzv;

@zzzb
public final class zzamk {
    public final zzama zza(Context context, zzanp zzanp, String str, boolean z, boolean z2, @Nullable zzcs zzcs, zzaiy zzaiy, zznd zznd, zzbl zzbl, zzv zzv, zzib zzib) throws zzamm {
        try {
            return (zzama) zzain.zzb(context, new zzaml(this, context, zzanp, str, z, z2, zzcs, zzaiy, zznd, zzbl, zzv, zzib));
        } catch (Throwable th) {
            throw new zzamm(this, "Webview initialization failed.", th);
        }
    }
}
