package com.google.android.gms.ads.search;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.zzaiw;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class SearchAdView extends ViewGroup {
    private final zzle zzakz;

    public SearchAdView(Context context) {
        super(context);
        this.zzakz = new zzle(this);
    }

    public SearchAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzakz = new zzle(this, attributeSet, false);
    }

    public SearchAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzakz = new zzle(this, attributeSet, false);
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

    public final String getAdUnitId() {
        return this.zzakz.getAdUnitId();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(DynamicHeightSearchAdRequest dynamicHeightSearchAdRequest) {
        if (!AdSize.SEARCH.equals(getAdSize())) {
            throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
        }
        this.zzakz.zza(dynamicHeightSearchAdRequest.zzbb());
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(SearchAdRequest searchAdRequest) {
        this.zzakz.zza(searchAdRequest.zzbb());
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

    public final void resume() {
        this.zzakz.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.zzakz.setAdListener(adListener);
    }

    public final void setAdSize(AdSize adSize) {
        this.zzakz.setAdSizes(adSize);
    }

    public final void setAdUnitId(String str) {
        this.zzakz.setAdUnitId(str);
    }
}
