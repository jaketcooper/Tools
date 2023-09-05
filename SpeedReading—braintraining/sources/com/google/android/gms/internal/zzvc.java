package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@zzzb
public final class zzvc<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */
    public final zzui zzcea;

    public zzvc(zzui zzui) {
        this.zzcea = zzui;
    }

    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaiw.zzbw("Adapter called onClick.");
        zzjk.zzhx();
        if (!zzais.zzqt()) {
            zzaiw.zzco("onClick must be called on the main UI thread.");
            zzais.zzdbs.post(new zzvd(this));
            return;
        }
        try {
            this.zzcea.onAdClicked();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdClicked.", e);
        }
    }

    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaiw.zzbw("Adapter called onDismissScreen.");
        zzjk.zzhx();
        if (!zzais.zzqt()) {
            zzaiw.zzco("onDismissScreen must be called on the main UI thread.");
            zzais.zzdbs.post(new zzvg(this));
            return;
        }
        try {
            this.zzcea.onAdClosed();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdClosed.", e);
        }
    }

    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaiw.zzbw("Adapter called onDismissScreen.");
        zzjk.zzhx();
        if (!zzais.zzqt()) {
            zzaiw.zzco("onDismissScreen must be called on the main UI thread.");
            zzais.zzdbs.post(new zzvl(this));
            return;
        }
        try {
            this.zzcea.onAdClosed();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdClosed.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzaiw.zzbw(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(valueOf).toString());
        zzjk.zzhx();
        if (!zzais.zzqt()) {
            zzaiw.zzco("onFailedToReceiveAd must be called on the main UI thread.");
            zzais.zzdbs.post(new zzvh(this, errorCode));
            return;
        }
        try {
            this.zzcea.onAdFailedToLoad(zzvo.zza(errorCode));
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzaiw.zzbw(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(valueOf).append(".").toString());
        zzjk.zzhx();
        if (!zzais.zzqt()) {
            zzaiw.zzco("onFailedToReceiveAd must be called on the main UI thread.");
            zzais.zzdbs.post(new zzvm(this, errorCode));
            return;
        }
        try {
            this.zzcea.onAdFailedToLoad(zzvo.zza(errorCode));
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaiw.zzbw("Adapter called onLeaveApplication.");
        zzjk.zzhx();
        if (!zzais.zzqt()) {
            zzaiw.zzco("onLeaveApplication must be called on the main UI thread.");
            zzais.zzdbs.post(new zzvi(this));
            return;
        }
        try {
            this.zzcea.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaiw.zzbw("Adapter called onLeaveApplication.");
        zzjk.zzhx();
        if (!zzais.zzqt()) {
            zzaiw.zzco("onLeaveApplication must be called on the main UI thread.");
            zzais.zzdbs.post(new zzvn(this));
            return;
        }
        try {
            this.zzcea.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaiw.zzbw("Adapter called onPresentScreen.");
        zzjk.zzhx();
        if (!zzais.zzqt()) {
            zzaiw.zzco("onPresentScreen must be called on the main UI thread.");
            zzais.zzdbs.post(new zzvj(this));
            return;
        }
        try {
            this.zzcea.onAdOpened();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdOpened.", e);
        }
    }

    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaiw.zzbw("Adapter called onPresentScreen.");
        zzjk.zzhx();
        if (!zzais.zzqt()) {
            zzaiw.zzco("onPresentScreen must be called on the main UI thread.");
            zzais.zzdbs.post(new zzve(this));
            return;
        }
        try {
            this.zzcea.onAdOpened();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdOpened.", e);
        }
    }

    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaiw.zzbw("Adapter called onReceivedAd.");
        zzjk.zzhx();
        if (!zzais.zzqt()) {
            zzaiw.zzco("onReceivedAd must be called on the main UI thread.");
            zzais.zzdbs.post(new zzvk(this));
            return;
        }
        try {
            this.zzcea.onAdLoaded();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLoaded.", e);
        }
    }

    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaiw.zzbw("Adapter called onReceivedAd.");
        zzjk.zzhx();
        if (!zzais.zzqt()) {
            zzaiw.zzco("onReceivedAd must be called on the main UI thread.");
            zzais.zzdbs.post(new zzvf(this));
            return;
        }
        try {
            this.zzcea.onAdLoaded();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLoaded.", e);
        }
    }
}
