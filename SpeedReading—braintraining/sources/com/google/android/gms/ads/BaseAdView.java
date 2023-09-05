package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.zzaiw;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzle;

class BaseAdView extends ViewGroup {
    protected final zzle zzakz;

    public BaseAdView(Context context, int i) {
        super(context);
        this.zzakz = new zzle(this, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.zzakz = new zzle(this, attributeSet, false, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.zzakz = new zzle(this, attributeSet, false, i2);
    }

    public void destroy() {
        this.zzakz.destroy();
    }

    public AdListener getAdListener() {
        return this.zzakz.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzakz.getAdSize();
    }

    public String getAdUnitId() {
        return this.zzakz.getAdUnitId();
    }

    public String getMediationAdapterClassName() {
        return this.zzakz.getMediationAdapterClassName();
    }

    public boolean isLoading() {
        return this.zzakz.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.zzakz.zza(adRequest.zzbb());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
    public void onMeasure(int i, int i2) {
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

    public void pause() {
        this.zzakz.pause();
    }

    public void resume() {
        this.zzakz.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zzakz.setAdListener(adListener);
        if (adListener == null) {
            this.zzakz.zza((zzin) null);
            this.zzakz.setAppEventListener((AppEventListener) null);
            return;
        }
        if (adListener instanceof zzin) {
            this.zzakz.zza((zzin) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zzakz.setAppEventListener((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zzakz.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.zzakz.setAdUnitId(str);
    }
}
