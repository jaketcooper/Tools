package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

public final class zzbzu {
    private boolean zzaqh = false;
    private zzbzv zzhgj = null;

    public final void initialize(Context context) {
        synchronized (this) {
            if (!this.zzaqh) {
                try {
                    this.zzhgj = zzbzw.asInterface(DynamiteModule.zza(context, DynamiteModule.zzgur, ModuleDescriptor.MODULE_ID).zzgx("com.google.android.gms.flags.impl.FlagProviderImpl"));
                    this.zzhgj.init(zzn.zzy(context));
                    this.zzaqh = true;
                } catch (RemoteException | DynamiteModule.zzc e) {
                    Log.w("FlagValueProvider", "Failed to initialize flags module.", e);
                }
                return;
            }
            return;
        }
    }

    public final <T> T zzb(zzbzn<T> zzbzn) {
        synchronized (this) {
            if (this.zzaqh) {
                return zzbzn.zza(this.zzhgj);
            }
            T zzip = zzbzn.zzip();
            return zzip;
        }
    }
}
