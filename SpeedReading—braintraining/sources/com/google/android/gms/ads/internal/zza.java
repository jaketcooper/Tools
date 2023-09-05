package com.google.android.gms.ads.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzaci;
import com.google.android.gms.internal.zzacv;
import com.google.android.gms.internal.zzadw;
import com.google.android.gms.internal.zzaeo;
import com.google.android.gms.internal.zzaeu;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzaew;
import com.google.android.gms.internal.zzafe;
import com.google.android.gms.internal.zzaff;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzais;
import com.google.android.gms.internal.zzanp;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzic;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjq;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzla;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zzma;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznj;
import com.google.android.gms.internal.zzwq;
import com.google.android.gms.internal.zzww;
import com.google.android.gms.internal.zzxg;
import com.google.android.gms.internal.zzzb;
import com.google.android.gms.internal.zzzd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;

@zzzb
public abstract class zza extends zzkc implements zzb, zzq, zzafe, zzin, zzxg, zzzd {
    protected zznd zzamo;
    protected zznb zzamp;
    private zznb zzamq;
    protected boolean zzamr = false;
    protected final zzbi zzams;
    protected final zzbt zzamt;
    @Nullable
    protected transient zzis zzamu;
    protected final zzfb zzamv;
    protected final zzv zzamw;

    zza(zzbt zzbt, @Nullable zzbi zzbi, zzv zzv) {
        this.zzamt = zzbt;
        this.zzams = new zzbi(this);
        this.zzamw = zzv;
        zzbs.zzec().zzah(this.zzamt.zzaif);
        zzbs.zzfb().initialize(this.zzamt.zzaif);
        zzbs.zzeg().zzd(this.zzamt.zzaif, this.zzamt.zzatd);
        zzbs.zzeh().initialize(this.zzamt.zzaif);
        this.zzamv = zzbs.zzeg().zzpm();
        zzbs.zzef().initialize(this.zzamt.zzaif);
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbng)).booleanValue()) {
            Timer timer = new Timer();
            timer.schedule(new zzb(this, new CountDownLatch(((Integer) zzbs.zzep().zzd(zzmq.zzbni)).intValue()), timer), 0, ((Long) zzbs.zzep().zzd(zzmq.zzbnh)).longValue());
        }
    }

    protected static boolean zza(zzis zzis) {
        Bundle bundle = zzis.zzbcf.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        return bundle == null || !bundle.containsKey("gw");
    }

    private static long zzq(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            zzafj.zzco("Invalid index for Url fetch time in CSI latency info.");
        } catch (NumberFormatException e2) {
            zzafj.zzco("Cannot find valid format of Url fetch time in CSI latency info.");
        }
        return -1;
    }

    public void destroy() {
        zzbq.zzga("destroy must be called on the main UI thread.");
        this.zzams.cancel();
        this.zzamv.zzi(this.zzamt.zzati);
        zzbt zzbt = this.zzamt;
        if (zzbt.zzate != null) {
            zzbt.zzate.zzfk();
        }
        zzbt.zzatm = null;
        zzbt.zzatn = null;
        zzbt.zzaty = null;
        zzbt.zzato = null;
        zzbt.zzf(false);
        if (zzbt.zzate != null) {
            zzbt.zzate.removeAllViews();
        }
        zzbt.zzfe();
        zzbt.zzff();
        zzbt.zzati = null;
    }

    public String getAdUnitId() {
        return this.zzamt.zzatb;
    }

    public zzku getVideoController() {
        return null;
    }

    public final boolean isLoading() {
        return this.zzamr;
    }

    public final boolean isReady() {
        zzbq.zzga("isLoaded must be called on the main UI thread.");
        return this.zzamt.zzatf == null && this.zzamt.zzatg == null && this.zzamt.zzati != null;
    }

    public void onAdClicked() {
        if (this.zzamt.zzati == null) {
            zzafj.zzco("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzafj.zzbw("Pinging click URLs.");
        if (this.zzamt.zzatk != null) {
            this.zzamt.zzatk.zzoj();
        }
        if (this.zzamt.zzati.zzcbv != null) {
            zzbs.zzec();
            zzagr.zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, zzb(this.zzamt.zzati.zzcbv));
        }
        if (this.zzamt.zzatl != null) {
            try {
                this.zzamt.zzatl.onAdClicked();
            } catch (RemoteException e) {
                zzafj.zzc("Could not notify onAdClicked event.", e);
            }
        }
    }

    public final void onAppEvent(String str, @Nullable String str2) {
        if (this.zzamt.zzatn != null) {
            try {
                this.zzamt.zzatn.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzafj.zzc("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        zzbq.zzga("pause must be called on the main UI thread.");
    }

    public void resume() {
        zzbq.zzga("resume must be called on the main UI thread.");
    }

    public void setImmersiveMode(boolean z) {
        throw new IllegalStateException("onImmersiveModeUpdated is not supported for current ad type");
    }

    public void setManualImpressionsEnabled(boolean z) {
        zzafj.zzco("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public final void setUserId(String str) {
        zzbq.zzga("setUserId must be called on the main UI thread.");
        this.zzamt.zzaua = str;
    }

    public final void stopLoading() {
        zzbq.zzga("stopLoading must be called on the main UI thread.");
        this.zzamr = false;
        this.zzamt.zzf(true);
    }

    public final void zza(zzacv zzacv) {
        zzbq.zzga("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzamt.zzatz = zzacv;
    }

    /* access modifiers changed from: protected */
    public final void zza(@Nullable zzadw zzadw) {
        if (this.zzamt.zzatz != null) {
            String str = "";
            int i = 1;
            if (zzadw != null) {
                try {
                    str = zzadw.type;
                    i = zzadw.zzcuk;
                } catch (RemoteException e) {
                    zzafj.zzc("Could not call RewardedVideoAdListener.onRewarded().", e);
                    return;
                }
            }
            this.zzamt.zzatz.zza(new zzaci(str, i));
        }
    }

    public final void zza(zzaev zzaev) {
        if (zzaev.zzcwe.zzcnk != -1 && !TextUtils.isEmpty(zzaev.zzcwe.zzcnt)) {
            long zzq = zzq(zzaev.zzcwe.zzcnt);
            if (zzq != -1) {
                zznb zzc = this.zzamo.zzc(zzq + zzaev.zzcwe.zzcnk);
                this.zzamo.zza(zzc, "stc");
            }
        }
        this.zzamo.zzan(zzaev.zzcwe.zzcnt);
        this.zzamo.zza(this.zzamp, "arf");
        this.zzamq = this.zzamo.zziz();
        this.zzamo.zzf("gqi", zzaev.zzcwe.zzcnu);
        this.zzamt.zzatf = null;
        this.zzamt.zzatj = zzaev;
        zzaev.zzcwc.zza((zzic) new zzc(this, zzaev));
        zzaev.zzcwc.zza(zzid.zza.zzb.AD_LOADED);
        zza(zzaev, this.zzamo);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzaev zzaev, zznd zznd);

    public final void zza(zziw zziw) {
        zzbq.zzga("setAdSize must be called on the main UI thread.");
        this.zzamt.zzath = zziw;
        if (!(this.zzamt.zzati == null || this.zzamt.zzati.zzchj == null || this.zzamt.zzaue != 0)) {
            this.zzamt.zzati.zzchj.zza(zzanp.zzc(zziw));
        }
        if (this.zzamt.zzate != null) {
            if (this.zzamt.zzate.getChildCount() > 1) {
                this.zzamt.zzate.removeView(this.zzamt.zzate.getNextView());
            }
            this.zzamt.zzate.setMinimumWidth(zziw.widthPixels);
            this.zzamt.zzate.setMinimumHeight(zziw.heightPixels);
            this.zzamt.zzate.requestLayout();
        }
    }

    public final void zza(zzjn zzjn) {
        zzbq.zzga("setAdListener must be called on the main UI thread.");
        this.zzamt.zzatl = zzjn;
    }

    public final void zza(zzjq zzjq) {
        zzbq.zzga("setAdListener must be called on the main UI thread.");
        this.zzamt.zzatm = zzjq;
    }

    public final void zza(zzkg zzkg) {
        zzbq.zzga("setAppEventListener must be called on the main UI thread.");
        this.zzamt.zzatn = zzkg;
    }

    public final void zza(zzkm zzkm) {
        zzbq.zzga("setCorrelationIdProvider must be called on the main UI thread");
        this.zzamt.zzato = zzkm;
    }

    public final void zza(@Nullable zzla zzla) {
        zzbq.zzga("setIconAdOptions must be called on the main UI thread.");
        this.zzamt.zzatv = zzla;
    }

    public final void zza(@Nullable zzma zzma) {
        zzbq.zzga("setVideoOptions must be called on the main UI thread.");
        this.zzamt.zzatu = zzma;
    }

    public final void zza(zznb zznb) {
        this.zzamo = new zznd(((Boolean) zzbs.zzep().zzd(zzmq.zzbhx)).booleanValue(), "load_ad", this.zzamt.zzath.zzbda);
        this.zzamq = new zznb(-1, (String) null, (zznb) null);
        if (zznb == null) {
            this.zzamp = new zznb(-1, (String) null, (zznb) null);
        } else {
            this.zzamp = new zznb(zznb.getTime(), zznb.zziw(), zznb.zzix());
        }
    }

    public void zza(zznj zznj) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void zza(zzwq zzwq) {
        zzafj.zzco("setInAppPurchaseListener is deprecated and should not be called.");
    }

    public final void zza(zzww zzww, String str) {
        zzafj.zzco("setPlayStorePurchaseParams is deprecated and should not be called.");
    }

    public final void zza(HashSet<zzaew> hashSet) {
        this.zzamt.zza(hashSet);
    }

    /* access modifiers changed from: package-private */
    public boolean zza(zzaeu zzaeu) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(@Nullable zzaeu zzaeu, zzaeu zzaeu2);

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzis zzis, zznd zznd);

    /* access modifiers changed from: protected */
    public final List<String> zzb(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String zzb : list) {
            arrayList.add(zzaeo.zzb(zzb, this.zzamt.zzaif));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public final void zzb(View view) {
        zzbu zzbu = this.zzamt.zzate;
        if (zzbu != null) {
            zzbu.addView(view, zzbs.zzee().zzqc());
        }
    }

    public void zzb(zzaeu zzaeu) {
        this.zzamo.zza(this.zzamq, "awr");
        this.zzamt.zzatg = null;
        if (!(zzaeu.errorCode == -2 || zzaeu.errorCode == 3 || this.zzamt.zzfd() == null)) {
            zzbs.zzeg().zzb(this.zzamt.zzfd());
        }
        if (zzaeu.errorCode == -1) {
            this.zzamr = false;
            return;
        }
        if (zza(zzaeu)) {
            zzafj.zzbw("Ad refresh scheduled.");
        }
        if (zzaeu.errorCode != -2) {
            if (zzaeu.errorCode == 3) {
                zzaeu.zzcwc.zza(zzid.zza.zzb.AD_FAILED_TO_LOAD_NO_FILL);
            } else {
                zzaeu.zzcwc.zza(zzid.zza.zzb.AD_FAILED_TO_LOAD);
            }
            zzi(zzaeu.errorCode);
            return;
        }
        if (this.zzamt.zzauc == null) {
            this.zzamt.zzauc = new zzaff(this.zzamt.zzatb);
        }
        this.zzamv.zzh(this.zzamt.zzati);
        if (zza(this.zzamt.zzati, zzaeu)) {
            this.zzamt.zzati = zzaeu;
            zzbt zzbt = this.zzamt;
            if (zzbt.zzatk != null) {
                if (zzbt.zzati != null) {
                    zzbt.zzatk.zzg(zzbt.zzati.zzcvw);
                    zzbt.zzatk.zzh(zzbt.zzati.zzcvx);
                    zzbt.zzatk.zzw(zzbt.zzati.zzcng);
                }
                zzbt.zzatk.zzv(zzbt.zzath.zzbdb);
            }
            this.zzamo.zzf("is_mraid", this.zzamt.zzati.zzfr() ? "1" : "0");
            this.zzamo.zzf("is_mediation", this.zzamt.zzati.zzcng ? "1" : "0");
            if (!(this.zzamt.zzati.zzchj == null || this.zzamt.zzati.zzchj.zzsq() == null)) {
                this.zzamo.zzf("is_delay_pl", this.zzamt.zzati.zzchj.zzsq().zzth() ? "1" : "0");
            }
            this.zzamo.zza(this.zzamp, "ttc");
            if (zzbs.zzeg().zzow() != null) {
                zzbs.zzeg().zzow().zza(this.zzamo);
            }
            zzbw();
            if (this.zzamt.zzfg()) {
                zzbs();
            }
        }
        if (zzaeu.zzcby != null) {
            zzbs.zzec().zza(this.zzamt.zzaif, zzaeu.zzcby);
        }
    }

    public boolean zzb(zzis zzis) {
        zzbq.zzga("loadAd must be called on the main UI thread.");
        zzbs.zzeh().zzhb();
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbjy)).booleanValue()) {
            zzis.zzh(zzis);
        }
        if (zzi.zzcr(this.zzamt.zzaif) && zzis.zzbcd != null) {
            zzis = new zzit(zzis).zza((Location) null).zzho();
        }
        if (this.zzamt.zzatf == null && this.zzamt.zzatg == null) {
            zzafj.zzcn("Starting ad request.");
            zza((zznb) null);
            this.zzamp = this.zzamo.zziz();
            if (zzis.zzbby) {
                zzafj.zzcn("This request is sent from a test device.");
            } else {
                zzjk.zzhx();
                String zzbb = zzais.zzbb(this.zzamt.zzaif);
                zzafj.zzcn(new StringBuilder(String.valueOf(zzbb).length() + 71).append("Use AdRequest.Builder.addTestDevice(\"").append(zzbb).append("\") to get test ads on this device.").toString());
            }
            this.zzams.zzf(zzis);
            this.zzamr = zza(zzis, this.zzamo);
            return this.zzamr;
        }
        if (this.zzamu != null) {
            zzafj.zzco("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            zzafj.zzco("Loading already in progress, saving this object for future refreshes.");
        }
        this.zzamu = zzis;
        return false;
    }

    public final zzv zzbk() {
        return this.zzamw;
    }

    public final IObjectWrapper zzbl() {
        zzbq.zzga("getAdFrame must be called on the main UI thread.");
        return zzn.zzy(this.zzamt.zzate);
    }

    @Nullable
    public final zziw zzbm() {
        zzbq.zzga("getAdSize must be called on the main UI thread.");
        if (this.zzamt.zzath == null) {
            return null;
        }
        return new zzly(this.zzamt.zzath);
    }

    public final void zzbn() {
        zzbq();
    }

    public final void zzbo() {
        zzbq.zzga("recordManualImpression must be called on the main UI thread.");
        if (this.zzamt.zzati == null) {
            zzafj.zzco("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzafj.zzbw("Pinging manual tracking URLs.");
        if (!this.zzamt.zzati.zzcwa) {
            ArrayList arrayList = new ArrayList();
            if (this.zzamt.zzati.zzcni != null) {
                arrayList.addAll(this.zzamt.zzati.zzcni);
            }
            if (!(this.zzamt.zzati.zzcdd == null || this.zzamt.zzati.zzcdd.zzcbi == null)) {
                arrayList.addAll(this.zzamt.zzati.zzcdd.zzcbi);
            }
            if (!arrayList.isEmpty()) {
                zzbs.zzec();
                zzagr.zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, (List<String>) arrayList);
                this.zzamt.zzati.zzcwa = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzbp() {
        zzafj.zzcn("Ad closing.");
        if (this.zzamt.zzatm != null) {
            try {
                this.zzamt.zzatm.onAdClosed();
            } catch (RemoteException e) {
                zzafj.zzc("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.zzamt.zzatz != null) {
            try {
                this.zzamt.zzatz.onRewardedVideoAdClosed();
            } catch (RemoteException e2) {
                zzafj.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzbq() {
        zzafj.zzcn("Ad leaving application.");
        if (this.zzamt.zzatm != null) {
            try {
                this.zzamt.zzatm.onAdLeftApplication();
            } catch (RemoteException e) {
                zzafj.zzc("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.zzamt.zzatz != null) {
            try {
                this.zzamt.zzatz.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e2) {
                zzafj.zzc("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzbr() {
        zzafj.zzcn("Ad opening.");
        if (this.zzamt.zzatm != null) {
            try {
                this.zzamt.zzatm.onAdOpened();
            } catch (RemoteException e) {
                zzafj.zzc("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.zzamt.zzatz != null) {
            try {
                this.zzamt.zzatz.onRewardedVideoAdOpened();
            } catch (RemoteException e2) {
                zzafj.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzbs() {
        zzc(false);
    }

    public final void zzbt() {
        zzafj.zzcn("Ad impression.");
        if (this.zzamt.zzatm != null) {
            try {
                this.zzamt.zzatm.onAdImpression();
            } catch (RemoteException e) {
                zzafj.zzc("Could not call AdListener.onAdImpression().", e);
            }
        }
    }

    public final void zzbu() {
        zzafj.zzcn("Ad clicked.");
        if (this.zzamt.zzatm != null) {
            try {
                this.zzamt.zzatm.onAdClicked();
            } catch (RemoteException e) {
                zzafj.zzc("Could not call AdListener.onAdClicked().", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzbv() {
        if (this.zzamt.zzatz != null) {
            try {
                this.zzamt.zzatz.onRewardedVideoStarted();
            } catch (RemoteException e) {
                zzafj.zzc("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }

    public final void zzbw() {
        zzaeu zzaeu = this.zzamt.zzati;
        if (zzaeu != null && !TextUtils.isEmpty(zzaeu.zzcoc) && !zzaeu.zzcwb && zzbs.zzel().zzqk()) {
            zzafj.zzbw("Sending troubleshooting signals to the server.");
            zzbs.zzel().zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, zzaeu.zzcoc, this.zzamt.zzatb);
            zzaeu.zzcwb = true;
        }
    }

    public final zzkg zzbx() {
        return this.zzamt.zzatn;
    }

    public final zzjq zzby() {
        return this.zzamt.zzatm;
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, boolean z) {
        zzafj.zzco(new StringBuilder(30).append("Failed to load ad: ").append(i).toString());
        this.zzamr = z;
        if (this.zzamt.zzatm != null) {
            try {
                this.zzamt.zzatm.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzafj.zzc("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.zzamt.zzatz != null) {
            try {
                this.zzamt.zzatz.onRewardedVideoAdFailedToLoad(i);
            } catch (RemoteException e2) {
                zzafj.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzc(boolean z) {
        zzafj.zzcn("Ad finished loading.");
        this.zzamr = z;
        if (this.zzamt.zzatm != null) {
            try {
                this.zzamt.zzatm.onAdLoaded();
            } catch (RemoteException e) {
                zzafj.zzc("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.zzamt.zzatz != null) {
            try {
                this.zzamt.zzatz.onRewardedVideoAdLoaded();
            } catch (RemoteException e2) {
                zzafj.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzc(zzis zzis) {
        if (this.zzamt.zzate == null) {
            return false;
        }
        ViewParent parent = this.zzamt.zzate.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return zzbs.zzec().zza(view, view.getContext());
    }

    /* access modifiers changed from: protected */
    public void zzi(int i) {
        zzc(i, false);
    }
}
