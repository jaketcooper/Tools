package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzzb
public final class zzuw extends zzug {
    private final MediationAdapter zzcdy;
    private zzux zzcdz;

    public zzuw(MediationAdapter mediationAdapter) {
        this.zzcdy = mediationAdapter;
    }

    private final Bundle zza(String str, zzis zzis, String str2) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzaiw.zzco(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zzcdy instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzis != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzis.zzbbz);
                }
            }
            return bundle;
        } catch (Throwable th) {
            zzaiw.zzc("Could not get Server Parameters Bundle.", th);
            throw new RemoteException();
        }
    }

    private static boolean zzn(zzis zzis) {
        if (!zzis.zzbby) {
            zzjk.zzhx();
            return zzais.zzqs();
        }
    }

    public final void destroy() throws RemoteException {
        try {
            this.zzcdy.onDestroy();
        } catch (Throwable th) {
            zzaiw.zzc("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        if (this.zzcdy instanceof zzanr) {
            return ((zzanr) this.zzcdy).getInterstitialAdapterInfo();
        }
        String valueOf = String.valueOf(this.zzcdy.getClass().getCanonicalName());
        zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a v2 MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a v2 MediationInterstitialAdapter: "));
        return new Bundle();
    }

    public final zzku getVideoController() {
        if (!(this.zzcdy instanceof zza)) {
            return null;
        }
        try {
            return ((zza) this.zzcdy).getVideoController();
        } catch (Throwable th) {
            zzaiw.zzc("Could not get video controller.", th);
            return null;
        }
    }

    public final IObjectWrapper getView() throws RemoteException {
        if (!(this.zzcdy instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.zzcdy.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return zzn.zzy(((MediationBannerAdapter) this.zzcdy).getBannerView());
        } catch (Throwable th) {
            zzaiw.zzc("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    public final boolean isInitialized() throws RemoteException {
        if (!(this.zzcdy instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.zzcdy.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzaiw.zzbw("Check if adapter is initialized.");
        try {
            return ((MediationRewardedVideoAdAdapter) this.zzcdy).isInitialized();
        } catch (Throwable th) {
            zzaiw.zzc("Could not check if adapter is initialized.", th);
            throw new RemoteException();
        }
    }

    public final void pause() throws RemoteException {
        try {
            this.zzcdy.onPause();
        } catch (Throwable th) {
            zzaiw.zzc("Could not pause adapter.", th);
            throw new RemoteException();
        }
    }

    public final void resume() throws RemoteException {
        try {
            this.zzcdy.onResume();
        } catch (Throwable th) {
            zzaiw.zzc("Could not resume adapter.", th);
            throw new RemoteException();
        }
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        if (!(this.zzcdy instanceof OnImmersiveModeUpdatedListener)) {
            String valueOf = String.valueOf(this.zzcdy.getClass().getCanonicalName());
            zzaiw.zzcn(valueOf.length() != 0 ? "MediationAdapter is not an OnImmersiveModeUpdatedListener: ".concat(valueOf) : new String("MediationAdapter is not an OnImmersiveModeUpdatedListener: "));
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) this.zzcdy).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzaiw.zzc("Could not set immersive mode.", th);
        }
    }

    public final void showInterstitial() throws RemoteException {
        if (!(this.zzcdy instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.zzcdy.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzaiw.zzbw("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzcdy).showInterstitial();
        } catch (Throwable th) {
            zzaiw.zzc("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    public final void showVideo() throws RemoteException {
        if (!(this.zzcdy instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.zzcdy.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzaiw.zzbw("Show rewarded video ad from adapter.");
        try {
            ((MediationRewardedVideoAdAdapter) this.zzcdy).showVideo();
        } catch (Throwable th) {
            zzaiw.zzc("Could not show rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzads zzads, List<String> list) throws RemoteException {
        if (!(this.zzcdy instanceof InitializableMediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.zzcdy.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not an InitializableMediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not an InitializableMediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzaiw.zzbw("Initialize rewarded video adapter.");
        try {
            InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzcdy;
            ArrayList arrayList = new ArrayList();
            for (String zza : list) {
                arrayList.add(zza(zza, (zzis) null, (String) null));
            }
            initializableMediationRewardedVideoAdAdapter.initialize((Context) zzn.zzx(iObjectWrapper), new zzadv(zzads), arrayList);
        } catch (Throwable th) {
            zzaiw.zzc("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, zzads zzads, String str2) throws RemoteException {
        Bundle bundle;
        zzuv zzuv;
        if (!(this.zzcdy instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.zzcdy.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzaiw.zzbw("Initialize rewarded video adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzcdy;
            Bundle zza = zza(str2, zzis, (String) null);
            if (zzis != null) {
                zzuv zzuv2 = new zzuv(zzis.zzbbv == -1 ? null : new Date(zzis.zzbbv), zzis.zzbbw, zzis.zzbbx != null ? new HashSet(zzis.zzbbx) : null, zzis.zzbcd, zzn(zzis), zzis.zzbbz, zzis.zzbck);
                if (zzis.zzbcf != null) {
                    bundle = zzis.zzbcf.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                    zzuv = zzuv2;
                } else {
                    bundle = null;
                    zzuv = zzuv2;
                }
            } else {
                bundle = null;
                zzuv = null;
            }
            mediationRewardedVideoAdAdapter.initialize((Context) zzn.zzx(iObjectWrapper), zzuv, str, new zzadv(zzads), zza, bundle);
        } catch (Throwable th) {
            zzaiw.zzc("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, zzui zzui) throws RemoteException {
        zza(iObjectWrapper, zzis, str, (String) null, zzui);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, String str2, zzui zzui) throws RemoteException {
        if (!(this.zzcdy instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.zzcdy.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzaiw.zzbw("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzcdy;
            mediationInterstitialAdapter.requestInterstitialAd((Context) zzn.zzx(iObjectWrapper), new zzux(zzui), zza(str, zzis, str2), new zzuv(zzis.zzbbv == -1 ? null : new Date(zzis.zzbbv), zzis.zzbbw, zzis.zzbbx != null ? new HashSet(zzis.zzbbx) : null, zzis.zzbcd, zzn(zzis), zzis.zzbbz, zzis.zzbck), zzis.zzbcf != null ? zzis.zzbcf.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzaiw.zzc("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, String str2, zzui zzui, zzom zzom, List<String> list) throws RemoteException {
        if (!(this.zzcdy instanceof MediationNativeAdapter)) {
            String valueOf = String.valueOf(this.zzcdy.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a MediationNativeAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationNativeAdapter: "));
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.zzcdy;
            zzva zzva = new zzva(zzis.zzbbv == -1 ? null : new Date(zzis.zzbbv), zzis.zzbbw, zzis.zzbbx != null ? new HashSet(zzis.zzbbx) : null, zzis.zzbcd, zzn(zzis), zzis.zzbbz, zzom, list, zzis.zzbck);
            Bundle bundle = zzis.zzbcf != null ? zzis.zzbcf.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.zzcdz = new zzux(zzui);
            mediationNativeAdapter.requestNativeAd((Context) zzn.zzx(iObjectWrapper), this.zzcdz, zza(str, zzis, str2), zzva, bundle);
        } catch (Throwable th) {
            zzaiw.zzc("Could not request native ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zziw zziw, zzis zzis, String str, zzui zzui) throws RemoteException {
        zza(iObjectWrapper, zziw, zzis, str, (String) null, zzui);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zziw zziw, zzis zzis, String str, String str2, zzui zzui) throws RemoteException {
        if (!(this.zzcdy instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.zzcdy.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzaiw.zzbw("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzcdy;
            mediationBannerAdapter.requestBannerAd((Context) zzn.zzx(iObjectWrapper), new zzux(zzui), zza(str, zzis, str2), zzb.zza(zziw.width, zziw.height, zziw.zzbda), new zzuv(zzis.zzbbv == -1 ? null : new Date(zzis.zzbbv), zzis.zzbbw, zzis.zzbbx != null ? new HashSet(zzis.zzbbx) : null, zzis.zzbcd, zzn(zzis), zzis.zzbbz, zzis.zzbck), zzis.zzbcf != null ? zzis.zzbcf.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzaiw.zzc("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public final void zza(zzis zzis, String str, String str2) throws RemoteException {
        if (!(this.zzcdy instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(this.zzcdy.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzaiw.zzbw("Requesting rewarded video ad from adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzcdy;
            mediationRewardedVideoAdAdapter.loadAd(new zzuv(zzis.zzbbv == -1 ? null : new Date(zzis.zzbbv), zzis.zzbbw, zzis.zzbbx != null ? new HashSet(zzis.zzbbx) : null, zzis.zzbcd, zzn(zzis), zzis.zzbbz, zzis.zzbck), zza(str, zzis, str2), zzis.zzbcf != null ? zzis.zzbcf.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzaiw.zzc("Could not load rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public final void zzc(zzis zzis, String str) throws RemoteException {
        zza(zzis, str, (String) null);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        try {
            ((OnContextChangedListener) this.zzcdy).onContextChanged((Context) zzn.zzx(iObjectWrapper));
        } catch (Throwable th) {
            zzaiw.zza("Could not inform adapter of changed context", th);
        }
    }

    public final zzuo zzly() {
        NativeAdMapper zzmg = this.zzcdz.zzmg();
        if (zzmg instanceof NativeAppInstallAdMapper) {
            return new zzuy((NativeAppInstallAdMapper) zzmg);
        }
        return null;
    }

    public final zzur zzlz() {
        NativeAdMapper zzmg = this.zzcdz.zzmg();
        if (zzmg instanceof NativeContentAdMapper) {
            return new zzuz((NativeContentAdMapper) zzmg);
        }
        return null;
    }

    public final Bundle zzma() {
        if (this.zzcdy instanceof zzanq) {
            return ((zzanq) this.zzcdy).zzma();
        }
        String valueOf = String.valueOf(this.zzcdy.getClass().getCanonicalName());
        zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a v2 MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a v2 MediationBannerAdapter: "));
        return new Bundle();
    }

    public final Bundle zzmb() {
        return new Bundle();
    }

    public final boolean zzmc() {
        return this.zzcdy instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    public final zzpu zzmd() {
        NativeCustomTemplateAd zzmh = this.zzcdz.zzmh();
        if (zzmh instanceof zzpx) {
            return ((zzpx) zzmh).zzkg();
        }
        return null;
    }
}
