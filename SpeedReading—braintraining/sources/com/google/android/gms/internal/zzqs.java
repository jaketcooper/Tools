package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

@zzzb
public final class zzqs extends zzqi {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzbuv;

    public zzqs(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzbuv = onCustomTemplateAdLoadedListener;
    }

    public final void zzb(zzpu zzpu) {
        this.zzbuv.onCustomTemplateAdLoaded(zzpx.zza(zzpu));
    }
}
