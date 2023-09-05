package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;

@zzzb
public final class zzacj extends zzacr {
    private final Context mContext;
    private final Object mLock;
    private final zzaiy zzaov;
    private final zzack zzcte;

    public zzacj(Context context, zzv zzv, zzuc zzuc, zzaiy zzaiy) {
        this(context, zzaiy, new zzack(context, zzv, zziw.zzhp(), zzuc, zzaiy));
    }

    private zzacj(Context context, zzaiy zzaiy, zzack zzack) {
        this.mLock = new Object();
        this.mContext = context;
        this.zzaov = zzaiy;
        this.zzcte = zzack;
    }

    public final void destroy() {
        zzd((IObjectWrapper) null);
    }

    public final String getMediationAdapterClassName() {
        String mediationAdapterClassName;
        synchronized (this.mLock) {
            mediationAdapterClassName = this.zzcte.getMediationAdapterClassName();
        }
        return mediationAdapterClassName;
    }

    public final boolean isLoaded() {
        boolean isLoaded;
        synchronized (this.mLock) {
            isLoaded = this.zzcte.isLoaded();
        }
        return isLoaded;
    }

    public final void pause() {
        zzb((IObjectWrapper) null);
    }

    public final void resume() {
        zzc((IObjectWrapper) null);
    }

    public final void setImmersiveMode(boolean z) {
        synchronized (this.mLock) {
            this.zzcte.setImmersiveMode(z);
        }
    }

    public final void setUserId(String str) {
        synchronized (this.mLock) {
            this.zzcte.setUserId(str);
        }
    }

    public final void show() {
        synchronized (this.mLock) {
            this.zzcte.zznv();
        }
    }

    public final void zza(zzacv zzacv) {
        synchronized (this.mLock) {
            this.zzcte.zza(zzacv);
        }
    }

    public final void zza(zzadb zzadb) {
        synchronized (this.mLock) {
            this.zzcte.zza(zzadb);
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper) {
        synchronized (this.mLock) {
            this.zzcte.pause();
        }
    }

    public final void zzc(IObjectWrapper iObjectWrapper) {
        synchronized (this.mLock) {
            Context context = iObjectWrapper == null ? null : (Context) zzn.zzx(iObjectWrapper);
            if (context != null) {
                try {
                    this.zzcte.onContextChanged(context);
                } catch (Exception e) {
                    zzafj.zzc("Unable to extract updated context.", e);
                }
            }
            this.zzcte.resume();
        }
    }

    public final void zzd(IObjectWrapper iObjectWrapper) {
        synchronized (this.mLock) {
            this.zzcte.destroy();
        }
    }
}
