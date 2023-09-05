package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

@zzzb
public final class zznm extends zznk {
    private final OnCustomRenderedAdLoadedListener zzbeu;

    public zznm(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzbeu = onCustomRenderedAdLoadedListener;
    }

    public final void zza(zzng zzng) {
        this.zzbeu.onCustomRenderedAdLoaded(new zznf(zzng));
    }
}
