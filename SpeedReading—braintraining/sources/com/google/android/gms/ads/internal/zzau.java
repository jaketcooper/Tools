package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzama;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class zzau implements zzt<zzama> {
    private /* synthetic */ CountDownLatch zzamx;

    zzau(CountDownLatch countDownLatch) {
        this.zzamx = countDownLatch;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzafj.zzco("Adapter returned an ad, but assets substitution failed");
        this.zzamx.countDown();
        ((zzama) obj).destroy();
    }
}
