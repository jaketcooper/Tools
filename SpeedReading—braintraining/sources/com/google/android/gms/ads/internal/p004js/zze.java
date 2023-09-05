package com.google.android.gms.ads.internal.p004js;

import android.content.Context;
import com.google.android.gms.ads.internal.p004js.JavascriptEngineFactory;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzamm;
import com.google.android.gms.internal.zzcs;

/* renamed from: com.google.android.gms.ads.internal.js.zze */
final class zze implements Runnable {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzaiy zzbyw;
    private /* synthetic */ zzcs zzbyx;
    private /* synthetic */ zzv zzbyy;
    final /* synthetic */ JavascriptEngineFactory.JSEngineSettableFuture zzbyz;
    private /* synthetic */ String zzbza;

    zze(JavascriptEngineFactory javascriptEngineFactory, Context context, zzaiy zzaiy, zzcs zzcs, zzv zzv, JavascriptEngineFactory.JSEngineSettableFuture jSEngineSettableFuture, String str) {
        this.val$context = context;
        this.zzbyw = zzaiy;
        this.zzbyx = zzcs;
        this.zzbyy = zzv;
        this.zzbyz = jSEngineSettableFuture;
        this.zzbza = str;
    }

    public final void run() {
        try {
            zzg zzg = new zzg(this.val$context, this.zzbyw, this.zzbyx, this.zzbyy);
            this.zzbyz.mEngineReference = zzg;
            zzg.zza(new zzf(this));
            zzg.zzbb(this.zzbza);
        } catch (zzamm e) {
            this.zzbyz.setException(e);
        }
    }
}
