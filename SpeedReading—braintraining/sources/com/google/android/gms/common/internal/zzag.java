package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzag {
    private static final Object zzfxy = new Object();
    private static zzag zzfxz;

    public static zzag zzcl(Context context) {
        synchronized (zzfxy) {
            if (zzfxz == null) {
                zzfxz = new zzai(context.getApplicationContext());
            }
        }
        return zzfxz;
    }

    public final void zza(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        zzb(new zzah(str, str2, i), serviceConnection, str3);
    }

    public final boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zzah(componentName, 129), serviceConnection, str);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzah zzah, ServiceConnection serviceConnection, String str);

    public final void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zzah(componentName, 129), serviceConnection, str);
    }

    /* access modifiers changed from: protected */
    public abstract void zzb(zzah zzah, ServiceConnection serviceConnection, String str);
}
