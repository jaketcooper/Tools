package com.google.android.gms.internal;

final class zzxs implements Runnable {
    private /* synthetic */ zzajy zzcix;
    private /* synthetic */ String zzciy;
    private /* synthetic */ zzxr zzciz;

    zzxs(zzxr zzxr, zzajy zzajy, String str) {
        this.zzciz = zzxr;
        this.zzcix = zzajy;
        this.zzciy = str;
    }

    public final void run() {
        this.zzcix.set(this.zzciz.zzcis.zzdo().get(this.zzciy));
    }
}
