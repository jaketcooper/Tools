package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzkl extends zzed implements zzkj {
    zzkl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    public final zzjw createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzuc zzuc, int i) throws RemoteException {
        zzjw zzjy;
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzaz.writeString(str);
        zzef.zza(zzaz, (IInterface) zzuc);
        zzaz.writeInt(i);
        Parcel zza = zza(3, zzaz);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzjy = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            zzjy = queryLocalInterface instanceof zzjw ? (zzjw) queryLocalInterface : new zzjy(readStrongBinder);
        }
        zza.recycle();
        return zzjy;
    }

    public final zzwj createAdOverlay(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        Parcel zza = zza(8, zzaz);
        zzwj zzu = zzwk.zzu(zza.readStrongBinder());
        zza.recycle();
        return zzu;
    }

    public final zzkb createBannerAdManager(IObjectWrapper iObjectWrapper, zziw zziw, String str, zzuc zzuc, int i) throws RemoteException {
        zzkb zzkd;
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (Parcelable) zziw);
        zzaz.writeString(str);
        zzef.zza(zzaz, (IInterface) zzuc);
        zzaz.writeInt(i);
        Parcel zza = zza(1, zzaz);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkd = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzkd = queryLocalInterface instanceof zzkb ? (zzkb) queryLocalInterface : new zzkd(readStrongBinder);
        }
        zza.recycle();
        return zzkd;
    }

    public final zzwt createInAppPurchaseManager(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        Parcel zza = zza(7, zzaz);
        zzwt zzw = zzwu.zzw(zza.readStrongBinder());
        zza.recycle();
        return zzw;
    }

    public final zzkb createInterstitialAdManager(IObjectWrapper iObjectWrapper, zziw zziw, String str, zzuc zzuc, int i) throws RemoteException {
        zzkb zzkd;
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (Parcelable) zziw);
        zzaz.writeString(str);
        zzef.zza(zzaz, (IInterface) zzuc);
        zzaz.writeInt(i);
        Parcel zza = zza(2, zzaz);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkd = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzkd = queryLocalInterface instanceof zzkb ? (zzkb) queryLocalInterface : new zzkd(readStrongBinder);
        }
        zza.recycle();
        return zzkd;
    }

    public final zzpc createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (IInterface) iObjectWrapper2);
        Parcel zza = zza(5, zzaz);
        zzpc zzl = zzpd.zzl(zza.readStrongBinder());
        zza.recycle();
        return zzl;
    }

    public final zzph createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (IInterface) iObjectWrapper2);
        zzef.zza(zzaz, (IInterface) iObjectWrapper3);
        Parcel zza = zza(11, zzaz);
        zzph zzm = zzpi.zzm(zza.readStrongBinder());
        zza.recycle();
        return zzm;
    }

    public final zzacq createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzuc zzuc, int i) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (IInterface) zzuc);
        zzaz.writeInt(i);
        Parcel zza = zza(6, zzaz);
        zzacq zzy = zzacr.zzy(zza.readStrongBinder());
        zza.recycle();
        return zzy;
    }

    public final zzkb createSearchAdManager(IObjectWrapper iObjectWrapper, zziw zziw, String str, int i) throws RemoteException {
        zzkb zzkd;
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (Parcelable) zziw);
        zzaz.writeString(str);
        zzaz.writeInt(i);
        Parcel zza = zza(10, zzaz);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkd = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzkd = queryLocalInterface instanceof zzkb ? (zzkb) queryLocalInterface : new zzkd(readStrongBinder);
        }
        zza.recycle();
        return zzkd;
    }

    public final zzkp getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzkp zzkr;
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        Parcel zza = zza(4, zzaz);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkr = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzkr = queryLocalInterface instanceof zzkp ? (zzkp) queryLocalInterface : new zzkr(readStrongBinder);
        }
        zza.recycle();
        return zzkr;
    }

    public final zzkp getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzkp zzkr;
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzaz.writeInt(i);
        Parcel zza = zza(9, zzaz);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkr = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzkr = queryLocalInterface instanceof zzkp ? (zzkp) queryLocalInterface : new zzkr(readStrongBinder);
        }
        zza.recycle();
        return zzkr;
    }
}
