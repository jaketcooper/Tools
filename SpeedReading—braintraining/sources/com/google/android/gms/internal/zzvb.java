package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzzb
public final class zzvb<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzug {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzceg;
    private final NETWORK_EXTRAS zzceh;

    public zzvb(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzceg = mediationAdapter;
        this.zzceh = network_extras;
    }

    private final SERVER_PARAMETERS zza(String str, int i, String str2) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                zzaiw.zzc("Could not get MediationServerParameters.", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.zzceg.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (MediationServerParameters) serverParametersType.newInstance();
        server_parameters.load(hashMap);
        return server_parameters;
    }

    private static boolean zzn(zzis zzis) {
        if (!zzis.zzbby) {
            zzjk.zzhx();
            return zzais.zzqs();
        }
    }

    public final void destroy() throws RemoteException {
        try {
            this.zzceg.destroy();
        } catch (Throwable th) {
            zzaiw.zzc("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    public final zzku getVideoController() {
        return null;
    }

    public final IObjectWrapper getView() throws RemoteException {
        if (!(this.zzceg instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.zzceg.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return zzn.zzy(((MediationBannerAdapter) this.zzceg).getBannerView());
        } catch (Throwable th) {
            zzaiw.zzc("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    public final boolean isInitialized() {
        return true;
    }

    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final void showInterstitial() throws RemoteException {
        if (!(this.zzceg instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.zzceg.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzaiw.zzbw("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzceg).showInterstitial();
        } catch (Throwable th) {
            zzaiw.zzc("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    public final void showVideo() {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzads zzads, List<String> list) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, zzads zzads, String str2) throws RemoteException {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, zzui zzui) throws RemoteException {
        zza(iObjectWrapper, zzis, str, (String) null, zzui);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, String str2, zzui zzui) throws RemoteException {
        if (!(this.zzceg instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.zzceg.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzaiw.zzbw("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzceg).requestInterstitialAd(new zzvc(zzui), (Activity) zzn.zzx(iObjectWrapper), zza(str, zzis.zzbbz, str2), zzvo.zza(zzis, zzn(zzis)), this.zzceh);
        } catch (Throwable th) {
            zzaiw.zzc("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, String str2, zzui zzui, zzom zzom, List<String> list) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zziw zziw, zzis zzis, String str, zzui zzui) throws RemoteException {
        zza(iObjectWrapper, zziw, zzis, str, (String) null, zzui);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zziw zziw, zzis zzis, String str, String str2, zzui zzui) throws RemoteException {
        if (!(this.zzceg instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.zzceg.getClass().getCanonicalName());
            zzaiw.zzco(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzaiw.zzbw("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter) this.zzceg).requestBannerAd(new zzvc(zzui), (Activity) zzn.zzx(iObjectWrapper), zza(str, zzis.zzbbz, str2), zzvo.zzb(zziw), zzvo.zza(zzis, zzn(zzis)), this.zzceh);
        } catch (Throwable th) {
            zzaiw.zzc("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public final void zza(zzis zzis, String str, String str2) {
    }

    public final void zzc(zzis zzis, String str) {
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final zzuo zzly() {
        return null;
    }

    public final zzur zzlz() {
        return null;
    }

    public final Bundle zzma() {
        return new Bundle();
    }

    public final Bundle zzmb() {
        return new Bundle();
    }

    public final boolean zzmc() {
        return false;
    }

    public final zzpu zzmd() {
        return null;
    }
}
