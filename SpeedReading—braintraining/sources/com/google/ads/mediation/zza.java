package com.google.ads.mediation;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

final class zza implements RewardedVideoAdListener {
    private /* synthetic */ AbstractAdViewAdapter zzgt;

    zza(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzgt = abstractAdViewAdapter;
    }

    public final void onRewarded(RewardItem rewardItem) {
        this.zzgt.zzgr.onRewarded(this.zzgt, rewardItem);
    }

    public final void onRewardedVideoAdClosed() {
        this.zzgt.zzgr.onAdClosed(this.zzgt);
        InterstitialAd unused = this.zzgt.zzgq = null;
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        this.zzgt.zzgr.onAdFailedToLoad(this.zzgt, i);
    }

    public final void onRewardedVideoAdLeftApplication() {
        this.zzgt.zzgr.onAdLeftApplication(this.zzgt);
    }

    public final void onRewardedVideoAdLoaded() {
        this.zzgt.zzgr.onAdLoaded(this.zzgt);
    }

    public final void onRewardedVideoAdOpened() {
        this.zzgt.zzgr.onAdOpened(this.zzgt);
    }

    public final void onRewardedVideoStarted() {
        this.zzgt.zzgr.onVideoStarted(this.zzgt);
    }
}
