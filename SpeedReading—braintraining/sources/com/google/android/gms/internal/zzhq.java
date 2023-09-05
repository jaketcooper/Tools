package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzg;

final class zzhq implements zzg {
    private /* synthetic */ zzhm zzbae;

    zzhq(zzhm zzhm) {
        this.zzbae = zzhm;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzbae.mLock) {
            zzhx unused = this.zzbae.zzbad = null;
            if (this.zzbae.zzbac != null) {
                zzht unused2 = this.zzbae.zzbac = null;
            }
            this.zzbae.mLock.notifyAll();
        }
    }
}
