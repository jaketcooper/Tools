package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzacv;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagl;
import com.google.android.gms.internal.zzais;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjq;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzla;
import com.google.android.gms.internal.zzma;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zznj;
import com.google.android.gms.internal.zzwq;
import com.google.android.gms.internal.zzww;
import com.google.android.gms.internal.zzzb;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@zzzb
public final class zzbm extends zzkc {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    @Nullable
    public zzjq zzaoj;
    /* access modifiers changed from: private */
    public final zzaiy zzaov;
    private final zziw zzarg;
    /* access modifiers changed from: private */
    public final Future<zzcs> zzarh = zzagl.zza((ExecutorService) zzagl.zzcyx, new zzbp(this));
    private final zzbr zzari;
    /* access modifiers changed from: private */
    @Nullable
    public WebView zzarj = new WebView(this.mContext);
    /* access modifiers changed from: private */
    @Nullable
    public zzcs zzark;
    private AsyncTask<Void, Void, String> zzarl;

    public zzbm(Context context, zziw zziw, String str, zzaiy zzaiy) {
        this.mContext = context;
        this.zzaov = zzaiy;
        this.zzarg = zziw;
        this.zzari = new zzbr(str);
        zzk(0);
        this.zzarj.setVerticalScrollBarEnabled(false);
        this.zzarj.getSettings().setJavaScriptEnabled(true);
        this.zzarj.setWebViewClient(new zzbn(this));
        this.zzarj.setOnTouchListener(new zzbo(this));
    }

    /* access modifiers changed from: private */
    public final String zzv(String str) {
        if (this.zzark == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzark.zza(parse, this.mContext, (View) null);
        } catch (zzct e) {
            zzafj.zzc("Unable to process ad data", e);
        }
        return parse.toString();
    }

    /* access modifiers changed from: private */
    public final void zzw(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.mContext.startActivity(intent);
    }

    public final void destroy() throws RemoteException {
        zzbq.zzga("destroy must be called on the main UI thread.");
        this.zzarl.cancel(true);
        this.zzarh.cancel(true);
        this.zzarj.destroy();
        this.zzarj = null;
    }

    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Nullable
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Nullable
    public final zzku getVideoController() {
        return null;
    }

    public final boolean isLoading() throws RemoteException {
        return false;
    }

    public final boolean isReady() throws RemoteException {
        return false;
    }

    public final void pause() throws RemoteException {
        zzbq.zzga("pause must be called on the main UI thread.");
    }

    public final void resume() throws RemoteException {
        zzbq.zzga("resume must be called on the main UI thread.");
    }

    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    public final void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void stopLoading() throws RemoteException {
    }

    public final void zza(zzacv zzacv) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zziw zziw) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void zza(zzjn zzjn) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzjq zzjq) throws RemoteException {
        this.zzaoj = zzjq;
    }

    public final void zza(zzkg zzkg) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzkm zzkm) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzla zzla) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzma zzma) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zznj zznj) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzwq zzwq) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzww zzww, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final boolean zzb(zzis zzis) throws RemoteException {
        zzbq.checkNotNull(this.zzarj, "This Search Ad has already been torn down");
        this.zzari.zza(zzis, this.zzaov);
        this.zzarl = new zzbq(this, (zzbn) null).execute(new Void[0]);
        return true;
    }

    public final IObjectWrapper zzbl() throws RemoteException {
        zzbq.zzga("getAdFrame must be called on the main UI thread.");
        return zzn.zzy(this.zzarj);
    }

    public final zziw zzbm() throws RemoteException {
        return this.zzarg;
    }

    public final void zzbo() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final zzkg zzbx() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzjq zzby() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Nullable
    public final String zzcj() throws RemoteException {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final String zzds() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzbs.zzep().zzd(zzmq.zzbnx));
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zzari.getQuery());
        builder.appendQueryParameter("pubId", this.zzari.zzdv());
        Map<String, String> zzdw = this.zzari.zzdw();
        for (String next : zzdw.keySet()) {
            builder.appendQueryParameter(next, zzdw.get(next));
        }
        Uri build = builder.build();
        if (this.zzark != null) {
            try {
                build = this.zzark.zza(build, this.mContext);
            } catch (zzct e) {
                zzafj.zzc("Unable to process ad data", e);
            }
        }
        String zzdt = zzdt();
        String encodedQuery = build.getEncodedQuery();
        return new StringBuilder(String.valueOf(zzdt).length() + 1 + String.valueOf(encodedQuery).length()).append(zzdt).append("#").append(encodedQuery).toString();
    }

    /* access modifiers changed from: package-private */
    public final String zzdt() {
        String zzdu = this.zzari.zzdu();
        String str = TextUtils.isEmpty(zzdu) ? "www.google.com" : zzdu;
        String str2 = (String) zzbs.zzep().zzd(zzmq.zzbnx);
        return new StringBuilder(String.valueOf("https://").length() + String.valueOf(str).length() + String.valueOf(str2).length()).append("https://").append(str).append(str2).toString();
    }

    /* access modifiers changed from: package-private */
    public final void zzk(int i) {
        if (this.zzarj != null) {
            this.zzarj.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzu(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzjk.zzhx();
            return zzais.zzc(this.mContext, Integer.parseInt(queryParameter));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
