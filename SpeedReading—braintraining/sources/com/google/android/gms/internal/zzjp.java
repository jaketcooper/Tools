package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;

public final class zzjp extends zzed implements zzjn {
    zzjp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    public final void onAdClicked() throws RemoteException {
        zzb(1, zzaz());
    }
}
