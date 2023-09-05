package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzwl extends zzed implements zzwj {
    zzwl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeInt(i);
        zzaz.writeInt(i2);
        zzef.zza(zzaz, (Parcelable) intent);
        zzb(12, zzaz);
    }

    public final void onBackPressed() throws RemoteException {
        zzb(10, zzaz());
    }

    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) bundle);
        zzb(1, zzaz);
    }

    public final void onDestroy() throws RemoteException {
        zzb(8, zzaz());
    }

    public final void onPause() throws RemoteException {
        zzb(5, zzaz());
    }

    public final void onRestart() throws RemoteException {
        zzb(2, zzaz());
    }

    public final void onResume() throws RemoteException {
        zzb(4, zzaz());
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) bundle);
        Parcel zza = zza(6, zzaz);
        if (zza.readInt() != 0) {
            bundle.readFromParcel(zza);
        }
        zza.recycle();
    }

    public final void onStart() throws RemoteException {
        zzb(3, zzaz());
    }

    public final void onStop() throws RemoteException {
        zzb(7, zzaz());
    }

    public final void zzba() throws RemoteException {
        zzb(9, zzaz());
    }

    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) iObjectWrapper);
        zzb(13, zzaz);
    }

    public final boolean zzmo() throws RemoteException {
        Parcel zza = zza(11, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }
}
