package com.google.android.gms.internal;

final class zzj implements Runnable {
    private final zzp zzt;
    private final zzt zzu;
    private final Runnable zzv;

    public zzj(zzh zzh, zzp zzp, zzt zzt2, Runnable runnable) {
        this.zzt = zzp;
        this.zzu = zzt2;
        this.zzv = runnable;
    }

    public final void run() {
        if (this.zzu.zzbf == null) {
            this.zzt.zza(this.zzu.result);
        } else {
            this.zzt.zzb(this.zzu.zzbf);
        }
        if (this.zzu.zzbg) {
            this.zzt.zzb("intermediate-response");
        } else {
            this.zzt.zzc("done");
        }
        if (this.zzv != null) {
            this.zzv.run();
        }
    }
}
