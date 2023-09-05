package com.google.android.gms.internal;

final class zznv implements Runnable {
    private /* synthetic */ zznu zzbso;

    zznv(zznu zznu) {
        this.zzbso = zznu;
    }

    public final void run() {
        if (this.zzbso.zzbsk != null) {
            this.zzbso.zzbsk.zzkc();
            this.zzbso.zzbsk.zzkb();
        }
        zzoa unused = this.zzbso.zzbsk = null;
    }
}
