package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzns;

final class zzs implements Runnable {
    private /* synthetic */ zzq zzanm;
    private /* synthetic */ zzns zzann;

    zzs(zzq zzq, zzns zzns) {
        this.zzanm = zzq;
        this.zzann = zzns;
    }

    public final void run() {
        try {
            if (this.zzanm.zzamt.zzatp != null) {
                this.zzanm.zzamt.zzatp.zza(this.zzann);
            }
        } catch (RemoteException e) {
            zzafj.zzc("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }
}
