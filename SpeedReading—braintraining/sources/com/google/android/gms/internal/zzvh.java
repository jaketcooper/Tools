package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;

final class zzvh implements Runnable {
    private /* synthetic */ zzvc zzcei;
    private /* synthetic */ AdRequest.ErrorCode zzcej;

    zzvh(zzvc zzvc, AdRequest.ErrorCode errorCode) {
        this.zzcei = zzvc;
        this.zzcej = errorCode;
    }

    public final void run() {
        try {
            this.zzcei.zzcea.onAdFailedToLoad(zzvo.zza(this.zzcej));
        } catch (RemoteException e) {
            zzaiw.zzc("Could not call onAdFailedToLoad.", e);
        }
    }
}
