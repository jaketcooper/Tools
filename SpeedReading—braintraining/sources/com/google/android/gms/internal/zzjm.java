package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

@zzzb
public class zzjm extends AdListener {
    private final Object lock = new Object();
    private AdListener zzbed;

    public void onAdClosed() {
        synchronized (this.lock) {
            if (this.zzbed != null) {
                this.zzbed.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.lock) {
            if (this.zzbed != null) {
                this.zzbed.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.lock) {
            if (this.zzbed != null) {
                this.zzbed.onAdLeftApplication();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.lock) {
            if (this.zzbed != null) {
                this.zzbed.onAdLoaded();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.lock) {
            if (this.zzbed != null) {
                this.zzbed.onAdOpened();
            }
        }
    }

    public final void zza(AdListener adListener) {
        synchronized (this.lock) {
            this.zzbed = adListener;
        }
    }
}
