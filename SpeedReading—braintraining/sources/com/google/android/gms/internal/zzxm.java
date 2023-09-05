package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzaq;
import java.util.concurrent.CountDownLatch;

final class zzxm implements Runnable {
    private /* synthetic */ CountDownLatch zzamx;
    private /* synthetic */ zzxl zzcik;

    zzxm(zzxl zzxl, CountDownLatch countDownLatch) {
        this.zzcik = zzxl;
        this.zzamx = countDownLatch;
    }

    public final void run() {
        synchronized (this.zzcik.zzchy) {
            boolean unused = this.zzcik.zzcij = zzaq.zza(this.zzcik.zzbwq, this.zzcik.zzcii, this.zzamx);
        }
    }
}
