package com.google.android.gms.ads.internal.p004js;

import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzakd;

/* renamed from: com.google.android.gms.ads.internal.js.zzai */
final class zzai implements zzakd<zzc> {
    final /* synthetic */ zzaf zzcag;

    zzai(zzaf zzaf) {
        this.zzcag = zzaf;
    }

    public final /* synthetic */ void zzf(Object obj) {
        zzbs.zzec();
        zzagr.runOnUiThread(new zzaj(this, (zzc) obj));
    }
}
