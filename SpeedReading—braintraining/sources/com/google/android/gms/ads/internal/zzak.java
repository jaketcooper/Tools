package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.gmsg.zzaf;
import com.google.android.gms.ads.internal.gmsg.zzag;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.gmsg.zzx;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzaad;
import com.google.android.gms.internal.zzabm;
import com.google.android.gms.internal.zzadw;
import com.google.android.gms.internal.zzaee;
import com.google.android.gms.internal.zzaeh;
import com.google.android.gms.internal.zzaek;
import com.google.android.gms.internal.zzaeu;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzagw;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzamb;
import com.google.android.gms.internal.zzamh;
import com.google.android.gms.internal.zzamm;
import com.google.android.gms.internal.zzanp;
import com.google.android.gms.internal.zzfy;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zztm;
import com.google.android.gms.internal.zztn;
import com.google.android.gms.internal.zzuc;
import com.google.android.gms.internal.zzwh;
import com.google.android.gms.internal.zzzb;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzak extends zzi implements zzag, zzx {
    private transient boolean zzapf = false;
    private int zzapg = -1;
    /* access modifiers changed from: private */
    public boolean zzaph;
    /* access modifiers changed from: private */
    public float zzapi;
    /* access modifiers changed from: private */
    public boolean zzapj;
    private zzaek zzapk;
    private String zzapl;
    private final String zzapm;

    public zzak(Context context, zziw zziw, String str, zzuc zzuc, zzaiy zzaiy, zzv zzv) {
        super(context, zziw, str, zzuc, zzaiy, zzv);
        this.zzapm = (zziw == null || !"reward_mb".equals(zziw.zzbda)) ? "/Interstitial" : "/Rewarded";
    }

    private final void zza(Bundle bundle) {
        zzbs.zzec().zzb(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, "gmob-apps", bundle, false);
    }

    private static zzaev zzb(zzaev zzaev) {
        try {
            String jSONObject = zzabm.zzb(zzaev.zzcwe).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zzaev.zzcpe.zzatb);
            zztm zztm = new zztm(jSONObject, (String) null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), (String) null, (String) null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), (String) null, Collections.emptyList(), Collections.emptyList(), (String) null, (String) null, (String) null, (List<String>) null, (String) null, Collections.emptyList(), (String) null);
            zzaad zzaad = zzaev.zzcwe;
            zztn zztn = new zztn(Collections.singletonList(zztm), ((Long) zzbs.zzep().zzd(zzmq.zzblt)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), zzaad.zzcby, zzaad.zzcbz, "", -1, 0, 1, (String) null, 0, -1, -1, false);
            return new zzaev(zzaev.zzcpe, new zzaad(zzaev.zzcpe, zzaad.zzchl, zzaad.body, Collections.emptyList(), Collections.emptyList(), zzaad.zzcnf, true, zzaad.zzcnh, Collections.emptyList(), zzaad.zzccb, zzaad.orientation, zzaad.zzcnj, zzaad.zzcnk, zzaad.zzcnl, zzaad.zzcnm, zzaad.zzcnn, (String) null, zzaad.zzcnp, zzaad.zzbdd, zzaad.zzclw, zzaad.zzcnq, zzaad.zzcnr, zzaad.zzcnu, zzaad.zzbde, zzaad.zzbdf, (zzadw) null, Collections.emptyList(), Collections.emptyList(), zzaad.zzcny, zzaad.zzcnz, zzaad.zzcmk, zzaad.zzcml, zzaad.zzcby, zzaad.zzcbz, zzaad.zzcoa, (zzaee) null, zzaad.zzcoc, zzaad.zzcod, zzaad.zzcmw, zzaad.zzapy, 0), zztn, zzaev.zzath, zzaev.errorCode, zzaev.zzcvw, zzaev.zzcvx, (JSONObject) null, zzaev.zzcwc, (Boolean) null);
        } catch (JSONException e) {
            zzafj.zzb("Unable to generate ad state for an interstitial ad with pooling.", e);
            return zzaev;
        }
    }

    public final void setImmersiveMode(boolean z) {
        zzbq.zzga("setImmersiveMode must be called on the main UI thread.");
        this.zzapj = z;
    }

    public final void showInterstitial() {
        Bitmap bitmap = null;
        zzbq.zzga("showInterstitial must be called on the main UI thread.");
        if (zzbs.zzfa().zzu(this.zzamt.zzaif)) {
            this.zzapl = zzbs.zzfa().zzw(this.zzamt.zzaif);
            String valueOf = String.valueOf(this.zzapl);
            String valueOf2 = String.valueOf(this.zzapm);
            this.zzapl = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        if (this.zzamt.zzati == null) {
            zzafj.zzco("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbld)).booleanValue()) {
            String packageName = this.zzamt.zzaif.getApplicationContext() != null ? this.zzamt.zzaif.getApplicationContext().getPackageName() : this.zzamt.zzaif.getPackageName();
            if (!this.zzapf) {
                zzafj.zzco("It is not recommended to show an interstitial before onAdLoaded completes.");
                Bundle bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_before_load_finish");
                zza(bundle);
            }
            zzbs.zzec();
            if (!zzagr.zzam(this.zzamt.zzaif)) {
                zzafj.zzco("It is not recommended to show an interstitial when app is not in foreground.");
                Bundle bundle2 = new Bundle();
                bundle2.putString("appid", packageName);
                bundle2.putString("action", "show_interstitial_app_not_in_foreground");
                zza(bundle2);
            }
        }
        if (this.zzamt.zzfh()) {
            return;
        }
        if (this.zzamt.zzati.zzcng && this.zzamt.zzati.zzcde != null) {
            try {
                if (((Boolean) zzbs.zzep().zzd(zzmq.zzbka)).booleanValue()) {
                    this.zzamt.zzati.zzcde.setImmersiveMode(this.zzapj);
                }
                this.zzamt.zzati.zzcde.showInterstitial();
            } catch (RemoteException e) {
                zzafj.zzc("Could not show interstitial.", e);
                zzde();
            }
        } else if (this.zzamt.zzati.zzchj == null) {
            zzafj.zzco("The interstitial failed to load.");
        } else if (this.zzamt.zzati.zzchj.zzst()) {
            zzafj.zzco("The interstitial is already showing.");
        } else {
            this.zzamt.zzati.zzchj.zzac(true);
            if (this.zzamt.zzati.zzcvq != null) {
                this.zzamv.zza(this.zzamt.zzath, this.zzamt.zzati);
            }
            zzaeu zzaeu = this.zzamt.zzati;
            if (zzaeu.zzfr()) {
                Context context = this.zzamt.zzaif;
                zzama zzama = zzaeu.zzchj;
                if (zzama == null) {
                    throw null;
                }
                new zzfy(context, (View) zzama).zza((zzgc) zzaeu.zzchj);
            } else {
                zzaeu.zzchj.zzsq().zza((zzamh) new zzal(this, zzaeu));
            }
            if (this.zzamt.zzapr) {
                zzbs.zzec();
                bitmap = zzagr.zzan(this.zzamt.zzaif);
            }
            this.zzapg = zzbs.zzex().zzb(bitmap);
            if (!((Boolean) zzbs.zzep().zzd(zzmq.zzbmk)).booleanValue() || bitmap == null) {
                zzao zzao = new zzao(this.zzamt.zzapr, zzdd(), false, 0.0f, -1, this.zzapj, this.zzamt.zzati.zzapy);
                int requestedOrientation = this.zzamt.zzati.zzchj.getRequestedOrientation();
                if (requestedOrientation == -1) {
                    requestedOrientation = this.zzamt.zzati.orientation;
                }
                AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(this, this, this, this.zzamt.zzati.zzchj, requestedOrientation, this.zzamt.zzatd, this.zzamt.zzati.zzcnl, zzao);
                zzbs.zzea();
                zzl.zza(this.zzamt.zzaif, adOverlayInfoParcel, true);
                return;
            }
            new zzam(this, this.zzapg).zzps();
        }
    }

    /* access modifiers changed from: protected */
    public final zzama zza(zzaev zzaev, @Nullable zzw zzw, @Nullable zzaeh zzaeh) throws zzamm {
        zzama zza = zzbs.zzed().zza(this.zzamt.zzaif, zzanp.zzc(this.zzamt.zzath), this.zzamt.zzath.zzbda, false, false, this.zzamt.zzatc, this.zzamt.zzatd, this.zzamo, this, this.zzamw, zzaev.zzcwc);
        zza.zzsq().zza(this, (zzn) null, this, this, ((Boolean) zzbs.zzep().zzd(zzmq.zzbiu)).booleanValue(), this, zzw, (zzwh) null, zzaeh);
        zza(zza);
        zza.zzcu(zzaev.zzcpe.zzcmb);
        zza.zzsq().zza("/reward", (zzt<? super zzama>) new zzaf(this));
        return zza;
    }

    public final void zza(zzaev zzaev, zznd zznd) {
        if (!((Boolean) zzbs.zzep().zzd(zzmq.zzbkg)).booleanValue()) {
            super.zza(zzaev, zznd);
        } else if (zzaev.errorCode != -2) {
            super.zza(zzaev, zznd);
        } else {
            boolean z = !zzaev.zzcwe.zzcng;
            if (zza(zzaev.zzcpe.zzclo) && z) {
                this.zzamt.zzatj = zzb(zzaev);
            }
            super.zza(this.zzamt.zzatj, zznd);
        }
    }

    public final void zza(boolean z, float f) {
        this.zzaph = z;
        this.zzapi = f;
    }

    public final boolean zza(@Nullable zzaeu zzaeu, zzaeu zzaeu2) {
        if (!super.zza(zzaeu, zzaeu2)) {
            return false;
        }
        if (!(this.zzamt.zzfg() || this.zzamt.zzaud == null || zzaeu2.zzcvq == null)) {
            this.zzamv.zza(this.zzamt.zzath, zzaeu2, this.zzamt.zzaud);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzis zzis, zzaeu zzaeu, boolean z) {
        if (this.zzamt.zzfg() && zzaeu.zzchj != null) {
            zzbs.zzee();
            zzagw.zzh(zzaeu.zzchj);
        }
        return this.zzams.zzdr();
    }

    public final boolean zza(zzis zzis, zznd zznd) {
        if (this.zzamt.zzati != null) {
            zzafj.zzco("An interstitial is already loading. Aborting.");
            return false;
        }
        if (this.zzapk == null && zza(zzis) && zzbs.zzfa().zzu(this.zzamt.zzaif) && !TextUtils.isEmpty(this.zzamt.zzatb)) {
            this.zzapk = new zzaek(this.zzamt.zzaif, this.zzamt.zzatb);
        }
        return super.zza(zzis, zznd);
    }

    public final void zzb(zzadw zzadw) {
        if (this.zzamt.zzati != null) {
            if (this.zzamt.zzati.zzcnx != null) {
                zzbs.zzec();
                zzagr.zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, this.zzamt.zzati.zzcnx);
            }
            if (this.zzamt.zzati.zzcnv != null) {
                zzadw = this.zzamt.zzati.zzcnv;
            }
        }
        zza(zzadw);
    }

    /* access modifiers changed from: protected */
    public final void zzbp() {
        zzde();
        super.zzbp();
    }

    /* access modifiers changed from: protected */
    public final void zzbs() {
        super.zzbs();
        this.zzapf = true;
    }

    public final void zzca() {
        super.zzca();
        this.zzamv.zzh(this.zzamt.zzati);
        if (this.zzapk != null) {
            this.zzapk.zzu(false);
        }
    }

    public final void zzcb() {
        zzamb zzsq;
        recordImpression();
        super.zzcb();
        if (!(this.zzamt.zzati == null || this.zzamt.zzati.zzchj == null || (zzsq = this.zzamt.zzati.zzchj.zzsq()) == null)) {
            zzsq.zztk();
        }
        if (!(!zzbs.zzfa().zzu(this.zzamt.zzaif) || this.zzamt.zzati == null || this.zzamt.zzati.zzchj == null)) {
            zzbs.zzfa().zzd(this.zzamt.zzati.zzchj.getContext(), this.zzapl);
        }
        if (this.zzapk != null) {
            this.zzapk.zzu(true);
        }
    }

    public final void zzd(boolean z) {
        this.zzamt.zzapr = z;
    }

    /* access modifiers changed from: protected */
    public final boolean zzdd() {
        if (!(this.zzamt.zzaif instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.zzamt.zzaif).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, (Point) null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        return (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
    }

    public final void zzde() {
        zzbs.zzex().zzb(Integer.valueOf(this.zzapg));
        if (this.zzamt.zzfg()) {
            this.zzamt.zzfe();
            this.zzamt.zzati = null;
            this.zzamt.zzapr = false;
            this.zzapf = false;
        }
    }

    public final void zzdf() {
        if (!(this.zzamt.zzati == null || this.zzamt.zzati.zzcvv == null)) {
            zzbs.zzec();
            zzagr.zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, this.zzamt.zzati.zzcvv);
        }
        zzbv();
    }
}
