package com.google.android.gms.internal;

final /* synthetic */ class zzajj implements Runnable {
    private final zzajy zzbxh;
    private final zzajp zzdch;
    private final zzajb zzdci;

    zzajj(zzajy zzajy, zzajb zzajb, zzajp zzajp) {
        this.zzbxh = zzajy;
        this.zzdci = zzajb;
        this.zzdch = zzajp;
    }

    public final void run() {
        zzajg.zza(this.zzbxh, this.zzdci, this.zzdch);
    }
}
