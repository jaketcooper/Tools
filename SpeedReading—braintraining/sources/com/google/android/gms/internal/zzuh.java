package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public final class zzuh extends zzed implements zzuf {
    zzuh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final void destroy() throws RemoteException {
        zzb(5, zzaz());
    }

    public final Bundle getInterstitialAdapterInfo() throws RemoteException {
        Parcel zza = zza(18, zzaz());
        Bundle bundle = (Bundle) zzef.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final zzku getVideoController() throws RemoteException {
        Parcel zza = zza(26, zzaz());
        zzku zzh = zzkv.zzh(zza.readStrongBinder());
        zza.recycle();
        return zzh;
    }

    public final IObjectWrapper getView() throws RemoteException {
        Parcel zza = zza(2, zzaz());
        IObjectWrapper zzap = IObjectWrapper.zza.zzap(zza.readStrongBinder());
        zza.recycle();
        return zzap;
    }

    public final boolean isInitialized() throws RemoteException {
        Parcel zza = zza(13, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void pause() throws RemoteException {
        zzb(8, zzaz());
    }

    public final void resume() throws RemoteException {
        zzb(9, zzaz());
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, z);
        zzb(25, zzaz);
    }

    public final void showInterstitial() throws RemoteException {
        zzb(4, zzaz());
    }

    public final void showVideo() throws RemoteException {
        zzb(12, zzaz());
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzads zzads, List<String> list) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (IInterface) zzads);
        zzaz.writeStringList(list);
        zzb(23, zzaz);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, zzads zzads, String str2) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (Parcelable) zzis);
        zzaz.writeString(str);
        zzef.zza(zzaz, (IInterface) zzads);
        zzaz.writeString(str2);
        zzb(10, zzaz);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, zzui zzui) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (Parcelable) zzis);
        zzaz.writeString(str);
        zzef.zza(zzaz, (IInterface) zzui);
        zzb(3, zzaz);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, String str2, zzui zzui) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (Parcelable) zzis);
        zzaz.writeString(str);
        zzaz.writeString(str2);
        zzef.zza(zzaz, (IInterface) zzui);
        zzb(7, zzaz);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, String str2, zzui zzui, zzom zzom, List<String> list) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (Parcelable) zzis);
        zzaz.writeString(str);
        zzaz.writeString(str2);
        zzef.zza(zzaz, (IInterface) zzui);
        zzef.zza(zzaz, (Parcelable) zzom);
        zzaz.writeStringList(list);
        zzb(14, zzaz);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zziw zziw, zzis zzis, String str, zzui zzui) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (Parcelable) zziw);
        zzef.zza(zzaz, (Parcelable) zzis);
        zzaz.writeString(str);
        zzef.zza(zzaz, (IInterface) zzui);
        zzb(1, zzaz);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zziw zziw, zzis zzis, String str, String str2, zzui zzui) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzef.zza(zzaz, (Parcelable) zziw);
        zzef.zza(zzaz, (Parcelable) zzis);
        zzaz.writeString(str);
        zzaz.writeString(str2);
        zzef.zza(zzaz, (IInterface) zzui);
        zzb(6, zzaz);
    }

    public final void zza(zzis zzis, String str, String str2) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzis);
        zzaz.writeString(str);
        zzaz.writeString(str2);
        zzb(20, zzaz);
    }

    public final void zzc(zzis zzis, String str) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzis);
        zzaz.writeString(str);
        zzb(11, zzaz);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(21, zzaz);
    }

    public final zzuo zzly() throws RemoteException {
        zzuo zzuq;
        Parcel zza = zza(15, zzaz());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzuq = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzuq = queryLocalInterface instanceof zzuo ? (zzuo) queryLocalInterface : new zzuq(readStrongBinder);
        }
        zza.recycle();
        return zzuq;
    }

    public final zzur zzlz() throws RemoteException {
        zzur zzut;
        Parcel zza = zza(16, zzaz());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzut = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzut = queryLocalInterface instanceof zzur ? (zzur) queryLocalInterface : new zzut(readStrongBinder);
        }
        zza.recycle();
        return zzut;
    }

    public final Bundle zzma() throws RemoteException {
        Parcel zza = zza(17, zzaz());
        Bundle bundle = (Bundle) zzef.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final Bundle zzmb() throws RemoteException {
        Parcel zza = zza(19, zzaz());
        Bundle bundle = (Bundle) zzef.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final boolean zzmc() throws RemoteException {
        Parcel zza = zza(22, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final zzpu zzmd() throws RemoteException {
        Parcel zza = zza(24, zzaz());
        zzpu zzn = zzpv.zzn(zza.readStrongBinder());
        zza.recycle();
        return zzn;
    }
}
