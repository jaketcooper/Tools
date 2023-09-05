package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzzb
public class zzake<T> implements zzaka<T> {
    private final Object mLock = new Object();
    private int zzbzn = 0;
    private BlockingQueue<zzakf> zzddc = new LinkedBlockingQueue();
    private T zzddd;

    public final int getStatus() {
        return this.zzbzn;
    }

    public final void reject() {
        synchronized (this.mLock) {
            if (this.zzbzn != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzbzn = -1;
            for (zzakf zzakf : this.zzddc) {
                zzakf.zzddf.run();
            }
            this.zzddc.clear();
        }
    }

    public final void zza(zzakd<T> zzakd, zzakb zzakb) {
        synchronized (this.mLock) {
            if (this.zzbzn == 1) {
                zzakd.zzf(this.zzddd);
            } else if (this.zzbzn == -1) {
                zzakb.run();
            } else if (this.zzbzn == 0) {
                this.zzddc.add(new zzakf(this, zzakd, zzakb));
            }
        }
    }

    public final void zzj(T t) {
        synchronized (this.mLock) {
            if (this.zzbzn != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzddd = t;
            this.zzbzn = 1;
            for (zzakf zzakf : this.zzddc) {
                zzakf.zzdde.zzf(t);
            }
            this.zzddc.clear();
        }
    }
}
