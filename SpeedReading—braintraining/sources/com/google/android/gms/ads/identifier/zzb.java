package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.zzo;

public class zzb {
    private static zzb zzamj;
    private final Context zzaif;

    private zzb(Context context) {
        this.zzaif = context;
    }

    private final void zza(AdvertisingIdClient.Info info, boolean z, long j) {
        if (Math.random() <= ((double) new zzd(this.zzaif).getFloat("gads:ad_id_use_shared_preference:ping_ratio", 0.0f))) {
            new Thread(new zzc(info, z, j)).start();
        }
    }

    public static zzb zzc(Context context) {
        zzb zzb;
        synchronized (zzb.class) {
            if (zzamj == null) {
                zzamj = new zzb(context);
            }
            zzb = zzamj;
        }
        return zzb;
    }

    public final AdvertisingIdClient.Info getInfo() {
        AdvertisingIdClient.Info info = null;
        Context remoteContext = zzo.getRemoteContext(this.zzaif);
        if (remoteContext == null) {
            zza((AdvertisingIdClient.Info) null, false, -1);
        } else {
            SharedPreferences sharedPreferences = remoteContext.getSharedPreferences("adid_settings", 0);
            if (sharedPreferences == null) {
                zza((AdvertisingIdClient.Info) null, false, -1);
            } else {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (sharedPreferences.contains("adid_key") && sharedPreferences.contains("enable_limit_ad_tracking")) {
                    info = new AdvertisingIdClient.Info(sharedPreferences.getString("adid_key", ""), sharedPreferences.getBoolean("enable_limit_ad_tracking", false));
                }
                zza(info, true, SystemClock.elapsedRealtime() - elapsedRealtime);
            }
        }
        return info;
    }
}
