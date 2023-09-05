package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

@zzzb
public final class zzlg {
    private final Context mContext;
    private final zziv zzakq;
    private AppEventListener zzalu;
    private String zzaou;
    private boolean zzapj;
    private zzin zzbbt;
    private AdListener zzbbu;
    private final zzub zzbeo;
    private Correlator zzbes;
    private zzkb zzbet;
    private OnCustomRenderedAdLoadedListener zzbeu;
    private PublisherInterstitialAd zzbey;
    private boolean zzbez;
    private RewardedVideoAdListener zzgs;

    public zzlg(Context context) {
        this(context, zziv.zzbcz, (PublisherInterstitialAd) null);
    }

    public zzlg(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zziv.zzbcz, publisherInterstitialAd);
    }

    private zzlg(Context context, zziv zziv, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzbeo = new zzub();
        this.mContext = context;
        this.zzakq = zziv;
        this.zzbey = publisherInterstitialAd;
    }

    private final void zzaj(String str) {
        if (this.zzbet == null) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 63).append("The ad unit ID must be set on InterstitialAd before ").append(str).append(" is called.").toString());
        }
    }

    public final AdListener getAdListener() {
        return this.zzbbu;
    }

    public final String getAdUnitId() {
        return this.zzaou;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzalu;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbet != null) {
                return this.zzbet.zzcj();
            }
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzbeu;
    }

    public final boolean isLoaded() {
        try {
            if (this.zzbet == null) {
                return false;
            }
            return this.zzbet.isReady();
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to check if ad is ready.", e);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.zzbet == null) {
                return false;
            }
            return this.zzbet.isLoading();
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.zzbbu = adListener;
            if (this.zzbet != null) {
                this.zzbet.zza((zzjq) adListener != null ? new zzip(adListener) : null);
            }
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to set the AdListener.", e);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.zzaou != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zzaou = str;
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzalu = appEventListener;
            if (this.zzbet != null) {
                this.zzbet.zza((zzkg) appEventListener != null ? new zziy(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to set the AppEventListener.", e);
        }
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzbes = correlator;
        try {
            if (this.zzbet != null) {
                this.zzbet.zza((zzkm) this.zzbes == null ? null : this.zzbes.zzbc());
            }
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to set correlator.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzapj = z;
            if (this.zzbet != null) {
                this.zzbet.setImmersiveMode(z);
            }
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to set immersive mode", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzbeu = onCustomRenderedAdLoadedListener;
            if (this.zzbet != null) {
                this.zzbet.zza((zznj) onCustomRenderedAdLoadedListener != null ? new zznm(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzgs = rewardedVideoAdListener;
            if (this.zzbet != null) {
                this.zzbet.zza((zzacv) rewardedVideoAdListener != null ? new zzada(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to set the AdListener.", e);
        }
    }

    public final void show() {
        try {
            zzaj("show");
            this.zzbet.showInterstitial();
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to show interstitial.", e);
        }
    }

    public final void zza(zzin zzin) {
        try {
            this.zzbbt = zzin;
            if (this.zzbet != null) {
                this.zzbet.zza((zzjn) zzin != null ? new zzio(zzin) : null);
            }
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to set the AdClickListener.", e);
        }
    }

    public final void zza(zzlc zzlc) {
        try {
            if (this.zzbet == null) {
                if (this.zzaou == null) {
                    zzaj("loadAd");
                }
                zziw zzhp = this.zzbez ? zziw.zzhp() : new zziw();
                zzja zzhy = zzjk.zzhy();
                Context context = this.mContext;
                this.zzbet = (zzkb) zzja.zza(context, false, new zzjd(zzhy, context, zzhp, this.zzaou, this.zzbeo));
                if (this.zzbbu != null) {
                    this.zzbet.zza((zzjq) new zzip(this.zzbbu));
                }
                if (this.zzbbt != null) {
                    this.zzbet.zza((zzjn) new zzio(this.zzbbt));
                }
                if (this.zzalu != null) {
                    this.zzbet.zza((zzkg) new zziy(this.zzalu));
                }
                if (this.zzbeu != null) {
                    this.zzbet.zza((zznj) new zznm(this.zzbeu));
                }
                if (this.zzbes != null) {
                    this.zzbet.zza((zzkm) this.zzbes.zzbc());
                }
                if (this.zzgs != null) {
                    this.zzbet.zza((zzacv) new zzada(this.zzgs));
                }
                this.zzbet.setImmersiveMode(this.zzapj);
            }
            if (this.zzbet.zzb(zziv.zza(this.mContext, zzlc))) {
                this.zzbeo.zzm(zzlc.zzig());
            }
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to load ad.", e);
        }
    }

    public final void zza(boolean z) {
        this.zzbez = true;
    }
}
