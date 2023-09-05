package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

@zzzb
public final class zzqp extends zzpz {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzbus;

    public zzqp(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzbus = onAppInstallAdLoadedListener;
    }

    public final void zza(zzpm zzpm) {
        this.zzbus.onAppInstallAdLoaded(new zzpp(zzpm));
    }
}
