package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzba;
import com.google.android.gms.common.internal.zzbb;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzf {
    private static zzba zzfio;
    private static final Object zzfip = new Object();
    private static Context zzfiq;

    static boolean zza(String str, zzg zzg) {
        return zza(str, zzg, false);
    }

    private static boolean zza(String str, zzg zzg, boolean z) {
        if (!zzafo()) {
            return false;
        }
        zzbq.checkNotNull(zzfiq);
        try {
            return zzfio.zza(new zzm(str, zzg, z), zzn.zzy(zzfiq.getPackageManager()));
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    private static boolean zzafo() {
        boolean z = true;
        if (zzfio == null) {
            zzbq.checkNotNull(zzfiq);
            synchronized (zzfip) {
                if (zzfio == null) {
                    try {
                        zzfio = zzbb.zzam(DynamiteModule.zza(zzfiq, DynamiteModule.zzgup, "com.google.android.gms.googlecertificates").zzgx("com.google.android.gms.common.GoogleCertificatesImpl"));
                    } catch (DynamiteModule.zzc e) {
                        Log.e("GoogleCertificates", "Failed to load com.google.android.gms.googlecertificates", e);
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    static boolean zzb(String str, zzg zzg) {
        return zza(str, zzg, true);
    }

    static synchronized void zzce(Context context) {
        synchronized (zzf.class) {
            if (zzfiq != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzfiq = context.getApplicationContext();
            }
        }
    }
}
