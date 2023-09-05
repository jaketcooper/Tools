package com.google.android.gms.internal;

final class zzlf extends zzjm {
    private /* synthetic */ zzle zzbex;

    zzlf(zzle zzle) {
        this.zzbex = zzle;
    }

    public final void onAdFailedToLoad(int i) {
        this.zzbex.zzbeq.zza(this.zzbex.zzbe());
        super.onAdFailedToLoad(i);
    }

    public final void onAdLoaded() {
        this.zzbex.zzbeq.zza(this.zzbex.zzbe());
        super.onAdLoaded();
    }
}
