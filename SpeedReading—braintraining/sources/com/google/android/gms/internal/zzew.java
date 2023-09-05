package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzew extends zzed implements zzeu {
    zzew(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzaz.writeString(str);
        zzb(2, zzaz);
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzaz.writeString(str);
        zzaz.writeString((String) null);
        zzb(8, zzaz);
    }

    public final void zza(int[] iArr) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeIntArray(iArr);
        zzb(4, zzaz);
    }

    public final void zzbf() throws RemoteException {
        zzb(3, zzaz());
    }

    public final void zzc(byte[] bArr) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeByteArray(bArr);
        zzb(5, zzaz);
    }

    public final void zzg(int i) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeInt(i);
        zzb(6, zzaz);
    }

    public final void zzh(int i) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeInt(i);
        zzb(7, zzaz);
    }
}
