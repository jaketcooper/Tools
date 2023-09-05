package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbq;
import java.util.List;
import java.util.Map;

@WorkerThread
final class zzcgq implements Runnable {
    private final String mPackageName;
    private final int zzbzn;
    private final Throwable zzdcz;
    private final zzcgp zzizw;
    private final byte[] zzizx;
    private final Map<String, List<String>> zzizy;

    private zzcgq(String str, zzcgp zzcgp, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        zzbq.checkNotNull(zzcgp);
        this.zzizw = zzcgp;
        this.zzbzn = i;
        this.zzdcz = th;
        this.zzizx = bArr;
        this.mPackageName = str;
        this.zzizy = map;
    }

    public final void run() {
        this.zzizw.zza(this.mPackageName, this.zzbzn, this.zzdcz, this.zzizx, this.zzizy);
    }
}
