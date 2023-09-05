package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.zzo;

@zzzb
public final class zzmo {
    private Context mContext;
    private final Object mLock = new Object();
    private volatile boolean zzaqh = false;
    private final ConditionVariable zzbft = new ConditionVariable();
    /* access modifiers changed from: private */
    @Nullable
    public SharedPreferences zzbfu = null;

    public final void initialize(Context context) {
        if (!this.zzaqh) {
            synchronized (this.mLock) {
                if (!this.zzaqh) {
                    this.mContext = context;
                    try {
                        Context remoteContext = zzo.getRemoteContext(context);
                        if (remoteContext != null || context == null) {
                            context = remoteContext;
                        } else {
                            Context applicationContext = context.getApplicationContext();
                            if (applicationContext != null) {
                                context = applicationContext;
                            }
                        }
                        if (context != null) {
                            zzbs.zzen();
                            this.zzbfu = context.getSharedPreferences("google_ads_flags", 0);
                            this.zzaqh = true;
                            this.zzbft.open();
                        }
                    } finally {
                        this.zzbft.open();
                    }
                }
            }
        }
    }

    public final <T> T zzd(zzmg<T> zzmg) {
        if (!this.zzbft.block(5000)) {
            throw new IllegalStateException("Flags.initialize() was not called!");
        }
        if (!this.zzaqh || this.zzbfu == null) {
            synchronized (this.mLock) {
                if (!this.zzaqh || this.zzbfu == null) {
                    T zzip = zzmg.zzip();
                    return zzip;
                }
            }
        }
        return zzain.zza(this.mContext, new zzmp(this, zzmg));
    }
}
