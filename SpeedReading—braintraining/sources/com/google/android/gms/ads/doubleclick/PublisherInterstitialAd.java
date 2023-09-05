package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzlg;

public final class PublisherInterstitialAd {
    private final zzlg zzalb;

    public PublisherInterstitialAd(Context context) {
        this.zzalb = new zzlg(context, this);
        zzbq.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzalb.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzalb.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzalb.getAppEventListener();
    }

    public final String getMediationAdapterClassName() {
        return this.zzalb.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzalb.getOnCustomRenderedAdLoadedListener();
    }

    public final boolean isLoaded() {
        return this.zzalb.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzalb.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzalb.zza(publisherAdRequest.zzbb());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzalb.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.zzalb.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzalb.setAppEventListener(appEventListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzalb.setCorrelator(correlator);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzalb.setImmersiveMode(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzalb.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void show() {
        this.zzalb.show();
    }
}
