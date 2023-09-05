package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

@zzzb
public final class zzip extends zzjr {
    private final AdListener zzbbu;

    public zzip(AdListener adListener) {
        this.zzbbu = adListener;
    }

    public final AdListener getAdListener() {
        return this.zzbbu;
    }

    public final void onAdClicked() {
        this.zzbbu.onAdClicked();
    }

    public final void onAdClosed() {
        this.zzbbu.onAdClosed();
    }

    public final void onAdFailedToLoad(int i) {
        this.zzbbu.onAdFailedToLoad(i);
    }

    public final void onAdImpression() {
        this.zzbbu.onAdImpression();
    }

    public final void onAdLeftApplication() {
        this.zzbbu.onAdLeftApplication();
    }

    public final void onAdLoaded() {
        this.zzbbu.onAdLoaded();
    }

    public final void onAdOpened() {
        this.zzbbu.onAdOpened();
    }
}
