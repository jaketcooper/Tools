package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzln extends zzju {
    final /* synthetic */ zzll zzbfe;

    private zzln(zzll zzll) {
        this.zzbfe = zzll;
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    public final boolean isLoading() throws RemoteException {
        return false;
    }

    public final void zza(zzis zzis, int i) throws RemoteException {
        zzaiw.m12e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzais.zzdbs.post(new zzlo(this));
    }

    public final String zzcj() throws RemoteException {
        return null;
    }

    public final void zzd(zzis zzis) throws RemoteException {
        zza(zzis, 1);
    }
}
