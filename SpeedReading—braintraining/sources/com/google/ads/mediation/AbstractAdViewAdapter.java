package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.zzais;
import com.google.android.gms.internal.zzaiw;
import com.google.android.gms.internal.zzanr;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzzb;
import java.util.Date;
import java.util.Set;

@zzzb
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, com.google.android.gms.ads.mediation.zza, MediationRewardedVideoAdAdapter, zzanr {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzgm;
    private InterstitialAd zzgn;
    private AdLoader zzgo;
    private Context zzgp;
    /* access modifiers changed from: private */
    public InterstitialAd zzgq;
    /* access modifiers changed from: private */
    public MediationRewardedVideoAdListener zzgr;
    private RewardedVideoAdListener zzgs = new zza(this);

    static class zza extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd zzgu;

        public zza(NativeAppInstallAd nativeAppInstallAd) {
            this.zzgu = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzgu);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzalq.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.zzgu);
            }
        }
    }

    static class zzb extends NativeContentAdMapper {
        private final NativeContentAd zzgv;

        public zzb(NativeContentAd nativeContentAd) {
            this.zzgv = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeContentAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzgv);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzalq.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.zzgv);
            }
        }
    }

    static final class zzc extends AdListener implements AppEventListener, zzin {
        private AbstractAdViewAdapter zzgw;
        private MediationBannerListener zzgx;

        public zzc(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.zzgw = abstractAdViewAdapter;
            this.zzgx = mediationBannerListener;
        }

        public final void onAdClicked() {
            this.zzgx.onAdClicked(this.zzgw);
        }

        public final void onAdClosed() {
            this.zzgx.onAdClosed(this.zzgw);
        }

        public final void onAdFailedToLoad(int i) {
            this.zzgx.onAdFailedToLoad(this.zzgw, i);
        }

        public final void onAdLeftApplication() {
            this.zzgx.onAdLeftApplication(this.zzgw);
        }

        public final void onAdLoaded() {
            this.zzgx.onAdLoaded(this.zzgw);
        }

        public final void onAdOpened() {
            this.zzgx.onAdOpened(this.zzgw);
        }

        public final void onAppEvent(String str, String str2) {
            this.zzgx.zza(this.zzgw, str, str2);
        }
    }

    static final class zzd extends AdListener implements zzin {
        private AbstractAdViewAdapter zzgw;
        private MediationInterstitialListener zzgy;

        public zzd(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzgw = abstractAdViewAdapter;
            this.zzgy = mediationInterstitialListener;
        }

        public final void onAdClicked() {
            this.zzgy.onAdClicked(this.zzgw);
        }

        public final void onAdClosed() {
            this.zzgy.onAdClosed(this.zzgw);
        }

        public final void onAdFailedToLoad(int i) {
            this.zzgy.onAdFailedToLoad(this.zzgw, i);
        }

        public final void onAdLeftApplication() {
            this.zzgy.onAdLeftApplication(this.zzgw);
        }

        public final void onAdLoaded() {
            this.zzgy.onAdLoaded(this.zzgw);
        }

        public final void onAdOpened() {
            this.zzgy.onAdOpened(this.zzgw);
        }
    }

    static final class zze extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener {
        private AbstractAdViewAdapter zzgw;
        private MediationNativeListener zzgz;

        public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.zzgw = abstractAdViewAdapter;
            this.zzgz = mediationNativeListener;
        }

        public final void onAdClicked() {
            this.zzgz.onAdClicked(this.zzgw);
        }

        public final void onAdClosed() {
            this.zzgz.onAdClosed(this.zzgw);
        }

        public final void onAdFailedToLoad(int i) {
            this.zzgz.onAdFailedToLoad(this.zzgw, i);
        }

        public final void onAdImpression() {
            this.zzgz.onAdImpression(this.zzgw);
        }

        public final void onAdLeftApplication() {
            this.zzgz.onAdLeftApplication(this.zzgw);
        }

        public final void onAdLoaded() {
        }

        public final void onAdOpened() {
            this.zzgz.onAdOpened(this.zzgw);
        }

        public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.zzgz.onAdLoaded(this.zzgw, new zza(nativeAppInstallAd));
        }

        public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.zzgz.onAdLoaded(this.zzgw, new zzb(nativeContentAd));
        }

        public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.zzgz.zza(this.zzgw, nativeCustomTemplateAd, str);
        }

        public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.zzgz.zza(this.zzgw, nativeCustomTemplateAd);
        }
    }

    private final AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            zzjk.zzhx();
            builder.addTestDevice(zzais.zzbb(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.tagForChildDirectedTreatment(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzgm;
    }

    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().zzah(1).zztz();
    }

    public zzku getVideoController() {
        VideoController videoController;
        if (this.zzgm == null || (videoController = this.zzgm.getVideoController()) == null) {
            return null;
        }
        return videoController.zzbe();
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzgp = context.getApplicationContext();
        this.zzgr = mediationRewardedVideoAdListener;
        this.zzgr.onInitializationSucceeded(this);
    }

    public boolean isInitialized() {
        return this.zzgr != null;
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        if (this.zzgp == null || this.zzgr == null) {
            zzaiw.m12e("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzgq = new InterstitialAd(this.zzgp);
        this.zzgq.zza(true);
        this.zzgq.setAdUnitId(getAdUnitId(bundle));
        this.zzgq.setRewardedVideoAdListener(this.zzgs);
        this.zzgq.loadAd(zza(this.zzgp, mediationAdRequest, bundle2, bundle));
    }

    public void onDestroy() {
        if (this.zzgm != null) {
            this.zzgm.destroy();
            this.zzgm = null;
        }
        if (this.zzgn != null) {
            this.zzgn = null;
        }
        if (this.zzgo != null) {
            this.zzgo = null;
        }
        if (this.zzgq != null) {
            this.zzgq = null;
        }
    }

    public void onImmersiveModeUpdated(boolean z) {
        if (this.zzgn != null) {
            this.zzgn.setImmersiveMode(z);
        }
        if (this.zzgq != null) {
            this.zzgq.setImmersiveMode(z);
        }
    }

    public void onPause() {
        if (this.zzgm != null) {
            this.zzgm.pause();
        }
    }

    public void onResume() {
        if (this.zzgm != null) {
            this.zzgm.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzgm = new AdView(context);
        this.zzgm.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzgm.setAdUnitId(getAdUnitId(bundle));
        this.zzgm.setAdListener(new zzc(this, mediationBannerListener));
        this.zzgm.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzgn = new InterstitialAd(context);
        this.zzgn.setAdUnitId(getAdUnitId(bundle));
        this.zzgn.setAdListener(new zzd(this, mediationInterstitialListener));
        this.zzgn.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        zze zze2 = new zze(this, mediationNativeListener);
        AdLoader.Builder withAdListener = new AdLoader.Builder(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(zze2);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(zze2);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(zze2);
        }
        if (nativeMediationAdRequest.zzmi()) {
            for (String next : nativeMediationAdRequest.zzmj().keySet()) {
                withAdListener.forCustomTemplateAd(next, zze2, nativeMediationAdRequest.zzmj().get(next).booleanValue() ? zze2 : null);
            }
        }
        this.zzgo = withAdListener.build();
        this.zzgo.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.zzgn.show();
    }

    public void showVideo() {
        this.zzgq.show();
    }

    /* access modifiers changed from: protected */
    public abstract Bundle zza(Bundle bundle, Bundle bundle2);
}
