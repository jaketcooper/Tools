package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.p000v4.util.SimpleArrayMap;
import android.util.Log;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzaeu;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagl;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzaiw;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzajp;
import com.google.android.gms.internal.zzajy;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzamm;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzfe;
import com.google.android.gms.internal.zzgm;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznj;
import com.google.android.gms.internal.zznp;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznw;
import com.google.android.gms.internal.zzny;
import com.google.android.gms.internal.zznz;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzob;
import com.google.android.gms.internal.zzoc;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zztn;
import com.google.android.gms.internal.zzuc;
import com.google.android.gms.internal.zzuf;
import com.google.android.gms.internal.zzuo;
import com.google.android.gms.internal.zzur;
import com.google.android.gms.internal.zzwq;
import com.google.android.gms.internal.zzxf;
import com.google.android.gms.internal.zzyg;
import com.google.android.gms.internal.zzyk;
import com.google.android.gms.internal.zzzb;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzba extends zzd implements zzob {
    private final Object mLock;
    private boolean zzane;
    private boolean zzaqm;
    private zzajy<zzoc> zzaqn;
    private zzama zzaqo;
    private int zzaqp;
    private zzyg zzaqq;
    private final String zzaqr;

    public zzba(Context context, zzv zzv, zziw zziw, String str, zzuc zzuc, zzaiy zzaiy) {
        this(context, zzv, zziw, str, zzuc, zzaiy, false);
    }

    public zzba(Context context, zzv zzv, zziw zziw, String str, zzuc zzuc, zzaiy zzaiy, boolean z) {
        super(context, zziw, str, zzuc, zzaiy, zzv);
        this.mLock = new Object();
        this.zzaqn = new zzajy<>();
        this.zzaqp = 1;
        this.zzaqr = UUID.randomUUID().toString();
        this.zzaqm = z;
    }

    /* access modifiers changed from: private */
    public static void zza(zzbt zzbt, zzbt zzbt2) {
        if (zzbt2.zzatp == null) {
            zzbt2.zzatp = zzbt.zzatp;
        }
        if (zzbt2.zzatq == null) {
            zzbt2.zzatq = zzbt.zzatq;
        }
        if (zzbt2.zzatr == null) {
            zzbt2.zzatr = zzbt.zzatr;
        }
        if (zzbt2.zzats == null) {
            zzbt2.zzats = zzbt.zzats;
        }
        if (zzbt2.zzatu == null) {
            zzbt2.zzatu = zzbt.zzatu;
        }
        if (zzbt2.zzatt == null) {
            zzbt2.zzatt = zzbt.zzatt;
        }
        if (zzbt2.zzaub == null) {
            zzbt2.zzaub = zzbt.zzaub;
        }
        if (zzbt2.zzatk == null) {
            zzbt2.zzatk = zzbt.zzatk;
        }
        if (zzbt2.zzauc == null) {
            zzbt2.zzauc = zzbt.zzauc;
        }
        if (zzbt2.zzatl == null) {
            zzbt2.zzatl = zzbt.zzatl;
        }
        if (zzbt2.zzatm == null) {
            zzbt2.zzatm = zzbt.zzatm;
        }
        if (zzbt2.zzath == null) {
            zzbt2.zzath = zzbt.zzath;
        }
        if (zzbt2.zzati == null) {
            zzbt2.zzati = zzbt.zzati;
        }
        if (zzbt2.zzatj == null) {
            zzbt2.zzatj = zzbt.zzatj;
        }
    }

    private final void zza(zzns zzns) {
        zzagr.zzczc.post(new zzbe(this, zzns));
    }

    private final void zza(zznu zznu) {
        zzagr.zzczc.post(new zzbf(this, zznu));
    }

    @Nullable
    private final zztn zzcs() {
        if (this.zzamt.zzati == null || !this.zzamt.zzati.zzcng) {
            return null;
        }
        return this.zzamt.zzati.zzcvs;
    }

    private final void zzdq() {
        zzyg zzdk = zzdk();
        if (zzdk != null) {
            zzdk.zzlm();
        }
    }

    public final String getAdUnitId() {
        return this.zzamt.zzatb;
    }

    public final String getUuid() {
        return this.zzaqr;
    }

    public final void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public final void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public final void zza(zzaev zzaev, zznd zznd) {
        if (zzaev.zzath != null) {
            this.zzamt.zzath = zzaev.zzath;
        }
        if (zzaev.errorCode != -2) {
            zzagr.zzczc.post(new zzbb(this, zzaev));
            return;
        }
        int i = zzaev.zzcpe.zzcmz;
        if (i == 1) {
            this.zzamt.zzaue = 0;
            zzbt zzbt = this.zzamt;
            zzbs.zzeb();
            zzbt.zzatg = zzxf.zza(this.zzamt.zzaif, this, zzaev, this.zzamt.zzatc, (zzama) null, this.zzanb, this, zznd);
            String valueOf = String.valueOf(this.zzamt.zzatg.getClass().getName());
            zzafj.zzbw(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONObject(zzaev.zzcwe.body).getJSONArray("slots");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONArray jSONArray3 = jSONArray2.getJSONObject(i2).getJSONArray("ads");
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    jSONArray.put(jSONArray3.get(i3));
                }
            }
            zzdq();
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i);
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i; i4++) {
                arrayList.add(zzagl.zza(newFixedThreadPool, new zzbc(this, i4, jSONArray, i, zzaev)));
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                try {
                    zzagr.zzczc.post(new zzbd(this, (zzoc) ((zzajp) arrayList.get(i5)).get(((Long) zzbs.zzep().zzd(zzmq.zzblt)).longValue(), TimeUnit.MILLISECONDS), i5, arrayList));
                } catch (InterruptedException e) {
                    zzafj.zzc("Exception occurred while getting an ad response", e);
                    Thread.currentThread().interrupt();
                } catch (CancellationException | ExecutionException | TimeoutException e2) {
                    zzafj.zzc("Exception occurred while getting an ad response", e2);
                }
            }
        } catch (JSONException e3) {
            zzafj.zzc("Malformed native ad response", e3);
            zzi(0);
        }
    }

    public final void zza(zznj zznj) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public final void zza(zzny zzny) {
        if (this.zzaqo != null) {
            this.zzaqo.zzb(zzny);
        }
    }

    public final void zza(zzoa zzoa) {
        if (this.zzamt.zzati.zzcvq != null) {
            zzbs.zzeg().zzpm().zza(this.zzamt.zzath, this.zzamt.zzati, (zzgm) new zzfe(zzoa), (zzama) null);
        }
    }

    public final void zza(zzwq zzwq) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzaeu zzaeu, zzaeu zzaeu2) {
        zzc((List<String>) null);
        if (!this.zzamt.zzfg()) {
            throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
        }
        if (zzaeu2.zzcng) {
            zzdq();
            try {
                zzuo zzly = zzaeu2.zzcde != null ? zzaeu2.zzcde.zzly() : null;
                zzur zzlz = zzaeu2.zzcde != null ? zzaeu2.zzcde.zzlz() : null;
                zzpu zzmd = zzaeu2.zzcde != null ? zzaeu2.zzcde.zzmd() : null;
                String zzc = zzc(zzaeu2);
                if (zzly == null || this.zzamt.zzatp == null) {
                    if (zzlz != null) {
                        if (this.zzamt.zzatq != null) {
                            zznu zznu = new zznu(zzlz.getHeadline(), zzlz.getImages(), zzlz.getBody(), zzlz.zzjt() != null ? zzlz.zzjt() : null, zzlz.getCallToAction(), zzlz.getAdvertiser(), (zznp) null, zzlz.getExtras(), zzlz.getVideoController(), zzlz.zzmf() != null ? (View) zzn.zzx(zzlz.zzmf()) : null, zzlz.zzjr(), zzc);
                            zznu.zzb((zzoa) new zznz(this.zzamt.zzaif, (zzob) this, this.zzamt.zzatc, zzlz, (zzoc) zznu));
                            zza(zznu);
                        }
                    }
                    if (zzmd != null) {
                        if (!(this.zzamt.zzats == null || this.zzamt.zzats.get(zzmd.getCustomTemplateId()) == null)) {
                            zzagr.zzczc.post(new zzbh(this, zzmd));
                        }
                    }
                    zzafj.zzco("No matching mapper/listener for retrieved native ad template.");
                    zzi(0);
                    return false;
                }
                zzns zzns = new zzns(zzly.getHeadline(), zzly.getImages(), zzly.getBody(), zzly.zzjm() != null ? zzly.zzjm() : null, zzly.getCallToAction(), zzly.getStarRating(), zzly.getStore(), zzly.getPrice(), (zznp) null, zzly.getExtras(), zzly.getVideoController(), zzly.zzmf() != null ? (View) zzn.zzx(zzly.zzmf()) : null, zzly.zzjr(), zzc);
                zzns.zzb((zzoa) new zznz(this.zzamt.zzaif, (zzob) this, this.zzamt.zzatc, zzly, (zzoc) zzns));
                zza(zzns);
            } catch (RemoteException e) {
                zzafj.zzc("Failed to get native ad mapper", e);
            }
        } else {
            zzoc zzoc = zzaeu2.zzcvy;
            if (this.zzaqm) {
                this.zzaqn.set(zzoc);
            } else if ((zzoc instanceof zznu) && this.zzamt.zzatq != null) {
                zza((zznu) zzaeu2.zzcvy);
            } else if ((zzoc instanceof zzns) && this.zzamt.zzatp != null) {
                zza((zzns) zzaeu2.zzcvy);
            } else if (!(zzoc instanceof zznw) || this.zzamt.zzats == null || this.zzamt.zzats.get(((zznw) zzoc).getCustomTemplateId()) == null) {
                zzafj.zzco("No matching listener for retrieved native ad template.");
                zzi(0);
                return false;
            } else {
                zzagr.zzczc.post(new zzbg(this, ((zznw) zzoc).getCustomTemplateId(), zzaeu2));
            }
        }
        return super.zza(zzaeu, zzaeu2);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzis zzis, zzaeu zzaeu, boolean z) {
        return this.zzams.zzdr();
    }

    public final boolean zza(zzis zzis, zznd zznd) {
        try {
            zzdj();
            return super.zza(zzis, zznd, this.zzaqp);
        } catch (Exception e) {
            if (zzaiw.zzae(4)) {
                Log.i(AdRequest.LOGTAG, "Error initializing webview.", e);
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzbs() {
        zzc(false);
    }

    /* access modifiers changed from: protected */
    public final void zzc(int i, boolean z) {
        zzdq();
        super.zzc(i, z);
    }

    public final void zzc(@Nullable List<String> list) {
        zzbq.zzga("setNativeTemplates must be called on the main UI thread.");
        this.zzamt.zzaub = list;
    }

    /* access modifiers changed from: protected */
    public final void zzc(boolean z) {
        super.zzc(z);
        if (this.zzane) {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbnd)).booleanValue()) {
                zzdm();
            }
        }
    }

    public final void zzcc() {
        zzkx zzid;
        zzaeu zzaeu = this.zzamt.zzati;
        if (zzaeu.zzcde == null) {
            super.zzcc();
            return;
        }
        try {
            zzuf zzuf = zzaeu.zzcde;
            zzku zzku = null;
            zzuo zzly = zzuf.zzly();
            if (zzly != null) {
                zzku = zzly.getVideoController();
            } else {
                zzur zzlz = zzuf.zzlz();
                if (zzlz != null) {
                    zzku = zzlz.getVideoController();
                } else {
                    zzpu zzmd = zzuf.zzmd();
                    if (zzmd != null) {
                        zzku = zzmd.getVideoController();
                    }
                }
            }
            if (zzku != null && (zzid = zzku.zzid()) != null) {
                zzid.onVideoEnd();
            }
        } catch (RemoteException e) {
            zzafj.zzc("Unable to call onVideoEnd()", e);
        }
    }

    public final void zzcd() {
        if (this.zzamt.zzati == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzamt.zzati.zzcdf)) {
            super.zzcd();
        } else {
            zzbu();
        }
    }

    public final void zzci() {
        if (this.zzamt.zzati == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzamt.zzati.zzcdf)) {
            super.zzci();
        } else {
            zzbt();
        }
    }

    public final void zzcp() {
        if (this.zzaqo != null) {
            this.zzaqo.destroy();
            this.zzaqo = null;
        }
    }

    public final boolean zzcq() {
        if (zzcs() != null) {
            return zzcs().zzcch;
        }
        return false;
    }

    public final boolean zzcr() {
        if (zzcs() != null) {
            return zzcs().zzcci;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void zzdj() throws zzamm {
        synchronized (this.mLock) {
            zzafj.m11v("Initializing webview native ads utills");
            this.zzaqq = new zzyk(this.zzamt.zzaif, this, this.zzaqr, this.zzamt.zzatc, this.zzamt.zzatd);
        }
    }

    @Nullable
    public final zzyg zzdk() {
        zzyg zzyg;
        synchronized (this.mLock) {
            zzyg = this.zzaqq;
        }
        return zzyg;
    }

    /* access modifiers changed from: protected */
    public final Future<zzoc> zzdl() {
        return this.zzaqn;
    }

    public final void zzdm() {
        if (this.zzamt.zzati == null || this.zzaqo == null) {
            this.zzane = true;
            zzafj.zzco("Request to enable ActiveView before adState is available.");
            return;
        }
        zzfb zzpm = zzbs.zzeg().zzpm();
        zziw zziw = this.zzamt.zzath;
        zzaeu zzaeu = this.zzamt.zzati;
        zzama zzama = this.zzaqo;
        if (zzama == null) {
            throw null;
        }
        zzpm.zza(zziw, zzaeu, (View) zzama, this.zzaqo);
        this.zzane = false;
    }

    public final void zzdn() {
        this.zzane = false;
        if (this.zzamt.zzati == null || this.zzaqo == null) {
            zzafj.zzco("Request to enable ActiveView before adState is available.");
        } else {
            zzbs.zzeg().zzpm().zzh(this.zzamt.zzati);
        }
    }

    public final SimpleArrayMap<String, zzqh> zzdo() {
        zzbq.zzga("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzamt.zzats;
    }

    public final void zzdp() {
        if (this.zzaqo != null && this.zzaqo.zzrx() != null && this.zzamt.zzatt != null && this.zzamt.zzatt.zzbtn != null) {
            this.zzaqo.zzrx().zzb(this.zzamt.zzatt.zzbtn);
        }
    }

    public final void zze(zzama zzama) {
        this.zzaqo = zzama;
    }

    /* access modifiers changed from: protected */
    public final void zzi(int i) {
        zzc(i, false);
    }

    public final void zzj(int i) {
        zzbq.zzga("setMaxNumberOfAds must be called on the main UI thread.");
        this.zzaqp = i;
    }

    @Nullable
    public final zzqe zzr(String str) {
        zzbq.zzga("getOnCustomClickListener must be called on the main UI thread.");
        if (this.zzamt.zzatr == null) {
            return null;
        }
        return this.zzamt.zzatr.get(str);
    }
}
