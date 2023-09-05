package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.p000v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzagw;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzwg;
import com.google.android.gms.internal.zzwk;
import com.google.android.gms.internal.zzzb;
import java.util.Collections;
import java.util.Map;

@zzzb
public final class zzd extends zzwk implements zzt {
    private static int zzcgi = Color.argb(0, 0, 0, 0);
    /* access modifiers changed from: private */
    public final Activity mActivity;
    private zzama zzbwq;
    AdOverlayInfoParcel zzcgj;
    private zzi zzcgk;
    private zzo zzcgl;
    private boolean zzcgm = false;
    private FrameLayout zzcgn;
    private WebChromeClient.CustomViewCallback zzcgo;
    private boolean zzcgp = false;
    private boolean zzcgq = false;
    private zzh zzcgr;
    private boolean zzcgs = false;
    private int zzcgt = 0;
    private final Object zzcgu = new Object();
    private Runnable zzcgv;
    private boolean zzcgw;
    private boolean zzcgx;
    private boolean zzcgy = false;
    private boolean zzcgz = false;
    private boolean zzcha = true;

    public zzd(Activity activity) {
        this.mActivity = activity;
    }

    private final void zzmq() {
        if (this.mActivity.isFinishing() && !this.zzcgy) {
            this.zzcgy = true;
            if (this.zzbwq != null) {
                this.zzbwq.zzag(this.zzcgt);
                synchronized (this.zzcgu) {
                    if (!this.zzcgw && this.zzbwq.zzsx()) {
                        this.zzcgv = new zzf(this);
                        zzagr.zzczc.postDelayed(this.zzcgv, ((Long) zzbs.zzep().zzd(zzmq.zzbjz)).longValue());
                        return;
                    }
                }
            }
            zzmr();
        }
    }

    private final void zzmt() {
        this.zzbwq.zzmt();
    }

    private final void zzr(boolean z) {
        int intValue = ((Integer) zzbs.zzep().zzd(zzmq.zzbpj)).intValue();
        zzp zzp = new zzp();
        zzp.size = 50;
        zzp.paddingLeft = z ? intValue : 0;
        zzp.paddingRight = z ? 0 : intValue;
        zzp.paddingTop = 0;
        zzp.paddingBottom = intValue;
        this.zzcgl = new zzo(this.mActivity, zzp, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzcgj.zzchm);
        this.zzcgr.addView(this.zzcgl, layoutParams);
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0143 A[SYNTHETIC, Splitter:B:51:0x0143] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x025c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzs(boolean r18) throws com.google.android.gms.ads.internal.overlay.zzg {
        /*
            r17 = this;
            r0 = r17
            boolean r1 = r0.zzcgx
            if (r1 != 0) goto L_0x000e
            r0 = r17
            android.app.Activity r1 = r0.mActivity
            r2 = 1
            r1.requestWindowFeature(r2)
        L_0x000e:
            r0 = r17
            android.app.Activity r1 = r0.mActivity
            android.view.Window r3 = r1.getWindow()
            if (r3 != 0) goto L_0x0020
            com.google.android.gms.ads.internal.overlay.zzg r1 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r2 = "Invalid activity, no window available."
            r1.<init>(r2)
            throw r1
        L_0x0020:
            r2 = 1
            boolean r1 = com.google.android.gms.common.util.zzq.isAtLeastN()
            if (r1 == 0) goto L_0x0308
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r1 = com.google.android.gms.internal.zzmq.zzbph
            com.google.android.gms.internal.zzmo r4 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r1 = r4.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0308
            com.google.android.gms.ads.internal.zzbs.zzec()
            r0 = r17
            android.app.Activity r1 = r0.mActivity
            r0 = r17
            android.app.Activity r2 = r0.mActivity
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            boolean r1 = com.google.android.gms.internal.zzagr.zza((android.app.Activity) r1, (android.content.res.Configuration) r2)
        L_0x0050:
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r2 = r0.zzcgj
            com.google.android.gms.ads.internal.zzao r2 = r2.zzchr
            if (r2 == 0) goto L_0x0226
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r2 = r0.zzcgj
            com.google.android.gms.ads.internal.zzao r2 = r2.zzchr
            boolean r2 = r2.zzaps
            if (r2 == 0) goto L_0x0226
            r2 = 1
        L_0x0063:
            r0 = r17
            boolean r4 = r0.zzcgq
            if (r4 == 0) goto L_0x006b
            if (r2 == 0) goto L_0x00a7
        L_0x006b:
            if (r1 == 0) goto L_0x00a7
            r1 = 1024(0x400, float:1.435E-42)
            r2 = 1024(0x400, float:1.435E-42)
            r3.setFlags(r1, r2)
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r1 = com.google.android.gms.internal.zzmq.zzbka
            com.google.android.gms.internal.zzmo r2 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x00a7
            boolean r1 = com.google.android.gms.common.util.zzq.zzama()
            if (r1 == 0) goto L_0x00a7
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            com.google.android.gms.ads.internal.zzao r1 = r1.zzchr
            if (r1 == 0) goto L_0x00a7
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            com.google.android.gms.ads.internal.zzao r1 = r1.zzchr
            boolean r1 = r1.zzapx
            if (r1 == 0) goto L_0x00a7
            android.view.View r1 = r3.getDecorView()
            r2 = 4098(0x1002, float:5.743E-42)
            r1.setSystemUiVisibility(r2)
        L_0x00a7:
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            com.google.android.gms.internal.zzama r1 = r1.zzchj
            if (r1 == 0) goto L_0x0229
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            com.google.android.gms.internal.zzama r1 = r1.zzchj
            com.google.android.gms.internal.zzamb r1 = r1.zzsq()
        L_0x00b9:
            if (r1 == 0) goto L_0x022c
            boolean r6 = r1.zzfr()
        L_0x00bf:
            r1 = 0
            r0 = r17
            r0.zzcgs = r1
            if (r6 == 0) goto L_0x00ec
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            int r1 = r1.orientation
            com.google.android.gms.internal.zzagw r2 = com.google.android.gms.ads.internal.zzbs.zzee()
            int r2 = r2.zzpz()
            if (r1 != r2) goto L_0x0232
            r0 = r17
            android.app.Activity r1 = r0.mActivity
            android.content.res.Resources r1 = r1.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.orientation
            r2 = 1
            if (r1 != r2) goto L_0x022f
            r1 = 1
        L_0x00e8:
            r0 = r17
            r0.zzcgs = r1
        L_0x00ec:
            r0 = r17
            boolean r1 = r0.zzcgs
            r2 = 46
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            java.lang.String r2 = "Delay onShow to next orientation change: "
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            com.google.android.gms.internal.zzafj.zzbw(r1)
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            int r1 = r1.orientation
            r0 = r17
            r0.setRequestedOrientation(r1)
            com.google.android.gms.internal.zzagw r1 = com.google.android.gms.ads.internal.zzbs.zzee()
            boolean r1 = r1.zza((android.view.Window) r3)
            if (r1 == 0) goto L_0x0122
            java.lang.String r1 = "Hardware acceleration on the AdActivity window enabled."
            com.google.android.gms.internal.zzafj.zzbw(r1)
        L_0x0122:
            r0 = r17
            boolean r1 = r0.zzcgq
            if (r1 != 0) goto L_0x025c
            r0 = r17
            com.google.android.gms.ads.internal.overlay.zzh r1 = r0.zzcgr
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1.setBackgroundColor(r2)
        L_0x0131:
            r0 = r17
            android.app.Activity r1 = r0.mActivity
            r0 = r17
            com.google.android.gms.ads.internal.overlay.zzh r2 = r0.zzcgr
            r1.setContentView(r2)
            r1 = 1
            r0 = r17
            r0.zzcgx = r1
            if (r18 == 0) goto L_0x02ab
            com.google.android.gms.internal.zzamk r1 = com.google.android.gms.ads.internal.zzbs.zzed()     // Catch:{ Exception -> 0x0270 }
            r0 = r17
            android.app.Activity r2 = r0.mActivity     // Catch:{ Exception -> 0x0270 }
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r0.zzcgj     // Catch:{ Exception -> 0x0270 }
            com.google.android.gms.internal.zzama r3 = r3.zzchj     // Catch:{ Exception -> 0x0270 }
            if (r3 == 0) goto L_0x0267
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r0.zzcgj     // Catch:{ Exception -> 0x0270 }
            com.google.android.gms.internal.zzama r3 = r3.zzchj     // Catch:{ Exception -> 0x0270 }
            com.google.android.gms.internal.zzanp r3 = r3.zzso()     // Catch:{ Exception -> 0x0270 }
        L_0x015d:
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r4 = r0.zzcgj     // Catch:{ Exception -> 0x0270 }
            com.google.android.gms.internal.zzama r4 = r4.zzchj     // Catch:{ Exception -> 0x0270 }
            if (r4 == 0) goto L_0x026a
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r4 = r0.zzcgj     // Catch:{ Exception -> 0x0270 }
            com.google.android.gms.internal.zzama r4 = r4.zzchj     // Catch:{ Exception -> 0x0270 }
            java.lang.String r4 = r4.zzsp()     // Catch:{ Exception -> 0x0270 }
        L_0x016f:
            r5 = 1
            r7 = 0
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r8 = r0.zzcgj     // Catch:{ Exception -> 0x0270 }
            com.google.android.gms.internal.zzaiy r8 = r8.zzatd     // Catch:{ Exception -> 0x0270 }
            r9 = 0
            r10 = 0
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r11 = r0.zzcgj     // Catch:{ Exception -> 0x0270 }
            com.google.android.gms.internal.zzama r11 = r11.zzchj     // Catch:{ Exception -> 0x0270 }
            if (r11 == 0) goto L_0x026d
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r11 = r0.zzcgj     // Catch:{ Exception -> 0x0270 }
            com.google.android.gms.internal.zzama r11 = r11.zzchj     // Catch:{ Exception -> 0x0270 }
            com.google.android.gms.ads.internal.zzv r11 = r11.zzbk()     // Catch:{ Exception -> 0x0270 }
        L_0x018b:
            com.google.android.gms.internal.zzib r12 = com.google.android.gms.internal.zzib.zzhi()     // Catch:{ Exception -> 0x0270 }
            com.google.android.gms.internal.zzama r1 = r1.zza(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0270 }
            r0 = r17
            r0.zzbwq = r1     // Catch:{ Exception -> 0x0270 }
            r0 = r17
            com.google.android.gms.internal.zzama r1 = r0.zzbwq
            com.google.android.gms.internal.zzamb r7 = r1.zzsq()
            r8 = 0
            r9 = 0
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            com.google.android.gms.ads.internal.gmsg.zzb r10 = r1.zzchk
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            com.google.android.gms.ads.internal.overlay.zzq r11 = r1.zzcho
            r12 = 1
            r13 = 0
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            com.google.android.gms.internal.zzama r1 = r1.zzchj
            if (r1 == 0) goto L_0x027e
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            com.google.android.gms.internal.zzama r1 = r1.zzchj
            com.google.android.gms.internal.zzamb r1 = r1.zzsq()
            com.google.android.gms.ads.internal.zzw r14 = r1.zztd()
        L_0x01c5:
            r15 = 0
            r16 = 0
            r7.zza(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = r17
            com.google.android.gms.internal.zzama r1 = r0.zzbwq
            com.google.android.gms.internal.zzamb r1 = r1.zzsq()
            com.google.android.gms.ads.internal.overlay.zze r2 = new com.google.android.gms.ads.internal.overlay.zze
            r0 = r17
            r2.<init>(r0)
            r1.zza((com.google.android.gms.internal.zzamf) r2)
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            java.lang.String r1 = r1.url
            if (r1 == 0) goto L_0x0281
            r0 = r17
            com.google.android.gms.internal.zzama r1 = r0.zzbwq
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r2 = r0.zzcgj
            java.lang.String r2 = r2.url
            r1.loadUrl(r2)
        L_0x01f2:
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            com.google.android.gms.internal.zzama r1 = r1.zzchj
            if (r1 == 0) goto L_0x0205
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            com.google.android.gms.internal.zzama r1 = r1.zzchj
            r0 = r17
            r1.zzc(r0)
        L_0x0205:
            r0 = r17
            com.google.android.gms.internal.zzama r1 = r0.zzbwq
            r0 = r17
            r1.zzb((com.google.android.gms.ads.internal.overlay.zzd) r0)
            r0 = r17
            com.google.android.gms.internal.zzama r1 = r0.zzbwq
            android.view.ViewParent r1 = r1.getParent()
            if (r1 == 0) goto L_0x02c7
            boolean r2 = r1 instanceof android.view.ViewGroup
            if (r2 == 0) goto L_0x02c7
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r0 = r17
            com.google.android.gms.internal.zzama r2 = r0.zzbwq
            if (r2 != 0) goto L_0x02c2
            r1 = 0
            throw r1
        L_0x0226:
            r2 = 0
            goto L_0x0063
        L_0x0229:
            r1 = 0
            goto L_0x00b9
        L_0x022c:
            r6 = 0
            goto L_0x00bf
        L_0x022f:
            r1 = 0
            goto L_0x00e8
        L_0x0232:
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            int r1 = r1.orientation
            com.google.android.gms.internal.zzagw r2 = com.google.android.gms.ads.internal.zzbs.zzee()
            int r2 = r2.zzqa()
            if (r1 != r2) goto L_0x00ec
            r0 = r17
            android.app.Activity r1 = r0.mActivity
            android.content.res.Resources r1 = r1.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.orientation
            r2 = 2
            if (r1 != r2) goto L_0x025a
            r1 = 1
        L_0x0254:
            r0 = r17
            r0.zzcgs = r1
            goto L_0x00ec
        L_0x025a:
            r1 = 0
            goto L_0x0254
        L_0x025c:
            r0 = r17
            com.google.android.gms.ads.internal.overlay.zzh r1 = r0.zzcgr
            int r2 = zzcgi
            r1.setBackgroundColor(r2)
            goto L_0x0131
        L_0x0267:
            r3 = 0
            goto L_0x015d
        L_0x026a:
            r4 = 0
            goto L_0x016f
        L_0x026d:
            r11 = 0
            goto L_0x018b
        L_0x0270:
            r1 = move-exception
            java.lang.String r2 = "Error obtaining webview."
            com.google.android.gms.internal.zzafj.zzb(r2, r1)
            com.google.android.gms.ads.internal.overlay.zzg r1 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r2 = "Could not obtain webview for the overlay."
            r1.<init>(r2)
            throw r1
        L_0x027e:
            r14 = 0
            goto L_0x01c5
        L_0x0281:
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            java.lang.String r1 = r1.zzchn
            if (r1 == 0) goto L_0x02a3
            r0 = r17
            com.google.android.gms.internal.zzama r7 = r0.zzbwq
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            java.lang.String r8 = r1.zzchl
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            java.lang.String r9 = r1.zzchn
            java.lang.String r10 = "text/html"
            java.lang.String r11 = "UTF-8"
            r12 = 0
            r7.loadDataWithBaseURL(r8, r9, r10, r11, r12)
            goto L_0x01f2
        L_0x02a3:
            com.google.android.gms.ads.internal.overlay.zzg r1 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r2 = "No URL or HTML to display in ad overlay."
            r1.<init>(r2)
            throw r1
        L_0x02ab:
            r0 = r17
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r0.zzcgj
            com.google.android.gms.internal.zzama r1 = r1.zzchj
            r0 = r17
            r0.zzbwq = r1
            r0 = r17
            com.google.android.gms.internal.zzama r1 = r0.zzbwq
            r0 = r17
            android.app.Activity r2 = r0.mActivity
            r1.setContext(r2)
            goto L_0x0205
        L_0x02c2:
            android.view.View r2 = (android.view.View) r2
            r1.removeView(r2)
        L_0x02c7:
            r0 = r17
            boolean r1 = r0.zzcgq
            if (r1 == 0) goto L_0x02d4
            r0 = r17
            com.google.android.gms.internal.zzama r1 = r0.zzbwq
            r1.zztb()
        L_0x02d4:
            r0 = r17
            com.google.android.gms.ads.internal.overlay.zzh r2 = r0.zzcgr
            r0 = r17
            com.google.android.gms.internal.zzama r1 = r0.zzbwq
            if (r1 != 0) goto L_0x02e0
            r1 = 0
            throw r1
        L_0x02e0:
            android.view.View r1 = (android.view.View) r1
            r3 = -1
            r4 = -1
            r2.addView(r1, r3, r4)
            if (r18 != 0) goto L_0x02f2
            r0 = r17
            boolean r1 = r0.zzcgs
            if (r1 != 0) goto L_0x02f2
            r17.zzmt()
        L_0x02f2:
            r0 = r17
            r0.zzr(r6)
            r0 = r17
            com.google.android.gms.internal.zzama r1 = r0.zzbwq
            boolean r1 = r1.zzsr()
            if (r1 == 0) goto L_0x0307
            r1 = 1
            r0 = r17
            r0.zza((boolean) r6, (boolean) r1)
        L_0x0307:
            return
        L_0x0308:
            r1 = r2
            goto L_0x0050
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzd.zzs(boolean):void");
    }

    public final void close() {
        this.zzcgt = 2;
        this.mActivity.finish();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onBackPressed() {
        this.zzcgt = 0;
    }

    public final void onCreate(Bundle bundle) {
        boolean z = false;
        this.mActivity.requestWindowFeature(1);
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.zzcgp = z;
        try {
            this.zzcgj = AdOverlayInfoParcel.zzc(this.mActivity.getIntent());
            if (this.zzcgj == null) {
                throw new zzg("Could not get info for ad overlay.");
            }
            if (this.zzcgj.zzatd.zzdca > 7500000) {
                this.zzcgt = 3;
            }
            if (this.mActivity.getIntent() != null) {
                this.zzcha = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.zzcgj.zzchr != null) {
                this.zzcgq = this.zzcgj.zzchr.zzapr;
            } else {
                this.zzcgq = false;
            }
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbmk)).booleanValue() && this.zzcgq && this.zzcgj.zzchr.zzapw != -1) {
                new zzj(this, (zze) null).zzps();
            }
            if (bundle == null) {
                if (this.zzcgj.zzchi != null && this.zzcha) {
                    this.zzcgj.zzchi.zzcb();
                }
                if (!(this.zzcgj.zzchp == 1 || this.zzcgj.zzchh == null)) {
                    this.zzcgj.zzchh.onAdClicked();
                }
            }
            this.zzcgr = new zzh(this.mActivity, this.zzcgj.zzchq, this.zzcgj.zzatd.zzcp);
            this.zzcgr.setId(1000);
            switch (this.zzcgj.zzchp) {
                case 1:
                    zzs(false);
                    return;
                case 2:
                    this.zzcgk = new zzi(this.zzcgj.zzchj);
                    zzs(false);
                    return;
                case 3:
                    zzs(true);
                    return;
                case 4:
                    if (this.zzcgp) {
                        this.zzcgt = 3;
                        this.mActivity.finish();
                        return;
                    }
                    zzbs.zzdz();
                    if (!zza.zza((Context) this.mActivity, this.zzcgj.zzchg, this.zzcgj.zzcho)) {
                        this.zzcgt = 3;
                        this.mActivity.finish();
                        return;
                    }
                    return;
                default:
                    throw new zzg("Could not determine ad overlay type.");
            }
        } catch (zzg e) {
            zzafj.zzco(e.getMessage());
            this.zzcgt = 3;
            this.mActivity.finish();
        }
    }

    public final void onDestroy() {
        if (this.zzbwq != null) {
            zzh zzh = this.zzcgr;
            zzama zzama = this.zzbwq;
            if (zzama == null) {
                throw null;
            }
            zzh.removeView((View) zzama);
        }
        zzmq();
    }

    public final void onPause() {
        zzmm();
        if (this.zzcgj.zzchi != null) {
            this.zzcgj.zzchi.onPause();
        }
        if (!((Boolean) zzbs.zzep().zzd(zzmq.zzbpi)).booleanValue() && this.zzbwq != null && (!this.mActivity.isFinishing() || this.zzcgk == null)) {
            zzbs.zzee();
            zzagw.zzh(this.zzbwq);
        }
        zzmq();
    }

    public final void onRestart() {
    }

    public final void onResume() {
        if (this.zzcgj != null && this.zzcgj.zzchp == 4) {
            if (this.zzcgp) {
                this.zzcgt = 3;
                this.mActivity.finish();
            } else {
                this.zzcgp = true;
            }
        }
        if (this.zzcgj.zzchi != null) {
            this.zzcgj.zzchi.onResume();
        }
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbpi)).booleanValue()) {
            return;
        }
        if (this.zzbwq == null || this.zzbwq.isDestroyed()) {
            zzafj.zzco("The webview does not exist. Ignoring action.");
            return;
        }
        zzbs.zzee();
        zzagw.zzi(this.zzbwq);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzcgp);
    }

    public final void onStart() {
        if (!((Boolean) zzbs.zzep().zzd(zzmq.zzbpi)).booleanValue()) {
            return;
        }
        if (this.zzbwq == null || this.zzbwq.isDestroyed()) {
            zzafj.zzco("The webview does not exist. Ignoring action.");
            return;
        }
        zzbs.zzee();
        zzagw.zzi(this.zzbwq);
    }

    public final void onStop() {
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbpi)).booleanValue() && this.zzbwq != null && (!this.mActivity.isFinishing() || this.zzcgk == null)) {
            zzbs.zzee();
            zzagw.zzh(this.zzbwq);
        }
        zzmq();
    }

    public final void setRequestedOrientation(int i) {
        this.mActivity.setRequestedOrientation(i);
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzcgn = new FrameLayout(this.mActivity);
        this.zzcgn.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzcgn.addView(view, -1, -1);
        this.mActivity.setContentView(this.zzcgn);
        this.zzcgx = true;
        this.zzcgo = customViewCallback;
        this.zzcgm = true;
    }

    public final void zza(boolean z, boolean z2) {
        boolean z3 = ((Boolean) zzbs.zzep().zzd(zzmq.zzbkb)).booleanValue() && this.zzcgj != null && this.zzcgj.zzchr != null && this.zzcgj.zzchr.zzapy;
        if (z && z2 && z3) {
            new zzwg(this.zzbwq, "useCustomClose").zzbl("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        if (this.zzcgl != null) {
            this.zzcgl.zza(z, z2 && !z3);
        }
    }

    public final void zzba() {
        this.zzcgx = true;
    }

    public final void zzk(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbph)).booleanValue() && zzq.isAtLeastN()) {
            zzbs.zzec();
            if (zzagr.zza(this.mActivity, (Configuration) zzn.zzx(iObjectWrapper))) {
                this.mActivity.getWindow().addFlags(1024);
                this.mActivity.getWindow().clearFlags(2048);
                return;
            }
            this.mActivity.getWindow().addFlags(2048);
            this.mActivity.getWindow().clearFlags(1024);
        }
    }

    public final void zzmm() {
        if (this.zzcgj != null && this.zzcgm) {
            setRequestedOrientation(this.zzcgj.orientation);
        }
        if (this.zzcgn != null) {
            this.mActivity.setContentView(this.zzcgr);
            this.zzcgx = true;
            this.zzcgn.removeAllViews();
            this.zzcgn = null;
        }
        if (this.zzcgo != null) {
            this.zzcgo.onCustomViewHidden();
            this.zzcgo = null;
        }
        this.zzcgm = false;
    }

    public final void zzmn() {
        this.zzcgt = 1;
        this.mActivity.finish();
    }

    public final boolean zzmo() {
        this.zzcgt = 0;
        if (this.zzbwq == null) {
            return true;
        }
        boolean zzsv = this.zzbwq.zzsv();
        if (zzsv) {
            return zzsv;
        }
        this.zzbwq.zza("onbackblocked", (Map<String, ?>) Collections.emptyMap());
        return zzsv;
    }

    public final void zzmp() {
        this.zzcgr.removeView(this.zzcgl);
        zzr(true);
    }

    /* access modifiers changed from: package-private */
    public final void zzmr() {
        if (!this.zzcgz) {
            this.zzcgz = true;
            if (this.zzbwq != null) {
                zzh zzh = this.zzcgr;
                zzama zzama = this.zzbwq;
                if (zzama == null) {
                    throw null;
                }
                zzh.removeView((View) zzama);
                if (this.zzcgk != null) {
                    this.zzbwq.setContext(this.zzcgk.zzaif);
                    this.zzbwq.zzac(false);
                    ViewGroup viewGroup = this.zzcgk.parent;
                    zzama zzama2 = this.zzbwq;
                    if (zzama2 == null) {
                        throw null;
                    }
                    viewGroup.addView((View) zzama2, this.zzcgk.index, this.zzcgk.zzchd);
                    this.zzcgk = null;
                } else if (this.mActivity.getApplicationContext() != null) {
                    this.zzbwq.setContext(this.mActivity.getApplicationContext());
                }
                this.zzbwq = null;
            }
            if (this.zzcgj != null && this.zzcgj.zzchi != null) {
                this.zzcgj.zzchi.zzca();
            }
        }
    }

    public final void zzms() {
        if (this.zzcgs) {
            this.zzcgs = false;
            zzmt();
        }
    }

    public final void zzmu() {
        this.zzcgr.zzchc = true;
    }

    public final void zzmv() {
        synchronized (this.zzcgu) {
            this.zzcgw = true;
            if (this.zzcgv != null) {
                zzagr.zzczc.removeCallbacks(this.zzcgv);
                zzagr.zzczc.post(this.zzcgv);
            }
        }
    }
}
