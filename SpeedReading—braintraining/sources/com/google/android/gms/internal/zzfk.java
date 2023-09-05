package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import org.json.JSONObject;

@zzzb
public final class zzfk implements zzfx {
    /* access modifiers changed from: private */
    public final zzfc zzavy;
    private final zzama zzavz;
    private final zzt<zzama> zzawa = new zzfl(this);
    private final zzt<zzama> zzawb = new zzfm(this);
    private final zzt<zzama> zzawc = new zzfn(this);

    public zzfk(zzfc zzfc, zzama zzama) {
        this.zzavy = zzfc;
        this.zzavz = zzama;
        zzama zzama2 = this.zzavz;
        zzama2.zza("/updateActiveView", (zzt<? super zzama>) this.zzawa);
        zzama2.zza("/untrackActiveViewUnit", (zzt<? super zzama>) this.zzawb);
        zzama2.zza("/visibilityChanged", (zzt<? super zzama>) this.zzawc);
        String valueOf = String.valueOf(this.zzavy.zzavb.zzfq());
        zzafj.zzbw(valueOf.length() != 0 ? "Custom JS tracking ad unit: ".concat(valueOf) : new String("Custom JS tracking ad unit: "));
    }

    public final void zzb(JSONObject jSONObject, boolean z) {
        if (!z) {
            this.zzavz.zzb("AFMA_updateActiveView", jSONObject);
        } else {
            this.zzavy.zzb((zzfx) this);
        }
    }

    public final boolean zzgc() {
        return true;
    }

    public final void zzgd() {
        zzama zzama = this.zzavz;
        zzama.zzb("/visibilityChanged", (zzt<? super zzama>) this.zzawc);
        zzama.zzb("/untrackActiveViewUnit", (zzt<? super zzama>) this.zzawb);
        zzama.zzb("/updateActiveView", (zzt<? super zzama>) this.zzawa);
    }
}
