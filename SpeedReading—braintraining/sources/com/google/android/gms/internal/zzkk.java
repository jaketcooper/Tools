package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzkk extends zzee implements zzkj {
    public zzkk() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    public static zzkj asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
        return queryLocalInterface instanceof zzkj ? (zzkj) queryLocalInterface : new zzkl(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzkb createBannerAdManager = createBannerAdManager(IObjectWrapper.zza.zzap(parcel.readStrongBinder()), (zziw) zzef.zza(parcel, zziw.CREATOR), parcel.readString(), zzud.zzt(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) createBannerAdManager);
                break;
            case 2:
                zzkb createInterstitialAdManager = createInterstitialAdManager(IObjectWrapper.zza.zzap(parcel.readStrongBinder()), (zziw) zzef.zza(parcel, zziw.CREATOR), parcel.readString(), zzud.zzt(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) createInterstitialAdManager);
                break;
            case 3:
                zzjw createAdLoaderBuilder = createAdLoaderBuilder(IObjectWrapper.zza.zzap(parcel.readStrongBinder()), parcel.readString(), zzud.zzt(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) createAdLoaderBuilder);
                break;
            case 4:
                zzkp mobileAdsSettingsManager = getMobileAdsSettingsManager(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) mobileAdsSettingsManager);
                break;
            case 5:
                zzpc createNativeAdViewDelegate = createNativeAdViewDelegate(IObjectWrapper.zza.zzap(parcel.readStrongBinder()), IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) createNativeAdViewDelegate);
                break;
            case 6:
                zzacq createRewardedVideoAd = createRewardedVideoAd(IObjectWrapper.zza.zzap(parcel.readStrongBinder()), zzud.zzt(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) createRewardedVideoAd);
                break;
            case 7:
                zzwt createInAppPurchaseManager = createInAppPurchaseManager(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) createInAppPurchaseManager);
                break;
            case 8:
                zzwj createAdOverlay = createAdOverlay(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) createAdOverlay);
                break;
            case 9:
                zzkp mobileAdsSettingsManagerWithClientJarVersion = getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper.zza.zzap(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) mobileAdsSettingsManagerWithClientJarVersion);
                break;
            case 10:
                zzkb createSearchAdManager = createSearchAdManager(IObjectWrapper.zza.zzap(parcel.readStrongBinder()), (zziw) zzef.zza(parcel, zziw.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) createSearchAdManager);
                break;
            case 11:
                zzph createNativeAdViewHolderDelegate = createNativeAdViewHolderDelegate(IObjectWrapper.zza.zzap(parcel.readStrongBinder()), IObjectWrapper.zza.zzap(parcel.readStrongBinder()), IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) createNativeAdViewHolderDelegate);
                break;
            default:
                return false;
        }
        return true;
    }
}
