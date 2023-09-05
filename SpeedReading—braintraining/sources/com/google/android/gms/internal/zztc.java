package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.p004js.zzc;
import com.google.android.gms.ads.internal.p004js.zzo;

@zzzb
public final class zztc {
    private static zzaht<zzc> zzcap = new zztd();
    private static zzaht<zzc> zzcaq = new zzte();
    private final zzo zzcar;

    public zztc(Context context, zzaiy zzaiy, String str) {
        this.zzcar = new zzo(context, zzaiy, str, zzcap, zzcaq);
    }

    public final <I, O> zzsu<I, O> zza(String str, zzsx<I> zzsx, zzsw<O> zzsw) {
        return new zztf(this.zzcar, str, zzsx, zzsw);
    }
}
