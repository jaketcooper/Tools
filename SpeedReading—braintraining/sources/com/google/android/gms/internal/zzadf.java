package com.google.android.gms.internal;

final class zzadf implements Runnable {
    private /* synthetic */ zzis zzaox;
    private /* synthetic */ zzuf zzctt;
    private /* synthetic */ zzade zzctu;

    zzadf(zzade zzade, zzis zzis, zzuf zzuf) {
        this.zzctu = zzade;
        this.zzaox = zzis;
        this.zzctt = zzuf;
    }

    public final void run() {
        this.zzctu.zza(this.zzaox, this.zzctt);
    }
}
