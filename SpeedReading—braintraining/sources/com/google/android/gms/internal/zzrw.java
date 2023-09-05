package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzrw extends zzjo {
    private /* synthetic */ zzrj zzbxj;

    zzrw(zzrj zzrj) {
        this.zzbxj = zzrj;
    }

    public final void onAdClicked() throws RemoteException {
        this.zzbxj.zzaof.add(new zzrx(this));
    }
}
