package com.google.android.gms.internal;

import android.os.Bundle;

@zzzb
public final class zzsp {
    private static zzsp zzbyk = new zzsp();
    private int zzbyl;
    private int zzbym;
    private int zzbyn;
    private int zzbyo;
    private int zzbyp;

    public static zzsp zzkw() {
        return zzbyk;
    }

    public final Bundle asBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("ipl", this.zzbyl);
        bundle.putInt("ipds", this.zzbym);
        bundle.putInt("ipde", this.zzbyn);
        bundle.putInt("iph", this.zzbyo);
        bundle.putInt("ipm", this.zzbyp);
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zzkx() {
        this.zzbym++;
    }

    /* access modifiers changed from: package-private */
    public final void zzky() {
        this.zzbyn++;
    }

    /* access modifiers changed from: package-private */
    public final void zzkz() {
        this.zzbyo++;
    }

    /* access modifiers changed from: package-private */
    public final void zzla() {
        this.zzbyp++;
    }

    public final int zzlb() {
        return this.zzbym;
    }

    public final int zzlc() {
        return this.zzbyn;
    }

    public final int zzld() {
        return this.zzbyo;
    }

    public final int zzle() {
        return this.zzbyp;
    }

    /* access modifiers changed from: package-private */
    public final void zzu(int i) {
        this.zzbyl += i;
    }
}
