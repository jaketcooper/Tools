package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzaeu;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zznw;

final class zzbg implements Runnable {
    private /* synthetic */ zzaeu zzaoc;
    private /* synthetic */ zzba zzaqs;
    private /* synthetic */ String zzaqy;

    zzbg(zzba zzba, String str, zzaeu zzaeu) {
        this.zzaqs = zzba;
        this.zzaqy = str;
        this.zzaoc = zzaeu;
    }

    public final void run() {
        try {
            this.zzaqs.zzamt.zzats.get(this.zzaqy).zzb((zznw) this.zzaoc.zzcvy);
        } catch (RemoteException e) {
            zzafj.zzc("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
