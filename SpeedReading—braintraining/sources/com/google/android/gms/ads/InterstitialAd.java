package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzlg;

public final class InterstitialAd {
    private final zzlg zzalb;

    public InterstitialAd(Context context) {
        this.zzalb = new zzlg(context);
        zzbq.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzalb.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzalb.getAdUnitId();
    }

    public final String getMediationAdapterClassName() {
        return this.zzalb.getMediationAdapterClassName();
    }

    public final boolean isLoaded() {
        return this.zzalb.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzalb.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest) {
        this.zzalb.zza(adRequest.zzbb());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzalb.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzin)) {
            this.zzalb.zza((zzin) adListener);
        } else if (adListener == null) {
            this.zzalb.zza((zzin) null);
        }
    }

    public final void setAdUnitId(String str) {
        this.zzalb.setAdUnitId(str);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzalb.setImmersiveMode(z);
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzalb.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void show() {
        this.zzalb.show();
    }

    public final void zza(boolean z) {
        this.zzalb.zza(true);
    }
}
