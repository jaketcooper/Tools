package com.google.android.gms.internal;

final class zzakn implements Runnable {
    private /* synthetic */ zzakk zzddy;
    private /* synthetic */ String zzddz;
    private /* synthetic */ String zzdea;

    zzakn(zzakk zzakk, String str, String str2) {
        this.zzddy = zzakk;
        this.zzddz = str;
        this.zzdea = str2;
    }

    public final void run() {
        if (this.zzddy.zzddx != null) {
            this.zzddy.zzddx.zzg(this.zzddz, this.zzdea);
        }
    }
}
