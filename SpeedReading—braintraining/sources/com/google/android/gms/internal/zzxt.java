package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.Map;

final class zzxt implements zzt<Object> {
    private /* synthetic */ zzxr zzciz;
    private /* synthetic */ zznw zzcja;

    zzxt(zzxr zzxr, zznw zznw) {
        this.zzciz = zzxr;
        this.zzcja = zznw;
    }

    public final void zza(Object obj, Map<String, String> map) {
        this.zzciz.zzc((zzpu) this.zzcja, map.get("asset"));
    }
}
