package com.google.android.gms.ads.internal;

import android.view.View;

final class zzo implements View.OnClickListener {
    private /* synthetic */ zzl zzani;
    private /* synthetic */ zzw zzanj;

    zzo(zzl zzl, zzw zzw) {
        this.zzani = zzl;
        this.zzanj = zzw;
    }

    public final void onClick(View view) {
        this.zzanj.recordClick();
        if (this.zzani.zzang != null) {
            this.zzani.zzang.zzog();
        }
    }
}
