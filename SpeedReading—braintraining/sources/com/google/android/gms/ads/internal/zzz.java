package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzaeu;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzamj;

final class zzz implements zzamj {
    private /* synthetic */ zzaeu zzanz;
    private /* synthetic */ Runnable zzaoa;

    zzz(zzx zzx, zzaeu zzaeu, Runnable runnable) {
        this.zzanz = zzaeu;
        this.zzaoa = runnable;
    }

    public final void zzcv() {
        if (!this.zzanz.zzcvr) {
            zzbs.zzec();
            zzagr.zzb(this.zzaoa);
        }
    }
}
