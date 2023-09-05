package com.google.android.gms.ads.internal.p004js;

import com.google.android.gms.internal.zzakc;
import com.google.android.gms.internal.zzake;

/* renamed from: com.google.android.gms.ads.internal.js.zzab */
public final class zzab extends zzake<zzak> {
    private final Object mLock = new Object();
    /* access modifiers changed from: private */
    public final zzaf zzcaa;
    private boolean zzcab;

    public zzab(zzaf zzaf) {
        this.zzcaa = zzaf;
    }

    public final void release() {
        synchronized (this.mLock) {
            if (!this.zzcab) {
                this.zzcab = true;
                zza(new zzac(this), new zzakc());
                zza(new zzad(this), new zzae(this));
            }
        }
    }
}
