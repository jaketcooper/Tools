package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzua implements Runnable {
    private /* synthetic */ zztt zzcdu;

    zzua(zztz zztz, zztt zztt) {
        this.zzcdu = zztt;
    }

    public final void run() {
        try {
            this.zzcdu.zzcde.destroy();
        } catch (RemoteException e) {
            zzafj.zzc("Could not destroy mediation adapter.", e);
        }
    }
}
