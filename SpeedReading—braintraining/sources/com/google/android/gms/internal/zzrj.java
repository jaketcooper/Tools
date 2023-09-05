package com.google.android.gms.internal;

import android.os.Handler;
import java.util.LinkedList;
import java.util.List;

@zzzb
final class zzrj {
    /* access modifiers changed from: private */
    public final List<zzsh> zzaof = new LinkedList();

    zzrj() {
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzsi zzsi) {
        Handler handler = zzagr.zzczc;
        for (zzsh zzsg : this.zzaof) {
            handler.post(new zzsg(this, zzsg, zzsi));
        }
        this.zzaof.clear();
    }
}
