package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.gmsg.zza;
import com.google.android.gms.ads.internal.gmsg.zzaa;
import com.google.android.gms.ads.internal.gmsg.zzab;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.gmsg.zzd;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.gmsg.zzx;
import com.google.android.gms.ads.internal.gmsg.zzz;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.zzr;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.mozilla.universalchardet.prober.contextanalysis.SJISContextAnalysis;
import org.mozilla.universalchardet.prober.distributionanalysis.Big5DistributionAnalysis;

@zzzb
public class zzamb extends WebViewClient {
    private static final String[] zzdhz = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzdia = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private final Object mLock;
    @Nullable
    protected zzaeh zzanv;
    private boolean zzaut;
    private zzin zzbbt;
    private zzb zzbva;
    private zzx zzbwi;
    private zzw zzbwk;
    private zzvw zzbwl;
    private zzq zzbwo;
    private zzn zzbwp;
    protected zzama zzbwq;
    private zzwh zzcff;
    private final HashMap<String, List<zzt<? super zzama>>> zzcio;
    private zzamf zzdib;
    private zzamg zzdic;
    /* access modifiers changed from: private */
    public zzamh zzdid;
    private boolean zzdie;
    private boolean zzdif;
    private ViewTreeObserver.OnGlobalLayoutListener zzdig;
    private ViewTreeObserver.OnScrollChangedListener zzdih;
    private boolean zzdii;
    private final zzwf zzdij;
    private zzamj zzdik;
    private boolean zzdil;
    private boolean zzdim;
    private boolean zzdin;
    private int zzdio;
    private View.OnAttachStateChangeListener zzdip;

    public zzamb(zzama zzama, boolean z) {
        this(zzama, z, new zzwf(zzama, zzama.zzsl(), new zzmc(zzama.getContext())), (zzvw) null);
    }

    private zzamb(zzama zzama, boolean z, zzwf zzwf, zzvw zzvw) {
        this.zzcio = new HashMap<>();
        this.mLock = new Object();
        this.zzdie = false;
        this.zzbwq = zzama;
        this.zzaut = z;
        this.zzdij = zzwf;
        this.zzbwl = null;
    }

    /* access modifiers changed from: private */
    public final void zza(View view, zzaeh zzaeh, int i) {
        if (zzaeh.zzof() && i > 0) {
            zzaeh.zzl(view);
            if (zzaeh.zzof()) {
                zzagr.zzczc.postDelayed(new zzamc(this, view, zzaeh, i), 100);
            }
        }
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean zzml = this.zzbwl != null ? this.zzbwl.zzml() : false;
        zzbs.zzea();
        Context context = this.zzbwq.getContext();
        if (!zzml) {
            z = true;
        }
        zzl.zza(context, adOverlayInfoParcel, z);
        if (this.zzanv != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzchg != null) {
                str = adOverlayInfoParcel.zzchg.url;
            }
            this.zzanv.zzbu(str);
        }
    }

    private final void zzc(Context context, String str, String str2, String str3) {
        String str4;
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzble)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompat.CATEGORY_ERROR, str);
            bundle.putString("code", str2);
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    str4 = parse.getHost();
                    bundle.putString("host", str4);
                    zzbs.zzec().zza(context, this.zzbwq.zzsb().zzcp, "gmob-apps", bundle, true);
                }
            }
            str4 = "";
            bundle.putString("host", str4);
            zzbs.zzec().zza(context, this.zzbwq.zzsb().zzcp, "gmob-apps", bundle, true);
        }
    }

    private final void zzh(Uri uri) {
        String path = uri.getPath();
        List<zzt> list = this.zzcio.get(path);
        if (list != null) {
            zzbs.zzec();
            Map<String, String> zzf = zzagr.zzf(uri);
            if (zzafj.zzae(2)) {
                String valueOf = String.valueOf(path);
                zzafj.m11v(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
                for (String next : zzf.keySet()) {
                    String str = zzf.get(next);
                    zzafj.m11v(new StringBuilder(String.valueOf(next).length() + 4 + String.valueOf(str).length()).append("  ").append(next).append(": ").append(str).toString());
                }
            }
            for (zzt zza : list) {
                zza.zza(this.zzbwq, zzf);
            }
            return;
        }
        String valueOf2 = String.valueOf(uri);
        zzafj.m11v(new StringBuilder(String.valueOf(valueOf2).length() + 32).append("No GMSG handler found for GMSG: ").append(valueOf2).toString());
    }

    private final void zztj() {
        if (this.zzdip != null) {
            zzama zzama = this.zzbwq;
            if (zzama == null) {
                throw null;
            }
            ((View) zzama).removeOnAttachStateChangeListener(this.zzdip);
        }
    }

    private final void zzto() {
        if (this.zzdib != null && ((this.zzdim && this.zzdio <= 0) || this.zzdin)) {
            this.zzdib.zza(this.zzbwq, !this.zzdin);
            this.zzdib = null;
        }
        this.zzbwq.zzsz();
    }

    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzafj.m11v(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        r2.zzdic.zzg(r2.zzbwq);
        r2.zzdic = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        zzto();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        r2.zzdim = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r2.zzdic == null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.Object r1 = r2.mLock
            monitor-enter(r1)
            boolean r0 = r2.zzdil     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = "Blank page loaded, 1..."
            com.google.android.gms.internal.zzafj.m11v(r0)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.internal.zzama r0 = r2.zzbwq     // Catch:{ all -> 0x0029 }
            r0.zzsu()     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
        L_0x0012:
            return
        L_0x0013:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            r0 = 1
            r2.zzdim = r0
            com.google.android.gms.internal.zzamg r0 = r2.zzdic
            if (r0 == 0) goto L_0x0025
            com.google.android.gms.internal.zzamg r0 = r2.zzdic
            com.google.android.gms.internal.zzama r1 = r2.zzbwq
            r0.zzg(r1)
            r0 = 0
            r2.zzdic = r0
        L_0x0025:
            r2.zzto()
            goto L_0x0012
        L_0x0029:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzamb.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        zzc(this.zzbwq.getContext(), "http_err", (i >= 0 || (-i) + -1 >= zzdhz.length) ? String.valueOf(i) : zzdhz[(-i) - 1], str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            zzc(this.zzbwq.getContext(), "ssl_err", (primaryError < 0 || primaryError >= zzdia.length) ? String.valueOf(primaryError) : zzdia[primaryError], zzbs.zzee().zza(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public final void reset() {
        if (this.zzanv != null) {
            this.zzanv.zzoh();
            this.zzanv = null;
        }
        zztj();
        synchronized (this.mLock) {
            this.zzcio.clear();
            this.zzbbt = null;
            this.zzbwp = null;
            this.zzdib = null;
            this.zzdic = null;
            this.zzbva = null;
            this.zzdie = false;
            this.zzaut = false;
            this.zzdif = false;
            this.zzdii = false;
            this.zzbwo = null;
            this.zzdid = null;
            if (this.zzbwl != null) {
                this.zzbwl.zzl(true);
                this.zzbwl = null;
            }
        }
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            String zzb = zzaeo.zzb(str, this.zzbwq.getContext());
            if (!zzb.equals(str)) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(zzb).openConnection();
                zzbs.zzec().zza(this.zzbwq.getContext(), this.zzbwq.zzsb().zzcp, true, httpURLConnection);
                return new WebResourceResponse(httpURLConnection.getContentType(), httpURLConnection.getHeaderField("encoding"), httpURLConnection.getInputStream());
            }
            zzhu zzaa = zzhu.zzaa(str);
            if (zzaa == null) {
                return null;
            }
            zzhr zza = zzbs.zzeh().zza(zzaa);
            if (zza == null || !zza.zzhc()) {
                return null;
            }
            return new WebResourceResponse("", "", zza.zzhd());
        } catch (Exception | NoClassDefFoundError e) {
            zzbs.zzeg().zza(e, "AdWebViewClient.shouldInterceptRequest");
            return null;
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case Big5DistributionAnalysis.LOWBYTE_END_1 /*126*/:
            case 127:
            case 128:
            case 129:
            case SJISContextAnalysis.HIRAGANA_HIGHBYTE /*130*/:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri uri;
        Uri uri2;
        String valueOf = String.valueOf(str);
        zzafj.m11v(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if (!"gmsg".equalsIgnoreCase(parse.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            if (this.zzdie && webView == this.zzbwq.getWebView()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    if (this.zzbbt != null) {
                        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbiv)).booleanValue()) {
                            this.zzbbt.onAdClicked();
                            if (this.zzanv != null) {
                                this.zzanv.zzbu(str);
                            }
                            this.zzbbt = null;
                        }
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzbwq.getWebView().willNotDraw()) {
                try {
                    zzcs zzss = this.zzbwq.zzss();
                    if (zzss == null || !zzss.zzb(parse)) {
                        uri2 = parse;
                    } else {
                        Context context = this.zzbwq.getContext();
                        zzama zzama = this.zzbwq;
                        if (zzama == null) {
                            throw null;
                        }
                        uri2 = zzss.zza(parse, context, (View) zzama);
                    }
                    uri = uri2;
                } catch (zzct e) {
                    String valueOf2 = String.valueOf(str);
                    zzafj.zzco(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                    uri = parse;
                }
                if (this.zzbwk == null || this.zzbwk.zzcu()) {
                    zza(new zzc("android.intent.action.VIEW", uri.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
                } else {
                    this.zzbwk.zzs(str);
                }
            } else {
                String valueOf3 = String.valueOf(str);
                zzafj.zzco(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            }
        } else {
            zzh(parse);
        }
        return true;
    }

    public final void zza(int i, int i2, boolean z) {
        this.zzdij.zzc(i, i2);
        if (this.zzbwl != null) {
            this.zzbwl.zza(i, i2, z);
        }
    }

    public final void zza(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.mLock) {
            this.zzdif = true;
            this.zzbwq.zzsy();
            this.zzdig = onGlobalLayoutListener;
            this.zzdih = onScrollChangedListener;
        }
    }

    public final void zza(zzc zzc) {
        zzn zzn = null;
        boolean zzst = this.zzbwq.zzst();
        zzin zzin = (!zzst || this.zzbwq.zzso().zztx()) ? this.zzbbt : null;
        if (!zzst) {
            zzn = this.zzbwp;
        }
        zza(new AdOverlayInfoParcel(zzc, zzin, zzn, this.zzbwo, this.zzbwq.zzsb()));
    }

    public final void zza(zzamf zzamf) {
        this.zzdib = zzamf;
    }

    public final void zza(zzamg zzamg) {
        this.zzdic = zzamg;
    }

    public final void zza(zzamh zzamh) {
        this.zzdid = zzamh;
    }

    public final void zza(zzamj zzamj) {
        this.zzdik = zzamj;
    }

    public final void zza(zzin zzin, zzn zzn, zzb zzb, zzq zzq, boolean z, @Nullable zzx zzx, zzw zzw, zzwh zzwh, @Nullable zzaeh zzaeh) {
        zzw zzw2 = zzw == null ? new zzw(this.zzbwq.getContext(), zzaeh, (zzaaf) null) : zzw;
        this.zzbwl = new zzvw(this.zzbwq, zzwh);
        this.zzanv = zzaeh;
        zza("/appEvent", (zzt<? super zzama>) new zza(zzb));
        zza("/backButton", (zzt<? super zzama>) zzd.zzbvl);
        zza("/refresh", (zzt<? super zzama>) zzd.zzbvm);
        zza("/canOpenURLs", (zzt<? super zzama>) zzd.zzbvc);
        zza("/canOpenIntents", (zzt<? super zzama>) zzd.zzbvd);
        zza("/click", (zzt<? super zzama>) zzd.zzbve);
        zza("/close", (zzt<? super zzama>) zzd.zzbvf);
        zza("/customClose", (zzt<? super zzama>) zzd.zzbvg);
        zza("/instrument", (zzt<? super zzama>) zzd.zzbvp);
        zza("/delayPageLoaded", (zzt<? super zzama>) zzd.zzbvr);
        zza("/delayPageClosed", (zzt<? super zzama>) zzd.zzbvs);
        zza("/getLocationInfo", (zzt<? super zzama>) zzd.zzbvt);
        zza("/httpTrack", (zzt<? super zzama>) zzd.zzbvh);
        zza("/log", (zzt<? super zzama>) zzd.zzbvi);
        zza("/mraid", (zzt<? super zzama>) new zzaa(zzw2, this.zzbwl));
        zza("/mraidLoaded", (zzt<? super zzama>) this.zzdij);
        zza("/open", (zzt<? super zzama>) new zzab(this.zzbwq.getContext(), this.zzbwq.zzsb(), this.zzbwq.zzss(), zzq, zzin, zzb, zzn, zzw2, this.zzbwl));
        zza("/precache", (zzt<? super zzama>) new zzalx());
        zza("/touch", (zzt<? super zzama>) zzd.zzbvk);
        zza("/video", (zzt<? super zzama>) zzd.zzbvn);
        zza("/videoMeta", (zzt<? super zzama>) zzd.zzbvo);
        if (zzbs.zzfa().zzr(this.zzbwq.getContext())) {
            zza("/logScionEvent", (zzt<? super zzama>) new zzz(this.zzbwq.getContext()));
        }
        if (zzx != null) {
            zza("/setInterstitialProperties", (zzt<? super zzama>) new com.google.android.gms.ads.internal.gmsg.zzw(zzx));
        }
        this.zzbbt = zzin;
        this.zzbwp = zzn;
        this.zzbva = zzb;
        this.zzbwo = zzq;
        this.zzbwk = zzw2;
        this.zzcff = zzwh;
        this.zzbwi = zzx;
        this.zzdie = z;
    }

    public final void zza(String str, zzt<? super zzama> zzt) {
        synchronized (this.mLock) {
            List list = this.zzcio.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zzcio.put(str, list);
            }
            list.add(zzt);
        }
    }

    public final void zza(String str, zzr<zzt<? super zzama>> zzr) {
        synchronized (this.mLock) {
            List<zzt> list = this.zzcio.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzt zzt : list) {
                    if (zzr.apply(zzt)) {
                        arrayList.add(zzt);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final void zza(boolean z, int i) {
        zza(new AdOverlayInfoParcel((!this.zzbwq.zzst() || this.zzbwq.zzso().zztx()) ? this.zzbbt : null, this.zzbwp, this.zzbwo, this.zzbwq, z, i, this.zzbwq.zzsb()));
    }

    public final void zza(boolean z, int i, String str) {
        zzami zzami = null;
        boolean zzst = this.zzbwq.zzst();
        zzin zzin = (!zzst || this.zzbwq.zzso().zztx()) ? this.zzbbt : null;
        if (!zzst) {
            zzami = new zzami(this.zzbwq, this.zzbwp);
        }
        zza(new AdOverlayInfoParcel(zzin, zzami, this.zzbva, this.zzbwo, this.zzbwq, z, i, str, this.zzbwq.zzsb()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzami zzami = null;
        boolean zzst = this.zzbwq.zzst();
        zzin zzin = (!zzst || this.zzbwq.zzso().zztx()) ? this.zzbbt : null;
        if (!zzst) {
            zzami = new zzami(this.zzbwq, this.zzbwp);
        }
        zza(new AdOverlayInfoParcel(zzin, zzami, this.zzbva, this.zzbwo, this.zzbwq, z, i, str, str2, this.zzbwq.zzsb()));
    }

    public final void zzab(boolean z) {
        this.zzdie = z;
    }

    public final void zzb(int i, int i2) {
        if (this.zzbwl != null) {
            this.zzbwl.zzb(i, i2);
        }
    }

    public final void zzb(String str, zzt<? super zzama> zzt) {
        synchronized (this.mLock) {
            List list = this.zzcio.get(str);
            if (list != null) {
                list.remove(zzt);
            }
        }
    }

    public final boolean zzfr() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzaut;
        }
        return z;
    }

    public final void zzmp() {
        synchronized (this.mLock) {
            this.zzdie = false;
            this.zzaut = true;
            zzbs.zzec();
            zzagr.runOnUiThread(new zzame(this));
        }
    }

    public final zzw zztd() {
        return this.zzbwk;
    }

    public final boolean zzte() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdif;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zztf() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.mLock) {
            onGlobalLayoutListener = this.zzdig;
        }
        return onGlobalLayoutListener;
    }

    public final ViewTreeObserver.OnScrollChangedListener zztg() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
        synchronized (this.mLock) {
            onScrollChangedListener = this.zzdih;
        }
        return onScrollChangedListener;
    }

    public final boolean zzth() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdii;
        }
        return z;
    }

    public final void zzti() {
        synchronized (this.mLock) {
            zzafj.m11v("Loading blank page in WebView, 2...");
            this.zzdil = true;
            this.zzbwq.zzct("about:blank");
        }
    }

    public final void zztk() {
        zzaeh zzaeh = this.zzanv;
        if (zzaeh != null) {
            WebView webView = this.zzbwq.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza((View) webView, zzaeh, 10);
                return;
            }
            zztj();
            this.zzdip = new zzamd(this, zzaeh);
            zzama zzama = this.zzbwq;
            if (zzama == null) {
                throw null;
            }
            ((View) zzama).addOnAttachStateChangeListener(this.zzdip);
        }
    }

    public final void zztl() {
        synchronized (this.mLock) {
            this.zzdii = true;
        }
        this.zzdio++;
        zzto();
    }

    public final void zztm() {
        this.zzdio--;
        zzto();
    }

    public final void zztn() {
        this.zzdin = true;
        zzto();
    }

    public final zzamj zztp() {
        return this.zzdik;
    }
}
