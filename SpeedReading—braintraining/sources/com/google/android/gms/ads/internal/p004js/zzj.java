package com.google.android.gms.ads.internal.p004js;

/* renamed from: com.google.android.gms.ads.internal.js.zzj */
final class zzj implements Runnable {
    private /* synthetic */ zzg zzbzf;
    private /* synthetic */ String zzbzg;

    zzj(zzg zzg, String str) {
        this.zzbzf = zzg;
        this.zzbzg = str;
    }

    public final void run() {
        this.zzbzf.zzbwq.loadData(this.zzbzg, "text/html", "UTF-8");
    }
}
