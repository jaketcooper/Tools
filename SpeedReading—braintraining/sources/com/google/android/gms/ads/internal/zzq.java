package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzaeu;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznj;
import com.google.android.gms.internal.zznp;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzny;
import com.google.android.gms.internal.zznz;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzob;
import com.google.android.gms.internal.zzoc;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zztm;
import com.google.android.gms.internal.zztn;
import com.google.android.gms.internal.zztp;
import com.google.android.gms.internal.zzuc;
import com.google.android.gms.internal.zzuf;
import com.google.android.gms.internal.zzuo;
import com.google.android.gms.internal.zzur;
import com.google.android.gms.internal.zzxf;
import com.google.android.gms.internal.zzzb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@zzzb
public final class zzq extends zzd implements zzob {
    private boolean zzals;
    /* access modifiers changed from: private */
    public zzaeu zzank;
    private boolean zzanl = false;

    public zzq(Context context, zzv zzv, zziw zziw, String str, zzuc zzuc, zzaiy zzaiy) {
        super(context, zziw, str, zzuc, zzaiy, zzv);
    }

    private static zzaeu zza(zzaev zzaev, int i) {
        return new zzaeu(zzaev.zzcpe.zzclo, (zzama) null, zzaev.zzcwe.zzcbv, i, zzaev.zzcwe.zzcbw, zzaev.zzcwe.zzcni, zzaev.zzcwe.orientation, zzaev.zzcwe.zzccb, zzaev.zzcpe.zzclr, zzaev.zzcwe.zzcng, (zztm) null, (zzuf) null, (String) null, zzaev.zzcvs, (zztp) null, zzaev.zzcwe.zzcnh, zzaev.zzath, zzaev.zzcwe.zzcnf, zzaev.zzcvw, zzaev.zzcvx, zzaev.zzcwe.zzcnl, zzaev.zzcvq, (zzoc) null, zzaev.zzcwe.zzcnv, zzaev.zzcwe.zzcnw, zzaev.zzcwe.zzcnw, zzaev.zzcwe.zzcny, zzaev.zzcwe.zzcnz, (String) null, zzaev.zzcwe.zzcby, zzaev.zzcwe.zzcoc, zzaev.zzcwc, zzaev.zzcwe.zzapy, zzaev.zzcwd);
    }

    private final boolean zzb(zzaeu zzaeu, zzaeu zzaeu2) {
        zzc((List<String>) null);
        if (!this.zzamt.zzfg()) {
            zzafj.zzco("Native ad does not have custom rendering mode.");
            zzi(0);
            return false;
        }
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
                        zzagr.zzczc.post(new zzt(this, zznu));
                    }
                }
                if (zzmd != null) {
                    if (!(this.zzamt.zzats == null || this.zzamt.zzats.get(zzmd.getCustomTemplateId()) == null)) {
                        zzagr.zzczc.post(new zzu(this, zzmd));
                    }
                }
                zzafj.zzco("No matching mapper/listener for retrieved native ad template.");
                zzi(0);
                return false;
            }
            zzns zzns = new zzns(zzly.getHeadline(), zzly.getImages(), zzly.getBody(), zzly.zzjm() != null ? zzly.zzjm() : null, zzly.getCallToAction(), zzly.getStarRating(), zzly.getStore(), zzly.getPrice(), (zznp) null, zzly.getExtras(), zzly.getVideoController(), zzly.zzmf() != null ? (View) zzn.zzx(zzly.zzmf()) : null, zzly.zzjr(), zzc);
            zzns.zzb((zzoa) new zznz(this.zzamt.zzaif, (zzob) this, this.zzamt.zzatc, zzly, (zzoc) zzns));
            zzagr.zzczc.post(new zzs(this, zzns));
            return super.zza(zzaeu, zzaeu2);
        } catch (RemoteException e) {
            zzafj.zzc("Failed to get native ad mapper", e);
            zzi(0);
            return false;
        }
    }

    private final boolean zzc(zzaeu zzaeu, zzaeu zzaeu2) {
        View zze = zzaq.zze(zzaeu2);
        if (zze == null) {
            return false;
        }
        View nextView = this.zzamt.zzate.getNextView();
        if (nextView != null) {
            if (nextView instanceof zzama) {
                ((zzama) nextView).destroy();
            }
            this.zzamt.zzate.removeView(nextView);
        }
        if (!zzaq.zzf(zzaeu2)) {
            try {
                zzb(zze);
            } catch (Throwable th) {
                zzbs.zzeg().zza(th, "AdLoaderManager.swapBannerViews");
                zzafj.zzc("Could not add mediation view to view hierarchy.", th);
                return false;
            }
        }
        if (this.zzamt.zzate.getChildCount() > 1) {
            this.zzamt.zzate.showNext();
        }
        if (zzaeu != null) {
            View nextView2 = this.zzamt.zzate.getNextView();
            if (nextView2 != null) {
                this.zzamt.zzate.removeView(nextView2);
            }
            this.zzamt.zzff();
        }
        this.zzamt.zzate.setMinimumWidth(zzbm().widthPixels);
        this.zzamt.zzate.setMinimumHeight(zzbm().heightPixels);
        this.zzamt.zzate.requestLayout();
        this.zzamt.zzate.setVisibility(0);
        return true;
    }

    @Nullable
    private final zztn zzcs() {
        if (this.zzamt.zzati == null || !this.zzamt.zzati.zzcng) {
            return null;
        }
        return this.zzamt.zzati.zzcvs;
    }

    @Nullable
    public final zzku getVideoController() {
        return null;
    }

    public final void pause() {
        if (!this.zzanl) {
            throw new IllegalStateException("Native Ad does not support pause().");
        }
        super.pause();
    }

    public final void resume() {
        if (!this.zzanl) {
            throw new IllegalStateException("Native Ad does not support resume().");
        }
        super.resume();
    }

    public final void setManualImpressionsEnabled(boolean z) {
        zzbq.zzga("setManualImpressionsEnabled must be called from the main thread.");
        this.zzals = z;
    }

    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is not supported by AdLoaderManager.");
    }

    public final void zza(zzaev zzaev, zznd zznd) {
        this.zzank = null;
        if (zzaev.errorCode != -2) {
            this.zzank = zza(zzaev, zzaev.errorCode);
        } else if (!zzaev.zzcwe.zzcng) {
            zzafj.zzco("partialAdState is not mediation");
            this.zzank = zza(zzaev, 0);
        }
        if (this.zzank != null) {
            zzagr.zzczc.post(new zzr(this));
            return;
        }
        if (zzaev.zzath != null) {
            this.zzamt.zzath = zzaev.zzath;
        }
        this.zzamt.zzaue = 0;
        zzbt zzbt = this.zzamt;
        zzbs.zzeb();
        zzbt.zzatg = zzxf.zza(this.zzamt.zzaif, this, zzaev, this.zzamt.zzatc, (zzama) null, this.zzanb, this, zznd);
    }

    public final void zza(zznj zznj) {
        throw new IllegalStateException("CustomRendering is not supported by AdLoaderManager.");
    }

    public final void zza(zzny zzny) {
        zzafj.zzco("Unexpected call to AdLoaderManager method");
    }

    public final void zza(zzoa zzoa) {
        zzafj.zzco("Unexpected call to AdLoaderManager method");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(@Nullable zzaeu zzaeu, zzaeu zzaeu2) {
        boolean z;
        if (!this.zzamt.zzfg()) {
            throw new IllegalStateException("AdLoader API does not support custom rendering.");
        } else if (!zzaeu2.zzcng) {
            zzi(0);
            zzafj.zzco("newState is not mediation.");
            return false;
        } else {
            if (zzaeu2.zzcdd != null && zzaeu2.zzcdd.zzlp()) {
                if (this.zzamt.zzfg() && this.zzamt.zzate != null) {
                    this.zzamt.zzate.zzfj().zzcj(zzaeu2.zzcnl);
                }
                if (!super.zza(zzaeu, zzaeu2)) {
                    z = false;
                } else if (!this.zzamt.zzfg() || zzc(zzaeu, zzaeu2)) {
                    if (!this.zzamt.zzfh()) {
                        super.zza(zzaeu2, false);
                    }
                    z = true;
                } else {
                    zzi(0);
                    z = false;
                }
                if (!z) {
                    return false;
                }
                this.zzanl = true;
            } else if (zzaeu2.zzcdd == null || !zzaeu2.zzcdd.zzlq()) {
                zzi(0);
                zzafj.zzco("Response is neither banner nor native.");
                return false;
            } else if (!zzb(zzaeu, zzaeu2)) {
                return false;
            }
            zzd(new ArrayList(Arrays.asList(new Integer[]{2})));
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzis zzis, zzaeu zzaeu, boolean z) {
        return false;
    }

    public final boolean zzb(zzis zzis) {
        if (this.zzamt.zzatx != null && this.zzamt.zzatx.size() == 1 && this.zzamt.zzatx.get(0).intValue() == 2) {
            zzafj.m12e("Requesting only banner Ad from AdLoader or calling loadAd on returned banner is not yet supported");
            zzi(0);
            return false;
        } else if (this.zzamt.zzatw == null) {
            return super.zzb(zzis);
        } else {
            if (zzis.zzbca != this.zzals) {
                zzis = new zzis(zzis.versionCode, zzis.zzbbv, zzis.extras, zzis.zzbbw, zzis.zzbbx, zzis.zzbby, zzis.zzbbz, zzis.zzbca || this.zzals, zzis.zzbcb, zzis.zzbcc, zzis.zzbcd, zzis.zzbce, zzis.zzbcf, zzis.zzbcg, zzis.zzbch, zzis.zzbci, zzis.zzbcj, zzis.zzbck);
            }
            return super.zzb(zzis);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzbs() {
        super.zzbs();
        zzaeu zzaeu = this.zzamt.zzati;
        if (zzaeu != null && zzaeu.zzcdd != null && zzaeu.zzcdd.zzlp() && this.zzamt.zzatw != null) {
            try {
                this.zzamt.zzatw.zza(this, zzn.zzy(this.zzamt.zzaif));
            } catch (RemoteException e) {
                zzafj.zzc("Could not call PublisherAdViewLoadedListener.onPublisherAdViewLoaded().", e);
            }
        }
    }

    public final void zzc(@Nullable List<String> list) {
        zzbq.zzga("setNativeTemplates must be called on the main UI thread.");
        this.zzamt.zzaub = list;
    }

    public final void zzcd() {
        if (this.zzamt.zzati == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzamt.zzati.zzcdf) || this.zzamt.zzati.zzcdd == null || !this.zzamt.zzati.zzcdd.zzlq()) {
            super.zzcd();
        } else {
            zzbu();
        }
    }

    public final void zzci() {
        if (this.zzamt.zzati == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzamt.zzati.zzcdf) || this.zzamt.zzati.zzcdd == null || !this.zzamt.zzati.zzcdd.zzlq()) {
            super.zzci();
        } else {
            zzbt();
        }
    }

    public final void zzcp() {
        zzafj.zzco("Unexpected call to AdLoaderManager method");
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

    public final void zzd(List<Integer> list) {
        zzbq.zzga("setAllowedAdTypes must be called on the main UI thread.");
        this.zzamt.zzatx = list;
    }

    @Nullable
    public final zzqe zzr(String str) {
        zzbq.zzga("getOnCustomClickListener must be called on the main UI thread.");
        return this.zzamt.zzatr.get(str);
    }
}
