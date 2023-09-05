package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzru extends zznk {
    private /* synthetic */ zzrj zzbxj;

    zzru(zzrj zzrj) {
        this.zzbxj = zzrj;
    }

    public final void zza(zzng zzng) throws RemoteException {
        this.zzbxj.zzaof.add(new zzrv(this, zzng));
    }
}
