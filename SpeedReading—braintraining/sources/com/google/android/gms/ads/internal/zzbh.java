package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzpu;

final class zzbh implements Runnable {
    private /* synthetic */ zzpu zzanp;
    private /* synthetic */ zzba zzaqs;

    zzbh(zzba zzba, zzpu zzpu) {
        this.zzaqs = zzba;
        this.zzanp = zzpu;
    }

    public final void run() {
        try {
            this.zzaqs.zzamt.zzats.get(this.zzanp.getCustomTemplateId()).zzb(this.zzanp);
        } catch (RemoteException e) {
            zzafj.zzc("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
