package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzkw extends zzed implements zzku {
    zzkw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public final float getAspectRatio() throws RemoteException {
        Parcel zza = zza(9, zzaz());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final int getPlaybackState() throws RemoteException {
        Parcel zza = zza(5, zzaz());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final boolean isClickToExpandEnabled() throws RemoteException {
        Parcel zza = zza(12, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isCustomControlsEnabled() throws RemoteException {
        Parcel zza = zza(10, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isMuted() throws RemoteException {
        Parcel zza = zza(4, zzaz());
        boolean zza2 = zzef.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void mute(boolean z) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, z);
        zzb(3, zzaz);
    }

    public final void pause() throws RemoteException {
        zzb(2, zzaz());
    }

    public final void play() throws RemoteException {
        zzb(1, zzaz());
    }

    public final void zza(zzkx zzkx) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (IInterface) zzkx);
        zzb(8, zzaz);
    }

    public final float zzib() throws RemoteException {
        Parcel zza = zza(6, zzaz());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float zzic() throws RemoteException {
        Parcel zza = zza(7, zzaz());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final zzkx zzid() throws RemoteException {
        zzkx zzkz;
        Parcel zza = zza(11, zzaz());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkz = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            zzkz = queryLocalInterface instanceof zzkx ? (zzkx) queryLocalInterface : new zzkz(readStrongBinder);
        }
        zza.recycle();
        return zzkz;
    }
}
