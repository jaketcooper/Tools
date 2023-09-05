package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.zzbq;

@zzzb
public final class zzux implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzui zzcea;
    private NativeAdMapper zzceb;
    private NativeCustomTemplateAd zzcec;

    public zzux(zzui zzui) {
        this.zzcea = zzui;
    }

    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        zzbq.zzga("onAdClicked must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdClicked.");
        try {
            this.zzcea.onAdClicked();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdClicked.", e);
        }
    }

    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzbq.zzga("onAdClicked must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdClicked.");
        try {
            this.zzcea.onAdClicked();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdClicked.", e);
        }
    }

    public final void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        zzbq.zzga("onAdClicked must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.zzceb;
        if (this.zzcec == null) {
            if (nativeAdMapper == null) {
                zzaiw.zzco("Could not call onAdClicked since NativeAdMapper is null.");
                return;
            } else if (!nativeAdMapper.getOverrideClickHandling()) {
                zzaiw.zzbw("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        zzaiw.zzbw("Adapter called onAdClicked.");
        try {
            this.zzcea.onAdClicked();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdClicked.", e);
        }
    }

    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        zzbq.zzga("onAdClosed must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdClosed.");
        try {
            this.zzcea.onAdClosed();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdClosed.", e);
        }
    }

    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzbq.zzga("onAdClosed must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdClosed.");
        try {
            this.zzcea.onAdClosed();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdClosed.", e);
        }
    }

    public final void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        zzbq.zzga("onAdClosed must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdClosed.");
        try {
            this.zzcea.onAdClosed();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdClosed.", e);
        }
    }

    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        zzbq.zzga("onAdFailedToLoad must be called on the main UI thread.");
        zzaiw.zzbw(new StringBuilder(55).append("Adapter called onAdFailedToLoad with error. ").append(i).toString());
        try {
            this.zzcea.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        zzbq.zzga("onAdFailedToLoad must be called on the main UI thread.");
        zzaiw.zzbw(new StringBuilder(55).append("Adapter called onAdFailedToLoad with error ").append(i).append(".").toString());
        try {
            this.zzcea.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        zzbq.zzga("onAdFailedToLoad must be called on the main UI thread.");
        zzaiw.zzbw(new StringBuilder(55).append("Adapter called onAdFailedToLoad with error ").append(i).append(".").toString());
        try {
            this.zzcea.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    public final void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        zzbq.zzga("onAdImpression must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.zzceb;
        if (this.zzcec == null) {
            if (nativeAdMapper == null) {
                zzaiw.zzco("Could not call onAdImpression since NativeAdMapper is null. ");
                return;
            } else if (!nativeAdMapper.getOverrideImpressionRecording()) {
                zzaiw.zzbw("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        zzaiw.zzbw("Adapter called onAdImpression.");
        try {
            this.zzcea.onAdImpression();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdImpression.", e);
        }
    }

    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        zzbq.zzga("onAdLeftApplication must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdLeftApplication.");
        try {
            this.zzcea.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzbq.zzga("onAdLeftApplication must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdLeftApplication.");
        try {
            this.zzcea.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    public final void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        zzbq.zzga("onAdLeftApplication must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdLeftApplication.");
        try {
            this.zzcea.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        zzbq.zzga("onAdLoaded must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdLoaded.");
        try {
            this.zzcea.onAdLoaded();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLoaded.", e);
        }
    }

    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzbq.zzga("onAdLoaded must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdLoaded.");
        try {
            this.zzcea.onAdLoaded();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLoaded.", e);
        }
    }

    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        zzbq.zzga("onAdLoaded must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdLoaded.");
        this.zzceb = nativeAdMapper;
        if (!(mediationNativeAdapter instanceof AdMobAdapter) && nativeAdMapper.hasVideoContent()) {
            VideoController videoController = new VideoController();
            videoController.zza(new zzuu());
            this.zzceb.zza(videoController);
        }
        try {
            this.zzcea.onAdLoaded();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLoaded.", e);
        }
    }

    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        zzbq.zzga("onAdOpened must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdOpened.");
        try {
            this.zzcea.onAdOpened();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdOpened.", e);
        }
    }

    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzbq.zzga("onAdOpened must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdOpened.");
        try {
            this.zzcea.onAdOpened();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdOpened.", e);
        }
    }

    public final void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        zzbq.zzga("onAdOpened must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAdOpened.");
        try {
            this.zzcea.onAdOpened();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdOpened.", e);
        }
    }

    public final void onVideoEnd(MediationNativeAdapter mediationNativeAdapter) {
        zzbq.zzga("onVideoEnd must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onVideoEnd.");
        try {
            this.zzcea.onVideoEnd();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onVideoEnd.", e);
        }
    }

    public final void zza(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        zzbq.zzga("onAppEvent must be called on the main UI thread.");
        zzaiw.zzbw("Adapter called onAppEvent.");
        try {
            this.zzcea.onAppEvent(str, str2);
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAppEvent.", e);
        }
    }

    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd) {
        zzbq.zzga("onAdLoaded must be called on the main UI thread.");
        String valueOf = String.valueOf(nativeCustomTemplateAd.getCustomTemplateId());
        zzaiw.zzbw(valueOf.length() != 0 ? "Adapter called onAdLoaded with template id ".concat(valueOf) : new String("Adapter called onAdLoaded with template id "));
        this.zzcec = nativeCustomTemplateAd;
        try {
            this.zzcea.onAdLoaded();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdLoaded.", e);
        }
    }

    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        if (nativeCustomTemplateAd instanceof zzpx) {
            try {
                this.zzcea.zzb(((zzpx) nativeCustomTemplateAd).zzkg(), str);
            } catch (RemoteException e) {
                zzaiw.zzc("Could not call onCustomClick.", e);
            }
        } else {
            zzaiw.zzco("Unexpected native custom template ad type.");
        }
    }

    public final NativeAdMapper zzmg() {
        return this.zzceb;
    }

    public final NativeCustomTemplateAd zzmh() {
        return this.zzcec;
    }
}
