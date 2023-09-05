package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.zzafh;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzzb;

@zzzb
final class zzam extends zzafh {
    final /* synthetic */ zzak zzapn;
    private final int zzapo;

    public zzam(zzak zzak, int i) {
        this.zzapn = zzak;
        this.zzapo = i;
    }

    public final void onStop() {
    }

    public final void zzdg() {
        zzao zzao = new zzao(this.zzapn.zzamt.zzapr, this.zzapn.zzdd(), this.zzapn.zzaph, this.zzapn.zzapi, this.zzapn.zzamt.zzapr ? this.zzapo : -1, this.zzapn.zzapj, this.zzapn.zzamt.zzati.zzapy);
        int requestedOrientation = this.zzapn.zzamt.zzati.zzchj.getRequestedOrientation();
        if (requestedOrientation == -1) {
            requestedOrientation = this.zzapn.zzamt.zzati.orientation;
        }
        zzagr.zzczc.post(new zzan(this, new AdOverlayInfoParcel(this.zzapn, this.zzapn, this.zzapn, this.zzapn.zzamt.zzati.zzchj, requestedOrientation, this.zzapn.zzamt.zzatd, this.zzapn.zzamt.zzati.zzcnl, zzao)));
    }
}
