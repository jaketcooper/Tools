package com.google.android.gms.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.zzn;

@zzzb
public final class zznf implements CustomRenderedAd {
    private final zzng zzbrc;

    public zznf(zzng zzng) {
        this.zzbrc = zzng;
    }

    public final String getBaseUrl() {
        try {
            return this.zzbrc.zzjd();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    public final String getContent() {
        try {
            return this.zzbrc.getContent();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    public final void onAdRendered(View view) {
        try {
            this.zzbrc.zze(view != null ? zzn.zzy(view) : null);
        } catch (RemoteException e) {
            zzaiw.zzc("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    public final void recordClick() {
        try {
            this.zzbrc.recordClick();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    public final void recordImpression() {
        try {
            this.zzbrc.recordImpression();
        } catch (RemoteException e) {
            zzaiw.zzc("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
