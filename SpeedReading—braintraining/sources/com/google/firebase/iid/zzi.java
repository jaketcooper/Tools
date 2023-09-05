package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.p000v4.util.ArrayMap;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Map;

public final class zzi {
    private static Map<String, zzi> zzicu = new ArrayMap();
    static String zzida;
    private static zzab zznur;
    private static zzw zznus;
    private Context mContext;
    private KeyPair zzicx;
    String zzicy = "";

    private zzi(Context context, String str, Bundle bundle) {
        this.mContext = context.getApplicationContext();
        this.zzicy = str;
    }

    public static synchronized zzi zza(Context context, @Nullable Bundle bundle) {
        zzi zza;
        synchronized (zzi.class) {
            zza = zza(context, (String) null, (Bundle) null);
        }
        return zza;
    }

    public static synchronized zzi zza(Context context, @Nullable String str, @Nullable Bundle bundle) {
        zzi zzi;
        synchronized (zzi.class) {
            if (str == null) {
                str = "";
            }
            Context applicationContext = context.getApplicationContext();
            if (zznur == null) {
                zznur = new zzab(applicationContext);
                zznus = new zzw(applicationContext);
            }
            zzida = Integer.toString(FirebaseInstanceId.zzes(applicationContext));
            zzi = zzicu.get(str);
            if (zzi == null) {
                zzi = new zzi(applicationContext, str, (Bundle) null);
                zzicu.put(str, zzi);
            }
        }
        return zzi;
    }

    public static zzab zzchc() {
        return zznur;
    }

    public final long getCreationTime() {
        return zznur.zzqu(this.zzicy);
    }

    public final String getToken(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        boolean z = true;
        if (bundle.getString("ttl") != null || "jwt".equals(bundle.getString("type"))) {
            z = false;
        } else {
            zzac zzo = zznur.zzo(this.zzicy, str, str2);
            if (zzo != null && !zzo.zzqz(zzida)) {
                return zzo.zzlax;
            }
        }
        String zzb = zzb(str, str2, bundle);
        if (zzb == null || !z) {
            return zzb;
        }
        zznur.zza(this.zzicy, str, str2, zzb, zzida);
        return zzb;
    }

    public final void zza(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        zznur.zzf(this.zzicy, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("delete", "1");
        zzb(str, str2, bundle);
    }

    /* access modifiers changed from: package-private */
    public final KeyPair zzaut() {
        if (this.zzicx == null) {
            this.zzicx = zznur.zzqx(this.zzicy);
        }
        if (this.zzicx == null) {
            this.zzicx = zznur.zzqv(this.zzicy);
        }
        return this.zzicx;
    }

    public final void zzauu() {
        zznur.zzqw(this.zzicy);
        this.zzicx = null;
    }

    public final String zzb(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        if (!"".equals(this.zzicy)) {
            str = this.zzicy;
        }
        bundle.putString("subtype", str);
        Bundle zzc = zznus.zzc(bundle, zzaut());
        if (zzc == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = zzc.getString("registration_id");
        if (string != null || (string = zzc.getString("unregistered")) != null) {
            return string;
        }
        String string2 = zzc.getString("error");
        if (string2 != null) {
            throw new IOException(string2);
        }
        String valueOf = String.valueOf(zzc);
        Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 20).append("Unexpected response ").append(valueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* access modifiers changed from: package-private */
    public final void zzchd() {
        zzauu();
        FirebaseInstanceId.getInstance().startSync();
    }

    /* access modifiers changed from: package-private */
    public final void zzche() {
        if (!zznur.isEmpty()) {
            zzauu();
            zznur.zzauy();
            FirebaseInstanceId.getInstance().startSync();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzchf() {
        zznur.zzhv(this.zzicy);
        FirebaseInstanceId.getInstance().startSync();
    }
}
