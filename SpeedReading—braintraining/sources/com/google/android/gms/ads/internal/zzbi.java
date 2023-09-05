package com.google.android.gms.ads.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzzb;
import java.lang.ref.WeakReference;

@zzzb
public final class zzbi {
    private final zzbk zzaqz;
    /* access modifiers changed from: private */
    @Nullable
    public zzis zzara;
    /* access modifiers changed from: private */
    public boolean zzarb;
    private boolean zzarc;
    private long zzard;
    private final Runnable zzv;

    public zzbi(zza zza) {
        this(zza, new zzbk(zzagr.zzczc));
    }

    private zzbi(zza zza, zzbk zzbk) {
        this.zzarb = false;
        this.zzarc = false;
        this.zzard = 0;
        this.zzaqz = zzbk;
        this.zzv = new zzbj(this, new WeakReference(zza));
    }

    public final void cancel() {
        this.zzarb = false;
        this.zzaqz.removeCallbacks(this.zzv);
    }

    public final void pause() {
        this.zzarc = true;
        if (this.zzarb) {
            this.zzaqz.removeCallbacks(this.zzv);
        }
    }

    public final void resume() {
        this.zzarc = false;
        if (this.zzarb) {
            this.zzarb = false;
            zza(this.zzara, this.zzard);
        }
    }

    public final void zza(zzis zzis, long j) {
        if (this.zzarb) {
            zzafj.zzco("An ad refresh is already scheduled.");
            return;
        }
        this.zzara = zzis;
        this.zzarb = true;
        this.zzard = j;
        if (!this.zzarc) {
            zzafj.zzcn(new StringBuilder(65).append("Scheduling ad refresh ").append(j).append(" milliseconds from now.").toString());
            this.zzaqz.postDelayed(this.zzv, j);
        }
    }

    public final boolean zzdr() {
        return this.zzarb;
    }

    public final void zzf(zzis zzis) {
        this.zzara = zzis;
    }

    public final void zzg(zzis zzis) {
        zza(zzis, 60000);
    }
}
