package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.PublisherAdView;

final class zzqu implements Runnable {
    private /* synthetic */ PublisherAdView zzbux;
    private /* synthetic */ zzkb zzbuy;
    private /* synthetic */ zzqt zzbuz;

    zzqu(zzqt zzqt, PublisherAdView publisherAdView, zzkb zzkb) {
        this.zzbuz = zzqt;
        this.zzbux = publisherAdView;
        this.zzbuy = zzkb;
    }

    public final void run() {
        if (this.zzbux.zza(this.zzbuy)) {
            this.zzbuz.zzbuw.onPublisherAdViewLoaded(this.zzbux);
        } else {
            zzaiw.zzco("Could not bind ad manager");
        }
    }
}
