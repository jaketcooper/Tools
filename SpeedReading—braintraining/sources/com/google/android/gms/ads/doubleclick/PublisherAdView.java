package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzaiw;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzle;

public final class PublisherAdView extends ViewGroup {
    private final zzle zzakz;

    public PublisherAdView(Context context) {
        super(context);
        this.zzakz = new zzle(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzakz = new zzle(this, attributeSet, true);
        zzbq.checkNotNull(context, "Context cannot be null");
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzakz = new zzle(this, attributeSet, true);
    }

    public final void destroy() {
        this.zzakz.destroy();
    }

    public final AdListener getAdListener() {
        return this.zzakz.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.zzakz.getAdSize();
    }

    public final AdSize[] getAdSizes() {
        return this.zzakz.getAdSizes();
    }

    public final String getAdUnitId() {
        return this.zzakz.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzakz.getAppEventListener();
    }

    public final String getMediationAdapterClassName() {
        return this.zzakz.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzakz.getOnCustomRenderedAdLoadedListener();
    }

    public final VideoController getVideoController() {
        return this.zzakz.getVideoController();
    }

    public final VideoOptions getVideoOptions() {
        return this.zzakz.getVideoOptions();
    }

    public final boolean isLoading() {
        return this.zzakz.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzakz.zza(publisherAdRequest.zzbb());
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        AdSize adSize;
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzaiw.zzb("Unable to retrieve ad size.", e);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                i3 = adSize.getWidthInPixels(context);
                i4 = adSize.getHeightInPixels(context);
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i3 = childAt.getMeasuredWidth();
            i4 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i2));
    }

    public final void pause() {
        this.zzakz.pause();
    }

    public final void recordManualImpression() {
        this.zzakz.recordManualImpression();
    }

    public final void resume() {
        this.zzakz.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.zzakz.setAdListener(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zzakz.zza(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        this.zzakz.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzakz.setAppEventListener(appEventListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzakz.setCorrelator(correlator);
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzakz.setManualImpressionsEnabled(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzakz.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzakz.setVideoOptions(videoOptions);
    }

    public final boolean zza(zzkb zzkb) {
        return this.zzakz.zza(zzkb);
    }
}
