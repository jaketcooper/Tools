package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzkj extends IInterface {
    zzjw createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzuc zzuc, int i) throws RemoteException;

    zzwj createAdOverlay(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzkb createBannerAdManager(IObjectWrapper iObjectWrapper, zziw zziw, String str, zzuc zzuc, int i) throws RemoteException;

    zzwt createInAppPurchaseManager(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzkb createInterstitialAdManager(IObjectWrapper iObjectWrapper, zziw zziw, String str, zzuc zzuc, int i) throws RemoteException;

    zzpc createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    zzph createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    zzacq createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzuc zzuc, int i) throws RemoteException;

    zzkb createSearchAdManager(IObjectWrapper iObjectWrapper, zziw zziw, String str, int i) throws RemoteException;

    zzkp getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzkp getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) throws RemoteException;
}
