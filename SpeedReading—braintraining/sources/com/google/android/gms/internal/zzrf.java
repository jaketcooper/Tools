package com.google.android.gms.internal;

import android.os.RemoteException;

final /* synthetic */ class zzrf implements Runnable {
    private final zzre zzbxd;
    private final zzqv zzbxe;
    private final zzajy zzbxf;
    private final zzqw zzbxg;

    zzrf(zzre zzre, zzqv zzqv, zzajy zzajy, zzqw zzqw) {
        this.zzbxd = zzre;
        this.zzbxe = zzqv;
        this.zzbxf = zzajy;
        this.zzbxg = zzqw;
    }

    public final void run() {
        zzre zzre = this.zzbxd;
        zzqv zzqv = this.zzbxe;
        zzajy zzajy = this.zzbxf;
        try {
            zzajy.set(zzqv.zzkn().zza(this.zzbxg));
        } catch (RemoteException e) {
            zzafj.zzb("Unable to obtain a cache service instance.", e);
            zzajy.setException(e);
            zzre.zzbxa.disconnect();
        }
    }
}
