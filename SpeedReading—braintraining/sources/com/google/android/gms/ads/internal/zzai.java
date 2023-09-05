package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzis;

final class zzai implements Runnable {
    private /* synthetic */ zzis zzaox;
    private /* synthetic */ zzag zzaoy;
    private /* synthetic */ int zzaoz;

    zzai(zzag zzag, zzis zzis, int i) {
        this.zzaoy = zzag;
        this.zzaox = zzis;
        this.zzaoz = i;
    }

    public final void run() {
        synchronized (this.zzaoy.mLock) {
            this.zzaoy.zzb(this.zzaox, this.zzaoz);
        }
    }
}
