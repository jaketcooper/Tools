package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

final class zzcn implements Runnable {
    private /* synthetic */ zzcm zzagp;

    zzcn(zzcm zzcm) {
        this.zzagp = zzcm;
    }

    public final void run() {
        if (this.zzagp.zzagn == null) {
            synchronized (zzcm.zzagl) {
                if (this.zzagp.zzagn == null) {
                    boolean booleanValue = ((Boolean) zzbs.zzep().zzd(zzmq.zzblu)).booleanValue();
                    if (booleanValue) {
                        try {
                            zzcm.zzagm = new zzig(this.zzagp.zzagk.zzaif, "ADSHIELD", (String) null);
                        } catch (Throwable th) {
                            booleanValue = false;
                        }
                    }
                    this.zzagp.zzagn = Boolean.valueOf(booleanValue);
                    zzcm.zzagl.open();
                }
            }
        }
    }
}
