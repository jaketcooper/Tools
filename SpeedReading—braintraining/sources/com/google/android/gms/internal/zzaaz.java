package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.p004js.zzab;

final class zzaaz implements Runnable {
    private /* synthetic */ zzaau zzcow;

    zzaaz(zzaau zzaau) {
        this.zzcow = zzaau;
    }

    public final void run() {
        if (this.zzcow.zzcov != null) {
            this.zzcow.zzcov.release();
            zzab unused = this.zzcow.zzcov = null;
        }
    }
}
