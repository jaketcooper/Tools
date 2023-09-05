package com.google.android.gms.internal;

import java.util.Map;

final class zzams implements Runnable {
    private /* synthetic */ Map zzamc;
    private /* synthetic */ zzamr zzdkl;

    zzams(zzamr zzamr, Map map) {
        this.zzdkl = zzamr;
        this.zzamc = map;
    }

    public final void run() {
        this.zzdkl.zzdew.zza("pubVideoCmd", this.zzamc);
    }
}
