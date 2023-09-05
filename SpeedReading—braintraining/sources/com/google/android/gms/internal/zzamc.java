package com.google.android.gms.internal;

import android.view.View;

final class zzamc implements Runnable {
    private /* synthetic */ View val$view;
    private /* synthetic */ zzaeh zzdiq;
    private /* synthetic */ int zzdir;
    private /* synthetic */ zzamb zzdis;

    zzamc(zzamb zzamb, View view, zzaeh zzaeh, int i) {
        this.zzdis = zzamb;
        this.val$view = view;
        this.zzdiq = zzaeh;
        this.zzdir = i;
    }

    public final void run() {
        this.zzdis.zza(this.val$view, this.zzdiq, this.zzdir - 1);
    }
}
