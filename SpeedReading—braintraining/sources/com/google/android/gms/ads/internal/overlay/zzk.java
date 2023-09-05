package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

final class zzk implements Runnable {
    private /* synthetic */ Drawable zzche;
    private /* synthetic */ zzj zzchf;

    zzk(zzj zzj, Drawable drawable) {
        this.zzchf = zzj;
        this.zzche = drawable;
    }

    public final void run() {
        this.zzchf.zzchb.mActivity.getWindow().setBackgroundDrawable(this.zzche);
    }
}
