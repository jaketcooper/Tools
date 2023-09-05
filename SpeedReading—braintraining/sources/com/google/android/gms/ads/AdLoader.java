package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzaiw;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zziv;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzjq;
import com.google.android.gms.internal.zzjt;
import com.google.android.gms.internal.zzjw;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzlc;
import com.google.android.gms.internal.zzom;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzqb;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqr;
import com.google.android.gms.internal.zzqs;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzub;

public class AdLoader {
    private final Context mContext;
    private final zziv zzakq;
    private final zzjt zzakr;

    public static class Builder {
        private final Context mContext;
        private final zzjw zzaks;

        private Builder(Context context, zzjw zzjw) {
            this.mContext = context;
            this.zzaks = zzjw;
        }

        public Builder(Context context, String str) {
            this((Context) zzbq.checkNotNull(context, "context cannot be null"), zzjk.zzhy().zzb(context, str, new zzub()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.mContext, this.zzaks.zzdc());
            } catch (RemoteException e) {
                zzaiw.zzb("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzaks.zza((zzpy) new zzqp(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzaiw.zzc("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzaks.zza((zzqb) new zzqq(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzaiw.zzc("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            try {
                this.zzaks.zza(str, new zzqs(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new zzqr(onCustomClickListener));
            } catch (RemoteException e) {
                zzaiw.zzc("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzaks.zza(new zzqt(onPublisherAdViewLoadedListener), new zziw(this.mContext, adSizeArr));
            } catch (RemoteException e) {
                zzaiw.zzc("Failed to add publisher banner ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzaks.zzb((zzjq) new zzip(adListener));
            } catch (RemoteException e) {
                zzaiw.zzc("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withCorrelator(@NonNull Correlator correlator) {
            zzbq.checkNotNull(correlator);
            try {
                this.zzaks.zzb((zzkm) correlator.zzbc());
            } catch (RemoteException e) {
                zzaiw.zzc("Failed to set correlator.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzaks.zza(new zzom(nativeAdOptions));
            } catch (RemoteException e) {
                zzaiw.zzc("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.zzaks.zza(publisherAdViewOptions);
            } catch (RemoteException e) {
                zzaiw.zzc("Failed to specify DFP banner ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, zzjt zzjt) {
        this(context, zzjt, zziv.zzbcz);
    }

    private AdLoader(Context context, zzjt zzjt, zziv zziv) {
        this.mContext = context;
        this.zzakr = zzjt;
        this.zzakq = zziv;
    }

    private final void zza(zzlc zzlc) {
        try {
            this.zzakr.zzd(zziv.zza(this.mContext, zzlc));
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to load ad.", e);
        }
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.zzakr.zzcj();
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzakr.isLoading();
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to check if ad is loading.", e);
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzbb());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzbb());
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzakr.zza(zziv.zza(this.mContext, adRequest.zzbb()), i);
        } catch (RemoteException e) {
            zzaiw.zzb("Failed to load ads.", e);
        }
    }
}
