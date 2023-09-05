package com.google.android.gms.internal;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;

@zzzb
public final class zzada extends zzacw {
    private final RewardedVideoAdListener zzgs;

    public zzada(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzgs = rewardedVideoAdListener;
    }

    public final void onRewardedVideoAdClosed() {
        if (this.zzgs != null) {
            this.zzgs.onRewardedVideoAdClosed();
        }
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        if (this.zzgs != null) {
            this.zzgs.onRewardedVideoAdFailedToLoad(i);
        }
    }

    public final void onRewardedVideoAdLeftApplication() {
        if (this.zzgs != null) {
            this.zzgs.onRewardedVideoAdLeftApplication();
        }
    }

    public final void onRewardedVideoAdLoaded() {
        if (this.zzgs != null) {
            this.zzgs.onRewardedVideoAdLoaded();
        }
    }

    public final void onRewardedVideoAdOpened() {
        if (this.zzgs != null) {
            this.zzgs.onRewardedVideoAdOpened();
        }
    }

    public final void onRewardedVideoStarted() {
        if (this.zzgs != null) {
            this.zzgs.onRewardedVideoStarted();
        }
    }

    public final void zza(zzacn zzacn) {
        if (this.zzgs != null) {
            this.zzgs.onRewarded(new zzacy(zzacn));
        }
    }
}
