package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import java.lang.ref.WeakReference;

final class zzog {
    /* access modifiers changed from: private */
    public final WeakReference<zzama> zzbtd;
    /* access modifiers changed from: private */
    public String zzbte;

    public zzog(zzama zzama) {
        this.zzbtd = new WeakReference<>(zzama);
    }

    public final void zza(zzyg zzyg) {
        zzyg.zza("/loadHtml", new zzoh(this, zzyg));
        zzyg.zza("/showOverlay", new zzoj(this, zzyg));
        zzyg.zza("/hideOverlay", new zzok(this, zzyg));
        zzama zzama = (zzama) this.zzbtd.get();
        if (zzama != null) {
            zzama.zzsq().zza("/sendMessageToSdk", (zzt<? super zzama>) new zzol(this, zzyg));
        }
    }
}
