package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzak;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.dynamic.IObjectWrapper;

@zzzb
public final class zzsq extends zzkc {
    private final String zzaou;
    private boolean zzapj;
    private final zzri zzbxy;
    @Nullable
    private zzak zzbyd;
    private final zzsi zzbyq;

    public zzsq(Context context, String str, zzuc zzuc, zzaiy zzaiy, zzv zzv) {
        this(str, new zzri(context, zzuc, zzaiy, zzv));
    }

    private zzsq(String str, zzri zzri) {
        this.zzaou = str;
        this.zzbxy = zzri;
        this.zzbyq = new zzsi();
        zzbs.zzer().zza(zzri);
    }

    private final void abort() {
        if (this.zzbyd == null) {
            this.zzbyd = this.zzbxy.zzau(this.zzaou);
            this.zzbyq.zzd(this.zzbyd);
        }
    }

    public final void destroy() throws RemoteException {
        if (this.zzbyd != null) {
            this.zzbyd.destroy();
        }
    }

    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Nullable
    public final String getMediationAdapterClassName() throws RemoteException {
        if (this.zzbyd != null) {
            return this.zzbyd.getMediationAdapterClassName();
        }
        return null;
    }

    public final zzku getVideoController() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    public final boolean isLoading() throws RemoteException {
        return this.zzbyd != null && this.zzbyd.isLoading();
    }

    public final boolean isReady() throws RemoteException {
        return this.zzbyd != null && this.zzbyd.isReady();
    }

    public final void pause() throws RemoteException {
        if (this.zzbyd != null) {
            this.zzbyd.pause();
        }
    }

    public final void resume() throws RemoteException {
        if (this.zzbyd != null) {
            this.zzbyd.resume();
        }
    }

    public final void setImmersiveMode(boolean z) {
        this.zzapj = z;
    }

    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        abort();
        if (this.zzbyd != null) {
            this.zzbyd.setManualImpressionsEnabled(z);
        }
    }

    public final void setUserId(String str) {
    }

    public final void showInterstitial() throws RemoteException {
        if (this.zzbyd != null) {
            this.zzbyd.setImmersiveMode(this.zzapj);
            this.zzbyd.showInterstitial();
            return;
        }
        zzafj.zzco("Interstitial ad must be loaded before showInterstitial().");
    }

    public final void stopLoading() throws RemoteException {
        if (this.zzbyd != null) {
            this.zzbyd.stopLoading();
        }
    }

    public final void zza(zzacv zzacv) {
        this.zzbyq.zzbxt = zzacv;
        if (this.zzbyd != null) {
            this.zzbyq.zzd(this.zzbyd);
        }
    }

    public final void zza(zziw zziw) throws RemoteException {
        if (this.zzbyd != null) {
            this.zzbyd.zza(zziw);
        }
    }

    public final void zza(zzjn zzjn) throws RemoteException {
        this.zzbyq.zzbxs = zzjn;
        if (this.zzbyd != null) {
            this.zzbyq.zzd(this.zzbyd);
        }
    }

    public final void zza(zzjq zzjq) throws RemoteException {
        this.zzbyq.zzaoj = zzjq;
        if (this.zzbyd != null) {
            this.zzbyq.zzd(this.zzbyd);
        }
    }

    public final void zza(zzkg zzkg) throws RemoteException {
        this.zzbyq.zzbxq = zzkg;
        if (this.zzbyd != null) {
            this.zzbyq.zzd(this.zzbyd);
        }
    }

    public final void zza(zzkm zzkm) throws RemoteException {
        abort();
        if (this.zzbyd != null) {
            this.zzbyd.zza(zzkm);
        }
    }

    public final void zza(zzla zzla) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzma zzma) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    public final void zza(zznj zznj) throws RemoteException {
        this.zzbyq.zzbxr = zznj;
        if (this.zzbyd != null) {
            this.zzbyq.zzd(this.zzbyd);
        }
    }

    public final void zza(zzwq zzwq) throws RemoteException {
        zzafj.zzco("setInAppPurchaseListener is deprecated and should not be called.");
    }

    public final void zza(zzww zzww, String str) throws RemoteException {
        zzafj.zzco("setPlayStorePurchaseParams is deprecated and should not be called.");
    }

    public final boolean zzb(zzis zzis) throws RemoteException {
        if (!zzsl.zzi(zzis).contains("gw")) {
            abort();
        }
        if (zzsl.zzi(zzis).contains("_skipMediation")) {
            abort();
        }
        if (zzis.zzbcc != null) {
            abort();
        }
        if (this.zzbyd != null) {
            return this.zzbyd.zzb(zzis);
        }
        zzsl zzer = zzbs.zzer();
        if (zzsl.zzi(zzis).contains("_ad")) {
            zzer.zzb(zzis, this.zzaou);
        }
        zzso zza = zzer.zza(zzis, this.zzaou);
        if (zza != null) {
            if (!zza.zzbyh) {
                zza.load();
                zzsp.zzkw().zzla();
            } else {
                zzsp.zzkw().zzkz();
            }
            this.zzbyd = zza.zzbyd;
            zza.zzbyf.zza(this.zzbyq);
            this.zzbyq.zzd(this.zzbyd);
            return zza.zzbyi;
        }
        abort();
        zzsp.zzkw().zzla();
        return this.zzbyd.zzb(zzis);
    }

    @Nullable
    public final IObjectWrapper zzbl() throws RemoteException {
        if (this.zzbyd != null) {
            return this.zzbyd.zzbl();
        }
        return null;
    }

    @Nullable
    public final zziw zzbm() throws RemoteException {
        if (this.zzbyd != null) {
            return this.zzbyd.zzbm();
        }
        return null;
    }

    public final void zzbo() throws RemoteException {
        if (this.zzbyd != null) {
            this.zzbyd.zzbo();
        } else {
            zzafj.zzco("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    public final zzkg zzbx() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzjq zzby() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Nullable
    public final String zzcj() throws RemoteException {
        if (this.zzbyd != null) {
            return this.zzbyd.zzcj();
        }
        return null;
    }
}
