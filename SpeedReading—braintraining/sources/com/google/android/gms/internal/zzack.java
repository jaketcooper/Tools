package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzbt;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzack extends zzd implements zzadl {
    private static zzack zzctf;
    private static final zzub zzctg = new zzub();
    private boolean zzapj;
    private zzaek zzapk;
    private final Map<String, zzadr> zzcth = new HashMap();
    private boolean zzcti;

    public zzack(Context context, zzv zzv, zziw zziw, zzuc zzuc, zzaiy zzaiy) {
        super(context, zziw, (String) null, zzuc, zzaiy, zzv);
        zzctf = this;
        this.zzapk = new zzaek(context, (String) null);
    }

    private static zzaev zzc(zzaev zzaev) {
        zzafj.m11v("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String jSONObject = zzabm.zzb(zzaev.zzcwe).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zzaev.zzcpe.zzatb);
            return new zzaev(zzaev.zzcpe, zzaev.zzcwe, new zztn(Arrays.asList(new zztm[]{new zztm(jSONObject, (String) null, Arrays.asList(new String[]{"com.google.ads.mediation.admob.AdMobAdapter"}), (String) null, (String) null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), (String) null, Collections.emptyList(), Collections.emptyList(), (String) null, (String) null, (String) null, (List<String>) null, (String) null, Collections.emptyList(), (String) null)}), ((Long) zzbs.zzep().zzd(zzmq.zzblt)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1, 0, 1, (String) null, 0, -1, -1, false), zzaev.zzath, zzaev.errorCode, zzaev.zzcvw, zzaev.zzcvx, zzaev.zzcvq, zzaev.zzcwc, (Boolean) null);
        } catch (JSONException e) {
            zzafj.zzb("Unable to generate ad state for non-mediated rewarded video.", e);
            return new zzaev(zzaev.zzcpe, zzaev.zzcwe, (zztn) null, zzaev.zzath, 0, zzaev.zzcvw, zzaev.zzcvx, zzaev.zzcvq, zzaev.zzcwc, (Boolean) null);
        }
    }

    public static zzack zznu() {
        return zzctf;
    }

    public final void destroy() {
        zzbq.zzga("destroy must be called on the main UI thread.");
        for (String next : this.zzcth.keySet()) {
            try {
                zzadr zzadr = this.zzcth.get(next);
                if (!(zzadr == null || zzadr.zzoc() == null)) {
                    zzadr.zzoc().destroy();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(next);
                zzafj.zzco(valueOf.length() != 0 ? "Fail to destroy adapter: ".concat(valueOf) : new String("Fail to destroy adapter: "));
            }
        }
    }

    public final boolean isLoaded() {
        zzbq.zzga("isLoaded must be called on the main UI thread.");
        return this.zzamt.zzatf == null && this.zzamt.zzatg == null && this.zzamt.zzati != null && !this.zzcti;
    }

    public final void onContextChanged(@NonNull Context context) {
        for (zzadr zzoc : this.zzcth.values()) {
            try {
                zzoc.zzoc().zzg(zzn.zzy(context));
            } catch (RemoteException e) {
                zzafj.zzb("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    public final void onRewardedVideoAdClosed() {
        if (zzbs.zzfa().zzv(this.zzamt.zzaif)) {
            this.zzapk.zzu(false);
        }
        zzbp();
    }

    public final void onRewardedVideoAdLeftApplication() {
        zzbq();
    }

    public final void onRewardedVideoAdOpened() {
        if (zzbs.zzfa().zzv(this.zzamt.zzaif)) {
            this.zzapk.zzu(true);
        }
        zza(this.zzamt.zzati, false);
        zzbr();
    }

    public final void onRewardedVideoStarted() {
        if (!(this.zzamt.zzati == null || this.zzamt.zzati.zzcdd == null)) {
            zzbs.zzew();
            zztv.zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, this.zzamt.zzati, this.zzamt.zzatb, false, this.zzamt.zzati.zzcdd.zzcbl);
        }
        zzbv();
    }

    public final void pause() {
        zzbq.zzga("pause must be called on the main UI thread.");
        for (String next : this.zzcth.keySet()) {
            try {
                zzadr zzadr = this.zzcth.get(next);
                if (!(zzadr == null || zzadr.zzoc() == null)) {
                    zzadr.zzoc().pause();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(next);
                zzafj.zzco(valueOf.length() != 0 ? "Fail to pause adapter: ".concat(valueOf) : new String("Fail to pause adapter: "));
            }
        }
    }

    public final void resume() {
        zzbq.zzga("resume must be called on the main UI thread.");
        for (String next : this.zzcth.keySet()) {
            try {
                zzadr zzadr = this.zzcth.get(next);
                if (!(zzadr == null || zzadr.zzoc() == null)) {
                    zzadr.zzoc().resume();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(next);
                zzafj.zzco(valueOf.length() != 0 ? "Fail to resume adapter: ".concat(valueOf) : new String("Fail to resume adapter: "));
            }
        }
    }

    public final void setImmersiveMode(boolean z) {
        zzbq.zzga("setImmersiveMode must be called on the main UI thread.");
        this.zzapj = z;
    }

    public final void zza(zzadb zzadb) {
        zzbq.zzga("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(zzadb.zzatb)) {
            zzafj.zzco("Invalid ad unit id. Aborting.");
            zzagr.zzczc.post(new zzacl(this));
            return;
        }
        this.zzcti = false;
        this.zzamt.zzatb = zzadb.zzatb;
        this.zzapk.setAdUnitId(zzadb.zzatb);
        super.zzb(zzadb.zzclo);
    }

    public final void zza(zzaev zzaev, zznd zznd) {
        if (zzaev.errorCode != -2) {
            zzagr.zzczc.post(new zzacm(this, zzaev));
            return;
        }
        this.zzamt.zzatj = zzaev;
        if (zzaev.zzcvs == null) {
            this.zzamt.zzatj = zzc(zzaev);
        }
        this.zzamt.zzaue = 0;
        zzbt zzbt = this.zzamt;
        zzbs.zzeb();
        zzado zzado = new zzado(this.zzamt.zzaif, this.zzamt.zzatj, this);
        String valueOf = String.valueOf(zzado.getClass().getName());
        zzafj.zzbw(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
        zzado.zzmx();
        zzbt.zzatg = zzado;
    }

    public final boolean zza(zzaeu zzaeu, zzaeu zzaeu2) {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzis zzis, zzaeu zzaeu, boolean z) {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zzadr zzbp(java.lang.String r6) {
        /*
            r5 = this;
            java.util.Map<java.lang.String, com.google.android.gms.internal.zzadr> r0 = r5.zzcth
            java.lang.Object r0 = r0.get(r6)
            com.google.android.gms.internal.zzadr r0 = (com.google.android.gms.internal.zzadr) r0
            if (r0 != 0) goto L_0x0026
            com.google.android.gms.internal.zzuc r1 = r5.zzanb     // Catch:{ Exception -> 0x0027 }
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobAdapter"
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x0027 }
            if (r2 == 0) goto L_0x0048
            com.google.android.gms.internal.zzub r1 = zzctg     // Catch:{ Exception -> 0x0027 }
            r2 = r1
        L_0x0017:
            com.google.android.gms.internal.zzadr r1 = new com.google.android.gms.internal.zzadr     // Catch:{ Exception -> 0x0027 }
            com.google.android.gms.internal.zzuf r2 = r2.zzbf(r6)     // Catch:{ Exception -> 0x0027 }
            r1.<init>(r2, r5)     // Catch:{ Exception -> 0x0027 }
            java.util.Map<java.lang.String, com.google.android.gms.internal.zzadr> r0 = r5.zzcth     // Catch:{ Exception -> 0x0045 }
            r0.put(r6, r1)     // Catch:{ Exception -> 0x0045 }
            r0 = r1
        L_0x0026:
            return r0
        L_0x0027:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x002a:
            java.lang.String r3 = "Fail to instantiate adapter "
            java.lang.String r0 = java.lang.String.valueOf(r6)
            int r4 = r0.length()
            if (r4 == 0) goto L_0x003f
            java.lang.String r0 = r3.concat(r0)
        L_0x003a:
            com.google.android.gms.internal.zzafj.zzc(r0, r2)
            r0 = r1
            goto L_0x0026
        L_0x003f:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            goto L_0x003a
        L_0x0045:
            r0 = move-exception
            r2 = r0
            goto L_0x002a
        L_0x0048:
            r2 = r1
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzack.zzbp(java.lang.String):com.google.android.gms.internal.zzadr");
    }

    /* access modifiers changed from: protected */
    public final void zzbp() {
        this.zzamt.zzati = null;
        super.zzbp();
    }

    public final void zzc(@Nullable zzadw zzadw) {
        if (!(this.zzamt.zzati == null || this.zzamt.zzati.zzcvs == null || TextUtils.isEmpty(this.zzamt.zzati.zzcvs.zzccc))) {
            zzadw = new zzadw(this.zzamt.zzati.zzcvs.zzccc, this.zzamt.zzati.zzcvs.zzccd);
        }
        if (!(this.zzamt.zzati == null || this.zzamt.zzati.zzcdd == null)) {
            zzbs.zzew();
            zztv.zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, this.zzamt.zzati.zzcdd.zzcbm, this.zzamt.zzaua, zzadw);
        }
        zza(zzadw);
    }

    public final void zznv() {
        zzbq.zzga("showAd must be called on the main UI thread.");
        if (!isLoaded()) {
            zzafj.zzco("The reward video has not loaded.");
            return;
        }
        this.zzcti = true;
        zzadr zzbp = zzbp(this.zzamt.zzati.zzcdf);
        if (zzbp != null && zzbp.zzoc() != null) {
            try {
                zzbp.zzoc().setImmersiveMode(this.zzapj);
                zzbp.zzoc().showVideo();
            } catch (RemoteException e) {
                zzafj.zzc("Could not call showVideo.", e);
            }
        }
    }

    public final void zznw() {
        onAdClicked();
    }
}
