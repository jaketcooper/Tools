package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class zzxz implements Runnable {
    final /* synthetic */ JSONObject zzcjt;
    final /* synthetic */ zzajy zzcju;
    final /* synthetic */ zzxy zzcjv;

    zzxz(zzxy zzxy, JSONObject jSONObject, zzajy zzajy) {
        this.zzcjv = zzxy;
        this.zzcjt = jSONObject;
        this.zzcju = zzajy;
    }

    public final void run() {
        try {
            zzama zznd = this.zzcjv.zznd();
            this.zzcjv.zzcjq.zze(zznd);
            WeakReference weakReference = new WeakReference(zznd);
            zznd.zzsq().zza(this.zzcjv.zza((WeakReference<zzama>) weakReference), this.zzcjv.zzb(weakReference));
            this.zzcjv.zzf(zznd);
            zznd.zzsq().zza((zzamg) new zzya(this, zznd));
            zznd.zzsq().zza((zzamf) new zzyb(this));
            zznd.loadUrl((String) zzbs.zzep().zzd(zzmq.zzbmv));
        } catch (Exception e) {
            zzafj.zzc("Exception occurred while getting video view", e);
            this.zzcju.set(null);
        }
    }
}
