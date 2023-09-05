package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzf;

final class zzre implements zzf {
    final /* synthetic */ zzrc zzbxa;
    private /* synthetic */ zzajy zzbxb;
    private /* synthetic */ zzqw zzbxc;

    zzre(zzrc zzrc, zzajy zzajy, zzqw zzqw) {
        this.zzbxa = zzrc;
        this.zzbxb = zzajy;
        this.zzbxc = zzqw;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzbxa.mLock) {
            if (!this.zzbxa.zzbwz) {
                boolean unused = this.zzbxa.zzbwz = true;
                zzqv zzd = this.zzbxa.zzbwy;
                if (zzd != null) {
                    this.zzbxb.zza(new zzrg(this.zzbxb, zzagl.zza(new zzrf(this, zzd, this.zzbxb, this.zzbxc))), zzaju.zzdcu);
                }
            }
        }
    }

    public final void onConnectionSuspended(int i) {
    }
}
