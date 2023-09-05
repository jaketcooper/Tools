package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzkz extends zzed implements zzkx {
    zzkz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final void onVideoEnd() throws RemoteException {
        zzb(4, zzaz());
    }

    public final void onVideoMute(boolean z) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, z);
        zzb(5, zzaz);
    }

    public final void onVideoPause() throws RemoteException {
        zzb(3, zzaz());
    }

    public final void onVideoPlay() throws RemoteException {
        zzb(2, zzaz());
    }

    public final void onVideoStart() throws RemoteException {
        zzb(1, zzaz());
    }
}
