package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzaaa;
import com.google.android.gms.internal.zzaau;
import com.google.android.gms.internal.zzaeu;
import com.google.android.gms.internal.zzaew;
import com.google.android.gms.internal.zzaey;
import com.google.android.gms.internal.zzafh;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagl;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzagw;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzajp;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzbgc;
import com.google.android.gms.internal.zzgt;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzla;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zzom;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzsp;
import com.google.android.gms.internal.zzto;
import com.google.android.gms.internal.zztv;
import com.google.android.gms.internal.zzuc;
import com.google.android.gms.internal.zzzb;
import com.google.android.gms.internal.zzze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public abstract class zzd extends zza implements zzn, zzbl, zzto {
    protected final zzuc zzanb;
    private transient boolean zzanc;

    public zzd(Context context, zziw zziw, String str, zzuc zzuc, zzaiy zzaiy, zzv zzv) {
        this(new zzbt(context, zziw, str, zzaiy), zzuc, (zzbi) null, zzv);
    }

    private zzd(zzbt zzbt, zzuc zzuc, @Nullable zzbi zzbi, zzv zzv) {
        super(zzbt, (zzbi) null, zzv);
        this.zzanb = zzuc;
        this.zzanc = false;
    }

    private final zzaaa zza(zzis zzis, Bundle bundle, zzaey zzaey, int i) {
        PackageInfo packageInfo;
        JSONArray optJSONArray;
        ApplicationInfo applicationInfo = this.zzamt.zzaif.getApplicationInfo();
        try {
            packageInfo = zzbgc.zzcy(this.zzamt.zzaif).getPackageInfo(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzamt.zzaif.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.zzamt.zzate == null || this.zzamt.zzate.getParent() == null)) {
            int[] iArr = new int[2];
            this.zzamt.zzate.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int width = this.zzamt.zzate.getWidth();
            int height = this.zzamt.zzate.getHeight();
            int i4 = 0;
            if (this.zzamt.zzate.isShown() && i2 + width > 0 && i3 + height > 0 && i2 <= displayMetrics.widthPixels && i3 <= displayMetrics.heightPixels) {
                i4 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i2);
            bundle2.putInt("y", i3);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i4);
        }
        String zzou = zzbs.zzeg().zzou();
        this.zzamt.zzatk = new zzaew(zzou, this.zzamt.zzatb);
        this.zzamt.zzatk.zzo(zzis);
        zzbs.zzec();
        String zza = zzagr.zza(this.zzamt.zzaif, (View) this.zzamt.zzate, this.zzamt.zzath);
        long j = 0;
        if (this.zzamt.zzato != null) {
            try {
                j = this.zzamt.zzato.getValue();
            } catch (RemoteException e2) {
                zzafj.zzco("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle zza2 = zzbs.zzeg().zza(this.zzamt.zzaif, this, zzou);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.zzamt.zzats.size()) {
                break;
            }
            String keyAt = this.zzamt.zzats.keyAt(i6);
            arrayList.add(keyAt);
            if (this.zzamt.zzatr.containsKey(keyAt) && this.zzamt.zzatr.get(keyAt) != null) {
                arrayList2.add(keyAt);
            }
            i5 = i6 + 1;
        }
        zzajp zza3 = zzagl.zza((ExecutorService) zzagl.zzcyx, new zze(this));
        zzajp zza4 = zzagl.zza((ExecutorService) zzagl.zzcyx, new zzf(this));
        String str = null;
        if (zzaey != null) {
            str = zzaey.zzoq();
        }
        String str2 = null;
        if (this.zzamt.zzaub != null && this.zzamt.zzaub.size() > 0) {
            int i7 = 0;
            if (packageInfo != null) {
                i7 = packageInfo.versionCode;
            }
            if (i7 > zzbs.zzeg().zzpe()) {
                zzbs.zzeg().zzpl();
                zzbs.zzeg().zzac(i7);
            } else {
                JSONObject zzpk = zzbs.zzeg().zzpk();
                if (!(zzpk == null || (optJSONArray = zzpk.optJSONArray(this.zzamt.zzatb)) == null)) {
                    str2 = optJSONArray.toString();
                }
            }
        }
        zziw zziw = this.zzamt.zzath;
        String str3 = this.zzamt.zzatb;
        String zzhz = zzjk.zzhz();
        zzaiy zzaiy = this.zzamt.zzatd;
        List<String> list = this.zzamt.zzaub;
        boolean zzox = zzbs.zzeg().zzox();
        int i8 = displayMetrics.widthPixels;
        int i9 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        List<String> zziq = zzmq.zziq();
        String str4 = this.zzamt.zzata;
        zzom zzom = this.zzamt.zzatt;
        String zzfi = this.zzamt.zzfi();
        zzbs.zzec();
        float zzdh = zzagr.zzdh();
        zzbs.zzec();
        boolean zzdi = zzagr.zzdi();
        zzbs.zzec();
        int zzaq = zzagr.zzaq(this.zzamt.zzaif);
        zzbs.zzec();
        int zzr = zzagr.zzr(this.zzamt.zzate);
        boolean z = this.zzamt.zzaif instanceof Activity;
        boolean zzpb = zzbs.zzeg().zzpb();
        boolean zzpg = zzbs.zzeg().zzpg();
        int zzsi = zzbs.zzey().zzsi();
        zzbs.zzec();
        Bundle zzpy = zzagr.zzpy();
        String zzqj = zzbs.zzel().zzqj();
        zzla zzla = this.zzamt.zzatv;
        boolean zzqk = zzbs.zzel().zzqk();
        Bundle asBundle = zzsp.zzkw().asBundle();
        zzbs.zzeg();
        Context context = this.zzamt.zzaif;
        return new zzaaa(bundle2, zzis, zziw, str3, applicationInfo, packageInfo, zzou, zzhz, zzaiy, zza2, list, arrayList, bundle, zzox, i8, i9, f, zza, j, uuid, zziq, str4, zzom, zzfi, zzdh, zzdi, zzaq, zzr, z, zzpb, zza3, str, zzpg, zzsi, zzpy, zzqj, zzla, zzqk, asBundle, context.getSharedPreferences("admob", 0).getStringSet("never_pool_slots", Collections.emptySet()).contains(this.zzamt.zzatb), zza4, this.zzamt.zzatx, str2, arrayList2, i, zzbgc.zzcy(this.zzamt.zzaif).zzamj(), zzbs.zzeg().zzph());
    }

    @Nullable
    static String zzc(zzaeu zzaeu) {
        if (zzaeu == null) {
            return null;
        }
        String str = zzaeu.zzcdf;
        if (!("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) || zzaeu.zzcdd == null) {
            return str;
        }
        try {
            return new JSONObject(zzaeu.zzcdd.zzcbk).getString("class_name");
        } catch (NullPointerException | JSONException e) {
            return str;
        }
    }

    @Nullable
    public final String getMediationAdapterClassName() {
        if (this.zzamt.zzati == null) {
            return null;
        }
        return this.zzamt.zzati.zzcdf;
    }

    public void onAdClicked() {
        if (this.zzamt.zzati == null) {
            zzafj.zzco("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.zzamt.zzati.zzcvs == null || this.zzamt.zzati.zzcvs.zzcbv == null)) {
            zzbs.zzew();
            zztv.zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, this.zzamt.zzati, this.zzamt.zzatb, false, zzb(this.zzamt.zzati.zzcvs.zzcbv));
        }
        if (!(this.zzamt.zzati.zzcdd == null || this.zzamt.zzati.zzcdd.zzcbg == null)) {
            zzbs.zzew();
            zztv.zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, this.zzamt.zzati, this.zzamt.zzatb, false, this.zzamt.zzati.zzcdd.zzcbg);
        }
        super.onAdClicked();
    }

    public final void onPause() {
        this.zzamv.zzj(this.zzamt.zzati);
    }

    public final void onResume() {
        this.zzamv.zzk(this.zzamt.zzati);
    }

    public void pause() {
        zzbq.zzga("pause must be called on the main UI thread.");
        if (!(this.zzamt.zzati == null || this.zzamt.zzati.zzchj == null || !this.zzamt.zzfg())) {
            zzbs.zzee();
            zzagw.zzh(this.zzamt.zzati.zzchj);
        }
        if (!(this.zzamt.zzati == null || this.zzamt.zzati.zzcde == null)) {
            try {
                this.zzamt.zzati.zzcde.pause();
            } catch (RemoteException e) {
                zzafj.zzco("Could not pause mediation adapter.");
            }
        }
        this.zzamv.zzj(this.zzamt.zzati);
        this.zzams.pause();
    }

    public final void recordImpression() {
        zza(this.zzamt.zzati, false);
    }

    public void resume() {
        zzbq.zzga("resume must be called on the main UI thread.");
        zzama zzama = null;
        if (!(this.zzamt.zzati == null || this.zzamt.zzati.zzchj == null)) {
            zzama = this.zzamt.zzati.zzchj;
        }
        if (zzama != null && this.zzamt.zzfg()) {
            zzbs.zzee();
            zzagw.zzi(this.zzamt.zzati.zzchj);
        }
        if (!(this.zzamt.zzati == null || this.zzamt.zzati.zzcde == null)) {
            try {
                this.zzamt.zzati.zzcde.resume();
            } catch (RemoteException e) {
                zzafj.zzco("Could not resume mediation adapter.");
            }
        }
        if (zzama == null || !zzama.zzsw()) {
            this.zzams.resume();
        }
        this.zzamv.zzk(this.zzamt.zzati);
    }

    public void showInterstitial() {
        zzafj.zzco("showInterstitial is not supported for current ad type");
    }

    /* access modifiers changed from: protected */
    public void zza(@Nullable zzaeu zzaeu, boolean z) {
        if (zzaeu == null) {
            zzafj.zzco("Ad state was null when trying to ping impression URLs.");
            return;
        }
        if (zzaeu == null) {
            zzafj.zzco("Ad state was null when trying to ping impression URLs.");
        } else {
            zzafj.zzbw("Pinging Impression URLs.");
            if (this.zzamt.zzatk != null) {
                this.zzamt.zzatk.zzoi();
            }
            zzaeu.zzcwc.zza(zzid.zza.zzb.AD_IMPRESSION);
            if (zzaeu.zzcbw != null && !zzaeu.zzcvz) {
                zzbs.zzec();
                zzagr.zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, zzb(zzaeu.zzcbw));
                zzaeu.zzcvz = true;
            }
        }
        if (!(zzaeu.zzcvs == null || zzaeu.zzcvs.zzcbw == null)) {
            zzbs.zzew();
            zztv.zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, zzaeu, this.zzamt.zzatb, z, zzb(zzaeu.zzcvs.zzcbw));
        }
        if (zzaeu.zzcdd != null && zzaeu.zzcdd.zzcbh != null) {
            zzbs.zzew();
            zztv.zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, zzaeu, this.zzamt.zzatb, z, zzaeu.zzcdd.zzcbh);
        }
    }

    public final void zza(zzpu zzpu, String str) {
        String str2;
        zzqe zzqe = null;
        if (zzpu != null) {
            try {
                str2 = zzpu.getCustomTemplateId();
            } catch (RemoteException e) {
                zzafj.zzc("Unable to call onCustomClick.", e);
                return;
            }
        } else {
            str2 = null;
        }
        if (!(this.zzamt.zzatr == null || str2 == null)) {
            zzqe = this.zzamt.zzatr.get(str2);
        }
        if (zzqe == null) {
            zzafj.zzco("Mediation adapter invoked onCustomClick but no listeners were set.");
        } else {
            zzqe.zzb(zzpu, str);
        }
    }

    public final boolean zza(zzaaa zzaaa, zznd zznd) {
        this.zzamo = zznd;
        zznd.zzf("seq_num", zzaaa.zzclr);
        zznd.zzf("request_id", zzaaa.zzcmb);
        zznd.zzf("session_id", zzaaa.zzcls);
        if (zzaaa.zzclp != null) {
            zznd.zzf("app_version", String.valueOf(zzaaa.zzclp.versionCode));
        }
        zzbt zzbt = this.zzamt;
        zzbs.zzdy();
        Context context = this.zzamt.zzaif;
        zzig zzig = this.zzamw.zzant;
        zzafh zzaau = zzaaa.zzclo.extras.getBundle("sdk_less_server_data") != null ? new zzaau(context, zzaaa, this, zzig) : new zzze(context, zzaaa, this, zzig);
        zzaau.zzps();
        zzbt.zzatf = zzaau;
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzaeu zzaeu) {
        zzis zzis;
        boolean z = false;
        if (this.zzamu != null) {
            zzis = this.zzamu;
            this.zzamu = null;
        } else {
            zzis = zzaeu.zzclo;
            if (zzis.extras != null) {
                z = zzis.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(zzis, zzaeu, z);
    }

    /* access modifiers changed from: protected */
    public boolean zza(@Nullable zzaeu zzaeu, zzaeu zzaeu2) {
        int i;
        int i2 = 0;
        if (!(zzaeu == null || zzaeu.zzcdg == null)) {
            zzaeu.zzcdg.zza((zzto) null);
        }
        if (zzaeu2.zzcdg != null) {
            zzaeu2.zzcdg.zza((zzto) this);
        }
        if (zzaeu2.zzcvs != null) {
            i = zzaeu2.zzcvs.zzccj;
            i2 = zzaeu2.zzcvs.zzcck;
        } else {
            i = 0;
        }
        this.zzamt.zzauc.zze(i, i2);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzis zzis, zzaeu zzaeu, boolean z) {
        if (!z && this.zzamt.zzfg()) {
            if (zzaeu.zzccb > 0) {
                this.zzams.zza(zzis, zzaeu.zzccb);
            } else if (zzaeu.zzcvs != null && zzaeu.zzcvs.zzccb > 0) {
                this.zzams.zza(zzis, zzaeu.zzcvs.zzccb);
            } else if (!zzaeu.zzcng && zzaeu.errorCode == 2) {
                this.zzams.zzg(zzis);
            }
        }
        return this.zzams.zzdr();
    }

    public boolean zza(zzis zzis, zznd zznd) {
        return zza(zzis, zznd, 1);
    }

    public final boolean zza(zzis zzis, zznd zznd, int i) {
        zzaey zzaey;
        if (!zzbz()) {
            return false;
        }
        zzbs.zzec();
        zzgt zzad = zzbs.zzeg().zzad(this.zzamt.zzaif);
        Bundle zza = zzad == null ? null : zzagr.zza(zzad);
        this.zzams.cancel();
        this.zzamt.zzaue = 0;
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbnq)).booleanValue()) {
            zzaey = zzbs.zzeg().zzpj();
            zzbs.zzej().zza(this.zzamt.zzaif, this.zzamt.zzatd, false, zzaey, zzaey != null ? zzaey.getAppId() : null, this.zzamt.zzatb, (Runnable) null);
        } else {
            zzaey = null;
        }
        return zza(zza(zzis, zza, zzaey, i), zznd);
    }

    public final void zzb(zzaeu zzaeu) {
        super.zzb(zzaeu);
        if (zzaeu.zzcdd != null) {
            zzafj.zzbw("Disable the debug gesture detector on the mediation ad frame.");
            if (this.zzamt.zzate != null) {
                this.zzamt.zzate.zzfm();
            }
            zzafj.zzbw("Pinging network fill URLs.");
            zzbs.zzew();
            zztv.zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, zzaeu, this.zzamt.zzatb, false, zzaeu.zzcdd.zzcbj);
            if (!(zzaeu.zzcvs == null || zzaeu.zzcvs.zzcby == null || zzaeu.zzcvs.zzcby.size() <= 0)) {
                zzafj.zzbw("Pinging urls remotely");
                zzbs.zzec().zza(this.zzamt.zzaif, zzaeu.zzcvs.zzcby);
            }
        } else {
            zzafj.zzbw("Enable the debug gesture detector on the admob ad frame.");
            if (this.zzamt.zzate != null) {
                this.zzamt.zzate.zzfl();
            }
        }
        if (zzaeu.errorCode == 3 && zzaeu.zzcvs != null && zzaeu.zzcvs.zzcbx != null) {
            zzafj.zzbw("Pinging no fill URLs.");
            zzbs.zzew();
            zztv.zza(this.zzamt.zzaif, this.zzamt.zzatd.zzcp, zzaeu, this.zzamt.zzatb, false, zzaeu.zzcvs.zzcbx);
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzbz() {
        zzbs.zzec();
        if (zzagr.zzd(this.zzamt.zzaif, this.zzamt.zzaif.getPackageName(), "android.permission.INTERNET")) {
            zzbs.zzec();
            return zzagr.zzag(this.zzamt.zzaif);
        }
    }

    public final void zzc(String str, String str2) {
        onAppEvent(str, str2);
    }

    /* access modifiers changed from: protected */
    public final boolean zzc(zzis zzis) {
        return super.zzc(zzis) && !this.zzanc;
    }

    public void zzca() {
        this.zzanc = false;
        zzbp();
        this.zzamt.zzatk.zzok();
    }

    public void zzcb() {
        this.zzanc = true;
        zzbr();
    }

    public void zzcc() {
        zzafj.zzco("Mediated ad does not support onVideoEnd callback");
    }

    public void zzcd() {
        onAdClicked();
    }

    public final void zzce() {
        zzca();
    }

    public final void zzcf() {
        zzbq();
    }

    public final void zzcg() {
        zzcb();
    }

    public final void zzch() {
        if (this.zzamt.zzati != null) {
            String str = this.zzamt.zzati.zzcdf;
            zzafj.zzco(new StringBuilder(String.valueOf(str).length() + 74).append("Mediation adapter ").append(str).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        zza(this.zzamt.zzati, true);
        zzbs();
    }

    public void zzci() {
        recordImpression();
    }

    @Nullable
    public final String zzcj() {
        if (this.zzamt.zzati == null) {
            return null;
        }
        return zzc(this.zzamt.zzati);
    }

    public final void zzck() {
        zzbs.zzec();
        zzagr.runOnUiThread(new zzg(this));
    }

    public final void zzcl() {
        zzbs.zzec();
        zzagr.runOnUiThread(new zzh(this));
    }
}
