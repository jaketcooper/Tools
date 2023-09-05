package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzchx implements Callable<List<zzcfi>> {
    private /* synthetic */ String zziju;
    private /* synthetic */ zzcho zzjed;
    private /* synthetic */ String zzjef;
    private /* synthetic */ String zzjeg;

    zzchx(zzcho zzcho, String str, String str2, String str3) {
        this.zzjed = zzcho;
        this.zziju = str;
        this.zzjef = str2;
        this.zzjeg = str3;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzjed.zzitu.zzbaa();
        return this.zzjed.zzitu.zzawh().zzh(this.zziju, this.zzjef, this.zzjeg);
    }
}
