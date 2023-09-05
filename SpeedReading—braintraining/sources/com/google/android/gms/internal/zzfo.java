package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.gmsg.zzz;
import com.google.android.gms.ads.internal.p004js.zzab;
import com.google.android.gms.ads.internal.p004js.zzak;
import com.google.android.gms.ads.internal.p004js.zzo;
import com.google.android.gms.ads.internal.zzbs;
import org.json.JSONObject;

@zzzb
public final class zzfo implements zzfx {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final zzfc zzavy;
    private final zzt<zzak> zzawa = new zzft(this);
    private final zzt<zzak> zzawb = new zzfu(this);
    private final zzt<zzak> zzawc = new zzfv(this);
    /* access modifiers changed from: private */
    public final zzz zzawe;
    private zzab zzawf;
    /* access modifiers changed from: private */
    public boolean zzawg;
    private final zzt<zzak> zzawh = new zzfw(this);

    public zzfo(zzfc zzfc, zzo zzo, Context context) {
        this.zzavy = zzfc;
        this.mContext = context;
        this.zzawe = new zzz(this.mContext);
        this.zzawf = zzo.zzb((zzcs) null);
        this.zzawf.zza(new zzfp(this), new zzfq(this));
        String valueOf = String.valueOf(this.zzavy.zzavb.zzfq());
        zzafj.zzbw(valueOf.length() != 0 ? "Core JS tracking ad unit: ".concat(valueOf) : new String("Core JS tracking ad unit: "));
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzak zzak) {
        zzak.zza("/updateActiveView", this.zzawa);
        zzak.zza("/untrackActiveViewUnit", this.zzawb);
        zzak.zza("/visibilityChanged", this.zzawc);
        if (zzbs.zzfa().zzr(this.mContext)) {
            zzak.zza("/logScionEvent", this.zzawh);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzak zzak) {
        zzak.zzb("/visibilityChanged", (zzt<? super zzak>) this.zzawc);
        zzak.zzb("/untrackActiveViewUnit", (zzt<? super zzak>) this.zzawb);
        zzak.zzb("/updateActiveView", (zzt<? super zzak>) this.zzawa);
        if (zzbs.zzfa().zzr(this.mContext)) {
            zzak.zzb("/logScionEvent", (zzt<? super zzak>) this.zzawh);
        }
    }

    public final void zzb(JSONObject jSONObject, boolean z) {
        this.zzawf.zza(new zzfr(this, jSONObject), new zzakc());
    }

    public final boolean zzgc() {
        return this.zzawg;
    }

    public final void zzgd() {
        this.zzawf.zza(new zzfs(this), new zzakc());
        this.zzawf.release();
    }
}
