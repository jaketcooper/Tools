package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzlu extends zzacr {
    /* access modifiers changed from: private */
    public zzacv zzbfh;

    public final void destroy() throws RemoteException {
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    public final void pause() throws RemoteException {
    }

    public final void resume() throws RemoteException {
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    public final void setUserId(String str) throws RemoteException {
    }

    public final void show() throws RemoteException {
    }

    public final void zza(zzacv zzacv) throws RemoteException {
        this.zzbfh = zzacv;
    }

    public final void zza(zzadb zzadb) throws RemoteException {
        zzaiw.m12e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzais.zzdbs.post(new zzlv(this));
    }

    public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzc(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
    }
}
