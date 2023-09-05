package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzuu extends zzkv {
    private final Object mLock = new Object();
    private volatile zzkx zzcdw;

    public final float getAspectRatio() throws RemoteException {
        throw new RemoteException();
    }

    public final int getPlaybackState() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isClickToExpandEnabled() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isCustomControlsEnabled() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isMuted() throws RemoteException {
        throw new RemoteException();
    }

    public final void mute(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    public final void play() throws RemoteException {
        throw new RemoteException();
    }

    public final void zza(zzkx zzkx) throws RemoteException {
        synchronized (this.mLock) {
            this.zzcdw = zzkx;
        }
    }

    public final float zzib() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzic() throws RemoteException {
        throw new RemoteException();
    }

    public final zzkx zzid() throws RemoteException {
        zzkx zzkx;
        synchronized (this.mLock) {
            zzkx = this.zzcdw;
        }
        return zzkx;
    }
}
