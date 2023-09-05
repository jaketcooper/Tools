package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.zzn;

@zzzb
public final class zzadd implements RewardedVideoAd {
    private final Context mContext;
    private final Object mLock = new Object();
    private String zzaua;
    private final zzacq zzctl;
    private RewardedVideoAdListener zzgs;

    public zzadd(Context context, zzacq zzacq) {
        this.zzctl = zzacq;
        this.mContext = context;
    }

    private final void zza(String str, zzlc zzlc) {
        synchronized (this.mLock) {
            if (this.zzctl != null) {
                try {
                    this.zzctl.zza(new zzadb(zziv.zza(this.mContext, zzlc), str));
                } catch (RemoteException e) {
                    zzaiw.zzc("Could not forward loadAd to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public final void destroy() {
        destroy((Context) null);
    }

    public final void destroy(Context context) {
        synchronized (this.mLock) {
            if (this.zzctl != null) {
                try {
                    this.zzctl.zzd(zzn.zzy(context));
                } catch (RemoteException e) {
                    zzaiw.zzc("Could not forward destroy to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzctl != null) {
                return this.zzctl.getMediationAdapterClassName();
            }
        } catch (RemoteException e) {
            zzaiw.zzc("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.mLock) {
            rewardedVideoAdListener = this.zzgs;
        }
        return rewardedVideoAdListener;
    }

    public final String getUserId() {
        String str;
        synchronized (this.mLock) {
            str = this.zzaua;
        }
        return str;
    }

    public final boolean isLoaded() {
        boolean z = false;
        synchronized (this.mLock) {
            if (this.zzctl != null) {
                try {
                    z = this.zzctl.isLoaded();
                } catch (RemoteException e) {
                    zzaiw.zzc("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return z;
    }

    public final void loadAd(String str, AdRequest adRequest) {
        zza(str, adRequest.zzbb());
    }

    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        zza(str, publisherAdRequest.zzbb());
    }

    public final void pause() {
        pause((Context) null);
    }

    public final void pause(Context context) {
        synchronized (this.mLock) {
            if (this.zzctl != null) {
                try {
                    this.zzctl.zzb(zzn.zzy(context));
                } catch (RemoteException e) {
                    zzaiw.zzc("Could not forward pause to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public final void resume() {
        resume((Context) null);
    }

    public final void resume(Context context) {
        synchronized (this.mLock) {
            if (this.zzctl != null) {
                try {
                    this.zzctl.zzc(zzn.zzy(context));
                } catch (RemoteException e) {
                    zzaiw.zzc("Could not forward resume to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public final void setImmersiveMode(boolean z) {
        synchronized (this.mLock) {
            if (this.zzctl != null) {
                try {
                    this.zzctl.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzaiw.zzc("Could not forward setImmersiveMode to RewardedVideoAd", e);
                }
            }
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.mLock) {
            this.zzgs = rewardedVideoAdListener;
            if (this.zzctl != null) {
                try {
                    this.zzctl.zza((zzacv) new zzada(rewardedVideoAdListener));
                } catch (RemoteException e) {
                    zzaiw.zzc("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    public final void setUserId(String str) {
        synchronized (this.mLock) {
            this.zzaua = str;
            if (this.zzctl != null) {
                try {
                    this.zzctl.setUserId(str);
                } catch (RemoteException e) {
                    zzaiw.zzc("Could not forward setUserId to RewardedVideoAd", e);
                }
            }
        }
    }

    public final void show() {
        synchronized (this.mLock) {
            if (this.zzctl != null) {
                try {
                    this.zzctl.show();
                } catch (RemoteException e) {
                    zzaiw.zzc("Could not forward show to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }
}
