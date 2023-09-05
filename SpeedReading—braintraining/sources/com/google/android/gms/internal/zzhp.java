package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzf;

final class zzhp implements zzf {
    private /* synthetic */ zzhm zzbae;

    zzhp(zzhm zzhm) {
        this.zzbae = zzhm;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzbae.mLock) {
            try {
                if (this.zzbae.zzbac != null) {
                    zzhx unused = this.zzbae.zzbad = this.zzbae.zzbac.zzhh();
                }
            } catch (DeadObjectException e) {
                zzafj.zzb("Unable to obtain a cache service instance.", e);
                this.zzbae.disconnect();
            }
            this.zzbae.mLock.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.zzbae.mLock) {
            zzhx unused = this.zzbae.zzbad = null;
            this.zzbae.mLock.notifyAll();
        }
    }
}
