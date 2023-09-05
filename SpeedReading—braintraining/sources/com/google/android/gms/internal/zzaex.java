package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

@zzzb
final class zzaex {
    private long zzcwo = -1;
    private long zzcwp = -1;

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzcwo);
        bundle.putLong("tclose", this.zzcwp);
        return bundle;
    }

    public final long zzol() {
        return this.zzcwp;
    }

    public final void zzom() {
        this.zzcwp = SystemClock.elapsedRealtime();
    }

    public final void zzon() {
        this.zzcwo = SystemClock.elapsedRealtime();
    }
}
