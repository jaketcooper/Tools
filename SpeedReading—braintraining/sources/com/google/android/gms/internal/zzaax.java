package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.p004js.zzak;

final class zzaax implements zzakd<zzak> {
    private /* synthetic */ zzaaw zzcoz;

    zzaax(zzaaw zzaaw) {
        this.zzcoz = zzaaw;
    }

    public final /* synthetic */ void zzf(Object obj) {
        try {
            ((zzak) obj).zzb("AFMA_getAdapterLessMediationAd", this.zzcoz.zzcox);
        } catch (Exception e) {
            zzafj.zzb("Error requesting an ad url", e);
            zzaau.zzcot.zzas(this.zzcoz.zzcoy);
        }
    }
}
