package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzagr;

final class zzax implements Runnable {
    final /* synthetic */ Runnable zzaqj;
    final /* synthetic */ zzaw zzaqk;

    zzax(zzaw zzaw, Runnable runnable) {
        this.zzaqk = zzaw;
        this.zzaqj = runnable;
    }

    public final void run() {
        zzbs.zzec();
        zzagr.runOnUiThread(new zzay(this));
    }
}
