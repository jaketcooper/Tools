package com.google.android.gms.internal;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@zzzb
public final class zzaij {
    private Map<Integer, Bitmap> zzdbc = new ConcurrentHashMap();
    private AtomicInteger zzdbd = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return this.zzdbc.get(num);
    }

    public final int zzb(Bitmap bitmap) {
        if (bitmap == null) {
            zzafj.zzbw("Bitmap is null. Skipping putting into the Memory Map.");
            return -1;
        }
        int andIncrement = this.zzdbd.getAndIncrement();
        this.zzdbc.put(Integer.valueOf(andIncrement), bitmap);
        return andIncrement;
    }

    public final void zzb(Integer num) {
        this.zzdbc.remove(num);
    }
}
