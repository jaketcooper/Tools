package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzns;

final class zzbe implements Runnable {
    private /* synthetic */ zzns zzann;
    private /* synthetic */ zzba zzaqs;

    zzbe(zzba zzba, zzns zzns) {
        this.zzaqs = zzba;
        this.zzann = zzns;
    }

    public final void run() {
        try {
            if (this.zzaqs.zzamt.zzatp != null) {
                this.zzaqs.zzamt.zzatp.zza(this.zzann);
            }
        } catch (RemoteException e) {
            zzafj.zzc("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }
}
