package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class zzciv implements Callable<String> {
    private /* synthetic */ zzcik zzjer;

    zzciv(zzcik zzcik) {
        this.zzjer = zzcik;
    }

    public final /* synthetic */ Object call() throws Exception {
        String zzazc = this.zzjer.zzawo().zzazc();
        if (zzazc == null) {
            zzcik zzawb = this.zzjer.zzawb();
            if (zzawb.zzawm().zzazh()) {
                zzawb.zzawn().zzays().log("Cannot retrieve app instance id from analytics worker thread");
                zzazc = null;
            } else {
                zzawb.zzawm();
                if (zzche.zzas()) {
                    zzawb.zzawn().zzays().log("Cannot retrieve app instance id from main thread");
                    zzazc = null;
                } else {
                    long elapsedRealtime = zzawb.zzwh().elapsedRealtime();
                    zzazc = zzawb.zzbc(120000);
                    long elapsedRealtime2 = zzawb.zzwh().elapsedRealtime() - elapsedRealtime;
                    if (zzazc == null && elapsedRealtime2 < 120000) {
                        zzazc = zzawb.zzbc(120000 - elapsedRealtime2);
                    }
                }
            }
            if (zzazc == null) {
                throw new TimeoutException();
            }
            this.zzjer.zzawo().zzjk(zzazc);
        }
        return zzazc;
    }
}
