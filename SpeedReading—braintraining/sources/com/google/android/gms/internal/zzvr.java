package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzn;

final class zzvr implements zzn {
    private /* synthetic */ zzvq zzceo;

    zzvr(zzvq zzvq) {
        this.zzceo = zzvq;
    }

    public final void onPause() {
        zzaiw.zzbw("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void onResume() {
        zzaiw.zzbw("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzca() {
        zzaiw.zzbw("AdMobCustomTabsAdapter overlay is closed.");
        this.zzceo.zzcen.onAdClosed(this.zzceo);
    }

    public final void zzcb() {
        zzaiw.zzbw("Opening AdMobCustomTabsAdapter overlay.");
        this.zzceo.zzcen.onAdOpened(this.zzceo);
    }
}
