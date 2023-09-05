package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.p000v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzahp {
    private final Object mLock = new Object();
    private String zzczx = "";
    private String zzczy = "";
    private boolean zzczz = false;
    private String zzdaa = "";

    private final void zza(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzafj.zzcn("Can not create dialog without Activity Context");
        } else {
            zzagr.zzczc.post(new zzahq(this, context, str, z, z2));
        }
    }

    private final String zzay(Context context) {
        String str;
        synchronized (this.mLock) {
            if (TextUtils.isEmpty(this.zzczx)) {
                zzbs.zzec();
                this.zzczx = zzagr.zzq(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.zzczx)) {
                    zzbs.zzec();
                    this.zzczx = zzagr.zzpv();
                    zzbs.zzec();
                    zzagr.zzf(context, "debug_signals_id.txt", this.zzczx);
                }
            }
            str = this.zzczx;
        }
        return str;
    }

    private final Uri zzb(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzay(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    private final boolean zzi(Context context, String str, String str2) {
        String zzk = zzk(context, zzb(context, (String) zzbs.zzep().zzd(zzmq.zzbpc), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzk)) {
            zzafj.zzbw("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzk.trim());
            String optString = jSONObject.optString("gct");
            this.zzdaa = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
            synchronized (this.mLock) {
                this.zzczy = optString;
            }
            return true;
        } catch (JSONException e) {
            zzafj.zzc("Fail to get in app preview response json.", e);
            return false;
        }
    }

    private final boolean zzj(Context context, String str, String str2) {
        String zzk = zzk(context, zzb(context, (String) zzbs.zzep().zzd(zzmq.zzbpd), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzk)) {
            zzafj.zzbw("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzk.trim()).optString("debug_mode"));
            synchronized (this.mLock) {
                this.zzczz = equals;
            }
            return equals;
        } catch (JSONException e) {
            zzafj.zzc("Fail to get debug mode response json.", e);
            return false;
        }
    }

    private static String zzk(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzbs.zzec().zzp(context, str2));
        zzajp<String> zzb = new zzahy(context).zzb(str, hashMap);
        try {
            return (String) zzb.get((long) ((Integer) zzbs.zzep().zzd(zzmq.zzbpf)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            TimeoutException timeoutException = e;
            String valueOf = String.valueOf(str);
            zzafj.zzb(valueOf.length() != 0 ? "Timeout while retriving a response from: ".concat(valueOf) : new String("Timeout while retriving a response from: "), timeoutException);
            zzb.cancel(true);
        } catch (InterruptedException e2) {
            InterruptedException interruptedException = e2;
            String valueOf2 = String.valueOf(str);
            zzafj.zzb(valueOf2.length() != 0 ? "Interrupted while retriving a response from: ".concat(valueOf2) : new String("Interrupted while retriving a response from: "), interruptedException);
            zzb.cancel(true);
        } catch (Exception e3) {
            Exception exc = e3;
            String valueOf3 = String.valueOf(str);
            zzafj.zzb(valueOf3.length() != 0 ? "Error retriving a response from: ".concat(valueOf3) : new String("Error retriving a response from: "), exc);
        }
        return null;
    }

    private final void zzl(Context context, String str, String str2) {
        zzbs.zzec();
        zzagr.zza(context, zzb(context, (String) zzbs.zzep().zzd(zzmq.zzbpb), str, str2));
    }

    public final void zza(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzb(context, (String) zzbs.zzep().zzd(zzmq.zzbpe), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzbs.zzec();
        zzagr.zze(context, str, buildUpon.build().toString());
    }

    public final void zzg(Context context, String str, String str2) {
        if (!zzi(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if ("2".equals(this.zzdaa)) {
            zzafj.zzbw("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.zzdaa)) {
            zzafj.zzbw("The app is not linked for creative preview.");
            zzl(context, str, str2);
        } else if ("0".equals(this.zzdaa)) {
            zzafj.zzbw("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zzh(Context context, String str, String str2) {
        if (zzj(context, str, str2)) {
            zzafj.zzbw("Device is linked for debug signals.");
            zza(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzl(context, str, str2);
    }

    public final String zzqj() {
        String str;
        synchronized (this.mLock) {
            str = this.zzczy;
        }
        return str;
    }

    public final boolean zzqk() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzczz;
        }
        return z;
    }
}
