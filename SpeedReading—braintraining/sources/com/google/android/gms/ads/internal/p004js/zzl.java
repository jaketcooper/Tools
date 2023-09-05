package com.google.android.gms.ads.internal.p004js;

/* renamed from: com.google.android.gms.ads.internal.js.zzl */
final class zzl implements Runnable {
    private /* synthetic */ String zzbza;
    private /* synthetic */ zzg zzbzf;

    zzl(zzg zzg, String str) {
        this.zzbzf = zzg;
        this.zzbza = str;
    }

    public final void run() {
        this.zzbzf.zzbwq.loadUrl(this.zzbza);
    }
}
