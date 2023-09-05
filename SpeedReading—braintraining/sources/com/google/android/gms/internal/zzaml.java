package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbl;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.Callable;

final class zzaml implements Callable<zzama> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzaiy zzbyw;
    private /* synthetic */ zzv zzbyy;
    private /* synthetic */ zzcs zzbzo;
    private /* synthetic */ zzanp zzdiu;
    private /* synthetic */ String zzdiv;
    private /* synthetic */ boolean zzdiw;
    private /* synthetic */ boolean zzdix;
    private /* synthetic */ zznd zzdiy;
    private /* synthetic */ zzbl zzdiz;
    private /* synthetic */ zzib zzdja;

    zzaml(zzamk zzamk, Context context, zzanp zzanp, String str, boolean z, boolean z2, zzcs zzcs, zzaiy zzaiy, zznd zznd, zzbl zzbl, zzv zzv, zzib zzib) {
        this.val$context = context;
        this.zzdiu = zzanp;
        this.zzdiv = str;
        this.zzdiw = z;
        this.zzdix = z2;
        this.zzbzo = zzcs;
        this.zzbyw = zzaiy;
        this.zzdiy = zznd;
        this.zzdiz = zzbl;
        this.zzbyy = zzv;
        this.zzdja = zzib;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzamn zzamn = new zzamn(zzamo.zzb(this.val$context, this.zzdiu, this.zzdiv, this.zzdiw, this.zzdix, this.zzbzo, this.zzbyw, this.zzdiy, this.zzdiz, this.zzbyy, this.zzdja));
        zzamn.setWebViewClient(zzbs.zzee().zzb((zzama) zzamn, this.zzdix));
        zzamn.setWebChromeClient(zzbs.zzee().zzj(zzamn));
        return zzamn;
    }
}
