package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzl;

final class zzan implements Runnable {
    private /* synthetic */ AdOverlayInfoParcel zzapp;
    private /* synthetic */ zzam zzapq;

    zzan(zzam zzam, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzapq = zzam;
        this.zzapp = adOverlayInfoParcel;
    }

    public final void run() {
        zzbs.zzea();
        zzl.zza(this.zzapq.zzapn.zzamt.zzaif, this.zzapp, true);
    }
}
