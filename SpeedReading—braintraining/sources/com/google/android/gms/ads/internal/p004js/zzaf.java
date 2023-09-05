package com.google.android.gms.ads.internal.p004js;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzakc;
import com.google.android.gms.internal.zzake;

/* renamed from: com.google.android.gms.ads.internal.js.zzaf */
public final class zzaf extends zzake<zzc> {
    private final Object mLock = new Object();
    /* access modifiers changed from: private */
    public zzaht<zzc> zzbzl;
    private boolean zzcad;
    private int zzcae;

    public zzaf(zzaht<zzc> zzaht) {
        this.zzbzl = zzaht;
        this.zzcad = false;
        this.zzcae = 0;
    }

    private final void zzlm() {
        synchronized (this.mLock) {
            zzbq.checkState(this.zzcae >= 0);
            if (!this.zzcad || this.zzcae != 0) {
                zzafj.m11v("There are still references to the engine. Not destroying.");
            } else {
                zzafj.m11v("No reference is left (including root). Cleaning up engine.");
                zza(new zzai(this), new zzakc());
            }
        }
    }

    public final zzab zzlj() {
        zzab zzab = new zzab(this);
        synchronized (this.mLock) {
            zza(new zzag(this, zzab), new zzah(this, zzab));
            zzbq.checkState(this.zzcae >= 0);
            this.zzcae++;
        }
        return zzab;
    }

    /* access modifiers changed from: protected */
    public final void zzlk() {
        synchronized (this.mLock) {
            zzbq.checkState(this.zzcae > 0);
            zzafj.m11v("Releasing 1 reference for JS Engine");
            this.zzcae--;
            zzlm();
        }
    }

    public final void zzll() {
        boolean z = true;
        synchronized (this.mLock) {
            if (this.zzcae < 0) {
                z = false;
            }
            zzbq.checkState(z);
            zzafj.m11v("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzcad = true;
            zzlm();
        }
    }
}
