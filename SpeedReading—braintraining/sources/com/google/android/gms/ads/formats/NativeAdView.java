package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzaiw;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzpc;

public class NativeAdView extends FrameLayout {
    private final FrameLayout zzaln;
    private final zzpc zzalo = zzbh();

    public NativeAdView(Context context) {
        super(context);
        this.zzaln = zzb(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzaln = zzb(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzaln = zzb(context);
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzaln = zzb(context);
    }

    private final FrameLayout zzb(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzpc zzbh() {
        zzbq.checkNotNull(this.zzaln, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzjk.zzhy().zza(this.zzaln.getContext(), (FrameLayout) this, this.zzaln);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzaln);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.zzaln != view) {
            super.bringChildToFront(this.zzaln);
        }
    }

    public void destroy() {
        try {
            this.zzalo.destroy();
        } catch (RemoteException e) {
            zzaiw.zzb("Unable to destroy native ad view", e);
        }
    }

    public AdChoicesView getAdChoicesView() {
        View zzp = zzp(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzp instanceof AdChoicesView) {
            return (AdChoicesView) zzp;
        }
        return null;
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.zzalo != null) {
            try {
                this.zzalo.zzb(zzn.zzy(view), i);
            } catch (RemoteException e) {
                zzaiw.zzb("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzaln);
    }

    public void removeView(View view) {
        if (this.zzaln != view) {
            super.removeView(view);
        }
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzalo.zza((IObjectWrapper) nativeAd.zzbg());
        } catch (RemoteException e) {
            zzaiw.zzb("Unable to call setNativeAd on delegate", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, View view) {
        try {
            this.zzalo.zzb(str, zzn.zzy(view));
        } catch (RemoteException e) {
            zzaiw.zzb("Unable to call setAssetView on delegate", e);
        }
    }

    /* access modifiers changed from: protected */
    public final View zzp(String str) {
        try {
            IObjectWrapper zzak = this.zzalo.zzak(str);
            if (zzak != null) {
                return (View) zzn.zzx(zzak);
            }
        } catch (RemoteException e) {
            zzaiw.zzb("Unable to call getAssetView on delegate", e);
        }
        return null;
    }
}
