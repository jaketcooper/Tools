package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zznu;

final class zzbf implements Runnable {
    private /* synthetic */ zznu zzano;
    private /* synthetic */ zzba zzaqs;

    zzbf(zzba zzba, zznu zznu) {
        this.zzaqs = zzba;
        this.zzano = zznu;
    }

    public final void run() {
        try {
            if (this.zzaqs.zzamt.zzatq != null) {
                this.zzaqs.zzamt.zzatq.zza(this.zzano);
            }
        } catch (RemoteException e) {
            zzafj.zzc("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }
}
