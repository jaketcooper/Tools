package com.google.android.gms.internal;

import java.util.Random;

@zzzb
public final class zzjl extends zzkn {
    private Object mLock = new Object();
    private final Random zzbeb = new Random();
    private long zzbec;

    public zzjl() {
        zzia();
    }

    public final long getValue() {
        return this.zzbec;
    }

    public final void zzia() {
        synchronized (this.mLock) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = ((long) this.zzbeb.nextInt()) + 2147483648L;
                if (j != this.zzbec && j != 0) {
                    break;
                }
            }
            this.zzbec = j;
        }
    }
}
