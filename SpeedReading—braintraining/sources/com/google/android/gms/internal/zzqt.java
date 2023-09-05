package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;

public final class zzqt extends zzql {
    /* access modifiers changed from: private */
    public final OnPublisherAdViewLoadedListener zzbuw;

    public zzqt(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzbuw = onPublisherAdViewLoadedListener;
    }

    public final void zza(zzkb zzkb, IObjectWrapper iObjectWrapper) {
        if (zzkb != null && iObjectWrapper != null) {
            PublisherAdView publisherAdView = new PublisherAdView((Context) zzn.zzx(iObjectWrapper));
            try {
                if (zzkb.zzby() instanceof zzip) {
                    zzip zzip = (zzip) zzkb.zzby();
                    publisherAdView.setAdListener(zzip != null ? zzip.getAdListener() : null);
                }
            } catch (RemoteException e) {
                zzaiw.zzc("Failed to get ad listener.", e);
            }
            try {
                if (zzkb.zzbx() instanceof zziy) {
                    zziy zziy = (zziy) zzkb.zzbx();
                    publisherAdView.setAppEventListener(zziy != null ? zziy.getAppEventListener() : null);
                }
            } catch (RemoteException e2) {
                zzaiw.zzc("Failed to get app event listener.", e2);
            }
            zzais.zzdbs.post(new zzqu(this, publisherAdView, zzkb));
        }
    }
}
