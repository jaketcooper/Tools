package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.util.ArrayList;
import java.util.List;

@zzzb
public final class zzuz extends zzus {
    private final NativeContentAdMapper zzcee;

    public zzuz(NativeContentAdMapper nativeContentAdMapper) {
        this.zzcee = nativeContentAdMapper;
    }

    public final String getAdvertiser() {
        return this.zzcee.getAdvertiser();
    }

    public final String getBody() {
        return this.zzcee.getBody();
    }

    public final String getCallToAction() {
        return this.zzcee.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.zzcee.getExtras();
    }

    public final String getHeadline() {
        return this.zzcee.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzcee.getImages();
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
        return this.zzcee.getOverrideClickHandling();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzcee.getOverrideImpressionRecording();
    }

    public final zzku getVideoController() {
        if (this.zzcee.getVideoController() != null) {
            return this.zzcee.getVideoController().zzbe();
        }
        return null;
    }

    public final void recordImpression() {
        this.zzcee.recordImpression();
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        this.zzcee.handleClick((View) zzn.zzx(iObjectWrapper));
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        this.zzcee.trackView((View) zzn.zzx(iObjectWrapper));
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zzcee.untrackView((View) zzn.zzx(iObjectWrapper));
    }

    public final IObjectWrapper zzjr() {
        return null;
    }

    public final zzou zzjs() {
        return null;
    }

    public final zzoy zzjt() {
        NativeAd.Image logo = this.zzcee.getLogo();
        if (logo != null) {
            return new zznr(logo.getDrawable(), logo.getUri(), logo.getScale());
        }
        return null;
    }

    public final IObjectWrapper zzme() {
        View adChoicesContent = this.zzcee.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return zzn.zzy(adChoicesContent);
    }

    public final IObjectWrapper zzmf() {
        View zzua = this.zzcee.zzua();
        if (zzua == null) {
            return null;
        }
        return zzn.zzy(zzua);
    }
}
