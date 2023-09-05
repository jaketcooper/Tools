package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.gmsg.HttpClient;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.gmsg.zzy;
import com.google.android.gms.ads.internal.p004js.zzab;
import com.google.android.gms.ads.internal.p004js.zzak;
import com.google.android.gms.ads.internal.p004js.zzc;
import com.google.android.gms.ads.internal.p004js.zzo;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzaau extends zzafh {
    private static final Object sLock = new Object();
    /* access modifiers changed from: private */
    public static zzo zzcke = null;
    private static long zzcoq = TimeUnit.SECONDS.toMillis(10);
    private static boolean zzcor = false;
    private static HttpClient zzcos = null;
    /* access modifiers changed from: private */
    public static zzy zzcot = null;
    private static zzt<Object> zzcou = null;
    private final Context mContext;
    private final Object zzchy = new Object();
    /* access modifiers changed from: private */
    public final zzzd zzckx;
    private final zzaaa zzcky;
    private zzig zzcla;
    /* access modifiers changed from: private */
    public zzab zzcov;

    public zzaau(Context context, zzaaa zzaaa, zzzd zzzd, zzig zzig) {
        super(true);
        this.zzckx = zzzd;
        this.mContext = context;
        this.zzcky = zzaaa;
        this.zzcla = zzig;
        synchronized (sLock) {
            if (!zzcor) {
                zzcot = new zzy();
                zzcos = new HttpClient(context.getApplicationContext(), zzaaa.zzatd);
                zzcou = new zzabc();
                zzcke = new zzo(this.mContext.getApplicationContext(), this.zzcky.zzatd, (String) zzbs.zzep().zzd(zzmq.zzbfy), new zzabb(), new zzaba());
                zzcor = true;
            }
        }
    }

    private final JSONObject zza(zzzz zzzz, String str) {
        zzabu zzabu;
        AdvertisingIdClient.Info info;
        Bundle bundle = zzzz.zzclo.extras.getBundle("sdk_less_server_data");
        if (bundle == null) {
            return null;
        }
        try {
            zzabu = zzbs.zzem().zzp(this.mContext).get();
        } catch (Exception e) {
            zzafj.zzc("Error grabbing device info: ", e);
            zzabu = null;
        }
        Context context = this.mContext;
        zzabf zzabf = new zzabf();
        zzabf.zzcpe = zzzz;
        zzabf.zzcpf = zzabu;
        JSONObject zza = zzabm.zza(context, zzabf);
        if (zza == null) {
            return null;
        }
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            zzafj.zzc("Cannot get advertising id info", e2);
            info = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request_id", str);
        hashMap.put("request_param", zza);
        hashMap.put("data", bundle);
        if (info != null) {
            hashMap.put("adid", info.getId());
            hashMap.put("lat", Integer.valueOf(info.isLimitAdTrackingEnabled() ? 1 : 0));
        }
        try {
            return zzbs.zzec().zzp((Map<String, ?>) hashMap);
        } catch (JSONException e3) {
            return null;
        }
    }

    protected static void zzb(zzc zzc) {
        zzc.zza("/loadAd", zzcot);
        zzc.zza("/fetchHttpRequest", zzcos);
        zzc.zza("/invalidRequest", zzcou);
    }

    private final zzaad zzc(zzzz zzzz) {
        zzbs.zzec();
        String zzpv = zzagr.zzpv();
        JSONObject zza = zza(zzzz, zzpv);
        if (zza == null) {
            return new zzaad(0);
        }
        long elapsedRealtime = zzbs.zzei().elapsedRealtime();
        Future<JSONObject> zzar = zzcot.zzar(zzpv);
        zzais.zzdbs.post(new zzaaw(this, zza, zzpv));
        try {
            JSONObject jSONObject = zzar.get(zzcoq - (zzbs.zzei().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new zzaad(-1);
            }
            zzaad zza2 = zzabm.zza(this.mContext, zzzz, jSONObject.toString());
            return (zza2.errorCode == -3 || !TextUtils.isEmpty(zza2.body)) ? zza2 : new zzaad(3);
        } catch (InterruptedException | CancellationException e) {
            return new zzaad(-1);
        } catch (TimeoutException e2) {
            return new zzaad(2);
        } catch (ExecutionException e3) {
            return new zzaad(0);
        }
    }

    protected static void zzc(zzc zzc) {
        zzc.zzb("/loadAd", (zzt<? super zzak>) zzcot);
        zzc.zzb("/fetchHttpRequest", (zzt<? super zzak>) zzcos);
        zzc.zzb("/invalidRequest", (zzt<? super zzak>) zzcou);
    }

    public final void onStop() {
        synchronized (this.zzchy) {
            zzais.zzdbs.post(new zzaaz(this));
        }
    }

    public final void zzdg() {
        zzafj.zzbw("SdkLessAdLoaderBackgroundTask started.");
        String zzz = zzbs.zzfa().zzz(this.mContext);
        zzzz zzzz = new zzzz(this.zzcky, -1, zzbs.zzfa().zzx(this.mContext), zzbs.zzfa().zzy(this.mContext), zzz);
        zzbs.zzfa().zzg(this.mContext, zzz);
        zzaad zzc = zzc(zzzz);
        zzzz zzzz2 = zzzz;
        zzais.zzdbs.post(new zzaav(this, new zzaev(zzzz2, zzc, (zztn) null, (zziw) null, zzc.errorCode, zzbs.zzei().elapsedRealtime(), zzc.zzcnk, (JSONObject) null, this.zzcla)));
    }
}
