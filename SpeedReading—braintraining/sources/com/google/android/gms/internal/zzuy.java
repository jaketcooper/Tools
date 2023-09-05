package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.util.ArrayList;
import java.util.List;

@zzzb
public final class zzuy extends zzup {
    private final NativeAppInstallAdMapper zzced;

    public zzuy(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzced = nativeAppInstallAdMapper;
    }

    public final String getBody() {
        return this.zzced.getBody();
    }

    public final String getCallToAction() {
        return this.zzced.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.zzced.getExtras();
    }

    public final String getHeadline() {
        return this.zzced.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzced.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image next : images) {
            arrayList.add(new zznr(next.getDrawable(), next.getUri(), next.getScale()));
        }
        return arrayList;
    }

    public final boolean getOverrideClickHandling() {
        return this.zzced.getOverrideClickHandling();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzced.getOverrideImpressionRecording();
    }

    public final String getPrice() {
        return this.zzced.getPrice();
    }

    public final double getStarRating() {
        return this.zzced.getStarRating();
    }

    public final String getStore() {
        return this.zzced.getStore();
    }

    public final zzku getVideoController() {
        if (this.zzced.getVideoController() != null) {
            return this.zzced.getVideoController().zzbe();
        }
        return null;
    }

    public final void recordImpression() {
        this.zzced.recordImpression();
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        this.zzced.handleClick((View) zzn.zzx(iObjectWrapper));
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        this.zzced.trackView((View) zzn.zzx(iObjectWrapper));
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zzced.untrackView((View) zzn.zzx(iObjectWrapper));
    }

    public final zzoy zzjm() {
        NativeAd.Image icon = this.zzced.getIcon();
        if (icon != null) {
            return new zznr(icon.getDrawable(), icon.getUri(), icon.getScale());
        }
        return null;
    }

    public final IObjectWrapper zzjr() {
        return null;
    }

    public final zzou zzjs() {
        return null;
    }

    public final IObjectWrapper zzme() {
        View adChoicesContent = this.zzced.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return zzn.zzy(adChoicesContent);
    }

    public final IObjectWrapper zzmf() {
        View zzua = this.zzced.zzua();
        if (zzua == null) {
            return null;
        }
        return zzn.zzy(zzua);
    }
}
