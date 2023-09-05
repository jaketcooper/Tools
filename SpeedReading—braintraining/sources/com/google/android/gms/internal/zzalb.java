package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.zzbs;
import java.util.concurrent.TimeUnit;

@zzzb
@TargetApi(14)
public final class zzalb {
    private final long zzdez = TimeUnit.MILLISECONDS.toNanos(((Long) zzbs.zzep().zzd(zzmq.zzbha)).longValue());
    private long zzdfa;
    private boolean zzdfb = true;

    zzalb() {
    }

    public final void zza(SurfaceTexture surfaceTexture, zzakt zzakt) {
        if (zzakt != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzdfb || Math.abs(timestamp - this.zzdfa) >= this.zzdez) {
                this.zzdfb = false;
                this.zzdfa = timestamp;
                zzagr.zzczc.post(new zzalc(this, zzakt));
            }
        }
    }

    public final void zzrg() {
        this.zzdfb = true;
    }
}
