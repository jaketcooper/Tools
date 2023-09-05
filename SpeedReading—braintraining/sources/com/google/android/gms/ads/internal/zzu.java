package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzpu;

final class zzu implements Runnable {
    private /* synthetic */ zzq zzanm;
    private /* synthetic */ zzpu zzanp;

    zzu(zzq zzq, zzpu zzpu) {
        this.zzanm = zzq;
        this.zzanp = zzpu;
    }

    public final void run() {
        try {
            this.zzanm.zzamt.zzats.get(this.zzanp.getCustomTemplateId()).zzb(this.zzanp);
        } catch (RemoteException e) {
            zzafj.zzc("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
