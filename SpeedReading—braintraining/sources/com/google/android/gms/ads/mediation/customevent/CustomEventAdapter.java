package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzaiw;

@KeepName
@KeepForSdkWithMembers
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    private CustomEventBanner zzdla;
    private CustomEventInterstitial zzdlb;
    private CustomEventNative zzdlc;
    private View zzhf;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzdld;
        private final MediationBannerListener zzgx;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzdld = customEventAdapter;
            this.zzgx = mediationBannerListener;
        }

        public final void onAdClicked() {
            zzaiw.zzbw("Custom event adapter called onAdClicked.");
            this.zzgx.onAdClicked(this.zzdld);
        }

        public final void onAdClosed() {
            zzaiw.zzbw("Custom event adapter called onAdClosed.");
            this.zzgx.onAdClosed(this.zzdld);
        }

        public final void onAdFailedToLoad(int i) {
            zzaiw.zzbw("Custom event adapter called onAdFailedToLoad.");
            this.zzgx.onAdFailedToLoad(this.zzdld, i);
        }

        public final void onAdLeftApplication() {
            zzaiw.zzbw("Custom event adapter called onAdLeftApplication.");
            this.zzgx.onAdLeftApplication(this.zzdld);
        }

        public final void onAdLoaded(View view) {
            zzaiw.zzbw("Custom event adapter called onAdLoaded.");
            this.zzdld.zza(view);
            this.zzgx.onAdLoaded(this.zzdld);
        }

        public final void onAdOpened() {
            zzaiw.zzbw("Custom event adapter called onAdOpened.");
            this.zzgx.onAdOpened(this.zzdld);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzdld;
        private final MediationInterstitialListener zzgy;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzdld = customEventAdapter;
            this.zzgy = mediationInterstitialListener;
        }

        public final void onAdClicked() {
            zzaiw.zzbw("Custom event adapter called onAdClicked.");
            this.zzgy.onAdClicked(this.zzdld);
        }

        public final void onAdClosed() {
            zzaiw.zzbw("Custom event adapter called onAdClosed.");
            this.zzgy.onAdClosed(this.zzdld);
        }

        public final void onAdFailedToLoad(int i) {
            zzaiw.zzbw("Custom event adapter called onFailedToReceiveAd.");
            this.zzgy.onAdFailedToLoad(this.zzdld, i);
        }

        public final void onAdLeftApplication() {
            zzaiw.zzbw("Custom event adapter called onAdLeftApplication.");
            this.zzgy.onAdLeftApplication(this.zzdld);
        }

        public final void onAdLoaded() {
            zzaiw.zzbw("Custom event adapter called onReceivedAd.");
            this.zzgy.onAdLoaded(CustomEventAdapter.this);
        }

        public final void onAdOpened() {
            zzaiw.zzbw("Custom event adapter called onAdOpened.");
            this.zzgy.onAdOpened(this.zzdld);
        }
    }

    static class zzc implements CustomEventNativeListener {
        private final CustomEventAdapter zzdld;
        private final MediationNativeListener zzgz;

        public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzdld = customEventAdapter;
            this.zzgz = mediationNativeListener;
        }

        public final void onAdClicked() {
            zzaiw.zzbw("Custom event adapter called onAdClicked.");
            this.zzgz.onAdClicked(this.zzdld);
        }

        public final void onAdClosed() {
            zzaiw.zzbw("Custom event adapter called onAdClosed.");
            this.zzgz.onAdClosed(this.zzdld);
        }

        public final void onAdFailedToLoad(int i) {
            zzaiw.zzbw("Custom event adapter called onAdFailedToLoad.");
            this.zzgz.onAdFailedToLoad(this.zzdld, i);
        }

        public final void onAdImpression() {
            zzaiw.zzbw("Custom event adapter called onAdImpression.");
            this.zzgz.onAdImpression(this.zzdld);
        }

        public final void onAdLeftApplication() {
            zzaiw.zzbw("Custom event adapter called onAdLeftApplication.");
            this.zzgz.onAdLeftApplication(this.zzdld);
        }

        public final void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzaiw.zzbw("Custom event adapter called onAdLoaded.");
            this.zzgz.onAdLoaded(this.zzdld, nativeAdMapper);
        }

        public final void onAdOpened() {
            zzaiw.zzbw("Custom event adapter called onAdOpened.");
            this.zzgz.onAdOpened(this.zzdld);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(View view) {
        this.zzhf = view;
    }

    private static <T> T zzh(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            zzaiw.zzco(new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(message).toString());
            return null;
        }
    }

    public final View getBannerView() {
        return this.zzhf;
    }

    public final void onDestroy() {
        if (this.zzdla != null) {
            this.zzdla.onDestroy();
        }
        if (this.zzdlb != null) {
            this.zzdlb.onDestroy();
        }
        if (this.zzdlc != null) {
            this.zzdlc.onDestroy();
        }
    }

    public final void onPause() {
        if (this.zzdla != null) {
            this.zzdla.onPause();
        }
        if (this.zzdlb != null) {
            this.zzdlb.onPause();
        }
        if (this.zzdlc != null) {
            this.zzdlc.onPause();
        }
    }

    public final void onResume() {
        if (this.zzdla != null) {
            this.zzdla.onResume();
        }
        if (this.zzdlb != null) {
            this.zzdlb.onResume();
        }
        if (this.zzdlc != null) {
            this.zzdlc.onResume();
        }
    }

    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdla = (CustomEventBanner) zzh(bundle.getString("class_name"));
        if (this.zzdla == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzdla.requestBannerAd(context, new zza(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdlb = (CustomEventInterstitial) zzh(bundle.getString("class_name"));
        if (this.zzdlb == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzdlb.requestInterstitialAd(context, new zzb(this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.zzdlc = (CustomEventNative) zzh(bundle.getString("class_name"));
        if (this.zzdlc == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzdlc.requestNativeAd(context, new zzc(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public final void showInterstitial() {
        this.zzdlb.showInterstitial();
    }
}
