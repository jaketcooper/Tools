package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzd;

final class zzame implements Runnable {
    private /* synthetic */ zzamb zzdis;

    zzame(zzamb zzamb) {
        this.zzdis = zzamb;
    }

    public final void run() {
        this.zzdis.zzbwq.zzsy();
        zzd zzsm = this.zzdis.zzbwq.zzsm();
        if (zzsm != null) {
            zzsm.zzmp();
        }
        if (this.zzdis.zzdid != null) {
            this.zzdis.zzdid.zzcw();
            zzamh unused = this.zzdis.zzdid = null;
        }
    }
}
