package com.google.android.gms.internal;

final class zzadp implements Runnable {
    private /* synthetic */ zzaeu zzaoc;
    private /* synthetic */ zzado zzcuh;

    zzadp(zzado zzado, zzaeu zzaeu) {
        this.zzcuh = zzado;
        this.zzaoc = zzaeu;
    }

    public final void run() {
        this.zzcuh.zzcug.zzb(this.zzaoc);
    }
}
