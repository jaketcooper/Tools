package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzrs extends zzkh {
    private /* synthetic */ zzrj zzbxj;

    zzrs(zzrj zzrj) {
        this.zzbxj = zzrj;
    }

    public final void onAppEvent(String str, String str2) throws RemoteException {
        this.zzbxj.zzaof.add(new zzrt(this, str, str2));
    }
}
