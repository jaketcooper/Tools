package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

final class zzajf implements zzajd {
    private /* synthetic */ String zzdcd;

    zzajf(String str) {
        this.zzdcd = str;
    }

    public final void onSuccess(Object obj) {
    }

    public final void zzb(Throwable th) {
        zzbs.zzeg().zza(th, this.zzdcd);
    }
}
