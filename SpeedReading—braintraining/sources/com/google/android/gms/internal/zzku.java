package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;

public interface zzku extends IInterface {
    float getAspectRatio() throws RemoteException;

    int getPlaybackState() throws RemoteException;

    boolean isClickToExpandEnabled() throws RemoteException;

    boolean isCustomControlsEnabled() throws RemoteException;

    boolean isMuted() throws RemoteException;

    void mute(boolean z) throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void zza(zzkx zzkx) throws RemoteException;

    float zzib() throws RemoteException;

    float zzic() throws RemoteException;

    zzkx zzid() throws RemoteException;
}
