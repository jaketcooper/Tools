package com.google.android.gms.internal;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;

@zzzb
public final class zzadm extends zzadt {
    private volatile zzadn zzctn;
    private volatile zzadk zzctz;
    private volatile zzadl zzcua;

    public zzadm(zzadl zzadl) {
        this.zzcua = zzadl;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzadw zzadw) {
        if (this.zzcua != null) {
            this.zzcua.zzc(zzadw);
        }
    }

    public final void zza(zzadk zzadk) {
        this.zzctz = zzadk;
    }

    public final void zza(zzadn zzadn) {
        this.zzctn = zzadn;
    }

    public final void zzc(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzctz != null) {
            this.zzctz.zzaa(i);
        }
    }

    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzctn != null) {
            this.zzctn.zza(zzn.zzx(iObjectWrapper).getClass().getName(), i);
        }
    }

    public final void zzm(IObjectWrapper iObjectWrapper) {
        if (this.zzctz != null) {
            this.zzctz.zznz();
        }
    }

    public final void zzn(IObjectWrapper iObjectWrapper) {
        if (this.zzctn != null) {
            this.zzctn.zzbq(zzn.zzx(iObjectWrapper).getClass().getName());
        }
    }

    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (this.zzcua != null) {
            this.zzcua.onRewardedVideoAdOpened();
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper) {
        if (this.zzcua != null) {
            this.zzcua.onRewardedVideoStarted();
        }
    }

    public final void zzq(IObjectWrapper iObjectWrapper) {
        if (this.zzcua != null) {
            this.zzcua.onRewardedVideoAdClosed();
        }
    }

    public final void zzr(IObjectWrapper iObjectWrapper) {
        if (this.zzcua != null) {
            this.zzcua.zznw();
        }
    }

    public final void zzs(IObjectWrapper iObjectWrapper) {
        if (this.zzcua != null) {
            this.zzcua.onRewardedVideoAdLeftApplication();
        }
    }
}
