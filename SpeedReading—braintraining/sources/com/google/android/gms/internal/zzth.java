package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.p004js.zzab;

final class zzth implements zzakb {
    private /* synthetic */ zzab zzcav;
    private /* synthetic */ zzajy zzcax;

    zzth(zztf zztf, zzajy zzajy, zzab zzab) {
        this.zzcax = zzajy;
        this.zzcav = zzab;
    }

    public final void run() {
        this.zzcax.setException(new zzst("Unable to obtain a JavascriptEngine."));
        this.zzcav.release();
    }
}
