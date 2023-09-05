package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzkv extends zzee implements zzku {
    public zzkv() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzku zzh(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return queryLocalInterface instanceof zzku ? (zzku) queryLocalInterface : new zzkw(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzkx zzkz;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                play();
                parcel2.writeNoException();
                break;
            case 2:
                pause();
                parcel2.writeNoException();
                break;
            case 3:
                mute(zzef.zza(parcel));
                parcel2.writeNoException();
                break;
            case 4:
                boolean isMuted = isMuted();
                parcel2.writeNoException();
                zzef.zza(parcel2, isMuted);
                break;
            case 5:
                int playbackState = getPlaybackState();
                parcel2.writeNoException();
                parcel2.writeInt(playbackState);
                break;
            case 6:
                float zzib = zzib();
                parcel2.writeNoException();
                parcel2.writeFloat(zzib);
                break;
            case 7:
                float zzic = zzic();
                parcel2.writeNoException();
                parcel2.writeFloat(zzic);
                break;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzkz = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    zzkz = queryLocalInterface instanceof zzkx ? (zzkx) queryLocalInterface : new zzkz(readStrongBinder);
                }
                zza(zzkz);
                parcel2.writeNoException();
                break;
            case 9:
                float aspectRatio = getAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(aspectRatio);
                break;
            case 10:
                boolean isCustomControlsEnabled = isCustomControlsEnabled();
                parcel2.writeNoException();
                zzef.zza(parcel2, isCustomControlsEnabled);
                break;
            case 11:
                zzkx zzid = zzid();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzid);
                break;
            case 12:
                boolean isClickToExpandEnabled = isClickToExpandEnabled();
                parcel2.writeNoException();
                zzef.zza(parcel2, isClickToExpandEnabled);
                break;
            default:
                return false;
        }
        return true;
    }
}
