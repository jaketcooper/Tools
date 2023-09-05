package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.p004js.zzab;
import org.json.JSONObject;

final class zzaaw implements Runnable {
    private /* synthetic */ zzaau zzcow;
    final /* synthetic */ JSONObject zzcox;
    final /* synthetic */ String zzcoy;

    zzaaw(zzaau zzaau, JSONObject jSONObject, String str) {
        this.zzcow = zzaau;
        this.zzcox = jSONObject;
        this.zzcoy = str;
    }

    public final void run() {
        zzab unused = this.zzcow.zzcov = zzaau.zzcke.zzb((zzcs) null);
        this.zzcow.zzcov.zza(new zzaax(this), new zzaay(this));
    }
}
