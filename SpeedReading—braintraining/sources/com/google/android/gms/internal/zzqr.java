package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

@zzzb
public final class zzqr extends zzqf {
    private final NativeCustomTemplateAd.OnCustomClickListener zzbuu;

    public zzqr(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzbuu = onCustomClickListener;
    }

    public final void zzb(zzpu zzpu, String str) {
        this.zzbuu.onCustomClick(zzpx.zza(zzpu), str);
    }
}
