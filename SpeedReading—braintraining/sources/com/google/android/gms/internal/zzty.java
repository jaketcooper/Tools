package com.google.android.gms.internal;

final class zzty implements Runnable {
    private /* synthetic */ zztw zzcdr;
    private /* synthetic */ zzajp zzcds;

    zzty(zztw zztw, zzajp zzajp) {
        this.zzcdr = zztw;
        this.zzcds = zzajp;
    }

    public final void run() {
        for (zzajp zzajp : this.zzcdr.zzcdn.keySet()) {
            if (zzajp != this.zzcds) {
                ((zztq) this.zzcdr.zzcdn.get(zzajp)).cancel();
            }
        }
    }
}
