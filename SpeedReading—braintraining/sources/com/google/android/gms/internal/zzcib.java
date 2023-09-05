package com.google.android.gms.internal;

import java.util.concurrent.Callable;

final class zzcib implements Callable<byte[]> {
    private /* synthetic */ String zziju;
    private /* synthetic */ zzcho zzjed;
    private /* synthetic */ zzcfx zzjeh;

    zzcib(zzcho zzcho, zzcfx zzcfx, String str) {
        this.zzjed = zzcho;
        this.zzjeh = zzcfx;
        this.zziju = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzjed.zzitu.zzbaa();
        return this.zzjed.zzitu.zza(this.zzjeh, this.zziju);
    }
}
