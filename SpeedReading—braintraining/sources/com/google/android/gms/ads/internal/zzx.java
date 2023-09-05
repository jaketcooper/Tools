package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzaeh;
import com.google.android.gms.internal.zzaek;
import com.google.android.gms.internal.zzaeu;
import com.google.android.gms.internal.zzaev;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzamj;
import com.google.android.gms.internal.zzamm;
import com.google.android.gms.internal.zzanp;
import com.google.android.gms.internal.zzfy;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzuc;
import com.google.android.gms.internal.zzuo;
import com.google.android.gms.internal.zzur;
import com.google.android.gms.internal.zzzb;
import java.lang.ref.WeakReference;
import java.util.List;

@zzzb
public final class zzx extends zzi implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private boolean zzals;
    private WeakReference<Object> zzanx = new WeakReference<>((Object) null);

    public zzx(Context context, zziw zziw, String str, zzuc zzuc, zzaiy zzaiy, zzv zzv) {
        super(context, zziw, str, zzuc, zzaiy, zzv);
    }

    private final boolean zzd(@Nullable zzaeu zzaeu, zzaeu zzaeu2) {
        if (zzaeu2.zzcng) {
            View zze = zzaq.zze(zzaeu2);
            if (zze == null) {
                zzafj.zzco("Could not get mediation view");
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
                    if (zzbs.zzfa().zzs(this.zzamt.zzaif)) {
                        new zzfy(this.zzamt.zzaif, zze).zza((zzgc) new zzaek(this.zzamt.zzaif, this.zzamt.zzatb));
                    }
                    if (zzaeu2.zzcvu != null) {
                        this.zzamt.zzate.setMinimumWidth(zzaeu2.zzcvu.widthPixels);
                        this.zzamt.zzate.setMinimumHeight(zzaeu2.zzcvu.heightPixels);
                    }
                    zzb(zze);
                } catch (Exception e) {
                    zzbs.zzeg().zza((Throwable) e, "BannerAdManager.swapViews");
                    zzafj.zzc("Could not add mediation view to view hierarchy.", e);
                    return false;
                }
            }
        } else if (!(zzaeu2.zzcvu == null || zzaeu2.zzchj == null)) {
            zzaeu2.zzchj.zza(zzanp.zzc(zzaeu2.zzcvu));
            this.zzamt.zzate.removeAllViews();
            this.zzamt.zzate.setMinimumWidth(zzaeu2.zzcvu.widthPixels);
            this.zzamt.zzate.setMinimumHeight(zzaeu2.zzcvu.heightPixels);
            zzama zzama = zzaeu2.zzchj;
            if (zzama == null) {
                throw null;
            }
            zzb((View) zzama);
        }
        if (this.zzamt.zzate.getChildCount() > 1) {
            this.zzamt.zzate.showNext();
        }
        if (zzaeu != null) {
            View nextView2 = this.zzamt.zzate.getNextView();
            if (nextView2 instanceof zzama) {
                ((zzama) nextView2).destroy();
            } else if (nextView2 != null) {
                this.zzamt.zzate.removeView(nextView2);
            }
            this.zzamt.zzff();
        }
        this.zzamt.zzate.setVisibility(0);
        return true;
    }

    @Nullable
    public final zzku getVideoController() {
        zzbq.zzga("getVideoController must be called from the main thread.");
        if (this.zzamt.zzati == null || this.zzamt.zzati.zzchj == null) {
            return null;
        }
        return this.zzamt.zzati.zzchj.zzrx();
    }

    public final void onGlobalLayout() {
        zzd(this.zzamt.zzati);
    }

    public final void onScrollChanged() {
        zzd(this.zzamt.zzati);
    }

    public final void setManualImpressionsEnabled(boolean z) {
        zzbq.zzga("setManualImpressionsEnabled must be called from the main thread.");
        this.zzals = z;
    }

    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    /* access modifiers changed from: protected */
    public final zzama zza(zzaev zzaev, @Nullable zzw zzw, @Nullable zzaeh zzaeh) throws zzamm {
        AdSize zzhq;
        zziw zziw;
        if (this.zzamt.zzath.zzbdc == null && this.zzamt.zzath.zzbde) {
            zzbt zzbt = this.zzamt;
            if (zzaev.zzcwe.zzbde) {
                zziw = this.zzamt.zzath;
            } else {
                String str = zzaev.zzcwe.zzcnj;
                if (str != null) {
                    String[] split = str.split("[xX]");
                    split[0] = split[0].trim();
                    split[1] = split[1].trim();
                    zzhq = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                } else {
                    zzhq = this.zzamt.zzath.zzhq();
                }
                zziw = new zziw(this.zzamt.zzaif, zzhq);
            }
            zzbt.zzath = zziw;
        }
        return super.zza(zzaev, zzw, zzaeh);
    }

    /* access modifiers changed from: protected */
    public final void zza(@Nullable zzaeu zzaeu, boolean z) {
        View view;
        super.zza(zzaeu, z);
        if (zzaq.zzf(zzaeu)) {
            zzab zzab = new zzab(this);
            if (zzaeu != null && zzaq.zzf(zzaeu)) {
                zzama zzama = zzaeu.zzchj;
                if (zzama == null) {
                    view = null;
                } else if (zzama == null) {
                    throw null;
                } else {
                    view = (View) zzama;
                }
                if (view == null) {
                    zzafj.zzco("AdWebView is null");
                    return;
                }
                try {
                    List<String> list = zzaeu.zzcdd != null ? zzaeu.zzcdd.zzcbq : null;
                    if (list == null || list.isEmpty()) {
                        zzafj.zzco("No template ids present in mediation response");
                        return;
                    }
                    zzuo zzly = zzaeu.zzcde != null ? zzaeu.zzcde.zzly() : null;
                    zzur zzlz = zzaeu.zzcde != null ? zzaeu.zzcde.zzlz() : null;
                    if (list.contains("2") && zzly != null) {
                        zzly.zzi(zzn.zzy(view));
                        if (!zzly.getOverrideImpressionRecording()) {
                            zzly.recordImpression();
                        }
                        zzama.zzsq().zza("/nativeExpressViewClicked", (zzt<? super zzama>) zzaq.zza(zzly, (zzur) null, zzab));
                    } else if (!list.contains("1") || zzlz == null) {
                        zzafj.zzco("No matching template id and mapper");
                    } else {
                        zzlz.zzi(zzn.zzy(view));
                        if (!zzlz.getOverrideImpressionRecording()) {
                            zzlz.recordImpression();
                        }
                        zzama.zzsq().zza("/nativeExpressViewClicked", (zzt<? super zzama>) zzaq.zza((zzuo) null, zzlz, zzab));
                    }
                } catch (RemoteException e) {
                    zzafj.zzc("Error occurred while recording impression and registering for clicks", e);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c2, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.zzbs.zzep().zzd(com.google.android.gms.internal.zzmq.zzbmr)).booleanValue() != false) goto L_0x00c4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(@android.support.annotation.Nullable com.google.android.gms.internal.zzaeu r5, com.google.android.gms.internal.zzaeu r6) {
        /*
            r4 = this;
            r2 = 0
            r1 = 0
            boolean r0 = super.zza((com.google.android.gms.internal.zzaeu) r5, (com.google.android.gms.internal.zzaeu) r6)
            if (r0 != 0) goto L_0x000a
            r0 = r1
        L_0x0009:
            return r0
        L_0x000a:
            com.google.android.gms.ads.internal.zzbt r0 = r4.zzamt
            boolean r0 = r0.zzfg()
            if (r0 == 0) goto L_0x0028
            boolean r0 = r4.zzd(r5, r6)
            if (r0 != 0) goto L_0x0028
            com.google.android.gms.internal.zzib r0 = r6.zzcwc
            if (r0 == 0) goto L_0x0023
            com.google.android.gms.internal.zzib r0 = r6.zzcwc
            com.google.android.gms.internal.zzid$zza$zzb r2 = com.google.android.gms.internal.zzid.zza.zzb.AD_FAILED_TO_LOAD
            r0.zza((com.google.android.gms.internal.zzid.zza.zzb) r2)
        L_0x0023:
            r4.zzi(r1)
            r0 = r1
            goto L_0x0009
        L_0x0028:
            boolean r0 = r6.zzcny
            if (r0 == 0) goto L_0x00aa
            r4.zzd(r6)
            com.google.android.gms.ads.internal.zzbs.zzez()
            com.google.android.gms.ads.internal.zzbt r0 = r4.zzamt
            com.google.android.gms.ads.internal.zzbu r0 = r0.zzate
            com.google.android.gms.internal.zzakg.zza((android.view.View) r0, (android.view.ViewTreeObserver.OnGlobalLayoutListener) r4)
            com.google.android.gms.ads.internal.zzbs.zzez()
            com.google.android.gms.ads.internal.zzbt r0 = r4.zzamt
            com.google.android.gms.ads.internal.zzbu r0 = r0.zzate
            com.google.android.gms.internal.zzakg.zza((android.view.View) r0, (android.view.ViewTreeObserver.OnScrollChangedListener) r4)
            boolean r0 = r6.zzcvr
            if (r0 != 0) goto L_0x0060
            com.google.android.gms.ads.internal.zzy r1 = new com.google.android.gms.ads.internal.zzy
            r1.<init>(r4)
            com.google.android.gms.internal.zzama r0 = r6.zzchj
            if (r0 == 0) goto L_0x00a8
            com.google.android.gms.internal.zzama r0 = r6.zzchj
            com.google.android.gms.internal.zzamb r0 = r0.zzsq()
        L_0x0056:
            if (r0 == 0) goto L_0x0060
            com.google.android.gms.ads.internal.zzz r3 = new com.google.android.gms.ads.internal.zzz
            r3.<init>(r4, r6, r1)
            r0.zza((com.google.android.gms.internal.zzamj) r3)
        L_0x0060:
            com.google.android.gms.internal.zzama r0 = r6.zzchj
            if (r0 == 0) goto L_0x0084
            com.google.android.gms.internal.zzama r0 = r6.zzchj
            com.google.android.gms.internal.zzamr r0 = r0.zzrx()
            com.google.android.gms.internal.zzama r1 = r6.zzchj
            com.google.android.gms.internal.zzamb r1 = r1.zzsq()
            if (r1 == 0) goto L_0x0075
            r1.zztk()
        L_0x0075:
            com.google.android.gms.ads.internal.zzbt r1 = r4.zzamt
            com.google.android.gms.internal.zzma r1 = r1.zzatu
            if (r1 == 0) goto L_0x0084
            if (r0 == 0) goto L_0x0084
            com.google.android.gms.ads.internal.zzbt r1 = r4.zzamt
            com.google.android.gms.internal.zzma r1 = r1.zzatu
            r0.zzb((com.google.android.gms.internal.zzma) r1)
        L_0x0084:
            com.google.android.gms.ads.internal.zzbt r0 = r4.zzamt
            boolean r0 = r0.zzfg()
            if (r0 == 0) goto L_0x011a
            com.google.android.gms.internal.zzama r0 = r6.zzchj
            if (r0 == 0) goto L_0x0108
            org.json.JSONObject r0 = r6.zzcvq
            if (r0 == 0) goto L_0x009d
            com.google.android.gms.internal.zzfb r0 = r4.zzamv
            com.google.android.gms.ads.internal.zzbt r1 = r4.zzamt
            com.google.android.gms.internal.zziw r1 = r1.zzath
            r0.zza(r1, r6)
        L_0x009d:
            com.google.android.gms.internal.zzfy r1 = new com.google.android.gms.internal.zzfy
            com.google.android.gms.ads.internal.zzbt r0 = r4.zzamt
            android.content.Context r3 = r0.zzaif
            com.google.android.gms.internal.zzama r0 = r6.zzchj
            if (r0 != 0) goto L_0x00c8
            throw r2
        L_0x00a8:
            r0 = r2
            goto L_0x0056
        L_0x00aa:
            com.google.android.gms.ads.internal.zzbt r0 = r4.zzamt
            boolean r0 = r0.zzfh()
            if (r0 == 0) goto L_0x00c4
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbmr
            com.google.android.gms.internal.zzmo r3 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0060
        L_0x00c4:
            r4.zza((com.google.android.gms.internal.zzaeu) r6, (boolean) r1)
            goto L_0x0060
        L_0x00c8:
            android.view.View r0 = (android.view.View) r0
            r1.<init>(r3, r0)
            com.google.android.gms.internal.zzael r0 = com.google.android.gms.ads.internal.zzbs.zzfa()
            com.google.android.gms.ads.internal.zzbt r2 = r4.zzamt
            android.content.Context r2 = r2.zzaif
            boolean r0 = r0.zzs(r2)
            if (r0 == 0) goto L_0x00fd
            com.google.android.gms.internal.zzis r0 = r6.zzclo
            boolean r0 = zza((com.google.android.gms.internal.zzis) r0)
            if (r0 == 0) goto L_0x00fd
            com.google.android.gms.ads.internal.zzbt r0 = r4.zzamt
            java.lang.String r0 = r0.zzatb
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00fd
            com.google.android.gms.internal.zzaek r0 = new com.google.android.gms.internal.zzaek
            com.google.android.gms.ads.internal.zzbt r2 = r4.zzamt
            android.content.Context r2 = r2.zzaif
            com.google.android.gms.ads.internal.zzbt r3 = r4.zzamt
            java.lang.String r3 = r3.zzatb
            r0.<init>(r2, r3)
            r1.zza((com.google.android.gms.internal.zzgc) r0)
        L_0x00fd:
            boolean r0 = r6.zzfr()
            if (r0 == 0) goto L_0x010b
            com.google.android.gms.internal.zzama r0 = r6.zzchj
            r1.zza((com.google.android.gms.internal.zzgc) r0)
        L_0x0108:
            r0 = 1
            goto L_0x0009
        L_0x010b:
            com.google.android.gms.internal.zzama r0 = r6.zzchj
            com.google.android.gms.internal.zzamb r0 = r0.zzsq()
            com.google.android.gms.ads.internal.zzaa r2 = new com.google.android.gms.ads.internal.zzaa
            r2.<init>(r4, r1, r6)
            r0.zza((com.google.android.gms.internal.zzamh) r2)
            goto L_0x0108
        L_0x011a:
            com.google.android.gms.ads.internal.zzbt r0 = r4.zzamt
            android.view.View r0 = r0.zzaud
            if (r0 == 0) goto L_0x0108
            org.json.JSONObject r0 = r6.zzcvq
            if (r0 == 0) goto L_0x0108
            com.google.android.gms.internal.zzfb r0 = r4.zzamv
            com.google.android.gms.ads.internal.zzbt r1 = r4.zzamt
            com.google.android.gms.internal.zziw r1 = r1.zzath
            com.google.android.gms.ads.internal.zzbt r2 = r4.zzamt
            android.view.View r2 = r2.zzaud
            r0.zza(r1, r6, r2)
            goto L_0x0108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzx.zza(com.google.android.gms.internal.zzaeu, com.google.android.gms.internal.zzaeu):boolean");
    }

    public final boolean zzb(zzis zzis) {
        if (zzis.zzbca != this.zzals) {
            zzis = new zzis(zzis.versionCode, zzis.zzbbv, zzis.extras, zzis.zzbbw, zzis.zzbbx, zzis.zzbby, zzis.zzbbz, zzis.zzbca || this.zzals, zzis.zzbcb, zzis.zzbcc, zzis.zzbcd, zzis.zzbce, zzis.zzbcf, zzis.zzbcg, zzis.zzbch, zzis.zzbci, zzis.zzbcj, zzis.zzbck);
        }
        return super.zzb(zzis);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbz() {
        boolean z = true;
        zzbs.zzec();
        if (!zzagr.zzd(this.zzamt.zzaif, this.zzamt.zzaif.getPackageName(), "android.permission.INTERNET")) {
            zzjk.zzhx().zza(this.zzamt.zzate, this.zzamt.zzath, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        zzbs.zzec();
        if (!zzagr.zzag(this.zzamt.zzaif)) {
            zzjk.zzhx().zza(this.zzamt.zzate, this.zzamt.zzath, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.zzamt.zzate != null) {
            this.zzamt.zzate.setVisibility(0);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(@Nullable zzaeu zzaeu) {
        if (zzaeu != null && !zzaeu.zzcvr && this.zzamt.zzate != null && zzbs.zzec().zza((View) this.zzamt.zzate, this.zzamt.zzaif) && this.zzamt.zzate.getGlobalVisibleRect(new Rect(), (Point) null)) {
            if (!(zzaeu == null || zzaeu.zzchj == null || zzaeu.zzchj.zzsq() == null)) {
                zzaeu.zzchj.zzsq().zza((zzamj) null);
            }
            zza(zzaeu, false);
            zzaeu.zzcvr = true;
        }
    }
}
