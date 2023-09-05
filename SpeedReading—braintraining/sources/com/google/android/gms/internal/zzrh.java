package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzg;

final class zzrh implements zzg {
    private /* synthetic */ zzrc zzbxa;
    private /* synthetic */ zzajy zzbxb;

    zzrh(zzrc zzrc, zzajy zzajy) {
        this.zzbxa = zzrc;
        this.zzbxb = zzajy;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzbxa.mLock) {
            this.zzbxb.setException(new RuntimeException("Connection failed."));
        }
    }
}
