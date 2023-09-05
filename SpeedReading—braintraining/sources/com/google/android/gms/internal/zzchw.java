package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzchw implements Callable<List<zzcfi>> {
    private /* synthetic */ zzcff zzjec;
    private /* synthetic */ zzcho zzjed;
    private /* synthetic */ String zzjef;
    private /* synthetic */ String zzjeg;

    zzchw(zzcho zzcho, zzcff zzcff, String str, String str2) {
        this.zzjed = zzcho;
        this.zzjec = zzcff;
        this.zzjef = str;
        this.zzjeg = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzjed.zzitu.zzbaa();
        return this.zzjed.zzitu.zzawh().zzh(this.zzjec.packageName, this.zzjef, this.zzjeg);
    }
}
