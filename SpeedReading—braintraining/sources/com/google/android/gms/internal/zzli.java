package com.google.android.gms.internal;

import android.content.Context;

final class zzli implements Runnable {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzlh zzbfd;

    zzli(zzlh zzlh, Context context) {
        this.zzbfd = zzlh;
        this.val$context = context;
    }

    public final void run() {
        this.zzbfd.getRewardedVideoAdInstance(this.val$context);
    }
}
