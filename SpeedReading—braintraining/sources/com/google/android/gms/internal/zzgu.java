package com.google.android.gms.internal;

import android.view.View;

final class zzgu implements Runnable {
    private /* synthetic */ View zzayu;
    private /* synthetic */ zzgt zzayv;

    zzgu(zzgt zzgt, View view) {
        this.zzayv = zzgt;
        this.zzayu = view;
    }

    public final void run() {
        this.zzayv.zzf(this.zzayu);
    }
}
