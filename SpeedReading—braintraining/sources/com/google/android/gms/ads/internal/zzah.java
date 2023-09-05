package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzis;

final class zzah implements Runnable {
    private /* synthetic */ zzis zzaox;
    private /* synthetic */ zzag zzaoy;

    zzah(zzag zzag, zzis zzis) {
        this.zzaoy = zzag;
        this.zzaox = zzis;
    }

    public final void run() {
        synchronized (this.zzaoy.mLock) {
            if (this.zzaoy.zzcz()) {
                this.zzaoy.zze(this.zzaox);
            } else {
                this.zzaoy.zzb(this.zzaox, 1);
            }
        }
    }
}
