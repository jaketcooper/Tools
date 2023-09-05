package com.google.android.gms.ads.internal;

import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.internal.zzama;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class zzat implements zzt<zzama> {
    private /* synthetic */ CountDownLatch zzamx;

    zzat(CountDownLatch countDownLatch) {
        this.zzamx = countDownLatch;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzama zzama = (zzama) obj;
        this.zzamx.countDown();
        if (zzama == null) {
            throw null;
        }
        ((View) zzama).setVisibility(0);
    }
}
