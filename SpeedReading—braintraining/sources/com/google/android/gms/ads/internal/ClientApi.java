package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzacj;
import com.google.android.gms.internal.zzacq;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzjw;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzkp;
import com.google.android.gms.internal.zzoo;
import com.google.android.gms.internal.zzor;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzph;
import com.google.android.gms.internal.zzuc;
import com.google.android.gms.internal.zzwj;
import com.google.android.gms.internal.zzwt;
import com.google.android.gms.internal.zzzb;
import java.util.HashMap;

@Keep
@zzzb
@KeepForSdkWithMembers
@DynamiteApi
public class ClientApi extends zzkk {
    public zzjw createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzuc zzuc, int i) {
        Context context = (Context) zzn.zzx(iObjectWrapper);
        zzbs.zzec();
        return new zzaj(context, str, zzuc, new zzaiy(11717000, i, true, zzagr.zzat(context)), zzv.zzd(context));
    }

    public zzwj createAdOverlay(IObjectWrapper iObjectWrapper) {
        return new zzd((Activity) zzn.zzx(iObjectWrapper));
    }

    public zzkb createBannerAdManager(IObjectWrapper iObjectWrapper, zziw zziw, String str, zzuc zzuc, int i) throws RemoteException {
        Context context = (Context) zzn.zzx(iObjectWrapper);
        zzbs.zzec();
        return new zzx(context, zziw, str, zzuc, new zzaiy(11717000, i, true, zzagr.zzat(context)), zzv.zzd(context));
    }

    public zzwt createInAppPurchaseManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0035, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.zzbs.zzep().zzd(com.google.android.gms.internal.zzmq.zzbkg)).booleanValue() == false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0049, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.zzbs.zzep().zzd(com.google.android.gms.internal.zzmq.zzbkh)).booleanValue() != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x004b, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzkb createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper r14, com.google.android.gms.internal.zziw r15, java.lang.String r16, com.google.android.gms.internal.zzuc r17, int r18) throws android.os.RemoteException {
        /*
            r13 = this;
            java.lang.Object r2 = com.google.android.gms.dynamic.zzn.zzx(r14)
            android.content.Context r2 = (android.content.Context) r2
            com.google.android.gms.internal.zzmq.initialize(r2)
            com.google.android.gms.internal.zzaiy r5 = new com.google.android.gms.internal.zzaiy
            r1 = 11717000(0xb2c988, float:1.6419014E-38)
            r3 = 1
            com.google.android.gms.ads.internal.zzbs.zzec()
            boolean r4 = com.google.android.gms.internal.zzagr.zzat(r2)
            r0 = r18
            r5.<init>(r1, r0, r3, r4)
            java.lang.String r1 = "reward_mb"
            java.lang.String r3 = r15.zzbda
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0037
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r1 = com.google.android.gms.internal.zzmq.zzbkg
            com.google.android.gms.internal.zzmo r4 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r1 = r4.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x004b
        L_0x0037:
            if (r3 == 0) goto L_0x005c
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r1 = com.google.android.gms.internal.zzmq.zzbkh
            com.google.android.gms.internal.zzmo r3 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r1 = r3.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x005c
        L_0x004b:
            r1 = 1
        L_0x004c:
            if (r1 == 0) goto L_0x005e
            com.google.android.gms.internal.zzsq r1 = new com.google.android.gms.internal.zzsq
            com.google.android.gms.ads.internal.zzv r6 = com.google.android.gms.ads.internal.zzv.zzd(r2)
            r3 = r16
            r4 = r17
            r1.<init>(r2, r3, r4, r5, r6)
        L_0x005b:
            return r1
        L_0x005c:
            r1 = 0
            goto L_0x004c
        L_0x005e:
            com.google.android.gms.ads.internal.zzak r6 = new com.google.android.gms.ads.internal.zzak
            com.google.android.gms.ads.internal.zzv r12 = com.google.android.gms.ads.internal.zzv.zzd(r2)
            r7 = r2
            r8 = r15
            r9 = r16
            r10 = r17
            r11 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r1 = r6
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.ClientApi.createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.zziw, java.lang.String, com.google.android.gms.internal.zzuc, int):com.google.android.gms.internal.zzkb");
    }

    public zzpc createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzoo((FrameLayout) zzn.zzx(iObjectWrapper), (FrameLayout) zzn.zzx(iObjectWrapper2));
    }

    public zzph createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzor((View) zzn.zzx(iObjectWrapper), (HashMap) zzn.zzx(iObjectWrapper2), (HashMap) zzn.zzx(iObjectWrapper3));
    }

    public zzacq createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzuc zzuc, int i) {
        Context context = (Context) zzn.zzx(iObjectWrapper);
        zzbs.zzec();
        return new zzacj(context, zzv.zzd(context), zzuc, new zzaiy(11717000, i, true, zzagr.zzat(context)));
    }

    public zzkb createSearchAdManager(IObjectWrapper iObjectWrapper, zziw zziw, String str, int i) throws RemoteException {
        Context context = (Context) zzn.zzx(iObjectWrapper);
        zzbs.zzec();
        return new zzbm(context, zziw, str, new zzaiy(11717000, i, true, zzagr.zzat(context)));
    }

    @Nullable
    public zzkp getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    public zzkp getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) {
        Context context = (Context) zzn.zzx(iObjectWrapper);
        zzbs.zzec();
        return zzaw.zza(context, new zzaiy(11717000, i, true, zzagr.zzat(context)));
    }
}
