package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzaey;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzaje;
import com.google.android.gms.internal.zzajg;
import com.google.android.gms.internal.zzajp;
import com.google.android.gms.internal.zzaju;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.internal.zzzb;
import org.json.JSONObject;

@zzzb
public final class zzac {
    private Context mContext;
    private final Object mLock = new Object();
    private long zzaod = 0;

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzajp zza(JSONObject jSONObject) throws Exception {
        if (!jSONObject.optBoolean("isSuccessful", false)) {
            return zzajg.zzi(null);
        }
        return zzbs.zzeg().zzk(this.mContext, jSONObject.getString("appSettingsJson"));
    }

    public final void zza(Context context, zzaiy zzaiy, String str, @Nullable Runnable runnable) {
        zza(context, zzaiy, true, (zzaey) null, str, (String) null, runnable);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Context context, zzaiy zzaiy, boolean z, @Nullable zzaey zzaey, String str, @Nullable String str2, @Nullable Runnable runnable) {
        boolean z2;
        if (zzbs.zzei().elapsedRealtime() - this.zzaod < 5000) {
            zzafj.zzco("Not retrying to fetch app settings");
            return;
        }
        this.zzaod = zzbs.zzei().elapsedRealtime();
        if (zzaey == null) {
            z2 = true;
        } else {
            z2 = (((zzbs.zzei().currentTimeMillis() - zzaey.zzoo()) > ((Long) zzbs.zzep().zzd(zzmq.zzbns)).longValue() ? 1 : ((zzbs.zzei().currentTimeMillis() - zzaey.zzoo()) == ((Long) zzbs.zzep().zzd(zzmq.zzbns)).longValue() ? 0 : -1)) > 0) || !zzaey.zzop();
        }
        if (!z2) {
            return;
        }
        if (context == null) {
            zzafj.zzco("Context not provided to fetch application settings");
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.mContext = applicationContext;
            zzsu<I, O> zza = zzbs.zzes().zzb(this.mContext, zzaiy).zza("google.afma.config.fetchAppSettings", zzsz.zzcam, zzsz.zzcam);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzajp<O> zzg = zza.zzg(jSONObject);
                zzajp<B> zza2 = zzajg.zza(zzg, new zzad(this), zzaju.zzdcu);
                if (runnable != null) {
                    zzg.zza(runnable, zzaju.zzdcu);
                }
                zzaje.zza(zza2, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e) {
                zzafj.zzb("Error requesting application settings", e);
            }
        } else {
            zzafj.zzco("App settings could not be fetched. Required parameters missing");
        }
    }
}
