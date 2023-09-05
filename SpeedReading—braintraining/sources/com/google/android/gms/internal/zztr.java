package com.google.android.gms.internal;

final class zztr implements Runnable {
    private /* synthetic */ zztp zzccz;
    private /* synthetic */ zztq zzcda;

    zztr(zztq zztq, zztp zztp) {
        this.zzcda = zztq;
        this.zzccz = zztp;
    }

    public final void run() {
        synchronized (this.zzcda.mLock) {
            if (this.zzcda.zzccx == -2) {
                zzuf unused = this.zzcda.zzccw = this.zzcda.zzlt();
                if (this.zzcda.zzccw == null) {
                    this.zzcda.zzv(4);
                } else if (!this.zzcda.zzlu() || this.zzcda.zzw(1)) {
                    this.zzccz.zza((zztu) this.zzcda);
                    this.zzcda.zza(this.zzccz);
                } else {
                    String zzf = this.zzcda.zzcco;
                    zzafj.zzco(new StringBuilder(String.valueOf(zzf).length() + 56).append("Ignoring adapter ").append(zzf).append(" as delayed impression is not supported").toString());
                    this.zzcda.zzv(2);
                }
            }
        }
    }
}
