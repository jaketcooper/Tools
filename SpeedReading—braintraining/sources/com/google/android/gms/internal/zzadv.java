package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;

@zzzb
public final class zzadv implements MediationRewardedVideoAdListener {
    private final zzads zzcuj;

    public zzadv(zzads zzads) {
        this.zzcuj = zzads;
    }

    public final void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbq.zzga("onAdClicked must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdClicked.");
        try {
            this.zzcuj.zzr(zzn.zzy(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdClicked.", e);
        }
    }

    public final void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbq.zzga("onAdClosed must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdClosed.");
        try {
            this.zzcuj.zzq(zzn.zzy(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdClosed.", e);
        }
    }

    public final void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        zzbq.zzga("onAdFailedToLoad must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdFailedToLoad.");
        try {
            this.zzcuj.zzd(zzn.zzy(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    public final void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbq.zzga("onAdLeftApplication must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdLeftApplication.");
        try {
            this.zzcuj.zzs(zzn.zzy(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    public final void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbq.zzga("onAdLoaded must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdLoaded.");
        try {
            this.zzcuj.zzn(zzn.zzy(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLoaded.", e);
        }
    }

    public final void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbq.zzga("onAdOpened must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdOpened.");
        try {
            this.zzcuj.zzo(zzn.zzy(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdOpened.", e);
        }
    }

    public final void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        zzbq.zzga("onInitializationFailed must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onInitializationFailed.");
        try {
            this.zzcuj.zzc(zzn.zzy(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onInitializationFailed.", e);
        }
    }

    public final void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbq.zzga("onInitializationSucceeded must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onInitializationSucceeded.");
        try {
            this.zzcuj.zzm(zzn.zzy(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onInitializationSucceeded.", e);
        }
    }

    public final void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        zzbq.zzga("onRewarded must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onRewarded.");
        if (rewardItem != null) {
            try {
                this.zzcuj.zza(zzn.zzy(mediationRewardedVideoAdAdapter), new zzadw(rewardItem));
            } catch (RemoteException e) {
                zzaiw.zzc("Could not call onRewarded.", e);
            }
        } else {
            this.zzcuj.zza(zzn.zzy(mediationRewardedVideoAdAdapter), new zzadw("", 1));
        }
    }

    public final void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbq.zzga("onVideoStarted must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onVideoStarted.");
        try {
            this.zzcuj.zzp(zzn.zzy(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onVideoStarted.", e);
        }
    }
}
