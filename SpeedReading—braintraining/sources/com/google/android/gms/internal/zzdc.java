package com.google.android.gms.internal;

final class zzdc implements Runnable {
    private /* synthetic */ zzda zzaiw;
    private /* synthetic */ int zzaix;
    private /* synthetic */ boolean zzaiy;

    zzdc(zzda zzda, int i, boolean z) {
        this.zzaiw = zzda;
        this.zzaix = i;
        this.zzaiy = z;
    }

    public final void run() {
        zzaw zzb = this.zzaiw.zzb(this.zzaix, this.zzaiy);
        zzaw unused = this.zzaiw.zzain = zzb;
        if (zzda.zza(this.zzaix, zzb)) {
            this.zzaiw.zza(this.zzaix + 1, this.zzaiy);
        }
    }
}
