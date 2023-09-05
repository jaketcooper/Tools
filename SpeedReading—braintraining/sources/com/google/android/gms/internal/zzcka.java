package com.google.android.gms.internal;

final class zzcka implements Runnable {
    private /* synthetic */ zzchj zzjbi;
    private /* synthetic */ Runnable zzjgq;

    zzcka(zzcjx zzcjx, zzchj zzchj, Runnable runnable) {
        this.zzjbi = zzchj;
        this.zzjgq = runnable;
    }

    public final void run() {
        this.zzjbi.zzbaa();
        this.zzjbi.zzi(this.zzjgq);
        this.zzjbi.zzazw();
    }
}
