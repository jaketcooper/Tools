package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzkd extends zzed implements zzkb {
    zzkd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public final void destroy() throws RemoteException {
        zzb(2, zzaz());
    }

    public final String getAdUnitId() throws RemoteException {
        Parcel zza = zza(31, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(18, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final zzku getVideoController() throws RemoteException {
        zzku zzkw;
        Parcel zza = zza(26, zzaz());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkw = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            zzkw = queryLocalInterface instanceof zzku ? (zzku) queryLocalInterface : new zzkw(readStrongBinder);
        }
        zza.recycle();
        return zzkw;
    }

    public final boolean isLoading() throws RemoteException {
        Parcel zza = zza(23, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isReady() throws RemoteException {
        Parcel zza = zza(3, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void pause() throws RemoteException {
        zzb(5, zzaz());
    }

    public final void resume() throws RemoteException {
        zzb(6, zzaz());
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, z);
        zzb(34, zzaz);
    }

    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, z);
        zzb(22, zzaz);
    }

    public final void setUserId(String str) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        zzb(25, zzaz);
    }

    public final void showInterstitial() throws RemoteException {
        zzb(9, zzaz());
    }

    public final void stopLoading() throws RemoteException {
        zzb(10, zzaz());
    }

    public final void zza(zzacv zzacv) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzacv);
        zzb(24, zzaz);
    }

    public final void zza(zziw zziw) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zziw);
        zzb(13, zzaz);
    }

    public final void zza(zzjn zzjn) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzjn);
        zzb(20, zzaz);
    }

    public final void zza(zzjq zzjq) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzjq);
        zzb(7, zzaz);
    }

    public final void zza(zzkg zzkg) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzkg);
        zzb(8, zzaz);
    }

    public final void zza(zzkm zzkm) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzkm);
        zzb(21, zzaz);
    }

    public final void zza(zzla zzla) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzla);
        zzb(30, zzaz);
    }

    public final void zza(zzma zzma) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzma);
        zzb(29, zzaz);
    }

    public final void zza(zznj zznj) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zznj);
        zzb(19, zzaz);
    }

    public final void zza(zzwq zzwq) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzwq);
        zzb(14, zzaz);
    }

    public final void zza(zzww zzww, String str) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzww);
        zzaz.writeString(str);
        zzb(15, zzaz);
    }

    public final boolean zzb(zzis zzis) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzis);
        Parcel zza = zza(4, zzaz);
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final IObjectWrapper zzbl() throws RemoteException {
        Parcel zza = zza(1, zzaz());
        IObjectWrapper zzap = IObjectWrapper.zza.zzap(zza.readStrongBinder());
        zza.recycle();
        return zzap;
    }

    public final zziw zzbm() throws RemoteException {
        Parcel zza = zza(12, zzaz());
        zziw zziw = (zziw) zzef.zza(zza, zziw.CREATOR);
        zza.recycle();
        return zziw;
    }

    public final void zzbo() throws RemoteException {
        zzb(11, zzaz());
    }

    public final zzkg zzbx() throws RemoteException {
        zzkg zzki;
        Parcel zza = zza(32, zzaz());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzki = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            zzki = queryLocalInterface instanceof zzkg ? (zzkg) queryLocalInterface : new zzki(readStrongBinder);
        }
        zza.recycle();
        return zzki;
    }

    public final zzjq zzby() throws RemoteException {
        zzjq zzjs;
        Parcel zza = zza(33, zzaz());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzjs = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            zzjs = queryLocalInterface instanceof zzjq ? (zzjq) queryLocalInterface : new zzjs(readStrongBinder);
        }
        zza.recycle();
        return zzjs;
    }

    public final String zzcj() throws RemoteException {
        Parcel zza = zza(35, zzaz());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }
}
