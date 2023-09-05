package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.zzbs;

final class zzvs implements Runnable {
    private /* synthetic */ AdOverlayInfoParcel zzapp;
    private /* synthetic */ zzvq zzceo;

    zzvs(zzvq zzvq, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzceo = zzvq;
        this.zzapp = adOverlayInfoParcel;
    }

    public final void run() {
        zzbs.zzea();
        zzl.zza(this.zzceo.zzcem, this.zzapp, true);
    }
}
