package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzafh;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzzb;

@zzzb
final class zzj extends zzafh {
    final /* synthetic */ zzd zzchb;

    private zzj(zzd zzd) {
        this.zzchb = zzd;
    }

    /* synthetic */ zzj(zzd zzd, zze zze) {
        this(zzd);
    }

    public final void onStop() {
    }

    public final void zzdg() {
        Bitmap zza = zzbs.zzex().zza(Integer.valueOf(this.zzchb.zzcgj.zzchr.zzapw));
        if (zza != null) {
            zzagr.zzczc.post(new zzk(this, zzbs.zzee().zza(this.zzchb.mActivity, zza, this.zzchb.zzcgj.zzchr.zzapu, this.zzchb.zzcgj.zzchr.zzapv)));
        }
    }
}
