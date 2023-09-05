package com.google.android.gms.internal;

import android.content.ComponentName;

final class zzcjt implements Runnable {
    private /* synthetic */ ComponentName val$name;
    private /* synthetic */ zzcjr zzjgi;

    zzcjt(zzcjr zzcjr, ComponentName componentName) {
        this.zzjgi = zzcjr;
        this.val$name = componentName;
    }

    public final void run() {
        this.zzjgi.zzjfy.onServiceDisconnected(this.val$name);
    }
}
