package com.google.android.gms.internal;

final class zzakp implements Runnable {
    private /* synthetic */ zzakk zzddy;
    private /* synthetic */ int zzdeb;
    private /* synthetic */ int zzdec;

    zzakp(zzakk zzakk, int i, int i2) {
        this.zzddy = zzakk;
        this.zzdeb = i;
        this.zzdec = i2;
    }

    public final void run() {
        if (this.zzddy.zzddx != null) {
            this.zzddy.zzddx.zzf(this.zzdeb, this.zzdec);
        }
    }
}
