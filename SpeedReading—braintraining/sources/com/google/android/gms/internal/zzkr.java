package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzkr extends zzed implements zzkp {
    zzkr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    public final void initialize() throws RemoteException {
        zzb(1, zzaz());
    }

    public final void setAppMuted(boolean z) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, z);
        zzb(4, zzaz);
    }

    public final void setAppVolume(float f) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeFloat(f);
        zzb(2, zzaz);
    }

    public final void zza(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(6, zzaz);
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzaz.writeString(str);
        zzb(5, zzaz);
    }

    public final float zzdh() throws RemoteException {
        Parcel zza = zza(7, zzaz());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final boolean zzdi() throws RemoteException {
        Parcel zza = zza(8, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zzt(String str) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        zzb(3, zzaz);
    }
}
