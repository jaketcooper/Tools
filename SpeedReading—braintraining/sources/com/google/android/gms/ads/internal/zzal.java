package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.zzaeu;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzamh;
import com.google.android.gms.internal.zzfy;
import com.google.android.gms.internal.zzgc;

final class zzal implements zzamh {
    private /* synthetic */ zzaeu zzaoc;
    private /* synthetic */ zzak zzapn;

    zzal(zzak zzak, zzaeu zzaeu) {
        this.zzapn = zzak;
        this.zzaoc = zzaeu;
    }

    public final void zzcw() {
        Context context = this.zzapn.zzamt.zzaif;
        zzama zzama = this.zzaoc.zzchj;
        if (zzama == null) {
            throw null;
        }
        new zzfy(context, (View) zzama).zza((zzgc) this.zzaoc.zzchj);
    }
}
