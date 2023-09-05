package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;

@zzzb
public final class zzsv {
    private final Object mLock = new Object();
    private zztc zzcal;

    public final zztc zzb(Context context, zzaiy zzaiy) {
        zztc zztc;
        synchronized (this.mLock) {
            if (this.zzcal == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                this.zzcal = new zztc(context, zzaiy, (String) zzbs.zzep().zzd(zzmq.zzbfy));
            }
            zztc = this.zzcal;
        }
        return zztc;
    }
}
