package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzbl;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzq;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
final class zzamo extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzama {
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private String zzaky;
    private final zzv zzamw;
    private final zzaiy zzaov;
    private zzair zzaun;
    private final WindowManager zzavc;
    @Nullable
    private final zzcs zzbta;
    private int zzcfw = -1;
    private int zzcfx = -1;
    private int zzcfz = -1;
    private int zzcga = -1;
    private final zzib zzckz;
    private String zzcqb = "";
    private Boolean zzcxg;
    private zznb zzdgr;
    private final zzano zzdjd;
    private final zzbl zzdje;
    private zzamb zzdjf;
    private zzd zzdjg;
    private zzanp zzdjh;
    private boolean zzdji;
    private boolean zzdjj;
    private boolean zzdjk;
    private boolean zzdjl;
    private int zzdjm;
    private boolean zzdjn = true;
    private boolean zzdjo = false;
    private zzamr zzdjp;
    private boolean zzdjq;
    private boolean zzdjr;
    private zzny zzdjs;
    private int zzdjt;
    /* access modifiers changed from: private */
    public int zzdju;
    private zznb zzdjv;
    private zznb zzdjw;
    private zznc zzdjx;
    private WeakReference<View.OnClickListener> zzdjy;
    private zzd zzdjz;
    private boolean zzdka;
    private Map<String, zzalt> zzdkb;

    private zzamo(zzano zzano, zzanp zzanp, String str, boolean z, boolean z2, @Nullable zzcs zzcs, zzaiy zzaiy, zznd zznd, zzbl zzbl, zzv zzv, zzib zzib) {
        super(zzano);
        this.zzdjd = zzano;
        this.zzdjh = zzanp;
        this.zzaky = str;
        this.zzdjk = z;
        this.zzdjm = -1;
        this.zzbta = zzcs;
        this.zzaov = zzaiy;
        this.zzdje = zzbl;
        this.zzamw = zzv;
        this.zzavc = (WindowManager) getContext().getSystemService("window");
        this.zzckz = zzib;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzafj.zzb("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(zzbs.zzec().zzp(zzano, zzaiy.zzcp));
        zzbs.zzee().zza(getContext(), settings);
        setDownloadListener(this);
        zzts();
        if (zzq.zzaly()) {
            addJavascriptInterface(new zzamu(this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzaun = new zzair(this.zzdjd.zzrz(), this, this, (ViewTreeObserver.OnScrollChangedListener) null);
        zztv();
        this.zzdjx = new zznc(new zznd(true, "make_wv", this.zzaky));
        this.zzdjx.zziy().zzc(zznd);
        this.zzdgr = zzmw.zzb(this.zzdjx.zziy());
        this.zzdjx.zza("native:view_create", this.zzdgr);
        this.zzdjw = null;
        this.zzdjv = null;
        zzbs.zzee().zzaw(zzano);
    }

    private final void zza(Boolean bool) {
        synchronized (this.mLock) {
            this.zzcxg = bool;
        }
        zzbs.zzeg().zza(bool);
    }

    private final void zzag(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", (Map<String, ?>) hashMap);
    }

    static zzamo zzb(Context context, zzanp zzanp, String str, boolean z, boolean z2, @Nullable zzcs zzcs, zzaiy zzaiy, zznd zznd, zzbl zzbl, zzv zzv, zzib zzib) {
        return new zzamo(new zzano(context), zzanp, str, z, z2, zzcs, zzaiy, zznd, zzbl, zzv, zzib);
    }

    private final void zzcv(String str) {
        synchronized (this.mLock) {
            if (!isDestroyed()) {
                loadUrl(str);
            } else {
                zzafj.zzco("The webview is destroyed. Ignoring action.");
            }
        }
    }

    private final void zzcw(String str) {
        if (zzq.zzama()) {
            if (zzpa() == null) {
                synchronized (this.mLock) {
                    this.zzcxg = zzbs.zzeg().zzpa();
                    if (this.zzcxg == null) {
                        try {
                            evaluateJavascript("(function(){})()", (ValueCallback<String>) null);
                            zza((Boolean) true);
                        } catch (IllegalStateException e) {
                            zza((Boolean) false);
                        }
                    }
                }
            }
            if (zzpa().booleanValue()) {
                synchronized (this.mLock) {
                    if (!isDestroyed()) {
                        evaluateJavascript(str, (ValueCallback<String>) null);
                    } else {
                        zzafj.zzco("The webview is destroyed. Ignoring action.");
                    }
                }
                return;
            }
            String valueOf = String.valueOf(str);
            zzcv(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        String valueOf2 = String.valueOf(str);
        zzcv(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    private final Boolean zzpa() {
        Boolean bool;
        synchronized (this.mLock) {
            bool = this.zzcxg;
        }
        return bool;
    }

    private final void zzpo() {
        synchronized (this.mLock) {
            if (!this.zzdka) {
                this.zzdka = true;
                zzbs.zzeg().zzpo();
            }
        }
    }

    private final boolean zztq() {
        int i;
        int i2;
        if (!this.zzdjf.zzfr() && !this.zzdjf.zzte()) {
            return false;
        }
        zzbs.zzec();
        DisplayMetrics zza = zzagr.zza(this.zzavc);
        zzjk.zzhx();
        int zzb = zzais.zzb(zza, zza.widthPixels);
        zzjk.zzhx();
        int zzb2 = zzais.zzb(zza, zza.heightPixels);
        Activity zzrz = this.zzdjd.zzrz();
        if (zzrz == null || zzrz.getWindow() == null) {
            i = zzb2;
            i2 = zzb;
        } else {
            zzbs.zzec();
            int[] zzf = zzagr.zzf(zzrz);
            zzjk.zzhx();
            i2 = zzais.zzb(zza, zzf[0]);
            zzjk.zzhx();
            i = zzais.zzb(zza, zzf[1]);
        }
        if (this.zzcfw == zzb && this.zzcfx == zzb2 && this.zzcfz == i2 && this.zzcga == i) {
            return false;
        }
        boolean z = (this.zzcfw == zzb && this.zzcfx == zzb2) ? false : true;
        this.zzcfw = zzb;
        this.zzcfx = zzb2;
        this.zzcfz = i2;
        this.zzcga = i;
        new zzwg(this).zza(zzb, zzb2, i2, i, zza.density, this.zzavc.getDefaultDisplay().getRotation());
        return z;
    }

    private final void zztr() {
        zzmw.zza(this.zzdjx.zziy(), this.zzdgr, "aeh2");
    }

    private final void zzts() {
        synchronized (this.mLock) {
            if (this.zzdjk || this.zzdjh.zztx()) {
                zzafj.zzbw("Enabling hardware acceleration on an overlay.");
                zztt();
            } else if (Build.VERSION.SDK_INT < 18) {
                zzafj.zzbw("Disabling hardware acceleration on an AdView.");
                synchronized (this.mLock) {
                    if (!this.zzdjl) {
                        zzbs.zzee().zzt(this);
                    }
                    this.zzdjl = true;
                }
            } else {
                zzafj.zzbw("Enabling hardware acceleration on an AdView.");
                zztt();
            }
        }
    }

    private final void zztt() {
        synchronized (this.mLock) {
            if (this.zzdjl) {
                zzbs.zzee().zzs(this);
            }
            this.zzdjl = false;
        }
    }

    private final void zztu() {
        synchronized (this.mLock) {
            this.zzdkb = null;
        }
    }

    private final void zztv() {
        zznd zziy;
        if (this.zzdjx != null && (zziy = this.zzdjx.zziy()) != null && zzbs.zzeg().zzow() != null) {
            zzbs.zzeg().zzow().zza(zziy);
        }
    }

    public final void destroy() {
        synchronized (this.mLock) {
            zztv();
            this.zzaun.zzqp();
            if (this.zzdjg != null) {
                this.zzdjg.close();
                this.zzdjg.onDestroy();
                this.zzdjg = null;
            }
            this.zzdjf.reset();
            if (!this.zzdjj) {
                zzbs.zzey();
                zzals.zzb((zzali) this);
                zztu();
                this.zzdjj = true;
                zzafj.m11v("Initiating WebView self destruct sequence in 3...");
                this.zzdjf.zzti();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void evaluateJavascript(java.lang.String r3, android.webkit.ValueCallback<java.lang.String> r4) {
        /*
            r2 = this;
            java.lang.Object r1 = r2.mLock
            monitor-enter(r1)
            boolean r0 = r2.isDestroyed()     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "The webview is destroyed. Ignoring action."
            com.google.android.gms.internal.zzafj.zzco(r0)     // Catch:{ all -> 0x001b }
            if (r4 == 0) goto L_0x0014
            r0 = 0
            r4.onReceiveValue(r0)     // Catch:{ all -> 0x001b }
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
        L_0x0015:
            return
        L_0x0016:
            super.evaluateJavascript(r3, r4)     // Catch:{ all -> 0x001b }
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            goto L_0x0015
        L_0x001b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzamo.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            if (this.mLock != null) {
                synchronized (this.mLock) {
                    if (!this.zzdjj) {
                        this.zzdjf.reset();
                        zzbs.zzey();
                        zzals.zzb((zzali) this);
                        zztu();
                        zzpo();
                    }
                }
            }
        } finally {
            super.finalize();
        }
    }

    public final View.OnClickListener getOnClickListener() {
        return (View.OnClickListener) this.zzdjy.get();
    }

    public final String getRequestId() {
        String str;
        synchronized (this.mLock) {
            str = this.zzcqb;
        }
        return str;
    }

    public final int getRequestedOrientation() {
        int i;
        synchronized (this.mLock) {
            i = this.zzdjm;
        }
        return i;
    }

    public final WebView getWebView() {
        return this;
    }

    public final boolean isDestroyed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdjj;
        }
        return z;
    }

    public final void loadData(String str, String str2, String str3) {
        synchronized (this.mLock) {
            if (!isDestroyed()) {
                super.loadData(str, str2, str3);
            } else {
                zzafj.zzco("The webview is destroyed. Ignoring action.");
            }
        }
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.mLock) {
            if (!isDestroyed()) {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            } else {
                zzafj.zzco("The webview is destroyed. Ignoring action.");
            }
        }
    }

    public final void loadUrl(String str) {
        synchronized (this.mLock) {
            if (!isDestroyed()) {
                try {
                    super.loadUrl(str);
                } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                    zzbs.zzeg().zza(e, "AdWebViewImpl.loadUrl");
                    zzafj.zzc("Could not call loadUrl. ", e);
                }
            } else {
                zzafj.zzco("The webview is destroyed. Ignoring action.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        boolean z = true;
        synchronized (this.mLock) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.zzaun.onAttachedToWindow();
            }
            boolean z2 = this.zzdjq;
            if (this.zzdjf == null || !this.zzdjf.zzte()) {
                z = z2;
            } else {
                if (!this.zzdjr) {
                    ViewTreeObserver.OnGlobalLayoutListener zztf = this.zzdjf.zztf();
                    if (zztf != null) {
                        zzbs.zzez();
                        if (this == null) {
                            throw null;
                        }
                        zzakg.zza((View) this, zztf);
                    }
                    ViewTreeObserver.OnScrollChangedListener zztg = this.zzdjf.zztg();
                    if (zztg != null) {
                        zzbs.zzez();
                        if (this == null) {
                            throw null;
                        }
                        zzakg.zza((View) this, zztg);
                    }
                    this.zzdjr = true;
                }
                zztq();
            }
            zzag(z);
        }
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        synchronized (this.mLock) {
            if (!isDestroyed()) {
                this.zzaun.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzdjr && this.zzdjf != null && this.zzdjf.zzte() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                ViewTreeObserver.OnGlobalLayoutListener zztf = this.zzdjf.zztf();
                if (zztf != null) {
                    zzbs.zzee().zza(getViewTreeObserver(), zztf);
                }
                ViewTreeObserver.OnScrollChangedListener zztg = this.zzdjf.zztg();
                if (zztg != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(zztg);
                }
                this.zzdjr = false;
            }
        }
        zzag(false);
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzbs.zzec();
            zzagr.zza(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            zzafj.zzbw(new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length()).append("Couldn't find an Activity to view url/mimetype: ").append(str).append(" / ").append(str4).toString());
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                if (this.zzdjf != null && this.zzdjf.zztp() != null) {
                    this.zzdjf.zztp().zzcv();
                }
            }
        }
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbjm)).booleanValue()) {
            float axisValue = motionEvent.getAxisValue(9);
            float axisValue2 = motionEvent.getAxisValue(10);
            if (motionEvent.getActionMasked() == 8 && ((axisValue > 0.0f && !canScrollVertically(-1)) || ((axisValue < 0.0f && !canScrollVertically(1)) || ((axisValue2 > 0.0f && !canScrollHorizontally(-1)) || (axisValue2 < 0.0f && !canScrollHorizontally(1)))))) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public final void onGlobalLayout() {
        boolean zztq = zztq();
        zzd zzsm = zzsm();
        if (zzsm != null && zztq) {
            zzsm.zzms();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        return;
     */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            r0 = 2147483647(0x7fffffff, float:NaN)
            r8 = 1073741824(0x40000000, float:2.0)
            r7 = 8
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.Object r4 = r9.mLock
            monitor-enter(r4)
            boolean r1 = r9.isDestroyed()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x0019
            r0 = 0
            r1 = 0
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x0030 }
            monitor-exit(r4)     // Catch:{ all -> 0x0030 }
        L_0x0018:
            return
        L_0x0019:
            boolean r1 = r9.isInEditMode()     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002b
            boolean r1 = r9.zzdjk     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002b
            com.google.android.gms.internal.zzanp r1 = r9.zzdjh     // Catch:{ all -> 0x0030 }
            boolean r1 = r1.zzty()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x0033
        L_0x002b:
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x0030 }
            monitor-exit(r4)     // Catch:{ all -> 0x0030 }
            goto L_0x0018
        L_0x0030:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0030 }
            throw r0
        L_0x0033:
            com.google.android.gms.internal.zzanp r1 = r9.zzdjh     // Catch:{ all -> 0x0030 }
            boolean r1 = r1.isFluid()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x008b
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbnf     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.zzmo r1 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x0030 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0030 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0030 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0030 }
            if (r0 != 0) goto L_0x0053
            boolean r0 = com.google.android.gms.common.util.zzq.zzaly()     // Catch:{ all -> 0x0030 }
            if (r0 != 0) goto L_0x0058
        L_0x0053:
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x0030 }
            monitor-exit(r4)     // Catch:{ all -> 0x0030 }
            goto L_0x0018
        L_0x0058:
            java.lang.String r0 = "/contentHeight"
            com.google.android.gms.internal.zzamp r1 = new com.google.android.gms.internal.zzamp     // Catch:{ all -> 0x0030 }
            r1.<init>(r9)     // Catch:{ all -> 0x0030 }
            r9.zza((java.lang.String) r0, (com.google.android.gms.ads.internal.gmsg.zzt<? super com.google.android.gms.internal.zzama>) r1)     // Catch:{ all -> 0x0030 }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r9.zzcw(r0)     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.zzano r0 = r9.zzdjd     // Catch:{ all -> 0x0030 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ all -> 0x0030 }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ all -> 0x0030 }
            float r0 = r0.density     // Catch:{ all -> 0x0030 }
            int r1 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x0030 }
            int r2 = r9.zzdju     // Catch:{ all -> 0x0030 }
            switch(r2) {
                case -1: goto L_0x0086;
                default: goto L_0x007c;
            }     // Catch:{ all -> 0x0030 }
        L_0x007c:
            int r2 = r9.zzdju     // Catch:{ all -> 0x0030 }
            float r2 = (float) r2     // Catch:{ all -> 0x0030 }
            float r0 = r0 * r2
            int r0 = (int) r0     // Catch:{ all -> 0x0030 }
        L_0x0081:
            r9.setMeasuredDimension(r1, r0)     // Catch:{ all -> 0x0030 }
            monitor-exit(r4)     // Catch:{ all -> 0x0030 }
            goto L_0x0018
        L_0x0086:
            int r0 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x0030 }
            goto L_0x0081
        L_0x008b:
            com.google.android.gms.internal.zzanp r1 = r9.zzdjh     // Catch:{ all -> 0x0030 }
            boolean r1 = r1.zztx()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x00ab
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics     // Catch:{ all -> 0x0030 }
            r0.<init>()     // Catch:{ all -> 0x0030 }
            android.view.WindowManager r1 = r9.zzavc     // Catch:{ all -> 0x0030 }
            android.view.Display r1 = r1.getDefaultDisplay()     // Catch:{ all -> 0x0030 }
            r1.getMetrics(r0)     // Catch:{ all -> 0x0030 }
            int r1 = r0.widthPixels     // Catch:{ all -> 0x0030 }
            int r0 = r0.heightPixels     // Catch:{ all -> 0x0030 }
            r9.setMeasuredDimension(r1, r0)     // Catch:{ all -> 0x0030 }
            monitor-exit(r4)     // Catch:{ all -> 0x0030 }
            goto L_0x0018
        L_0x00ab:
            int r2 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x0030 }
            int r3 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x0030 }
            int r5 = android.view.View.MeasureSpec.getMode(r11)     // Catch:{ all -> 0x0030 }
            int r1 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x0030 }
            if (r2 == r6) goto L_0x00bf
            if (r2 != r8) goto L_0x0156
        L_0x00bf:
            r2 = r3
        L_0x00c0:
            if (r5 == r6) goto L_0x00c4
            if (r5 != r8) goto L_0x00c5
        L_0x00c4:
            r0 = r1
        L_0x00c5:
            com.google.android.gms.internal.zzanp r5 = r9.zzdjh     // Catch:{ all -> 0x0030 }
            int r5 = r5.widthPixels     // Catch:{ all -> 0x0030 }
            if (r5 > r2) goto L_0x00d1
            com.google.android.gms.internal.zzanp r2 = r9.zzdjh     // Catch:{ all -> 0x0030 }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x0030 }
            if (r2 <= r0) goto L_0x0140
        L_0x00d1:
            com.google.android.gms.internal.zzano r0 = r9.zzdjd     // Catch:{ all -> 0x0030 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ all -> 0x0030 }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ all -> 0x0030 }
            float r0 = r0.density     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.zzanp r2 = r9.zzdjh     // Catch:{ all -> 0x0030 }
            int r2 = r2.widthPixels     // Catch:{ all -> 0x0030 }
            float r2 = (float) r2     // Catch:{ all -> 0x0030 }
            float r2 = r2 / r0
            int r2 = (int) r2     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.zzanp r5 = r9.zzdjh     // Catch:{ all -> 0x0030 }
            int r5 = r5.heightPixels     // Catch:{ all -> 0x0030 }
            float r5 = (float) r5     // Catch:{ all -> 0x0030 }
            float r5 = r5 / r0
            int r5 = (int) r5     // Catch:{ all -> 0x0030 }
            float r3 = (float) r3     // Catch:{ all -> 0x0030 }
            float r3 = r3 / r0
            int r3 = (int) r3     // Catch:{ all -> 0x0030 }
            float r1 = (float) r1     // Catch:{ all -> 0x0030 }
            float r0 = r1 / r0
            int r0 = (int) r0     // Catch:{ all -> 0x0030 }
            r1 = 103(0x67, float:1.44E-43)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r6.<init>(r1)     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = "Not enough space to show ad. Needs "
            java.lang.StringBuilder r1 = r6.append(r1)     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = "x"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = " dp, but only has "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = "x"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = " dp."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0030 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.zzafj.zzco(r0)     // Catch:{ all -> 0x0030 }
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x0030 }
            if (r0 == r7) goto L_0x0138
            r0 = 4
            r9.setVisibility(r0)     // Catch:{ all -> 0x0030 }
        L_0x0138:
            r0 = 0
            r1 = 0
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x0030 }
        L_0x013d:
            monitor-exit(r4)     // Catch:{ all -> 0x0030 }
            goto L_0x0018
        L_0x0140:
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x0030 }
            if (r0 == r7) goto L_0x014a
            r0 = 0
            r9.setVisibility(r0)     // Catch:{ all -> 0x0030 }
        L_0x014a:
            com.google.android.gms.internal.zzanp r0 = r9.zzdjh     // Catch:{ all -> 0x0030 }
            int r0 = r0.widthPixels     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.zzanp r1 = r9.zzdjh     // Catch:{ all -> 0x0030 }
            int r1 = r1.heightPixels     // Catch:{ all -> 0x0030 }
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x0030 }
            goto L_0x013d
        L_0x0156:
            r2 = r0
            goto L_0x00c0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzamo.onMeasure(int, int):void");
    }

    public final void onPause() {
        if (!isDestroyed()) {
            try {
                super.onPause();
            } catch (Exception e) {
                zzafj.zzb("Could not pause webview.", e);
            }
        }
    }

    public final void onResume() {
        if (!isDestroyed()) {
            try {
                super.onResume();
            } catch (Exception e) {
                zzafj.zzb("Could not resume webview.", e);
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zzdjf.zzte()) {
            synchronized (this.mLock) {
                if (this.zzdjs != null) {
                    this.zzdjs.zzc(motionEvent);
                }
            }
        } else if (this.zzbta != null) {
            this.zzbta.zza(motionEvent);
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setContext(Context context) {
        this.zzdjd.setBaseContext(context);
        this.zzaun.zzi(this.zzdjd.zzrz());
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzdjy = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final void setRequestedOrientation(int i) {
        synchronized (this.mLock) {
            this.zzdjm = i;
            if (this.zzdjg != null) {
                this.zzdjg.setRequestedOrientation(this.zzdjm);
            }
        }
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzamb) {
            this.zzdjf = (zzamb) webViewClient;
        }
    }

    public final void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzafj.zzb("Could not stop loading webview.", e);
            }
        }
    }

    public final void zza(zzc zzc) {
        this.zzdjf.zza(zzc);
    }

    public final void zza(zzamr zzamr) {
        synchronized (this.mLock) {
            if (this.zzdjp != null) {
                zzafj.m12e("Attempt to create multiple AdWebViewVideoControllers.");
            } else {
                this.zzdjp = zzamr;
            }
        }
    }

    public final void zza(zzanp zzanp) {
        synchronized (this.mLock) {
            this.zzdjh = zzanp;
            requestLayout();
        }
    }

    public final void zza(zzgb zzgb) {
        synchronized (this.mLock) {
            this.zzdjq = zzgb.zzaxe;
        }
        zzag(zzgb.zzaxe);
    }

    public final void zza(String str, zzt<? super zzama> zzt) {
        if (this.zzdjf != null) {
            this.zzdjf.zza(str, zzt);
        }
    }

    public final void zza(String str, Map<String, ?> map) {
        try {
            zza(str, zzbs.zzec().zzp(map));
        } catch (JSONException e) {
            zzafj.zzco("Could not convert parameters to JSON.");
        }
    }

    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzafj.zzbw(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzcw(sb.toString());
    }

    public final void zza(boolean z, int i) {
        this.zzdjf.zza(z, i);
    }

    public final void zza(boolean z, int i, String str) {
        this.zzdjf.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.zzdjf.zza(z, i, str, str2);
    }

    public final void zzab(boolean z) {
        this.zzdjf.zzab(z);
    }

    public final void zzac(boolean z) {
        synchronized (this.mLock) {
            boolean z2 = z != this.zzdjk;
            this.zzdjk = z;
            zzts();
            if (z2) {
                new zzwg(this).zzbn(z ? "expanded" : "default");
            }
        }
    }

    public final void zzad(boolean z) {
        synchronized (this.mLock) {
            if (this.zzdjg != null) {
                this.zzdjg.zza(this.zzdjf.zzfr(), z);
            } else {
                this.zzdji = z;
            }
        }
    }

    public final void zzae(boolean z) {
        synchronized (this.mLock) {
            this.zzdjn = z;
        }
    }

    public final void zzaf(boolean z) {
        synchronized (this.mLock) {
            this.zzdjt = (z ? 1 : -1) + this.zzdjt;
            if (this.zzdjt <= 0 && this.zzdjg != null) {
                this.zzdjg.zzmv();
            }
        }
    }

    public final void zzag(int i) {
        if (i == 0) {
            zzmw.zza(this.zzdjx.zziy(), this.zzdgr, "aebb2");
        }
        zztr();
        if (this.zzdjx.zziy() != null) {
            this.zzdjx.zziy().zzf("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzaov.zzcp);
        zza("onhide", (Map<String, ?>) hashMap);
    }

    public final void zzb(zzd zzd) {
        synchronized (this.mLock) {
            this.zzdjg = zzd;
        }
    }

    public final void zzb(zzny zzny) {
        synchronized (this.mLock) {
            this.zzdjs = zzny;
        }
    }

    public final void zzb(String str, zzt<? super zzama> zzt) {
        if (this.zzdjf != null) {
            this.zzdjf.zzb(str, zzt);
        }
    }

    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        zzcw(new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length()).append(str).append("(").append(jSONObject2).append(");").toString());
    }

    public final zzv zzbk() {
        return this.zzamw;
    }

    public final void zzc(zzd zzd) {
        synchronized (this.mLock) {
            this.zzdjz = zzd;
        }
    }

    public final void zzck() {
        synchronized (this.mLock) {
            this.zzdjo = true;
            if (this.zzdje != null) {
                this.zzdje.zzck();
            }
        }
    }

    public final void zzcl() {
        synchronized (this.mLock) {
            this.zzdjo = false;
            if (this.zzdje != null) {
                this.zzdje.zzcl();
            }
        }
    }

    public final void zzct(String str) {
        synchronized (this.mLock) {
            try {
                super.loadUrl(str);
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
                zzbs.zzeg().zza(e, "AdWebViewImpl.loadUrlUnsafe");
                zzafj.zzc("Could not call loadUrl. ", e);
            }
        }
    }

    public final void zzcu(String str) {
        synchronized (this.mLock) {
            if (str == null) {
                str = "";
            }
            this.zzcqb = str;
        }
    }

    public final void zzmt() {
        if (this.zzdjv == null) {
            zzmw.zza(this.zzdjx.zziy(), this.zzdgr, "aes2");
            this.zzdjv = zzmw.zzb(this.zzdjx.zziy());
            this.zzdjx.zza("native:view_show", this.zzdjv);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzaov.zzcp);
        zza("onshow", (Map<String, ?>) hashMap);
    }

    public final void zzmu() {
        zzd zzsm = zzsm();
        if (zzsm != null) {
            zzsm.zzmu();
        }
    }

    public final zzakz zzrw() {
        return null;
    }

    public final zzamr zzrx() {
        zzamr zzamr;
        synchronized (this.mLock) {
            zzamr = this.zzdjp;
        }
        return zzamr;
    }

    public final zznb zzry() {
        return this.zzdgr;
    }

    public final Activity zzrz() {
        return this.zzdjd.zzrz();
    }

    public final zznc zzsa() {
        return this.zzdjx;
    }

    public final zzaiy zzsb() {
        return this.zzaov;
    }

    public final int zzsc() {
        return getMeasuredHeight();
    }

    public final int zzsd() {
        return getMeasuredWidth();
    }

    public final void zzsj() {
        zztr();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzaov.zzcp);
        zza("onhide", (Map<String, ?>) hashMap);
    }

    public final void zzsk() {
        HashMap hashMap = new HashMap(3);
        zzbs.zzec();
        hashMap.put("app_muted", String.valueOf(zzagr.zzdi()));
        zzbs.zzec();
        hashMap.put("app_volume", String.valueOf(zzagr.zzdh()));
        zzbs.zzec();
        hashMap.put("device_volume", String.valueOf(zzagr.zzap(getContext())));
        zza("volume", (Map<String, ?>) hashMap);
    }

    public final Context zzsl() {
        return this.zzdjd.zzsl();
    }

    public final zzd zzsm() {
        zzd zzd;
        synchronized (this.mLock) {
            zzd = this.zzdjg;
        }
        return zzd;
    }

    public final zzd zzsn() {
        zzd zzd;
        synchronized (this.mLock) {
            zzd = this.zzdjz;
        }
        return zzd;
    }

    public final zzanp zzso() {
        zzanp zzanp;
        synchronized (this.mLock) {
            zzanp = this.zzdjh;
        }
        return zzanp;
    }

    public final String zzsp() {
        String str;
        synchronized (this.mLock) {
            str = this.zzaky;
        }
        return str;
    }

    public final zzamb zzsq() {
        return this.zzdjf;
    }

    public final boolean zzsr() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdji;
        }
        return z;
    }

    public final zzcs zzss() {
        return this.zzbta;
    }

    public final boolean zzst() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdjk;
        }
        return z;
    }

    public final void zzsu() {
        synchronized (this.mLock) {
            zzafj.m11v("Destroying WebView!");
            zzpo();
            zzagr.zzczc.post(new zzamq(this));
        }
    }

    public final boolean zzsv() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdjn;
        }
        return z;
    }

    public final boolean zzsw() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdjo;
        }
        return z;
    }

    public final boolean zzsx() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdjt > 0;
        }
        return z;
    }

    public final void zzsy() {
        this.zzaun.zzqo();
    }

    public final void zzsz() {
        if (this.zzdjw == null) {
            this.zzdjw = zzmw.zzb(this.zzdjx.zziy());
            this.zzdjx.zza("native:view_load", this.zzdjw);
        }
    }

    public final zzny zzta() {
        zzny zzny;
        synchronized (this.mLock) {
            zzny = this.zzdjs;
        }
        return zzny;
    }

    public final void zztb() {
        setBackgroundColor(0);
    }

    public final void zztc() {
        zzafj.m11v("Cannot add text view to inner AdWebView");
    }
}
