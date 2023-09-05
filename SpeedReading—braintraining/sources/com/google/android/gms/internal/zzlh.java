package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;

@zzzb
public final class zzlh {
    private static final Object sLock = new Object();
    private static zzlh zzbfa;
    private zzkp zzbfb;
    private RewardedVideoAd zzbfc;

    private zzlh() {
    }

    public static zzlh zzik() {
        zzlh zzlh;
        synchronized (sLock) {
            if (zzbfa == null) {
                zzbfa = new zzlh();
            }
            zzlh = zzbfa;
        }
        return zzlh;
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        RewardedVideoAd rewardedVideoAd;
        synchronized (sLock) {
            if (this.zzbfc != null) {
                rewardedVideoAd = this.zzbfc;
            } else {
                this.zzbfc = new zzadd(context, (zzacq) zzja.zza(context, false, new zzji(zzjk.zzhy(), context, new zzub())));
                rewardedVideoAd = this.zzbfc;
            }
        }
        return rewardedVideoAd;
    }

    public final void openDebugMenu(Context context, String str) {
        zzbq.zza(this.zzbfb != null, (Object) "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.zzbfb.zzb(zzn.zzy(context), str);
        } catch (RemoteException e) {
            zzaiw.zzb("Unable to open debug menu.", e);
        }
    }

    public final void setAppMuted(boolean z) {
        zzbq.zza(this.zzbfb != null, (Object) "MobileAds.initialize() must be called prior to setting app muted state.");
        try {
            this.zzbfb.setAppMuted(z);
        } catch (RemoteException e) {
            zzaiw.zzb("Unable to set app mute state.", e);
        }
    }

    public final void setAppVolume(float f) {
        boolean z = true;
        zzbq.checkArgument(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        if (this.zzbfb == null) {
            z = false;
        }
        zzbq.zza(z, (Object) "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzbfb.setAppVolume(f);
        } catch (RemoteException e) {
            zzaiw.zzb("Unable to set app volume.", e);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.content.Context r5, java.lang.String r6, com.google.android.gms.internal.zzlj r7) {
        /*
            r4 = this;
            java.lang.Object r1 = sLock
            monitor-enter(r1)
            com.google.android.gms.internal.zzkp r0 = r4.zzbfb     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
        L_0x0008:
            return
        L_0x0009:
            if (r5 != 0) goto L_0x0016
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0013 }
            java.lang.String r2 = "Context cannot be null."
            r0.<init>(r2)     // Catch:{ all -> 0x0013 }
            throw r0     // Catch:{ all -> 0x0013 }
        L_0x0013:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            throw r0
        L_0x0016:
            com.google.android.gms.internal.zzja r0 = com.google.android.gms.internal.zzjk.zzhy()     // Catch:{ RemoteException -> 0x003f }
            r2 = 0
            com.google.android.gms.internal.zzjf r3 = new com.google.android.gms.internal.zzjf     // Catch:{ RemoteException -> 0x003f }
            r3.<init>(r0, r5)     // Catch:{ RemoteException -> 0x003f }
            java.lang.Object r0 = com.google.android.gms.internal.zzja.zza((android.content.Context) r5, (boolean) r2, r3)     // Catch:{ RemoteException -> 0x003f }
            com.google.android.gms.internal.zzkp r0 = (com.google.android.gms.internal.zzkp) r0     // Catch:{ RemoteException -> 0x003f }
            r4.zzbfb = r0     // Catch:{ RemoteException -> 0x003f }
            com.google.android.gms.internal.zzkp r0 = r4.zzbfb     // Catch:{ RemoteException -> 0x003f }
            r0.initialize()     // Catch:{ RemoteException -> 0x003f }
            if (r6 == 0) goto L_0x003d
            com.google.android.gms.internal.zzkp r0 = r4.zzbfb     // Catch:{ RemoteException -> 0x003f }
            com.google.android.gms.internal.zzli r2 = new com.google.android.gms.internal.zzli     // Catch:{ RemoteException -> 0x003f }
            r2.<init>(r4, r5)     // Catch:{ RemoteException -> 0x003f }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.zzn.zzy(r2)     // Catch:{ RemoteException -> 0x003f }
            r0.zza(r6, r2)     // Catch:{ RemoteException -> 0x003f }
        L_0x003d:
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            goto L_0x0008
        L_0x003f:
            r0 = move-exception
            java.lang.String r2 = "MobileAdsSettingManager initialization failed"
            com.google.android.gms.internal.zzaiw.zzc(r2, r0)     // Catch:{ all -> 0x0013 }
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlh.zza(android.content.Context, java.lang.String, com.google.android.gms.internal.zzlj):void");
    }

    public final float zzdh() {
        if (this.zzbfb == null) {
            return 1.0f;
        }
        try {
            return this.zzbfb.zzdh();
        } catch (RemoteException e) {
            zzaiw.zzb("Unable to get app volume.", e);
            return 1.0f;
        }
    }

    public final boolean zzdi() {
        if (this.zzbfb == null) {
            return false;
        }
        try {
            return this.zzbfb.zzdi();
        } catch (RemoteException e) {
            zzaiw.zzb("Unable to get app mute state.", e);
            return false;
        }
    }
}
