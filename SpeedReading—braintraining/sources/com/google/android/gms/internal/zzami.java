package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzn;

final class zzami implements zzn {
    private zzn zzbwp;
    private zzama zzdit;

    public zzami(zzama zzama, zzn zzn) {
        this.zzdit = zzama;
        this.zzbwp = zzn;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void zzca() {
        this.zzbwp.zzca();
        this.zzdit.zzsj();
    }

    public final void zzcb() {
        this.zzbwp.zzcb();
        this.zzdit.zzmt();
    }
}
