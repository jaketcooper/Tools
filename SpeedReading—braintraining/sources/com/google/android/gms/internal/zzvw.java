package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zze;
import java.util.Set;

@zzzb
public final class zzvw extends zzwg {
    private static Set<String> zzcev = zze.zzb("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private final Object mLock = new Object();
    private int zzakw = -1;
    private int zzakx = -1;
    private final zzama zzbwq;
    private final Activity zzcem;
    private String zzcew = "top-right";
    private boolean zzcex = true;
    private int zzcey = 0;
    private int zzcez = 0;
    private int zzcfa = 0;
    private int zzcfb = 0;
    private zzanp zzcfc;
    private ImageView zzcfd;
    private LinearLayout zzcfe;
    private zzwh zzcff;
    private PopupWindow zzcfg;
    private RelativeLayout zzcfh;
    private ViewGroup zzcfi;

    public zzvw(zzama zzama, zzwh zzwh) {
        super(zzama, "resize");
        this.zzbwq = zzama;
        this.zzcem = zzama.zzrz();
        this.zzcff = zzwh;
    }

    private final void zza(int i, int i2) {
        zzb(i, i2 - zzbs.zzec().zzh(this.zzcem)[0], this.zzakw, this.zzakx);
    }

    private final int[] zzmk() {
        boolean z;
        int i;
        int i2;
        int[] zzg = zzbs.zzec().zzg(this.zzcem);
        int[] zzh = zzbs.zzec().zzh(this.zzcem);
        int i3 = zzg[0];
        int i4 = zzg[1];
        if (this.zzakw < 50 || this.zzakw > i3) {
            zzafj.zzco("Width is too small or too large.");
            z = false;
        } else if (this.zzakx < 50 || this.zzakx > i4) {
            zzafj.zzco("Height is too small or too large.");
            z = false;
        } else if (this.zzakx == i4 && this.zzakw == i3) {
            zzafj.zzco("Cannot resize to a full-screen ad.");
            z = false;
        } else {
            if (this.zzcex) {
                String str = this.zzcew;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        i = this.zzcfa + this.zzcey;
                        i2 = this.zzcez + this.zzcfb;
                        break;
                    case 1:
                        i = ((this.zzcey + this.zzcfa) + (this.zzakw / 2)) - 25;
                        i2 = this.zzcez + this.zzcfb;
                        break;
                    case 2:
                        i = ((this.zzcey + this.zzcfa) + (this.zzakw / 2)) - 25;
                        i2 = ((this.zzcez + this.zzcfb) + (this.zzakx / 2)) - 25;
                        break;
                    case 3:
                        i = this.zzcfa + this.zzcey;
                        i2 = ((this.zzcez + this.zzcfb) + this.zzakx) - 50;
                        break;
                    case 4:
                        i = ((this.zzcey + this.zzcfa) + (this.zzakw / 2)) - 25;
                        i2 = ((this.zzcez + this.zzcfb) + this.zzakx) - 50;
                        break;
                    case 5:
                        i = ((this.zzcey + this.zzcfa) + this.zzakw) - 50;
                        i2 = ((this.zzcez + this.zzcfb) + this.zzakx) - 50;
                        break;
                    default:
                        i = ((this.zzcey + this.zzcfa) + this.zzakw) - 50;
                        i2 = this.zzcez + this.zzcfb;
                        break;
                }
                if (i < 0 || i + 50 > i3 || i2 < zzh[0] || i2 + 50 > zzh[1]) {
                    z = false;
                }
            }
            z = true;
        }
        if (!z) {
            return null;
        }
        if (this.zzcex) {
            return new int[]{this.zzcey + this.zzcfa, this.zzcez + this.zzcfb};
        }
        int[] zzg2 = zzbs.zzec().zzg(this.zzcem);
        int[] zzh2 = zzbs.zzec().zzh(this.zzcem);
        int i5 = zzg2[0];
        int i6 = this.zzcey + this.zzcfa;
        int i7 = this.zzcez + this.zzcfb;
        if (i6 < 0) {
            i6 = 0;
        } else if (this.zzakw + i6 > i5) {
            i6 = i5 - this.zzakw;
        }
        if (i7 < zzh2[0]) {
            i7 = zzh2[0];
        } else if (this.zzakx + i7 > zzh2[1]) {
            i7 = zzh2[1] - this.zzakx;
        }
        return new int[]{i6, i7};
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void execute(java.util.Map<java.lang.String, java.lang.String> r15) {
        /*
            r14 = this;
            r5 = -1
            r13 = 0
            r6 = 1
            r4 = 0
            java.lang.Object r7 = r14.mLock
            monitor-enter(r7)
            android.app.Activity r1 = r14.zzcem     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x0012
            java.lang.String r1 = "Not an activity context. Cannot resize."
            r14.zzbl(r1)     // Catch:{ all -> 0x0021 }
            monitor-exit(r7)     // Catch:{ all -> 0x0021 }
        L_0x0011:
            return
        L_0x0012:
            com.google.android.gms.internal.zzama r1 = r14.zzbwq     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzanp r1 = r1.zzso()     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x0024
            java.lang.String r1 = "Webview is not yet available, size is not set."
            r14.zzbl(r1)     // Catch:{ all -> 0x0021 }
            monitor-exit(r7)     // Catch:{ all -> 0x0021 }
            goto L_0x0011
        L_0x0021:
            r1 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0021 }
            throw r1
        L_0x0024:
            com.google.android.gms.internal.zzama r1 = r14.zzbwq     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzanp r1 = r1.zzso()     // Catch:{ all -> 0x0021 }
            boolean r1 = r1.zztx()     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0037
            java.lang.String r1 = "Is interstitial. Cannot resize an interstitial."
            r14.zzbl(r1)     // Catch:{ all -> 0x0021 }
            monitor-exit(r7)     // Catch:{ all -> 0x0021 }
            goto L_0x0011
        L_0x0037:
            com.google.android.gms.internal.zzama r1 = r14.zzbwq     // Catch:{ all -> 0x0021 }
            boolean r1 = r1.zzst()     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0046
            java.lang.String r1 = "Cannot resize an expanded banner."
            r14.zzbl(r1)     // Catch:{ all -> 0x0021 }
            monitor-exit(r7)     // Catch:{ all -> 0x0021 }
            goto L_0x0011
        L_0x0046:
            java.lang.String r1 = "width"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0021 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x0021 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x0065
            com.google.android.gms.ads.internal.zzbs.zzec()     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = "width"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0021 }
            int r1 = com.google.android.gms.internal.zzagr.zzcd(r1)     // Catch:{ all -> 0x0021 }
            r14.zzakw = r1     // Catch:{ all -> 0x0021 }
        L_0x0065:
            java.lang.String r1 = "height"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0021 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x0021 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x0084
            com.google.android.gms.ads.internal.zzbs.zzec()     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = "height"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0021 }
            int r1 = com.google.android.gms.internal.zzagr.zzcd(r1)     // Catch:{ all -> 0x0021 }
            r14.zzakx = r1     // Catch:{ all -> 0x0021 }
        L_0x0084:
            java.lang.String r1 = "offsetX"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0021 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x0021 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x00a3
            com.google.android.gms.ads.internal.zzbs.zzec()     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = "offsetX"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0021 }
            int r1 = com.google.android.gms.internal.zzagr.zzcd(r1)     // Catch:{ all -> 0x0021 }
            r14.zzcfa = r1     // Catch:{ all -> 0x0021 }
        L_0x00a3:
            java.lang.String r1 = "offsetY"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0021 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x0021 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x00c2
            com.google.android.gms.ads.internal.zzbs.zzec()     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = "offsetY"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0021 }
            int r1 = com.google.android.gms.internal.zzagr.zzcd(r1)     // Catch:{ all -> 0x0021 }
            r14.zzcfb = r1     // Catch:{ all -> 0x0021 }
        L_0x00c2:
            java.lang.String r1 = "allowOffscreen"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0021 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x0021 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x00de
            java.lang.String r1 = "allowOffscreen"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0021 }
            boolean r1 = java.lang.Boolean.parseBoolean(r1)     // Catch:{ all -> 0x0021 }
            r14.zzcex = r1     // Catch:{ all -> 0x0021 }
        L_0x00de:
            java.lang.String r1 = "customClosePosition"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0021 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0021 }
            if (r2 != 0) goto L_0x00ee
            r14.zzcew = r1     // Catch:{ all -> 0x0021 }
        L_0x00ee:
            int r1 = r14.zzakw     // Catch:{ all -> 0x0021 }
            if (r1 < 0) goto L_0x0101
            int r1 = r14.zzakx     // Catch:{ all -> 0x0021 }
            if (r1 < 0) goto L_0x0101
            r1 = r6
        L_0x00f7:
            if (r1 != 0) goto L_0x0103
            java.lang.String r1 = "Invalid width and height options. Cannot resize."
            r14.zzbl(r1)     // Catch:{ all -> 0x0021 }
            monitor-exit(r7)     // Catch:{ all -> 0x0021 }
            goto L_0x0011
        L_0x0101:
            r1 = r4
            goto L_0x00f7
        L_0x0103:
            android.app.Activity r1 = r14.zzcem     // Catch:{ all -> 0x0021 }
            android.view.Window r8 = r1.getWindow()     // Catch:{ all -> 0x0021 }
            if (r8 == 0) goto L_0x0111
            android.view.View r1 = r8.getDecorView()     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x0119
        L_0x0111:
            java.lang.String r1 = "Activity context is not ready, cannot get window or decor view."
            r14.zzbl(r1)     // Catch:{ all -> 0x0021 }
            monitor-exit(r7)     // Catch:{ all -> 0x0021 }
            goto L_0x0011
        L_0x0119:
            int[] r9 = r14.zzmk()     // Catch:{ all -> 0x0021 }
            if (r9 != 0) goto L_0x0127
            java.lang.String r1 = "Resize location out of screen or close button is not visible."
            r14.zzbl(r1)     // Catch:{ all -> 0x0021 }
            monitor-exit(r7)     // Catch:{ all -> 0x0021 }
            goto L_0x0011
        L_0x0127:
            com.google.android.gms.internal.zzjk.zzhx()     // Catch:{ all -> 0x0021 }
            android.app.Activity r1 = r14.zzcem     // Catch:{ all -> 0x0021 }
            int r2 = r14.zzakw     // Catch:{ all -> 0x0021 }
            int r10 = com.google.android.gms.internal.zzais.zzc(r1, r2)     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzjk.zzhx()     // Catch:{ all -> 0x0021 }
            android.app.Activity r1 = r14.zzcem     // Catch:{ all -> 0x0021 }
            int r2 = r14.zzakx     // Catch:{ all -> 0x0021 }
            int r11 = com.google.android.gms.internal.zzais.zzc(r1, r2)     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzama r1 = r14.zzbwq     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x0142
            throw r13     // Catch:{ all -> 0x0021 }
        L_0x0142:
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x0021 }
            android.view.ViewParent r2 = r1.getParent()     // Catch:{ all -> 0x0021 }
            if (r2 == 0) goto L_0x01d7
            boolean r1 = r2 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x01d7
            r0 = r2
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ all -> 0x0021 }
            r1 = r0
            com.google.android.gms.internal.zzama r3 = r14.zzbwq     // Catch:{ all -> 0x0021 }
            if (r3 != 0) goto L_0x0157
            throw r13     // Catch:{ all -> 0x0021 }
        L_0x0157:
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x0021 }
            r1.removeView(r3)     // Catch:{ all -> 0x0021 }
            android.widget.PopupWindow r1 = r14.zzcfg     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x01d1
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ all -> 0x0021 }
            r14.zzcfi = r2     // Catch:{ all -> 0x0021 }
            com.google.android.gms.ads.internal.zzbs.zzec()     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzama r1 = r14.zzbwq     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x016c
            throw r13     // Catch:{ all -> 0x0021 }
        L_0x016c:
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x0021 }
            android.graphics.Bitmap r1 = com.google.android.gms.internal.zzagr.zzm(r1)     // Catch:{ all -> 0x0021 }
            android.widget.ImageView r2 = new android.widget.ImageView     // Catch:{ all -> 0x0021 }
            android.app.Activity r3 = r14.zzcem     // Catch:{ all -> 0x0021 }
            r2.<init>(r3)     // Catch:{ all -> 0x0021 }
            r14.zzcfd = r2     // Catch:{ all -> 0x0021 }
            android.widget.ImageView r2 = r14.zzcfd     // Catch:{ all -> 0x0021 }
            r2.setImageBitmap(r1)     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzama r1 = r14.zzbwq     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzanp r1 = r1.zzso()     // Catch:{ all -> 0x0021 }
            r14.zzcfc = r1     // Catch:{ all -> 0x0021 }
            android.view.ViewGroup r1 = r14.zzcfi     // Catch:{ all -> 0x0021 }
            android.widget.ImageView r2 = r14.zzcfd     // Catch:{ all -> 0x0021 }
            r1.addView(r2)     // Catch:{ all -> 0x0021 }
        L_0x018f:
            android.widget.RelativeLayout r1 = new android.widget.RelativeLayout     // Catch:{ all -> 0x0021 }
            android.app.Activity r2 = r14.zzcem     // Catch:{ all -> 0x0021 }
            r1.<init>(r2)     // Catch:{ all -> 0x0021 }
            r14.zzcfh = r1     // Catch:{ all -> 0x0021 }
            android.widget.RelativeLayout r1 = r14.zzcfh     // Catch:{ all -> 0x0021 }
            r2 = 0
            r1.setBackgroundColor(r2)     // Catch:{ all -> 0x0021 }
            android.widget.RelativeLayout r1 = r14.zzcfh     // Catch:{ all -> 0x0021 }
            android.view.ViewGroup$LayoutParams r2 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x0021 }
            r2.<init>(r10, r11)     // Catch:{ all -> 0x0021 }
            r1.setLayoutParams(r2)     // Catch:{ all -> 0x0021 }
            com.google.android.gms.ads.internal.zzbs.zzec()     // Catch:{ all -> 0x0021 }
            android.widget.RelativeLayout r1 = r14.zzcfh     // Catch:{ all -> 0x0021 }
            r2 = 0
            android.widget.PopupWindow r1 = com.google.android.gms.internal.zzagr.zza((android.view.View) r1, (int) r10, (int) r11, (boolean) r2)     // Catch:{ all -> 0x0021 }
            r14.zzcfg = r1     // Catch:{ all -> 0x0021 }
            android.widget.PopupWindow r1 = r14.zzcfg     // Catch:{ all -> 0x0021 }
            r2 = 1
            r1.setOutsideTouchable(r2)     // Catch:{ all -> 0x0021 }
            android.widget.PopupWindow r1 = r14.zzcfg     // Catch:{ all -> 0x0021 }
            r2 = 1
            r1.setTouchable(r2)     // Catch:{ all -> 0x0021 }
            android.widget.PopupWindow r2 = r14.zzcfg     // Catch:{ all -> 0x0021 }
            boolean r1 = r14.zzcex     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x01df
            r1 = r6
        L_0x01c7:
            r2.setClippingEnabled(r1)     // Catch:{ all -> 0x0021 }
            android.widget.RelativeLayout r2 = r14.zzcfh     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzama r1 = r14.zzbwq     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x01e1
            throw r13     // Catch:{ all -> 0x0021 }
        L_0x01d1:
            android.widget.PopupWindow r1 = r14.zzcfg     // Catch:{ all -> 0x0021 }
            r1.dismiss()     // Catch:{ all -> 0x0021 }
            goto L_0x018f
        L_0x01d7:
            java.lang.String r1 = "Webview is detached, probably in the middle of a resize or expand."
            r14.zzbl(r1)     // Catch:{ all -> 0x0021 }
            monitor-exit(r7)     // Catch:{ all -> 0x0021 }
            goto L_0x0011
        L_0x01df:
            r1 = r4
            goto L_0x01c7
        L_0x01e1:
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x0021 }
            r3 = -1
            r12 = -1
            r2.addView(r1, r3, r12)     // Catch:{ all -> 0x0021 }
            android.widget.LinearLayout r1 = new android.widget.LinearLayout     // Catch:{ all -> 0x0021 }
            android.app.Activity r2 = r14.zzcem     // Catch:{ all -> 0x0021 }
            r1.<init>(r2)     // Catch:{ all -> 0x0021 }
            r14.zzcfe = r1     // Catch:{ all -> 0x0021 }
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzjk.zzhx()     // Catch:{ all -> 0x0021 }
            android.app.Activity r1 = r14.zzcem     // Catch:{ all -> 0x0021 }
            r3 = 50
            int r1 = com.google.android.gms.internal.zzais.zzc(r1, r3)     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzjk.zzhx()     // Catch:{ all -> 0x0021 }
            android.app.Activity r3 = r14.zzcem     // Catch:{ all -> 0x0021 }
            r12 = 50
            int r3 = com.google.android.gms.internal.zzais.zzc(r3, r12)     // Catch:{ all -> 0x0021 }
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = r14.zzcew     // Catch:{ all -> 0x0021 }
            int r3 = r1.hashCode()     // Catch:{ all -> 0x0021 }
            switch(r3) {
                case -1364013995: goto L_0x029f;
                case -1012429441: goto L_0x028a;
                case -655373719: goto L_0x02aa;
                case 1163912186: goto L_0x02c0;
                case 1288627767: goto L_0x02b5;
                case 1755462605: goto L_0x0294;
                default: goto L_0x0215;
            }     // Catch:{ all -> 0x0021 }
        L_0x0215:
            r1 = r5
        L_0x0216:
            switch(r1) {
                case 0: goto L_0x02cb;
                case 1: goto L_0x02d7;
                case 2: goto L_0x02e3;
                case 3: goto L_0x02ea;
                case 4: goto L_0x02f6;
                case 5: goto L_0x0302;
                default: goto L_0x0219;
            }     // Catch:{ all -> 0x0021 }
        L_0x0219:
            r1 = 10
            r2.addRule(r1)     // Catch:{ all -> 0x0021 }
            r1 = 11
            r2.addRule(r1)     // Catch:{ all -> 0x0021 }
        L_0x0223:
            android.widget.LinearLayout r1 = r14.zzcfe     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzvx r3 = new com.google.android.gms.internal.zzvx     // Catch:{ all -> 0x0021 }
            r3.<init>(r14)     // Catch:{ all -> 0x0021 }
            r1.setOnClickListener(r3)     // Catch:{ all -> 0x0021 }
            android.widget.LinearLayout r1 = r14.zzcfe     // Catch:{ all -> 0x0021 }
            java.lang.String r3 = "Close button"
            r1.setContentDescription(r3)     // Catch:{ all -> 0x0021 }
            android.widget.RelativeLayout r1 = r14.zzcfh     // Catch:{ all -> 0x0021 }
            android.widget.LinearLayout r3 = r14.zzcfe     // Catch:{ all -> 0x0021 }
            r1.addView(r3, r2)     // Catch:{ all -> 0x0021 }
            android.widget.PopupWindow r1 = r14.zzcfg     // Catch:{ RuntimeException -> 0x030e }
            android.view.View r2 = r8.getDecorView()     // Catch:{ RuntimeException -> 0x030e }
            r3 = 0
            com.google.android.gms.internal.zzjk.zzhx()     // Catch:{ RuntimeException -> 0x030e }
            android.app.Activity r4 = r14.zzcem     // Catch:{ RuntimeException -> 0x030e }
            r5 = 0
            r5 = r9[r5]     // Catch:{ RuntimeException -> 0x030e }
            int r4 = com.google.android.gms.internal.zzais.zzc(r4, r5)     // Catch:{ RuntimeException -> 0x030e }
            com.google.android.gms.internal.zzjk.zzhx()     // Catch:{ RuntimeException -> 0x030e }
            android.app.Activity r5 = r14.zzcem     // Catch:{ RuntimeException -> 0x030e }
            r6 = 1
            r6 = r9[r6]     // Catch:{ RuntimeException -> 0x030e }
            int r5 = com.google.android.gms.internal.zzais.zzc(r5, r6)     // Catch:{ RuntimeException -> 0x030e }
            r1.showAtLocation(r2, r3, r4, r5)     // Catch:{ RuntimeException -> 0x030e }
            r1 = 0
            r1 = r9[r1]     // Catch:{ all -> 0x0021 }
            r2 = 1
            r2 = r9[r2]     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzwh r3 = r14.zzcff     // Catch:{ all -> 0x0021 }
            if (r3 == 0) goto L_0x0270
            com.google.android.gms.internal.zzwh r3 = r14.zzcff     // Catch:{ all -> 0x0021 }
            int r4 = r14.zzakw     // Catch:{ all -> 0x0021 }
            int r5 = r14.zzakx     // Catch:{ all -> 0x0021 }
            r3.zza(r1, r2, r4, r5)     // Catch:{ all -> 0x0021 }
        L_0x0270:
            com.google.android.gms.internal.zzama r1 = r14.zzbwq     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzanp r2 = com.google.android.gms.internal.zzanp.zzi(r10, r11)     // Catch:{ all -> 0x0021 }
            r1.zza((com.google.android.gms.internal.zzanp) r2)     // Catch:{ all -> 0x0021 }
            r1 = 0
            r1 = r9[r1]     // Catch:{ all -> 0x0021 }
            r2 = 1
            r2 = r9[r2]     // Catch:{ all -> 0x0021 }
            r14.zza(r1, r2)     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = "resized"
            r14.zzbn(r1)     // Catch:{ all -> 0x0021 }
            monitor-exit(r7)     // Catch:{ all -> 0x0021 }
            goto L_0x0011
        L_0x028a:
            java.lang.String r3 = "top-left"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0215
            r1 = r4
            goto L_0x0216
        L_0x0294:
            java.lang.String r3 = "top-center"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0215
            r1 = r6
            goto L_0x0216
        L_0x029f:
            java.lang.String r3 = "center"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0215
            r1 = 2
            goto L_0x0216
        L_0x02aa:
            java.lang.String r3 = "bottom-left"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0215
            r1 = 3
            goto L_0x0216
        L_0x02b5:
            java.lang.String r3 = "bottom-center"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0215
            r1 = 4
            goto L_0x0216
        L_0x02c0:
            java.lang.String r3 = "bottom-right"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0215
            r1 = 5
            goto L_0x0216
        L_0x02cb:
            r1 = 10
            r2.addRule(r1)     // Catch:{ all -> 0x0021 }
            r1 = 9
            r2.addRule(r1)     // Catch:{ all -> 0x0021 }
            goto L_0x0223
        L_0x02d7:
            r1 = 10
            r2.addRule(r1)     // Catch:{ all -> 0x0021 }
            r1 = 14
            r2.addRule(r1)     // Catch:{ all -> 0x0021 }
            goto L_0x0223
        L_0x02e3:
            r1 = 13
            r2.addRule(r1)     // Catch:{ all -> 0x0021 }
            goto L_0x0223
        L_0x02ea:
            r1 = 12
            r2.addRule(r1)     // Catch:{ all -> 0x0021 }
            r1 = 9
            r2.addRule(r1)     // Catch:{ all -> 0x0021 }
            goto L_0x0223
        L_0x02f6:
            r1 = 12
            r2.addRule(r1)     // Catch:{ all -> 0x0021 }
            r1 = 14
            r2.addRule(r1)     // Catch:{ all -> 0x0021 }
            goto L_0x0223
        L_0x0302:
            r1 = 12
            r2.addRule(r1)     // Catch:{ all -> 0x0021 }
            r1 = 11
            r2.addRule(r1)     // Catch:{ all -> 0x0021 }
            goto L_0x0223
        L_0x030e:
            r1 = move-exception
            java.lang.String r2 = "Cannot show popup window: "
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0021 }
            int r3 = r1.length()     // Catch:{ all -> 0x0021 }
            if (r3 == 0) goto L_0x032d
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x0021 }
        L_0x0323:
            r14.zzbl(r1)     // Catch:{ all -> 0x0021 }
            android.widget.RelativeLayout r2 = r14.zzcfh     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzama r1 = r14.zzbwq     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x0333
            throw r13     // Catch:{ all -> 0x0021 }
        L_0x032d:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0021 }
            r1.<init>(r2)     // Catch:{ all -> 0x0021 }
            goto L_0x0323
        L_0x0333:
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x0021 }
            r2.removeView(r1)     // Catch:{ all -> 0x0021 }
            android.view.ViewGroup r1 = r14.zzcfi     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0356
            android.view.ViewGroup r1 = r14.zzcfi     // Catch:{ all -> 0x0021 }
            android.widget.ImageView r2 = r14.zzcfd     // Catch:{ all -> 0x0021 }
            r1.removeView(r2)     // Catch:{ all -> 0x0021 }
            android.view.ViewGroup r2 = r14.zzcfi     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzama r1 = r14.zzbwq     // Catch:{ all -> 0x0021 }
            if (r1 != 0) goto L_0x034a
            throw r13     // Catch:{ all -> 0x0021 }
        L_0x034a:
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x0021 }
            r2.addView(r1)     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzama r1 = r14.zzbwq     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.zzanp r2 = r14.zzcfc     // Catch:{ all -> 0x0021 }
            r1.zza((com.google.android.gms.internal.zzanp) r2)     // Catch:{ all -> 0x0021 }
        L_0x0356:
            monitor-exit(r7)     // Catch:{ all -> 0x0021 }
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzvw.execute(java.util.Map):void");
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.mLock) {
            this.zzcey = i;
            this.zzcez = i2;
            if (this.zzcfg != null && z) {
                int[] zzmk = zzmk();
                if (zzmk != null) {
                    PopupWindow popupWindow = this.zzcfg;
                    zzjk.zzhx();
                    int zzc = zzais.zzc(this.zzcem, zzmk[0]);
                    zzjk.zzhx();
                    popupWindow.update(zzc, zzais.zzc(this.zzcem, zzmk[1]), this.zzcfg.getWidth(), this.zzcfg.getHeight());
                    zza(zzmk[0], zzmk[1]);
                } else {
                    zzl(true);
                }
            }
        }
    }

    public final void zzb(int i, int i2) {
        this.zzcey = i;
        this.zzcez = i2;
    }

    public final void zzl(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcfg != null) {
                this.zzcfg.dismiss();
                RelativeLayout relativeLayout = this.zzcfh;
                zzama zzama = this.zzbwq;
                if (zzama == null) {
                    throw null;
                }
                relativeLayout.removeView((View) zzama);
                if (this.zzcfi != null) {
                    this.zzcfi.removeView(this.zzcfd);
                    ViewGroup viewGroup = this.zzcfi;
                    zzama zzama2 = this.zzbwq;
                    if (zzama2 == null) {
                        throw null;
                    }
                    viewGroup.addView((View) zzama2);
                    this.zzbwq.zza(this.zzcfc);
                }
                if (z) {
                    zzbn("default");
                    if (this.zzcff != null) {
                        this.zzcff.zzco();
                    }
                }
                this.zzcfg = null;
                this.zzcfh = null;
                this.zzcfi = null;
                this.zzcfe = null;
            }
        }
    }

    public final boolean zzml() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcfg != null;
        }
        return z;
    }
}
