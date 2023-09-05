package com.google.android.gms.internal;

@zzzb
public final class zzahh {
    private float zzcmg = 1.0f;
    private boolean zzcmm = false;

    private final synchronized boolean zzqf() {
        return this.zzcmg >= 0.0f;
    }

    public final synchronized void setAppMuted(boolean z) {
        this.zzcmm = z;
    }

    public final synchronized void setAppVolume(float f) {
        this.zzcmg = f;
    }

    public final synchronized float zzdh() {
        return zzqf() ? this.zzcmg : 1.0f;
    }

    public final synchronized boolean zzdi() {
        return this.zzcmm;
    }
}
