package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

final class zzalr implements Runnable {
    private /* synthetic */ zzalq zzdhl;

    zzalr(zzalq zzalq) {
        this.zzdhl = zzalq;
    }

    public final void run() {
        zzbs.zzey().zzb(this.zzdhl);
    }
}
